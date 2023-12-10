package com.pjq.inspur.controller;

import com.pjq.inspur.pojo.GzcrmCertificate;
import com.pjq.inspur.pojo.GzcrmCminfo;
import com.pjq.inspur.service.CertificateService;
import com.pjq.inspur.service.CminfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("/certificate")
public class CertificateController {
    @Autowired
    private CertificateService certificateService;
    @Autowired
    private CminfoService cminfoService;

    @RequestMapping("/deleteCer")
    public String deleteCer(int cerId, Model model) {
        int nums = certificateService.deleteCerById(cerId);
        if (nums == 1) {
            System.out.println("删除证照信息成功！");
            model.addAttribute("msg", "<script>alert('删除证照信息成功！');</script>");
        } else {
            System.out.println("删除证照信息失败！！");
            model.addAttribute("msg", "<script>alert('删除证照信息失败！');</script>");
        }
        return "redirect:/certificate/queryList";
    }

    @RequestMapping("/deleteMany")
    public String deleteMany(String checkTnum, Model model) {

        boolean flag = certificateService.deleteMany(checkTnum);
        if (flag) {
            System.out.println("批量删除证照信息成功！");
            model.addAttribute("msg", "<script>alert('批量删除证照信息成功！');</script>");
        } else {
            System.out.println("批量删除证照信息失败！！");
            model.addAttribute("msg", "<script>alert('批量删除证照信息失败！');</script>");
        }
        return "redirect:/certificate/queryList";
    }

    @RequestMapping("/beforeUpdate")
    public String beforeUpdate(int cerId, Model model) {
        GzcrmCertificate gzcrmCertificate = certificateService.queryCerById(cerId);
        List<GzcrmCminfo> cminfos = cminfoService.queryAll();
        List<GzcrmCertificate> list = certificateService.queryList(null, null);
        model.addAttribute("upCer", gzcrmCertificate);
        model.addAttribute("light", "light4");
        model.addAttribute("hash", "tab2");
        model.addAttribute("certs", list);
        model.addAttribute("cminfo", cminfos);
        return "manager/clientMgrInfoOther";
    }

    @RequestMapping("/update")
    public String update(GzcrmCertificate certificate, MultipartFile cerFile, Model model) {
        if (!cerFile.isEmpty() && cerFile != null) {
            String filePath = "F:\\A课程\\7.银行管理系统\\ljhProject\\cmsproject01\\src\\main\\webapp\\upload\\cer";
            String originalFilename = cerFile.getOriginalFilename();
            if (originalFilename != null && !originalFilename.equals("")) {
                File targetFile = new File(filePath, originalFilename);
                try {
                    cerFile.transferTo(targetFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            certificate.setCmCertificateUrl(originalFilename);
        }
        int nums = certificateService.updateLearn(certificate);
        if (nums == 1) {
            System.out.println("更新证照信息成功！");
            model.addAttribute("msg", "<script>alert('更新证照信息成功！');</script>");
        } else {
            System.out.println("更新证照信息失败！！");
            model.addAttribute("msg", "<script>alert('更新证照信息失败！');</script>");
        }
        return "redirect:/certificate/queryList";
    }

    @RequestMapping("/insert")
    public String insert(GzcrmCertificate certificate, MultipartFile cerFile, HttpSession session, Model model) {
        int flag = 0;
        List<GzcrmCminfo> cminfos = cminfoService.queryAll();
        for (int i = 0; i < cminfos.size(); i++) {
            if (cminfos.get(i).getCmId() == certificate.getCmId()) {
                flag = 1;
            }
        }
        if (flag == 1) {
            if (!cerFile.isEmpty() && cerFile != null) {
                String filePath = "F:\\A课程\\7.银行管理系统\\ljhProject\\cmsproject01\\src\\main\\webapp\\upload\\cer";
                String originalFilename = cerFile.getOriginalFilename();
                if (originalFilename != null && !originalFilename.equals("")) {
                    File targetFile = new File(filePath, originalFilename);
                    try {
                        cerFile.transferTo(targetFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                certificate.setCmPeriod(1);
                certificate.setCmInvalid("未作废");
                certificate.setCmCertificateUrl(originalFilename);
            }
            certificate.setCmModificationPerson((String) session.getAttribute("uname"));
            int nums = certificateService.insertCer(certificate);
            if (nums == 1) {
                System.out.println("新增证照信息成功！");
                model.addAttribute("msg", "<script>alert('新增证照信息成功！');</script>");
            } else {
                System.out.println("新增证照信息失败！！");
                model.addAttribute("msg", "<script>alert('新增证照信息失败！');</script>");
            }
        } else {
            model.addAttribute("msg", "<script>alert('新增证照信息失败！业务经理ID不存在');</script>");
        }
        return "redirect:/certificate/queryList";
    }

    @RequestMapping("/queryList")
    public String queryList(@RequestParam(required = false) String cmId2,
                            @RequestParam(required = false) String cerName,
                            @RequestParam(required = false) String msg,
                            Model model) {
        List<GzcrmCminfo> cminfos = cminfoService.queryAll();
        List<GzcrmCertificate> list = certificateService.queryList(cmId2, cerName);
        model.addAttribute("cmId2", cmId2);
        model.addAttribute("cerName", cerName);
        model.addAttribute("certs", list);
        //定位页面
        model.addAttribute("hash", "tab2");
        model.addAttribute("msg", msg);
        model.addAttribute("cminfo", cminfos);
        return "manager/clientMgrInfoOther";
    }
}