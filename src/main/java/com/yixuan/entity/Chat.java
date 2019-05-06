package com.yixuan.entity;

import java.util.Date;

public class Chat {
    private Integer chatId;

    private String sendId;

    private String accessId;

    private String chatContent;

    private Date chatDate;

    private User User;

    public Integer getChatId() {
        return chatId;
    }

    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }

    public String getSendId() {
        return sendId;
    }

    public void setSendId(String sendId) {
        this.sendId = sendId == null ? null : sendId.trim();
    }

    public String getAccessId() {
        return accessId;
    }

    public void setAccessId(String accessId) {
        this.accessId = accessId == null ? null : accessId.trim();
    }

    public String getChatContent() {
        return chatContent;
    }

    public void setChatContent(String chatContent) {
        this.chatContent = chatContent == null ? null : chatContent.trim();
    }

    public Date getChatDate() {
        return chatDate;
    }

    public void setChatDate(Date chatDate) {
        this.chatDate = chatDate;
    }

    public com.yixuan.entity.User getUser() {
        return User;
    }

    public void setUser(com.yixuan.entity.User user) {
        User = user;
    }
}