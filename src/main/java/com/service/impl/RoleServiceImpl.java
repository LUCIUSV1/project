package com.service.impl;

import com.dao.RoleMapper;
import com.entity.Role;
import com.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/11/30.
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Resource(name = "roleMapper")
    private RoleMapper roleMapper;

    public RoleMapper getRoleMapper() {
        return roleMapper;
    }

    public void setRoleMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    public List<Role> getRole() {
        return roleMapper.getRole();
    }
}
