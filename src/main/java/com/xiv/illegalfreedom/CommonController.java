package com.xiv.illegalfreedom;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CommonController {
    private final Map<String, String> pageMap;

    public CommonController() {
        pageMap = new HashMap<>();
        pageMap.put("home", "home");
        pageMap.put("login", "member/loginForm");
        pageMap.put("membership", "member/memberForm");
        pageMap.put("board", "board/boardForm");
        pageMap.put("write", "board/writeForm");
        pageMap.put("view", "board/viewForm");
    }

    @RequestMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("formPath", "form/home");
        return "index";
    }

    @RequestMapping(value = "{pathName}")
    public String formPath(Model model, @PathVariable String pathName) {
        model.addAttribute("formPath", "form/" + pathName);
        return "index";
    }

    @RequestMapping(value = "form/{formPath}")
    public String getFormPath(@PathVariable String formPath) {
        return pageMap.get(formPath);
    }
}
