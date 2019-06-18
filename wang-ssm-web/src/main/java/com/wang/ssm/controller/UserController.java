package com.wang.ssm.controller;

import com.wang.ssm.domain.Role;
import com.wang.ssm.domain.UserInfo;
import com.wang.ssm.service.IRoleService;
import com.wang.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;


    /**
     * 查看用户
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        List<UserInfo> users = userService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("userList", users);
        mv.setViewName("user-list");
        return mv;
    }

    /**
     * 保存用户
     * @param user
     * @return
     */
    @RequestMapping("/save.do")
    public String save(UserInfo user){
        userService.save(user);
        return "redirect:findAll.do";
    }

    /**
     * 根据id查询某个用户
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/findById.do")
    public ModelAndView findById(String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        mv.addObject("user", userInfo);
        mv.setViewName("user-show1");
        return mv;
    }

    /**
     * 用户角色相关联
     * @param id
     * @return
     */
    @RequestMapping("findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(String id){
        //根据用户id查询用户
        UserInfo user = userService.findById(id);
        //根据用户id查询可以添加的角色
        List<Role> roleList = roleService.findOtherRole(id);
        ModelAndView mv=new ModelAndView();
        mv.addObject("user",user);
        mv.addObject("roleList",roleList);
        mv.setViewName("user-role-add");
        return mv;
    }

    /**
     * 给用户添加角色
     * @param userId
     * @param roleIds
     */
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name="userId",required = true)String userId,
                              @RequestParam(name="ids",required = true)String[] roleIds){
        userService.addRoleToUser(userId,roleIds);

        return "redirect:findAll.do";
    }
}
