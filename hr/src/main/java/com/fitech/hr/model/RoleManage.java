package com.fitech.hr.model;

import java.sql.Date;

public class RoleManage {
    private String roleId;
    private String pareRoleId;
    private String roleName;
    private String roleTypeCode;
    private String createEmployeeId;
    private Date createTime;
    private String mdyEmployeeId;
    private Date mdyTime;
    private String remark;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPareRoleId() {
        return pareRoleId;
    }

    public void setPareRoleId(String pareRoleId) {
        this.pareRoleId = pareRoleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleTypeCode() {
        return roleTypeCode;
    }

    public void setRoleTypeCode(String roleTypeCode) {
        this.roleTypeCode = roleTypeCode;
    }

    public String getCreateEmployeeId() {
        return createEmployeeId;
    }

    public void setCreateEmployeeId(String createEmployeeId) {
        this.createEmployeeId = createEmployeeId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMdyEmployeeId() {
        return mdyEmployeeId;
    }

    public void setMdyEmployeeId(String mdyEmployeeId) {
        this.mdyEmployeeId = mdyEmployeeId;
    }

    public Date getMdyTime() {
        return mdyTime;
    }

    public void setMdyTime(Date mdyTime) {
        this.mdyTime = mdyTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
