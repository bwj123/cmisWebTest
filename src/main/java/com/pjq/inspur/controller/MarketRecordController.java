package com.pjq.inspur.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pjq.inspur.pojo.GzcrmCmarketingRecord;
import com.pjq.inspur.service.MarketRecordService;
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
@RequestMapping("/marketRecord")
public class MarketRecordController {
    @Autowired
    private MarketRecordService recordService;

    @RequestMapping("/deleteMarketRecord")
    public String delteMarketRecord(int mrId, Model model) {
        int nums = recordService.deleteRecordById(mrId);
        if (nums == 1) {
            System.out.println("删除营销记录成功！");
            model.addAttribute("msg", "<script>alert('删除营销记录成功！');</script>");
        } else {
            System.out.println("删除营销记录失败！！");
            model.addAttribute("msg", "<script>alert('删除营销记录失败！');</script>");
        }
        return "redirect:/marketRecord/queryList";
    }

    @RequestMapping("/deleteMany")
    public String deleteMany(String checkTnum, Model model) {
        boolean flag = recordService.deleteMany(checkTnum);
        if (flag) {
            System.out.println("批量删除营销记录成功！");
            model.addAttribute("msg", "<script>alert('批量删除营销记录成功');</script>");
        } else {
            System.out.println("批量删除营销记录失败！");
            model.addAttribute("msg", "<script>alert('批量删除营销记录失败');</script>");
        }
        return "redirect:/marketRecord/queryList";
    }

    @RequestMapping("/beforeUpdate")
    public String beforeUpdate(int mrId, Model model) {
        GzcrmCmarketingRecord gzcrmCmarketingRecord = recordService.qureyMarketRecordById(mrId);
        model.addAttribute("mr", gzcrmCmarketingRecord);
        return "manager/marketRecordUpdate";
    }

    @RequestMapping("/uploadFile")
    public void uploadFile(HttpSession session,
                           String fileName,
                           HttpServletRequest request,
                           HttpServletResponse response) throws IOException {
        String path = "F:\\bangbang\\CMIS\\src\\main\\webapp\\upload\\marketRecord\\" + fileName;
        System.out.println(path);
        //得到要下载的文件
        File file = new File(path);
        if (!file.exists()) {
            response.setContentType("text/html; charset=UTF-8");
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

    @RequestMapping("/update")
    public String update(GzcrmCmarketingRecord gzcrmCmarketingRecord,
                         MultipartFile report,
                         MultipartFile recommendTable,
                         MultipartFile evaluation,
                         Model model) {
        //处理客户拜访报告书
        if (!report.isEmpty() && report != null) {
            String filePath = "F:\\bangbang\\CMIS\\src\\main\\webapp\\upload\\marketRecord";
            String originalFilename = report.getOriginalFilename();
            if (originalFilename != null && !originalFilename.equals("")) {
                File targetFile = new File(filePath, originalFilename);
                try {
                    report.transferTo(targetFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            gzcrmCmarketingRecord.setcReport(originalFilename);
        }
        //处理客户推荐表
        if (!recommendTable.isEmpty() && recommendTable != null) {
            String filePath = "F:\\bangbang\\CMIS\\src\\main\\webapp\\upload\\marketRecord";
            String originalFilename = recommendTable.getOriginalFilename();
            if (originalFilename != null && !originalFilename.equals("")) {
                File targetFile = new File(filePath, originalFilename);
                try {
                    recommendTable.transferTo(targetFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            gzcrmCmarketingRecord.setcTestimonials(originalFilename);
        }
        //处理客户综合评价
        if (!evaluation.isEmpty() && evaluation != null) {
            String filePath = "F:\\bangbang\\CMIS\\src\\main\\webapp\\upload\\marketRecord";
            String originalFilename = evaluation.getOriginalFilename();
            if (originalFilename != null && !originalFilename.equals("")) {
                File targetFile = new File(filePath, originalFilename);
                try {
                    evaluation.transferTo(targetFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            gzcrmCmarketingRecord.setcEvaluation(originalFilename);
        }
        int nums = recordService.updateMarketRecord(gzcrmCmarketingRecord);
        if (nums == 1) {
            System.out.println("修改营销记录成功！");
            model.addAttribute("msg", "<script>alert('修改营销记录成功！');</script>");
        } else {
            System.out.println("修改营销记录失败！！");
            model.addAttribute("msg", "<script>alert('修改营销记录失败！');</script>");
        }
        return "redirect:/marketRecord/queryList";
    }

    @RequestMapping("/insertMarketRecord")
    public String insertMarketRecord(GzcrmCmarketingRecord gzcrmCmarketingRecord,
                                     MultipartFile report,
                                     MultipartFile recommendTable,
                                     MultipartFile evaluation,
                                     Model model) {
        //处理客户拜访报告书
        if (!report.isEmpty() && report != null) {
            String filePath = "F:\\bangbang\\CMIS\\src\\main\\webapp\\upload\\marketRecord";
            String originalFilename = report.getOriginalFilename();
            if (originalFilename != null && !originalFilename.equals("")) {
                File targetFile = new File(filePath, originalFilename);
                try {
                    report.transferTo(targetFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            gzcrmCmarketingRecord.setcReport(originalFilename);
        }
        //处理客户推荐表
        if (!recommendTable.isEmpty() && recommendTable != null) {
            String filePath = "F:\\bangbang\\CMIS\\src\\main\\webapp\\upload\\marketRecord";
            String originalFilename = recommendTable.getOriginalFilename();
            if (originalFilename != null && !originalFilename.equals("")) {
                File targetFile = new File(filePath, originalFilename);
                try {
                    recommendTable.transferTo(targetFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            gzcrmCmarketingRecord.setcTestimonials(originalFilename);
        }
        //处理客户综合评价
        if (!evaluation.isEmpty() && evaluation != null) {
            String filePath = "F:\\bangbang\\CMIS\\src\\main\\webapp\\upload\\marketRecord";
            String originalFilename = evaluation.getOriginalFilename();
            if (originalFilename != null && !originalFilename.equals("")) {
                File targetFile = new File(filePath, originalFilename);
                try {
                    evaluation.transferTo(targetFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            gzcrmCmarketingRecord.setcEvaluation(originalFilename);
        }
        int nums = recordService.insertMarketRecord(gzcrmCmarketingRecord);
        if (nums == 1) {
            System.out.println("新增营销记录成功！");
            model.addAttribute("msg", "<script>alert('新增营销记录成功！');</script>");
        } else {
            System.out.println("新增营销记录失败！！");
            model.addAttribute("msg", "<script>alert('新增营销记录失败！');</script>");
        }
        return "redirect:/marketRecord/queryList";
    }

    @RequestMapping("/queryList")
    public String queryList(@RequestParam(required = false) String mrId,
                            @RequestParam(required = false) String mrName,
                            @RequestParam(required = false) String msg,
                            @RequestParam(defaultValue = "1") int pageNum,
                            Model model) {
        PageHelper.startPage(pageNum, 5);
        List<GzcrmCmarketingRecord> list = recordService.queryList(mrId, mrName);
        PageInfo<GzcrmCmarketingRecord> info = new PageInfo<>(list);
        model.addAttribute("mrId", mrId);
        model.addAttribute("mrName", mrName);
        model.addAttribute("msg", msg);
        model.addAttribute("pageNum", pageNum);
        model.addAttribute("info", info);
        return "manager/marketRecord";
    }
}