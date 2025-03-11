package com.example.app.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.domain.Admin;
import com.example.app.mapper.AdminMapper;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class AdminServiceImpl {
	
	private final AdminMapper mapper;
	public boolean isCorrectIdAndPassword(String loginId, String loginPass){
	Admin admin = mapper.selectByLoginId(loginId);
	// ログインID が正しいかチェック
	// ⇒ ログインID が正しくなければ、管理者データは取得されない
	if(admin == null) {
	return false;
	}
	// パスワードが正しいかチェック
	if(!BCrypt.checkpw(loginPass, admin.getLoginPass())) {
	return false;
	}
	return true;
	}
	}
