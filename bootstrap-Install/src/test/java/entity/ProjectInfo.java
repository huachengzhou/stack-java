package entity;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

import java.io.Serializable;

public class ProjectInfo implements Serializable,Comparable<ProjectInfo> {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(ProjectInfo o) {
        return ComparisonChain.start().compare(this.getName(),o.getName()).compare(this.getId(),o.getId()).result();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId(),getName());
    }
}
