package com.pjq.inspur.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pjq.inspur.pojo.YcMember;
import com.pjq.inspur.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @RequestMapping("/queryMemberList")
    public String queryMemberList(@RequestParam(required = false) String memId,
                                  @RequestParam(required = false) String memName,
                                  @RequestParam(required = false) String msg,
                                  @RequestParam(defaultValue = "1") int pageNum,
                                  Model model) {
        PageHelper.startPage(pageNum, 5);
        List<YcMember> list = memberService.queryMemberList(memId, memName);
        PageInfo<YcMember> info = new PageInfo<>(list);
        model.addAttribute("info", info);
        model.addAttribute("msg", msg);
        model.addAttribute("memId", memId);
        model.addAttribute("memName", memName);
        model.addAttribute("pageNum", pageNum);
        return "manager/userInfo";
    }

    @RequestMapping("/addMember")
    public String addMember(YcMember ycMember, Model model) {
        int nums = memberService.insertMember(ycMember);
        if (nums == 1) {
            System.out.println("添加用户成功！");
            model.addAttribute("msg", "<script>alert('添加用户成功');</script>");
        } else {
            System.out.println("添加用户失败！");
            model.addAttribute("msg", "<script>alert('添加用户失败');</script>");
        }
        return "redirect:/member/queryMemberList";
    }

    @RequestMapping("/deleteMember")
    public String deleteMember(int memid, Model model) {
        int nums = memberService.deleteMememberById(memid);
        if (nums == 1) {
            System.out.println("删除用户成功！");
            model.addAttribute("msg", "<script>alert('删除用户成功');</script>");
        } else {
            System.out.println("删除用户失败！");
            model.addAttribute("msg", "<script>alert('删除用户失败');</script>");
        }
        return "redirect:/member/queryMemberList";
    }

    @RequestMapping("/beforeUpdate")
    public String beforeUpdate(int memid, Model model) {
        YcMember ycMember = memberService.queryMemberById(memid);
        model.addAttribute("ycMember", ycMember);
        return "manager/userInfoUpdate";
    }

    @RequestMapping("/updateMember")
    public String updateMemember(YcMember ycMember, Model model) {
        int nums = memberService.updateMember(ycMember);
        if (nums == 1) {
            System.out.println("修改用户成功！");
            model.addAttribute("msg", "<script>alert('修改用户成功');</script>");
        } else {
            System.out.println("修改用户失败！");
            model.addAttribute("msg", "<script>alert('修改用户失败');</script>");
        }
        return "redirect:/member/queryMemberList";
    }

    @ResponseBody
    @RequestMapping("/updateIsEnable")
    public int updateIsEnable(int memid, String status, Model model) {
        return memberService.updateStatusById(memid, status);
    }

    @RequestMapping("/resetPass")
    public String resetPass(int memid, Model model) {
        int nums = memberService.resetPassById(memid);
        if (nums == 1) {
            System.out.println("已将密码重置为123456！");
            model.addAttribute("msg", "<script>alert('已将密码重置为123456！');</script>");
        } else {
            System.out.println("密码重置失败！");
            model.addAttribute("msg", "<script>alert('密码重置失败');</script>");
        }
        return "redirect:/member/queryMemberList";
    }

    @RequestMapping("/deleteMany")
    public String deleteMany(String checkTnum, Model model) {
        boolean flag = memberService.deleteMany(checkTnum);
        if (flag) {
            System.out.println("批量删除用户成功！");
            model.addAttribute("msg", "<script>alert('删除用户成功');</script>");
        } else {
            System.out.println("批量删除用户失败！");
            model.addAttribute("msg", "<script>alert('删除用户失败');</script>");
        }
        return "redirect:/member/queryMemberList";
    }
}