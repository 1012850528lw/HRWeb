package com.fitech.hr.model;

import java.sql.Date;

/**
 * 员工表
 */
public class Employee {
    private String employeeId; // 员工号
    private String organId; // 组织编号
    private String employeeName; // 员工姓名
    private String postName; // 职务/岗位名称
    private String sexTypeCode; // 性别类型代码 01男 02女
    private Date birthDate; // 出生日期
    private Integer age; // 年龄
    private String identId; // 身份证号
    private String mobile; // 主用移动电话
    private String postalAddress; // 通讯地址
    private String postalPost; // 通讯地址邮编
    private String residAddress; // 户籍地址
    private String residPost; // 户籍地址邮编
    private String baseLocation; // 工作基地
    private String socialPayLocation; // 社保缴纳地区
    private String eduBackLevelCode; // 最高学历代码
    private Date gradDate; // 毕业日期
    private String gradSchoolName; // 毕业院校名称
    private String gradProfessName; // 毕业专业名称
    private String gradSchoolTypeCode; // 毕业院校类型代码
    private Date joinWorkDate; // 参加工作日期
    private Integer workAge; // 工龄
    private Date joinCompDate; // 入司日期
    private Integer compAge; // 司龄
    private String lastContTypeCode; // 最近一次合同类型代码
    private Date lastContBeginDate; // 最近一次合同开始日期
    private Date lastContEndDate; // 最近一次合同到期日期
    private String resumeSource; // 简历来源
    private String payCardId; // 工资卡号
    private String payCardBankName; // 工资卡开户行名称
    private String dingdingOpenStatus; // 钉钉开通状态
    private String mailOpenStatus; // 邮箱开通状态
    private String wipeSysOpenStatus; // 报销系统开通状态
    private String trainSysOpenStatus; // 培训系统开通状态
    private String employeeStatus; // 员工状态
    private Date putOffDate; // 使用顺延日期;
    private Date becomeDate; // 转正日期
    private Date leaveDate; // 离职日期
    private String leaveReason; // 离职原因
    private String leaveNote; // 离职说明
    private String professCert; // 专业证书
    private String remark; // 备注
    private String createEmployeeId; // 创建员工号
    private Date createTime; // 创建日期
    private String mdyEmployeeId; // 修改员工号
    private Date mdyTime; // 修改时间

    public String getResidAddress() {
        return residAddress;
    }

    public void setResidAddress(String residAddress) {
        this.residAddress = residAddress;
    }

    public String getResidPost() {
        return residPost;
    }

    public void setResidPost(String residPost) {
        this.residPost = residPost;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getOrganId() {
        return organId;
    }

    public void setOrganId(String organId) {
        this.organId = organId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getSexTypeCode() {
        return sexTypeCode;
    }

    public void setSexTypeCode(String sexTypeCode) {
        this.sexTypeCode = sexTypeCode;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getIdentId() {
        return identId;
    }

    public void setIdentId(String identId) {
        this.identId = identId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String getPostalPost() {
        return postalPost;
    }

    public void setPostalPost(String postalPost) {
        this.postalPost = postalPost;
    }

    public String getBaseLocation() {
        return baseLocation;
    }

    public void setBaseLocation(String baseLocation) {
        this.baseLocation = baseLocation;
    }

    public String getSocialPayLocation() {
        return socialPayLocation;
    }

    public void setSocialPayLocation(String socialPayLocation) {
        this.socialPayLocation = socialPayLocation;
    }

    public String getEduBackLevelCode() {
        return eduBackLevelCode;
    }

    public void setEduBackLevelCode(String eduBackLevelCode) {
        this.eduBackLevelCode = eduBackLevelCode;
    }

    public Date getGradDate() {
        return gradDate;
    }

    public void setGradDate(Date gradDate) {
        this.gradDate = gradDate;
    }

    public String getGradSchoolName() {
        return gradSchoolName;
    }

    public void setGradSchoolName(String gradSchoolName) {
        this.gradSchoolName = gradSchoolName;
    }

    public String getGradProfessName() {
        return gradProfessName;
    }

    public void setGradProfessName(String gradProfessName) {
        this.gradProfessName = gradProfessName;
    }

    public String getGradSchoolTypeCode() {
        return gradSchoolTypeCode;
    }

    public void setGradSchoolTypeCode(String gradSchoolTypeCode) {
        this.gradSchoolTypeCode = gradSchoolTypeCode;
    }

    public Date getJoinWorkDate() {
        return joinWorkDate;
    }

    public void setJoinWorkDate(Date joinWorkDate) {
        this.joinWorkDate = joinWorkDate;
    }

    public Integer getWorkAge() {
        return workAge;
    }

    public void setWorkAge(Integer workAge) {
        this.workAge = workAge;
    }

    public Date getJoinCompDate() {
        return joinCompDate;
    }

    public void setJoinCompDate(Date joinCompDate) {
        this.joinCompDate = joinCompDate;
    }

    public Integer getCompAge() {
        return compAge;
    }

    public void setCompAge(Integer compAge) {
        this.compAge = compAge;
    }

    public String getLastContTypeCode() {
        return lastContTypeCode;
    }

    public void setLastContTypeCode(String lastContTypeCode) {
        this.lastContTypeCode = lastContTypeCode;
    }

    public Date getLastContBeginDate() {
        return lastContBeginDate;
    }

    public void setLastContBeginDate(Date lastContBeginDate) {
        this.lastContBeginDate = lastContBeginDate;
    }

    public Date getLastContEndDate() {
        return lastContEndDate;
    }

    public void setLastContEndDate(Date lastContEndDate) {
        this.lastContEndDate = lastContEndDate;
    }

    public String getResumeSource() {
        return resumeSource;
    }

    public void setResumeSource(String resumeSource) {
        this.resumeSource = resumeSource;
    }

    public String getPayCardId() {
        return payCardId;
    }

    public void setPayCardId(String payCardId) {
        this.payCardId = payCardId;
    }

    public String getPayCardBankName() {
        return payCardBankName;
    }

    public void setPayCardBankName(String payCardBankName) {
        this.payCardBankName = payCardBankName;
    }

    public String getDingdingOpenStatus() {
        return dingdingOpenStatus;
    }

    public void setDingdingOpenStatus(String dingdingOpenStatus) {
        this.dingdingOpenStatus = dingdingOpenStatus;
    }

    public String getMailOpenStatus() {
        return mailOpenStatus;
    }

    public void setMailOpenStatus(String mailOpenStatus) {
        this.mailOpenStatus = mailOpenStatus;
    }

    public String getWipeSysOpenStatus() {
        return wipeSysOpenStatus;
    }

    public void setWipeSysOpenStatus(String wipeSysOpenStatus) {
        this.wipeSysOpenStatus = wipeSysOpenStatus;
    }

    public String getTrainSysOpenStatus() {
        return trainSysOpenStatus;
    }

    public void setTrainSysOpenStatus(String trainSysOpenStatus) {
        this.trainSysOpenStatus = trainSysOpenStatus;
    }

    public String getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public Date getPutOffDate() {
        return putOffDate;
    }

    public void setPutOffDate(Date putOffDate) {
        this.putOffDate = putOffDate;
    }

    public Date getBecomeDate() {
        return becomeDate;
    }

    public void setBecomeDate(Date becomeDate) {
        this.becomeDate = becomeDate;
    }

    public Date getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(Date leaveDate) {
        this.leaveDate = leaveDate;
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }

    public String getLeaveNote() {
        return leaveNote;
    }

    public void setLeaveNote(String leaveNote) {
        this.leaveNote = leaveNote;
    }

    public String getProfessCert() {
        return professCert;
    }

    public void setProfessCert(String professCert) {
        this.professCert = professCert;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
}
