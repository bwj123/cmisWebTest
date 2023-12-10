package com.pjq.inspur.controller;

import com.pjq.inspur.pojo.GzcrmCminfo;
import com.pjq.inspur.pojo.GzcrmCmrpr;
import com.pjq.inspur.service.CminfoService;
import com.pjq.inspur.service.CmrprService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

@Controller
@RequestMapping("/cmrpr")
public class CmrprController {
    @Autowired
    private CmrprService cmrprService;
    @Autowired
    private CminfoService cminfoService;

    @RequestMapping("/queryList")
    public String queryList(@RequestParam(required = false) String cmId3,
                            @RequestParam(required = false) String cmType,
                            @RequestParam(required = false) String msg,
                            Model model) {
        List<GzcrmCminfo> cminfos = cminfoService.queryAll();
        List<GzcrmCmrpr> list = cmrprService.queryList(cmId3, cmType);
        model.addAttribute("cmId3", cmId3);
        model.addAttribute("cmType", cmType);
        model.addAttribute("cmprprs", list);
        //定位页面
        model.addAttribute("hash", "tab3");
        model.addAttribute("msg", msg);
        model.addAttribute("cminfo", cminfos);
        return "manager/clientMgrInfoOther";
    }

    @RequestMapping("/deleteCmprpr")
    public String deleteCmrpr(int cmrprId, Model model) {
        int nums = cmrprService.deleteCmrprById(cmrprId);
        if (nums == 1) {
            System.out.println("删除奖惩记录成功！");
            model.addAttribute("msg", "<script>alert('删除奖惩记录成功！');</script>");
        } else {
            System.out.println("删除奖惩记录失败！！");
            model.addAttribute("msg", "<script>alert('删除奖惩记录失败！');</script>");
        }
        return "redirect:/cmrpr/queryList";
    }

    @RequestMapping("/deleteMany")
    public String deleteMany(String checkTnum, Model model) {
        boolean flag = cmrprService.deleteMany(checkTnum);
        if (flag) {
            System.out.println("批量删除奖惩记录成功！");
            model.addAttribute("msg", "<script>alert('批量删除奖惩记录成功！');</script>");
        } else {
            System.out.println("批量删除奖惩记录失败！！");
            model.addAttribute("msg", "<script>alert('批量删除奖惩记录失败！');</script>");
        }
        return "redirect:/cmrpr/queryList";
    }

    @RequestMapping("/insert")
    public String insert(GzcrmCmrpr cmrpr, MultipartFile cmrprFile, Model model, HttpSession session) {
        int flag = 0;
        List<GzcrmCminfo> cminfos = cminfoService.queryAll();
        for (int i = 0; i < cminfos.size(); i++) {
            if (cminfos.get(i).getCmId() == cmrpr.getCmId()) {
                flag = 1;
            }
        }
        if (flag == 1) {
            if (!cmrprFile.isEmpty() && cmrprFile != null) {
                String filePath = "F:\\bangbang\\CMIS\\src\\main\\webapp\\upload\\cmrpr";
                String originalFilename = cmrprFile.getOriginalFilename();
                if (originalFilename != null && !originalFilename.equals("")) {
                    File targetFile = new File(filePath, originalFilename);
                    try {
                        cmrprFile.transferTo(targetFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                cmrpr.setCmAttachment(originalFilename);
            }
            cmrpr.setCmModificationPerson((String) session.getAttribute("uname"));
            int nums = cmrprService.insertCmrpr(cmrpr);
            if (nums == 1) {
                System.out.println("新增奖惩信息成功！");
                model.addAttribute("msg", "<script>alert('新增奖惩信息成功！');</script>");
            } else {
                System.out.println("新增奖惩信息失败！！");
                model.addAttribute("msg", "<script>alert('新增奖惩信息失败！');</script>");
            }
        } else {
            model.addAttribute("msg", "<script>alert('新增奖惩信息失败！业务经理ID不存在');</script>");
        }
        return "redirect:/cmrpr/queryList";
    }

    @RequestMapping("/beforeUpdate")
    public String beforeUpdate(int cmrprId, Model model) {
        GzcrmCmrpr cmrpr = cmrprService.queryCerById(cmrprId);
        List<GzcrmCminfo> cminfos = cminfoService.queryAll();
        List<GzcrmCmrpr> list = cmrprService.queryList(null, null);
        model.addAttribute("upCmrpr", cmrpr);
        model.addAttribute("light", "light6");
        model.addAttribute("hash", "tab3");
        model.addAttribute("cmprprs", list);
        model.addAttribute("cminfo", cminfos);
        return "manager/clientMgrInfoOther";
    }

    @RequestMapping("/update")
    public String update(GzcrmCmrpr cmrpr, Model model, MultipartFile cmrprFile) {
        if (!cmrprFile.isEmpty() && cmrprFile != null) {
            String filePath = "F:\\bangbang\\CMIS\\src\\main\\webapp\\upload\\cmrpr";
            String originalFilename = cmrprFile.getOriginalFilename();
            if (originalFilename != null && !originalFilename.equals("")) {
                File targetFile = new File(filePath, originalFilename);
                try {
                    cmrprFile.transferTo(targetFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            cmrpr.setCmAttachment(originalFilename);
        }
        int nums = cmrprService.update(cmrpr);
        if (nums == 1) {
            System.out.println("更新奖惩信息成功！");
            model.addAttribute("msg", "<script>alert('更新奖惩信息成功！');</script>");
        } else {
            System.out.println("更新奖惩信息失败！！");
            model.addAttribute("msg", "<script>alert('更新奖惩信息失败！');</script>");
        }
        return "redirect:/cmrpr/queryList";
    }

    @RequestMapping("/upload")
    public void upload(String fileName,
                       HttpServletRequest request,
                       HttpServletResponse response) throws IOException {

        String path = "F:\\bangbang\\CMIS\\src\\main\\webapp\\upload\\cmrpr\\" + fileName;
        System.out.println(path);
        //得到要下载的文件
        File file = new File(path);
        if (!file.exists()) {
            response.setContentType("text/html; charset=UTF-8");//注意text/html，和application/html
            response.getWriter().print("<html><body><script type='text/javascript'>alert('您要下载的资源不存在！');</script></body></html>");
            response.getWriter().close();
            return;
        }
        //转码，免得文件名中文乱码
        fileName = URLEncoder.encode(fileName, "UTF-8");
        //设置文件下载头
        response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
        response.setContentType("multipart/form-data");
        // 读取要下载的文件，保存到文件输入流
        FileInputStream in = null;
        in = new FileInputStream(path);
        // 创建输出流
        OutputStream out = response.getOutputStream();
        // 创建缓冲区
        byte buffer[] = new byte[1024];
        int len = 0;
        //循环将输入流中的内容读取到缓冲区当中
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
        //关闭文件输入流
        in.close();
        // 关闭输出流
        out.close();
    }
}