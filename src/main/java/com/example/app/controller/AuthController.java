package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.app.domain.Admin;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AuthController {


	@GetMapping("/login")
	public String showAuth(Model model) {
		model.addAttribute("admin", new Admin());
		return "login";
	}

	@PostMapping("/login")
	public String login(HttpSession session ) {
		// ログイン認証処理（省略）

        // ログイン成功時にセッションにログイン状態を保存
        session.setAttribute("loggedIn", true);

        return "redirect:/admin";
    }
	@GetMapping("/logout")
	public String logout() {
		// セッションを破棄し、トップページへ遷移

		return "logout";
	}
}