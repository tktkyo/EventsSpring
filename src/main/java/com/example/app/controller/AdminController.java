package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.app.domain.Event;
import com.example.app.mapper.EventMapper;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
//管理者が更新する画面
@Controller
@RequiredArgsConstructor
public class AdminController {
	private final EventMapper mapper;
	
	@GetMapping("/admin")
	public String getEvent( Model model, HttpSession session) {
        // ログイン状態をチェック
        if (session.getAttribute("loggedIn") == null) {
            // ログインしていない場合はログイン画面にリダイレクト
            return "redirect:/login";
        }
        
		//DBから取り出したイベントのデータを取得して表示
		Event event = mapper.find();
        model.addAttribute("event", event);
        System.out.println("GET----------");
        System.out.println(event);
		return "admin"; // resources/templates/admins.html
	}

	@PostMapping("/admin")
	public String postAdmin(@ModelAttribute Event event, HttpSession session) {
		// ログイン状態をチェック
        if (session.getAttribute("loggedIn") == null) {
            // ログインしていない場合はログイン画面にリダイレクト
            return "redirect:/login";
        }
        System.out.println("POST----------");
        System.out.println(event);
        mapper.update(event);
        
		return "redirect:/admin";
	}
}
