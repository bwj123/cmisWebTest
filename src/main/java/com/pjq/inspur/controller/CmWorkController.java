package com.pjq.inspur.controller;

import com.pjq.inspur.pojo.GzcrmCminfo;
import com.pjq.inspur.pojo.GzcrmCmwork;
import com.pjq.inspur.service.CmWorkService;
import com.pjq.inspur.service.CminfoService;
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
@RequestMapping("/cmwork")
public class CmWorkController {
    @Autowired
    private CmWorkService cmWorkService;
    @Autowired
    private CminfoService cminfoService;

    @RequestMapping("/queryList")
    public String queryList(@RequestParam(required = false) String cmId7,
                            @RequestParam(required = false) String cmPosition,
                            @RequestParam(required = false) String msg,
                            Model model) {
        List<GzcrmCminfo> cminfos = cminfoService.queryAll();
        List<GzcrmCmwork> list = cmWorkService.queryList(cmId7, cmPosition);
        model.addAttribute("cmId7", cmId7);
        model.addAttribute("cmPosition", cmPosition);
        model.addAttribute("cmworks", list);
        //定位页面
        model.addAttribute("hash", "tab7");
        model.addAttribute("msg", msg);
        model.addAttribute("cminfo", cminfos);
        return "manager/clientMgrInfoOther";
    }

    @RequestMapping("/deleteCmwork")
    public String deleteCmwork(int cmworkId, Model model) {
        int nums = cmWorkService.deleteCmWorkById(cmworkId);
        if (nums == 1) {
            System.out.println("删除工作记录成功！");
            model.addAttribute("msg", "<script>alert('删除工作记录成功！');</script>");
        } else {
            System.out.println("删除工作记录失败！！");
            model.addAttribute("msg", "<script>alert('删除工作记录失败！');</script>");
        }
        return "redirect:/cmwork/queryList";
    }

    @RequestMapping("/deleteMany")
    public String deleteMany(String checkTnum, Model model) {
        boolean flag = cmWorkService.deleteMany(checkTnum);
        if (flag) {
            System.out.println("批量删除工作记录成功！");
            model.addAttribute("msg", "<script>alert('批量删除工作记录成功！');</script>");
        } else {
            System.out.println("批量删除工作记录失败！！");
            model.addAttribute("msg", "<script>alert('批量删除工作记录失败！');</script>");
        }
        return "redirect:/cmwork/queryList";
    }

    @RequestMapping("/beforeUpdate")
    public String beforeUpdate(int cmworkId, Model model) {
        GzcrmCmwork cmwork = cmWorkService.queryCmWorkById(cmworkId);
        List<GzcrmCminfo> cminfos = cminfoService.queryAll();
        List<GzcrmCmwork> list = cmWorkService.queryList(null, null);
        model.addAttribute("upcmWork", cmwork);
        model.addAttribute("light", "light14");
        model.addAttribute("hash", "tab7");
        model.addAttribute("cmworks", list);
        model.addAttribute("cminfo", cminfos);
        return "manager/clientMgrInfoOther";
    }

    @RequestMapping("/update")
    public String update(GzcrmCmwork cmwork, MultipartFile cmworkFile, Model model) {
        if (!cmworkFile.isEmpty() && cmworkFile != null) {
            String filePath = "F:\\bangbang\\CMIS\\src\\main\\webapp\\upload\\cmwork";
            String originalFilename = cmworkFile.getOriginalFilename();
            if (originalFilename != null && !originalFilename.equals("")) {
                File targetFile = new File(filePath, originalFilename);
                try {
                    cmworkFile.transferTo(targetFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            cmwork.setCmAttachment(originalFilename);
        }
        int nums = cmWorkService.update(cmwork);
        if (nums == 1) {
            System.out.println("修改工作记录成功！");
            model.addAttribute("msg", "<script>alert('修改工作记录成功！');</script>");
        } else {
            System.out.println("修改工作记录失败！！");
            model.addAttribute("msg", "<script>alert('修改工作记录失败！');</script>");
        }
        return "redirect:/cmwork/queryList";
    }

    @RequestMapping("/insert")
    public String insert(GzcrmCmwork cmwork, MultipartFile cmworkFile, Model model, HttpSession session) {
        int flag = 0;
        List<GzcrmCminfo> cminfos = cminfoService.queryAll();
        for (int i = 0; i < cminfos.size(); i++) {
            if (cminfos.get(i).getCmId() == cmwork.getCmId()) {
                flag = 1;
            }
        }
        if (flag == 1) {
            if (!cmworkFile.isEmpty() && cmworkFile != null) {
                String filePath = "F:\\bangbang\\CMIS\\src\\main\\webapp\\upload\\cmwork";
                String originalFilename = cmworkFile.getOriginalFilename();
                if (originalFilename != null && !originalFilename.equals("")) {
                    File targetFile = new File(filePath, originalFilename);
                    try {
                        cmworkFile.transferTo(targetFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                cmwork.setCmAttachment(originalFilename);
            }
            cmwork.setCmModificationPerson((String) session.getAttribute("uname"));
            int nums = cmWorkService.insert(cmwork);
            if (nums == 1) {
                System.out.println("新增工作记录成功！");
                model.addAttribute("msg", "<script>alert('新增工作记录成功！');</script>");
            } else {
                System.out.println("新增工作记录失败！！");
                model.addAttribute("msg", "<script>alert('新增工作记录失败！！！');</script>");
            }
        } else {
            model.addAttribute("msg", "<script>alert('新增工作记录失败！客户经理ID不存在');</script>");
        }
        return "redirect:/cmwork/queryList";
    }

    @RequestMapping("/upload")
    public void upload(String fileName,
                       HttpServletRequest request,
                       HttpServletResponse response) throws IOException {
        String path = "F:\\bangbang\\CMIS\\src\\main\\webapp\\upload\\cmwork\\" + fileName;
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