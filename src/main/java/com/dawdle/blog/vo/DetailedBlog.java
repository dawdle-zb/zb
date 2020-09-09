package com.dawdle.blog.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhoubin
 * @create 2020/9/1  15:27
 */
public class DetailedBlog {

    private Long id;
    private String firstPicture;
    private String flag;
    private String title;
    private String content;

    private Integer view;
//    private Integer commentCount;
    private Date updateTime;
    private boolean comment;
    private boolean share;
    private boolean appreciate;
    private String nickname;
    private String avatar;

    //Type
    private String typeName;

    public DetailedBlog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstPicture() {
        return firstPicture;
    }

    public void setFirstPicture(String firstPicture) {
        this.firstPicture = firstPicture;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getView() {
        return view;
    }

    public void setView(Integer view) {
        this.view = view;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public boolean isComment() {
        return comment;
    }

    public void setComment(boolean comment) {
        this.comment = comment;
    }

    public boolean isShare() {
        return share;
    }

    public void setShare(boolean share) {
        this.share = share;
    }

    public boolean isAppreciate() {
        return appreciate;
    }

    public void setAppreciate(boolean appreciate) {
        this.appreciate = appreciate;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "DetailedBlog{" +
                "id=" + id +
                ", firstPicture='" + firstPicture + '\'' +
                ", flag='" + flag + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", view=" + view +
                ", updateTime=" + updateTime +
                ", comment=" + comment +
                ", share=" + share +
                ", appreciate=" + appreciate +
                ", nickname='" + nickname + '\'' +
                ", avatar='" + avatar + '\'' +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}