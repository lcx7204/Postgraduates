package com.yixuan.entity;

import java.util.Date;

public class Keep {
    private String collectionId;

    private String collectionUser;

    private String collectionInfo;

    private Date collectionDate;

    public String getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(String collectionId) {
        this.collectionId = collectionId == null ? null : collectionId.trim();
    }

    public String getCollectionUser() {
        return collectionUser;
    }

    public void setCollectionUser(String collectionUser) {
        this.collectionUser = collectionUser == null ? null : collectionUser.trim();
    }

    public String getCollectionInfo() {
        return collectionInfo;
    }

    public void setCollectionInfo(String collectionInfo) {
        this.collectionInfo = collectionInfo == null ? null : collectionInfo.trim();
    }

    public Date getCollectionDate() {
        return collectionDate;
    }

    public void setCollectionDate(Date collectionDate) {
        this.collectionDate = collectionDate;
    }
}