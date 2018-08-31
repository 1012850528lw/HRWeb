package com.fitech.hr.model;

import java.sql.Date;

/**
 * 组织机构表
 */
public class OrganStruct {
    private String organId; // 组织编号
    private String pareOrganId; //上级组织编号
    private String organName; //组织名称
    private String organTypeCode; // 组织类型代码
    private String organNote; //组织职能描述
    private Date establishDate; //成立日期
    private Date revokeDate; //撤销日期
    private String revokeReason; // 撤销理由
    private String headEmployeeId; //负责人员工号
    private String unSocialCreditCode; //统一社会信用代码
    private String organAddress; //地址
    private String contactNumber; // 联系电话
    private String basicDepositAcct; // 基本户账号
    private String basicDepositBank; // 基本户开户行名称
    private String organStatus; // 组织状态代码 01 筹备中 02 已成立 03 已撤销
    private String createEmployeeId; //创建员工号
    private String mdyEmployeeId; //修改员工号
    private Date createTime; // 创建时间
    private Date mdyTime; // 修改时间
    private String post; //邮编
    private String fax; //传真
    private Integer organLevel; //组织级别

    public String getOrganId() {
        return organId;
    }

    public void setOrganId(String organId) {
        this.organId = organId;
    }

    public String getPareOrganId() {
        return pareOrganId;
    }

    public void setPareOrganId(String pareOrganId) {
        this.pareOrganId = pareOrganId;
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    public String getOrganTypeCode() {
        return organTypeCode;
    }

    public void setOrganTypeCode(String organTypeCode) {
        this.organTypeCode = organTypeCode;
    }

    public String getOrganNote() {
        return organNote;
    }

    public void setOrganNote(String organNote) {
        this.organNote = organNote;
    }

    public Date getEstablishDate() {
        return establishDate;
    }

    public void setEstablishDate(Date establishDate) {
        this.establishDate = establishDate;
    }

    public Date getRevokeDate() {
        return revokeDate;
    }

    public void setRevokeDate(Date revokeDate) {
        this.revokeDate = revokeDate;
    }

    public String getRevokeReason() {
        return revokeReason;
    }

    public void setRevokeReason(String revokeReason) {
        this.revokeReason = revokeReason;
    }

    public String getHeadEmployeeId() {
        return headEmployeeId;
    }

    public void setHeadEmployeeId(String headEmployeeId) {
        this.headEmployeeId = headEmployeeId;
    }

    public String getUnSocialCreditCode() {
        return unSocialCreditCode;
    }

    public void setUnSocialCreditCode(String unSocialCreditCode) {
        this.unSocialCreditCode = unSocialCreditCode;
    }

    public String getOrganAddress() {
        return organAddress;
    }

    public void setOrganAddress(String organAddress) {
        this.organAddress = organAddress;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getBasicDepositAcct() {
        return basicDepositAcct;
    }

    public void setBasicDepositAcct(String basicDepositAcct) {
        this.basicDepositAcct = basicDepositAcct;
    }

    public String getBasicDepositBank() {
        return basicDepositBank;
    }

    public void setBasicDepositBank(String basicDepositBank) {
        this.basicDepositBank = basicDepositBank;
    }

    public String getOrganStatus() {
        return organStatus;
    }

    public void setOrganStatus(String organStatus) {
        this.organStatus = organStatus;
    }

    public String getCreateEmployeeId() {
        return createEmployeeId;
    }

    public void setCreateEmployeeId(String createEmployeeId) {
        this.createEmployeeId = createEmployeeId;
    }

    public String getMdyEmployeeId() {
        return mdyEmployeeId;
    }

    public void setMdyEmployeeId(String mdyEmployeeId) {
        this.mdyEmployeeId = mdyEmployeeId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getOrganLevel() {
        return organLevel;
    }

    public void setOrganLevel(Integer organLevel) {
        this.organLevel = organLevel;
    }

    public Date getMdyTime() {
        return mdyTime;
    }

    public void setMdyTime(Date mdyTime) {
        this.mdyTime = mdyTime;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
}
