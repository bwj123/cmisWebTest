package com.pjq.inspur.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pjq.inspur.pojo.GzcrmCminfoWork;
import com.pjq.inspur.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/work")
public class WorkController {
    @Autowired
    private WorkService workService;

    @RequestMapping("/deleteWork")
    public String deleteWork(int workId, Model model) {
        int nums = workService.deleteWorkById(workId);
        if (nums == 1) {
            System.out.println("删除工作记录成功！");
            model.addAttribute("msg", "<script>alert('删除工作记录成功！');</script>");
        } else {
            System.out.println("删除工作记录失败！");
            model.addAttribute("msg", "<script>alert('删除工作记录失败');</script>");
        }
        return "redirect:/work/queryWorkList";
    }

    @RequestMapping("/deleteMany")
    public String deleteMany(String checkTnum, Model model) {
        boolean flag = workService.deleteMany(checkTnum);
        if (flag) {
            System.out.println("批量删除工作记录成功！");
            model.addAttribute("msg", "<script>alert('批量删除工作记录成功');</script>");
        } else {
            System.out.println("批量删除工作记录失败！");
            model.addAttribute("msg", "<script>alert('批量删除工作记录失败');</script>");
        }
        return "redirect:/work/queryWorkList";
    }

    @RequestMapping("/beforeUpdate")
    public String beforeUpdate(int workId, Model model) {
        GzcrmCminfoWork cminfoWork = workService.queryWorkRecordById(workId);
        model.addAttribute("wr", cminfoWork);
        return "manager/workMgrUpdate";
    }

    @RequestMapping("/updateWork")
    public String updateWork(GzcrmCminfoWork gzcrmCminfoWork, Model model) {
        int nums = workService.updateWork(gzcrmCminfoWork);
        if (nums == 1) {
            System.out.println("修改工作记录成功！");
            model.addAttribute("msg", "<script>alert('修改工作记录成功！');</script>");
        } else {
            System.out.println("修改工作记录失败！");
            model.addAttribute("msg", "<script>alert('修改工作记录失败！');</script>");
        }
        return "redirect:/work/queryWorkList";
    }

    @RequestMapping("/insertWork")
    public String insertWork(GzcrmCminfoWork gzcrmCminfoWork, Model model) {
        int nums = workService.insertWork(gzcrmCminfoWork);
        if (nums == 1) {
            System.out.println("插入工作记录成功！");
            model.addAttribute("msg", "<script>alert('插入工作记录成功！');</script>");
        } else {
            System.out.println("插入工作记录失败！");
            model.addAttribute("msg", "<script>alert('插入工作记录失败！');</script>");
        }
        return "redirect:/work/queryWorkList";
    }

    @RequestMapping("/queryWorkList")
    public String queryWorkList(@RequestParam(required = false) String workKey,
                                @RequestParam(required = false) String inDate,
                                @RequestParam(required = false) String msg,
                                @RequestParam(defaultValue = "1") int pageNum,
                                Model model) {
        PageHelper.startPage(pageNum, 5);
        List<GzcrmCminfoWork> list = workService.queryList(workKey, inDate);
        PageInfo<GzcrmCminfoWork> info = new PageInfo<>(list);
        model.addAttribute("workKey", workKey);
        model.addAttribute("inDate", inDate);
        model.addAttribute("msg", msg);
        model.addAttribute("pageNum", pageNum);
        model.addAttribute("info", info);
        return "manager/workMgr";
    }
}