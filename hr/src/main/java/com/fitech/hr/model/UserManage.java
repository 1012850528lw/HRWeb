package com.fitech.hr.model;

import java.sql.Date;

/**
 * 用户表
 */
public class UserManage {
    private String employeeId;//员工号
    private String password;//密码
    private String userOpenStatus;//用户开通状态
    private String loginHomePage;//登录首页
    private String authOrganId;//用户最高权限组织编号
    private Date startDate;//启用日期
    private Date stopDate;//停用日期
    private String roleName; // 角色名称

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserOpenStatus() {
        return userOpenStatus;
    }

    public void setUserOpenStatus(String userOpenStatus) {
        this.userOpenStatus = userOpenStatus;
    }

    public String getLoginHomePage() {
        return loginHomePage;
    }

    public void setLoginHomePage(String loginHomePage) {
        this.loginHomePage = loginHomePage;
    }

    public String getAuthOrganId() {
        return authOrganId;
    }

    public void setAuthOrganId(String authOrganId) {
        this.authOrganId = authOrganId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStopDate() {
        return stopDate;
    }

    public void setStopDate(Date stopDate) {
        this.stopDate = stopDate;
    }
}
