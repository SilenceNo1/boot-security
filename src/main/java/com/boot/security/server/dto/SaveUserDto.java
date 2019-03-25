package com.boot.security.server.dto;

import com.boot.security.server.model.TUser;

public class SaveUserDto extends TUser {

    private static final long serialVersionUID = -184009306207076712L;

    private Integer inviteCode;

    public Integer getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(Integer inviteCode) {
        this.inviteCode = inviteCode;
    }

}
