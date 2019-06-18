package com.wang.ssm.service;

import com.wang.ssm.domain.Permission;
import org.springframework.stereotype.Service;


import java.util.List;


public interface PermissionService {

    public List<Permission> findAll();

    void save(Permission p);

    public List<Permission> findOtherPermission(String roleid);
}
