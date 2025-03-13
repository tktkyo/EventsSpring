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
public class AdminServiceImpl implements AdminService {

    private final AdminMapper mapper;
    
    public Admin findAdminByLoginId(String loginId) {
        return mapper.selectByLoginId(loginId);
    }

    public boolean isCorrectIdAndPassword(String loginId, String loginPass) {
        Admin admin = mapper.selectByLoginId(loginId);
        if (admin == null || admin.getLoginPass() == null) {
            return false;
        }
        return BCrypt.checkpw(loginPass, admin.getLoginPass());
    }
}