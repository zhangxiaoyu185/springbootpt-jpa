package com.xiaoyu.lingdian.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 测试表
 */
@Entity
public class Test {

    /**
     * id
     */
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * 名称
     */
    @NotNull(message = "名称必传")
    private String name;

    /**
     * 等级
     */
    @NotNull(message = "等级必传")
    @Min(value = 1, message = "最小等级为1")
    private Integer grade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Test() {
    }

}