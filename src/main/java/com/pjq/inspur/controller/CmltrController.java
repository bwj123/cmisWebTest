package com.pjq.inspur.controller;

import com.pjq.inspur.pojo.GzcrmCminfo;
import com.pjq.inspur.pojo.GzcrmCmltr;
import com.pjq.inspur.service.CminfoService;
import com.pjq.inspur.service.CmltrService;
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
@RequestMapping("/cmltr")
public class CmltrController {

    @Autowired
    private CmltrService cmltrService;
    @Autowired
    private CminfoService cminfoService;

    @RequestMapping("/queryList")
    public String queryList(@RequestParam(required = false) String cmId5,
                            @RequestParam(required = false) String cmTime,
                            @RequestParam(required = false) String cmSub,
                            @RequestParam(required = false) String msg,
                            Model model) {
        List<GzcrmCminfo> cminfos = cminfoService.queryAll();
        List<GzcrmCmltr> list = cmltrService.queryList(cmId5, cmTime, cmSub);
        model.addAttribute("cmId5", cmId5);
        model.addAttribute("cmTime", cmTime);
        model.addAttribute("cmSub", cmSub);
        model.addAttribute("cmltrs", list);
        //定位页面
        model.addAttribute("hash", "tab5");
        model.addAttribute("msg", msg);
        model.addAttribute("cminfo", cminfos);
        return "manager/clientMgrInfoOther";
    }

    @RequestMapping("/deleteCmltr")
    public String deleteCmltr(int cmltrId, Model model) {
        int nums = cmltrService.deleteCmltrById(cmltrId);
        if (nums == 1) {
            System.out.println("删除学习培训记录成功！");
            model.addAttribute("msg", "<script>alert('删除学习培训记录成功！');</script>");
        } else {
            System.out.println("删除学习培训记录失败！！");
            model.addAttribute("msg", "<script>alert('删除学习培训记录失败！');</script>");
        }
        return "redirect:/cmltr/queryList";
    }

    @RequestMapping("/deleteMany")
    public String deleteMany(String checkTnum, Model model) {
        boolean flag = cmltrService.deleteMany(checkTnum);
        if (flag) {
            System.out.println("批量删除学习培训记录成功！");
            model.addAttribute("msg", "<script>alert('批量删除学习培训记录成功！');</script>");
        } else {
            System.out.println("批量删除学习培训记录失败！！");
            model.addAttribute("msg", "<script>alert('批量删除学习培训记录失败！');</script>");
        }
        return "redirect:/cmltr/queryList";
    }

    @RequestMapping("/insert")
    public String insert(GzcrmCmltr cmltr, Model model, MultipartFile cmltrFile, HttpSession session) {
        int flag = 0;
        List<GzcrmCminfo> cminfos = cminfoService.queryAll();
        for (int i = 0; i < cminfos.size(); i++) {
            if (cminfos.get(i).getCmId() == cmltr.getCmId()) {
                flag = 1;
            }
        }
        if (flag == 1) {
            if (!cmltrFile.isEmpty() && cmltrFile != null) {
                String filePath = "F:\\bangbang\\CMIS\\src\\main\\webapp\\upload\\cmltr";
                String originalFilename = cmltrFile.getOriginalFilename();
                if (originalFilename != null && !originalFilename.equals("")) {
                    File targetFile = new File(filePath, originalFilename);
                    try {
                        cmltrFile.transferTo(targetFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                cmltr.setCmAttachment(originalFilename);
            }
            cmltr.setCmModificationPerson((String) session.getAttribute("uname"));
            int nums = cmltrService.insertCmrpr(cmltr);
            if (nums == 1) {
                System.out.println("新增学习培训记录成功！");
                model.addAttribute("msg", "<script>alert('新增学习培训记录成功！');</script>");
            } else {
                System.out.println("新增学习培训记录失败！！");
                model.addAttribute("msg", "<script>alert('新增学习培训记录失败！');</script>");
            }
        } else {
            model.addAttribute("msg", "<script>alert('新增学习培训记录失败！客户经理ID不存在');</script>");
        }
        return "redirect:/cmltr/queryList";
    }

    @RequestMapping("/beforeUpdate")
    public String beforeUpdate(int cmltrId, Model model) {
        GzcrmCmltr cmltr = cmltrService.queryCmltrById(cmltrId);
        List<GzcrmCminfo> cminfos = cminfoService.queryAll();
        List<GzcrmCmltr> list = cmltrService.queryList(null, null, null);
        model.addAttribute("upCmltr", cmltr);
        model.addAttribute("light", "light10");
        model.addAttribute("hash", "tab5");
        model.addAttribute("cmltrs", list);
        model.addAttribute("cminfo", cminfos);
        return "manager/clientMgrInfoOther";
    }

    @RequestMapping("/update")
    public String update(GzcrmCmltr cmltr, MultipartFile cmltrFile, Model model) {
        if (!cmltrFile.isEmpty() && cmltrFile != null) {
            String filePath = "F:\\bangbang\\CMIS\\src\\main\\webapp\\upload\\cmltr";
            String originalFilename = cmltrFile.getOriginalFilename();
            if (originalFilename != null && !originalFilename.equals("")) {
                File targetFile = new File(filePath, originalFilename);
                try {
                    cmltrFile.transferTo(targetFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            cmltr.setCmAttachment(originalFilename);
        }
        int nums = cmltrService.update(cmltr);
        if (nums == 1) {
            System.out.println("更新学习培训记录成功！");
            model.addAttribute("msg", "<script>alert('更新学习培训记录成功！');</script>");
        } else {
            System.out.println("更新学习培训记录失败！！");
            model.addAttribute("msg", "<script>alert('更新学习培训记录失败！');</script>");
        }
        return "redirect:/cmltr/queryList";
    }

    @RequestMapping("/upload")
    public void upload(String fileName,
                       HttpServletRequest request,
                       HttpServletResponse response) throws IOException {
        String path = "F:\\bangbang\\CMIS\\src\\main\\webapp\\upload\\cmltr\\" + fileName;
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