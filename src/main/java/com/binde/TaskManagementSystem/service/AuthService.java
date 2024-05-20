package com.binde.TaskManagementSystem.service;

import com.binde.TaskManagementSystem.dto.JwtAuthResponse;
import com.binde.TaskManagementSystem.dto.LoginDto;
import com.binde.TaskManagementSystem.dto.RegisterDto;

public interface AuthService {
    String register(RegisterDto registerDto);

    JwtAuthResponse login(LoginDto loginDto);
}
