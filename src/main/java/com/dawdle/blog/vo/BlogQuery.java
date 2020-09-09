package com.dawdle.blog.vo;

import com.dawdle.blog.pojo.Type;

import java.util.Date;

/**
 * @author zhoubin
 * @create 2020/9/1  15:26
 */
public class BlogQuery {
    private Long id;
    private String title;
    private Date updateTime;
    private Boolean recommend;
    private Boolean publish;
    private Long typeId;
    private Type type;

    public BlogQuery() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getRecommend() {
        return recommend;
    }

    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
    }

    public Boolean getPublish() {
        return publish;
    }

    public void setPublish(Boolean publish) {
        this.publish = publish;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "BlogQuery{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", updateTime=" + updateTime +
                ", recommend=" + recommend +
                ", publish=" + publish +
                ", typeId=" + typeId +
                ", type=" + type +
                '}';
    }

}
