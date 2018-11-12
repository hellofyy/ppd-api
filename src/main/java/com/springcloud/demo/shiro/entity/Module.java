package com.springcloud.demo.shiro.entity;

import java.util.Set;

public class Module {
    private Integer mid;

    private String mname;

    private Set<Role> roles;

    public Module(Integer mid, String mname) {
        this.mid = mid;
        this.mname = mname;
    }

    public Module() {
        super();
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


}
