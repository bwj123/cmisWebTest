package com.pjq.inspur.controller;

import com.pjq.inspur.pojo.YcMember;
import com.pjq.inspur.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private MemberService memberService;

    @RequestMapping("/login")
    public String login(@RequestParam("loginName") String loginName,
                        @RequestParam("loginPass") String loginPass,
                        Model model, HttpSession session) {
        List<YcMember> list = memberService.login(loginName, loginPass);
        if (list.size() == 1) {
            session.setAttribute("uname", loginName);
            session.setAttribute("uid", list.get(0).getMemId());
            session.setAttribute("urole", list.get(0).getRoleid());
            return "main";/*登录成功*/
        } else {
            model.addAttribute("msg", "登录失败");
            return "login";
        }
    }

    @RequestMapping("/logout")
    public String logout(Model model, HttpSession session) {
        session.removeAttribute("uname");
        session.removeAttribute("uid");
        session.removeAttribute("urole");
        return "login";
    }
}