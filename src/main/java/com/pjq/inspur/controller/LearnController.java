package com.pjq.inspur.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pjq.inspur.pojo.GzcrmLearn;
import com.pjq.inspur.service.LearnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;


@Controller
@RequestMapping("/learn")
public class LearnController {
    @Autowired
    private LearnService learnService;

    @RequestMapping("/deleteLearn")
    public String deleteLearn(int learnId, Model model) {
        int nums = learnService.deleteLearnById(learnId);
        if (nums == 1) {
            System.out.println("删除学习信息成功！");
            model.addAttribute("msg", "<script>alert('删除学习信息成功！');</script>");
        } else {
            System.out.println("删除学习信息失败！！");
            model.addAttribute("msg", "<script>alert('删除学习信息失败！');</script>");
        }
        return "redirect:/learn/queryLearnList";
    }

    @RequestMapping("/beforeUpdate")
    public String beforeUpdate(int learnId, Model model) {
        GzcrmLearn gzcrmLearn = learnService.queryLearnById(learnId);
        model.addAttribute("learn", gzcrmLearn);
        return "manager/studyMgrUpdate";
    }

    @RequestMapping("/updateLearn")
    public String updateLearn(GzcrmLearn gzcrmLearn, MultipartFile file, Model model) {
        if (!file.isEmpty() && file != null) {
            String filePath = "F:\\bangbang\\CMIS\\src\\main\\webapp\\upload\\learnFile";
            String originalFilename = file.getOriginalFilename();
            if (originalFilename != null && !originalFilename.equals("")) {
                File targetFile = new File(filePath, originalFilename);
                try {
                    file.transferTo(targetFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            gzcrmLearn.setlUrl(originalFilename);
        }
        int nums = learnService.updateLearn(gzcrmLearn);
        if (nums == 1) {
            System.out.println("更新学习信息成功！");
            model.addAttribute("msg", "<script>alert('更新学习信息成功！');</script>");
        } else {
            System.out.println("更新学习信息失败！！");
            model.addAttribute("msg", "<script>alert('更新学习信息失败！');</script>");
        }
        return "redirect:/learn/queryLearnList";
    }

    @RequestMapping("/insertLearn")
    public String insertLearn(GzcrmLearn gzcrmLearn, MultipartFile file, HttpSession session, Model model) {
        if (!file.isEmpty() && file != null) {
            String filePath = "F:\\bangbang\\CMIS\\src\\main\\webapp\\upload\\learnFile";
            String originalFilename = file.getOriginalFilename();
            if (originalFilename != null && !originalFilename.equals("")) {
                File targetFile = new File(filePath, originalFilename);
                try {
                    file.transferTo(targetFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            gzcrmLearn.setlUrl(originalFilename);
        }
        gzcrmLearn.setlUper((String) session.getAttribute("uname"));
        int nums = learnService.insertLearn(gzcrmLearn);
        if (nums == 1) {
            System.out.println("添加学习信息成功！");
            model.addAttribute("msg", "<script>alert('添加学习信息成功！');</script>");
        } else {
            System.out.println("添加学习信息失败！！");
            model.addAttribute("msg", "<script>alert('添加学习信息失败！');</script>");
        }
        return "redirect:/learn/queryLearnList";
    }

    @RequestMapping("/deleteMany")
    public String deleteMany(String checkTnum, Model model) {
        boolean flag = learnService.deleteMany(checkTnum);
        if (flag) {
            System.out.println("批量删除学习信息成功！");
            model.addAttribute("msg", "<script>alert('批量删除学习信息成功');</script>");
        } else {
            System.out.println("批量删除学习信息失败！");
            model.addAttribute("msg", "<script>alert('批量删除学习信息失败');</script>");
        }
        return "redirect:/learn/queryLearnList";
    }

    @RequestMapping("/queryLearnList")
    public String queryLearnList(@RequestParam(required = false) String lname,
                                 @RequestParam(required = false) String ltype,
                                 @RequestParam(required = false) String msg,
                                 @RequestParam(defaultValue = "1") int pageNum,
                                 Model model) {
        PageHelper.startPage(pageNum, 5);
        List<GzcrmLearn> learns = learnService.queryLearnList(lname, ltype);
        PageInfo<GzcrmLearn> info = new PageInfo<>(learns);
        model.addAttribute("info", info);
        model.addAttribute("lname", lname);
        model.addAttribute("ltype", ltype);
        model.addAttribute("msg", msg);
        model.addAttribute("pageNum", pageNum);
        return "manager/studyMgr";
    }

    @RequestMapping("/uploadFile")
    public void uploadFile(HttpSession session,
                           String fileName,
                           HttpServletRequest request,
                           HttpServletResponse response) throws IOException {
        String path = "F:\\bangbang\\CMIS\\src\\main\\webapp\\upload\\learnFile\\" + fileName;
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