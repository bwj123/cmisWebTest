package com.pjq.inspur.controller;

import com.pjq.inspur.pojo.GzcrmCminfo;
import com.pjq.inspur.pojo.GzcrmCmresults;
import com.pjq.inspur.service.CminfoService;
import com.pjq.inspur.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/results")
public class ResultController {
    @Autowired
    private ResultService resultService;
    @Autowired
    private CminfoService cminfoService;

    @ResponseBody
    @RequestMapping("/deleteResult")
    public int deleteResult(int resId, Model model) {
        return resultService.deleteResultById(resId);
    }

    @RequestMapping("/beforeUpdate")
    public String beforeUpdate(int resId, Model model) {
        //document.getElementById('light2').style.display = 'block';
        List<GzcrmCminfo> cminfos = cminfoService.queryAll();
        List<GzcrmCmresults> list = resultService.queryList(null, null);
        model.addAttribute("cminfo", cminfos);
        GzcrmCmresults gzcrmCmresults = resultService.queryResultById(resId);
        model.addAttribute("upResult", gzcrmCmresults);
        model.addAttribute("light", "light2");
        model.addAttribute("hash", "tab1");
        model.addAttribute("results", list);
        model.addAttribute("cminfo", cminfos);
        return "manager/clientMgrInfoOther";
    }

    @RequestMapping("/update")
    public String update(GzcrmCmresults cmresults, Model model) {
        int nums = resultService.update(cmresults);
        if (nums == 1) {
            System.out.println("更新年度工作业绩成功！");
            model.addAttribute("msg", "<script>alert('更新年度工作业绩成功！');</script>");
        } else {
            System.out.println("更新年度工作业绩失败！！");
            model.addAttribute("msg", "<script>alert('更新年度工作业绩失败！');</script>");
        }
        return "redirect:/results/queryList";
    }

    @RequestMapping("/queryList")
    public String queryList(@RequestParam(required = false) String cmId1,
                            @RequestParam(required = false) String workYear,
                            @RequestParam(required = false) String msg,
                            Model model,
                            HttpSession session) {
        List<GzcrmCminfo> cminfos = cminfoService.queryAll();
        List<GzcrmCmresults> list = resultService.queryList(cmId1, workYear);
        model.addAttribute("cmId1", cmId1);
        model.addAttribute("workYear", workYear);
        model.addAttribute("results", list);
        //定位页面
        model.addAttribute("hash", "tab1");
        model.addAttribute("msg", msg);
        model.addAttribute("cminfo", cminfos);
        return "manager/clientMgrInfoOther";
    }

    @RequestMapping("/deleteMany")
    public String deleteMany(String checkTnum, Model model) {
        boolean flag = resultService.deleteMany(checkTnum);
        if (flag) {
            System.out.println("批量删除年度工作业绩成功！");
            model.addAttribute("msg", "<script>alert('批量删除年度工作业绩失败！');</script>");
        } else {
            System.out.println("批量删除年度工作业绩失败！！");
            model.addAttribute("msg", "<script>alert('批量删除年度工作业绩失败！');</script>");
        }
        return "redirect:/results/queryList";
    }

    @RequestMapping("/insert")
    public String insert(GzcrmCmresults cmresults, Model model, HttpSession session) {
        int flag = 0;
        List<GzcrmCminfo> cminfos = cminfoService.queryAll();
        for (int i = 0; i < cminfos.size(); i++) {
            if (cminfos.get(i).getCmId() == cmresults.getCmId()) {
                flag = 1;
            }
        }
        if (flag == 1) {
            cmresults.setCmModificationPerson((String) session.getAttribute("uname"));
            int nums = resultService.insert(cmresults);
            if (nums == 1) {
                System.out.println("添加年度工作业绩成功！");
                model.addAttribute("msg", "<script>alert('添加年度工作业绩成功！');</script>");
            } else {
                System.out.println("添加年度工作业绩失败！！");
                model.addAttribute("msg", "<script>alert('添加年度工作业绩失败！');</script>");
            }
        } else {
            model.addAttribute("msg", "<script>alert('添加年度工作业绩失败，业务经理ID不存在！');</script>");
        }
        return "redirect:/results/queryList";
    }
}