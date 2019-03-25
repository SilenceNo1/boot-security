package com.boot.security.server.model;

public class Classification extends BaseEntity<Long> {

// 类别名称;
    private String name;
// 类别父级主键;
    private Long pid;
// 图片地址;
    private String classImageUrl;
// 是否展示;
    private Integer display = 0;
// 大图片地址;
    private String classBigimageUrl;
// 分类级别;
    private Integer grade;
// 类别首页展示图片;
    private String classHomeImage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getClassImageUrl() {
        return classImageUrl;
    }

    public void setClassImageUrl(String classImageUrl) {
        this.classImageUrl = classImageUrl;
    }

    public Integer getDisplay() {
        return display;
    }

    public void setDisplay(Integer display) {
        this.display = display;
    }

    public String getClassBigimageUrl() {
        return classBigimageUrl;
    }

    public void setClassBigimageUrl(String classBigimageUrl) {
        this.classBigimageUrl = classBigimageUrl;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getClassHomeImage() {
        return classHomeImage;
    }

    public void setClassHomeImage(String classHomeImage) {
        this.classHomeImage = classHomeImage;
    }

}
