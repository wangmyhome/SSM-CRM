package com.wang.ssm.service;

import com.wang.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {


    public List<UserInfo> findAll();

    public void save(UserInfo user);

    public UserInfo findById(String id);

    public void addRoleToUser(String userId, String[] roleIds);
}
