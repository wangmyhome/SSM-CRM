package com.wang.ssm.service;

import com.wang.ssm.domain.Role;

import java.util.List;

public interface IRoleService {
    List<Role> findAll(String id);

    public void save(Role role);

    List<Role> findOtherRole(String id);

    public Role findById(String roleid);

    void addPermissionToRole(String roleId, String[] permissionIds);
}
