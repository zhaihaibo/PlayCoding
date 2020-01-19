package com.example.demo.entity;

public class BaseEntity  {
    private String createTime;

    public BaseEntity(String createTime) {
        this.createTime = createTime;
    }

    public BaseEntity() {
    }

    public String getCreateTime() {
        return createTime;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "createTime='" + createTime + '\'' +
                '}';
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
