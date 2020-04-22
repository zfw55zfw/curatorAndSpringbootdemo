package com.newland.show.controller;

import com.newland.show.config.WebSecurityConfig;
import com.newland.show.entity.Student;
import com.newland.show.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhengfawei
 * @create 2018-04-16 下午3:11
 * @desc login
 **/
@Controller
public class LoginController {

    @Autowired
    private StudentService studentService;
    private Logger logger = LoggerFactory.getLogger(LoginController.class);
    @GetMapping("/")
    public String index(@SessionAttribute(WebSecurityConfig.SESSION_KEY) String account, Model model) {
        model.addAttribute("name", account);
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/loginPost")
    public String loginPost(String account, String password, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        List<Student> list = studentService.findAll();

        if (!"123456".equals(password)) {
            map.put("success", false);
            map.put("message", "密码错误");
            return "error";
        }

        // 设置session
        session.setAttribute(WebSecurityConfig.SESSION_KEY, account);

        map.put("success", true);
        map.put("message", "登录成功");
        return "index";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 移除session
        session.removeAttribute(WebSecurityConfig.SESSION_KEY);
        return "redirect:/login";
    }
}
