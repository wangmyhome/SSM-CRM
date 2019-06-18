package com.wang.ssm.service.impl;

import com.wang.ssm.dao.IRoleDao;
import com.wang.ssm.domain.Role;
import com.wang.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IRoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao iRoleDao;


    @Override
    public List<Role> findAll(String id) {
        try {
            return iRoleDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Role role) {
        iRoleDao.save(role);
    }

    @Override
    public List<Role> findOtherRole(String id) {
        return iRoleDao.findOtherRole(id);
    }

    @Override
    public Role findById(String roleid) {
        return iRoleDao.findById(roleid);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] permissionIds) {
        for (String permissionId:permissionIds) {
            iRoleDao.addPermissionToRole(roleId,permissionId);
        }
    }
}
