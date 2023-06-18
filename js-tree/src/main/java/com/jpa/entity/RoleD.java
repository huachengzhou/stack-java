package com.jpa.entity;

import java.io.Serializable;

public class RoleD implements Serializable {

    /**
     * 注意，对象要可序列化，需要实现Serializable接口，往往要重写serialVersionUID
     */
    private static final long serialVersionUID = 3447499459461375642L;
    private long id;
    private String roleName;
    private String note;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleD roleD = (RoleD) o;

        if (id != roleD.id) return false;
        if (roleName != null ? !roleName.equals(roleD.roleName) : roleD.roleName != null) return false;
        return note != null ? note.equals(roleD.note) : roleD.note == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RoleD{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
