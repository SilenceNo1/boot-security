package com.boot.security.server.dto;

import java.util.List;

import com.boot.security.server.model.SysUser;

public class UserDto extends SysUser {

    private static final long serialVersionUID = -184009306207076712L;

    private List<Long> roleIds;
    
    private String sysCode;

    public String getSysCode() {
		return sysCode;
	}

	public void setSysCode(String sysCode) {
		this.sysCode = sysCode;
	}

	public List<Long> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }

}
