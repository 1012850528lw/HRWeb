package com.fitech.hr.model;

/**
 * 菜单表
 */
public class MenuManage {

    private String menuId; // 菜单编号
    private String pareMenuId;// 上级菜单编号
    private String menuIcon;// 菜单图标
    private String isEnable; // 是否可用
    private String menuName; // 菜单名称
    private String menuUrl; // 菜单URL
    private Integer menuOrder; // 菜单顺序
    private String remark; //备注

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getPareMenuId() {
        return pareMenuId;
    }

    public void setPareMenuId(String pareMenuId) {
        this.pareMenuId = pareMenuId;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public Integer getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(Integer menuOrder) {
        this.menuOrder = menuOrder;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
