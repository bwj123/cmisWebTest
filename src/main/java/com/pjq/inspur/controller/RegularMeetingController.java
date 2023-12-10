package com.pjq.inspur.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pjq.inspur.pojo.GzcrmCmregular;
import com.pjq.inspur.service.RegularMeetingService;
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
@RequestMapping("/regularMeeting")
public class RegularMeetingController {
    @Autowired
    private RegularMeetingService regularMeetingService;

    @RequestMapping("/deleteRegular")
    public String deleteRegular(int reId, Model model) {
        int nums = regularMeetingService.deleteRegularById(reId);
        if (nums == 1) {
            System.out.println("删除客户经理例会成功！");
            model.addAttribute("msg", "<script>alert('删除客户经理例会成功！');</script>");
        } else {
            System.out.println("删除客户经理例会失败！！");
            model.addAttribute("msg", "<script>alert('删除客户经理例会失败！');</script>");
        }
        return "redirect:/regularMeeting/queryRegularList";
    }

    @RequestMapping("/deleteMany")
    public String deleteMany(String checkTnum, Model model) {
        boolean flag = regularMeetingService.deleteMany(checkTnum);
        if (flag) {
            System.out.println("批量删除客户经理例会成功！");
            model.addAttribute("msg", "<script>alert('批量删除客户经理例会成功');</script>");
        } else {
            System.out.println("批量删除客户经理例会失败！");
            model.addAttribute("msg", "<script>alert('批量删除客户经理例会失败');</script>");
        }
        return "redirect:/regularMeeting/queryRegularList";
    }

    @RequestMapping("/beforeUpdate")
    public String beforeUpdate(int reId, Model model) {
        GzcrmCmregular gzcrmCmregular = regularMeetingService.queryRegularById(reId);
        model.addAttribute("re", gzcrmCmregular);
        return "manager/regularMeetingUpdate";
    }

    @RequestMapping("/updateRegular")
    public String updateRegular(MultipartFile refile, GzcrmCmregular cmregular, Model model) {
        if (!refile.isEmpty() && refile != null) {
            // 保存图片的路径，图片上传成功后，将路径保存到数据库
            String filePath = "F:\\bangbang\\CMIS\\src\\main\\webapp\\upload\\meetingFile";
            // 获取原始图片的扩展名
            String originalFilename = refile.getOriginalFilename();
            // 封装上传文件位置的全路径
            if (originalFilename != null && !originalFilename.equals("")) {
                File targetFile = new File(filePath, originalFilename);
                try {
                    refile.transferTo(targetFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // 保存路径到gzcrmCminfo
            cmregular.setCmAttachment(originalFilename);
        }
        int nums = regularMeetingService.updateRegular(cmregular);
        if (nums == 1) {
            System.out.println("更新客户经理例会信息成功！");
            model.addAttribute("msg", "<script>alert('更新客户经理例会信息成功！');</script>");
        } else {
            System.out.println("更新客户经理例会信息失败！！");
            model.addAttribute("msg", "<script>alert('更新客户经理例会信息失败！');</script>");
        }
        return "redirect:/regularMeeting/queryRegularList";
    }

    @RequestMapping("/insertRegular")
    public String insertRegular(MultipartFile refile, GzcrmCmregular cmregular, Model model) {
        if (!refile.isEmpty() && refile != null) {
            // 保存图片的路径，图片上传成功后，将路径保存到数据库
            String filePath = "F:\\bangbang\\CMIS\\src\\main\\webapp\\upload\\meetingFile";
            // 获取原始图片的扩展名
            String originalFilename = refile.getOriginalFilename();
            // 封装上传文件位置的全路径
            if (originalFilename != null && !originalFilename.equals("")) {
                File targetFile = new File(filePath, originalFilename);
                try {
                    refile.transferTo(targetFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // 保存路径到gzcrmCminfo
            cmregular.setCmAttachment(originalFilename);
        }
        int nums = regularMeetingService.insertRegular(cmregular);
        if (nums == 1) {
            System.out.println("添加客户经理例会信息成功！");
            model.addAttribute("msg", "<script>alert('添加客户经理例会信息成功！');</script>");
        } else {
            System.out.println("添加客户经理例会信息失败！！");
            model.addAttribute("msg", "<script>alert('添加客户经理例会信息失败！');</script>");
        }
        return "redirect:/regularMeeting/queryRegularList";
    }

    @RequestMapping("/queryRegularList")
    public String queryRegularList(@RequestParam(required = false) String meetingId,
                                   @RequestParam(required = false) String meetingDate,
                                   @RequestParam(required = false) String meetingTheme,
                                   @RequestParam(required = false) String msg,
                                   @RequestParam(defaultValue = "1") int pageNum,
                                   Model model) {
        PageHelper.startPage(pageNum, 5);
        List<GzcrmCmregular> list = regularMeetingService.queryRegulaList(meetingId, meetingDate, meetingTheme);
        PageInfo<GzcrmCmregular> info = new PageInfo<>(list);
        model.addAttribute("meetingId", meetingId);
        model.addAttribute("meetingDate", meetingDate);
        model.addAttribute("meetingTheme", meetingTheme);
        model.addAttribute("msg", msg);
        model.addAttribute("pageNum", pageNum);
        model.addAttribute("info", info);
        return "manager/regularMeeting";
    }

    @RequestMapping("/uploadMeetingFile")
    public void uploadFile(HttpSession session,
                           String fileName,
                           HttpServletRequest request,
                           HttpServletResponse response) throws IOException {
        //获取文件的绝对路径名称，apk为根目录下的一个文件夹，这个只能获取根目录文件夹的绝对路径
        //String path = request.getSession().getServletContext().getRealPath("upload\\learnFile")+"\\"+fileName;
        String path = "F:\\bangbang\\CMIS\\src\\main\\webapp\\upload\\meetingFile\\" + fileName;
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