package com.wang.ssm.controller;

import com.wang.ssm.dao.IRoleDao;
import com.wang.ssm.domain.Permission;
import com.wang.ssm.domain.Role;
import com.wang.ssm.service.IRoleService;
import com.wang.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @Autowired
    private PermissionService permissionService;
    /**
     * 查看所有角色
     * @param id
     * @return
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(String id){

        ModelAndView modelAndView = new ModelAndView();
        List<Role> rolelist = roleService.findAll(id);
        modelAndView.addObject("roleList",rolelist);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }

    /**
     * 添加角色
     * @param role
     * @return
     */
    @RequestMapping("/save.do")
    public String save(Role role){
        roleService.save(role);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name="id",required = true)String roleid){
        ModelAndView mv=new ModelAndView();
        Role role = roleService.findById(roleid);
        List<Permission> permissionList = permissionService.findOtherPermission(roleid);
        mv.addObject(role);
        mv.addObject("permissionList",permissionList);
        mv.setViewName("role-permssion-add");
        return mv;
    }
    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name="roleId")String roleId,
                                      @RequestParam(name="ids")String[] permissionIds){
        roleService.addPermissionToRole(roleId,permissionIds);
        return "redirect:findAll.do";
    }
}
