package com.fitech.hr.model;

import java.sql.Date;

/**
 * 角色表
 */
public class RoleManage {
    private String roleId; // 角色Id
    private String pareRoleId; // 上级角色Id
    private String roleName; //角色名称
    private String roleTypeCode; //角色类型代码
    private String createEmployeeId; // 创建员工号
    private Date createTime; // 创建时间
    private String mdyEmployeeId; //修改员工号
    private Date mdyTime; // 修改时间
    private String remark; //备注

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
