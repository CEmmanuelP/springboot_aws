package com.eugene.book.springboot.web;

import com.eugene.book.springboot.config.auth.LoginUser;
import com.eugene.book.springboot.config.auth.dto.SessionUser;
import com.eugene.book.springboot.service.members.MembersService;

import com.eugene.book.springboot.web.dto.MembersResponseDto;
import com.eugene.book.springboot.web.dto.MembersSaveRequestDto;
import com.eugene.book.springboot.web.dto.MessageDto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {


    private final MembersService membersService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("members", membersService.findAllDesc());

        return "index";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @GetMapping("/login")
    public String login(){ return "login"; }

    @GetMapping("/message")
    public String message(){
        return "message";
    }

    @GetMapping("/posts/update/{id}")
    public String membersUpdate(@PathVariable Long id, Model model){
        MembersResponseDto dto = membersService.findById(id);
        model.addAttribute("members", dto);

        return "posts-update";
    }

    @RequestMapping(value = "/message", method = {RequestMethod.POST})
    public String getMessage(Model model, @ModelAttribute(value = "MessageDto")MessageDto message){

        System.out.println("I got it!");
        System.out.println(message);

        System.out.println(message.getTitle());

        model.addAttribute(message);

        return "index";
    }
}
