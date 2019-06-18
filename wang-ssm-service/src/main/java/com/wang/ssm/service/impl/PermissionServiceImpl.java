package com.wang.ssm.service.impl;

import com.wang.ssm.dao.PermissionDao;
import com.wang.ssm.domain.Permission;
import com.wang.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;
    @Override
    public List<Permission> findAll() {

        return permissionDao.findAll();
    }

    @Override
    public void save(Permission p) {
        permissionDao.save(p);
    }

    @Override
    public List<Permission> findOtherPermission(String roleid) {


        return permissionDao.findOtherPermission(roleid);
    }
}
