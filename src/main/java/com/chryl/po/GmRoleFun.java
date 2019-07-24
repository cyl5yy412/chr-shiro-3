package com.chryl.po;

import java.io.Serializable;

public class GmRoleFun implements Serializable {
    private String roleFunGRoleId;

    private String roleFunGFunId;

    private static final long serialVersionUID = 1L;

    public String getRoleFunGRoleId() {
        return roleFunGRoleId;
    }

    public void setRoleFunGRoleId(String roleFunGRoleId) {
        this.roleFunGRoleId = roleFunGRoleId == null ? null : roleFunGRoleId.trim();
    }

    public String getRoleFunGFunId() {
        return roleFunGFunId;
    }

    public void setRoleFunGFunId(String roleFunGFunId) {
        this.roleFunGFunId = roleFunGFunId == null ? null : roleFunGFunId.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", roleFunGRoleId=").append(roleFunGRoleId);
        sb.append(", roleFunGFunId=").append(roleFunGFunId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}