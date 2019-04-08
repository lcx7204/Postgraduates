package com.yixuan.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Recommend {
    private String recommendId;

    private String recommendCategory;

    private String recommendTitle;

    private String recommendContent;

    private String recommendIcon;

    private String recommendDetail;

    private String companyName;

    private String author;

    private Date publishDate;

    private BigDecimal price;

    public String getRecommendId() {
        return recommendId;
    }

    public void setRecommendId(String recommendId) {
        this.recommendId = recommendId == null ? null : recommendId.trim();
    }

    public String getRecommendCategory() {
        return recommendCategory;
    }

    public void setRecommendCategory(String recommendCategory) {
        this.recommendCategory = recommendCategory == null ? null : recommendCategory.trim();
    }

    public String getRecommendTitle() {
        return recommendTitle;
    }

    public void setRecommendTitle(String recommendTitle) {
        this.recommendTitle = recommendTitle == null ? null : recommendTitle.trim();
    }

    public String getRecommendContent() {
        return recommendContent;
    }

    public void setRecommendContent(String recommendContent) {
        this.recommendContent = recommendContent == null ? null : recommendContent.trim();
    }

    public String getRecommendIcon() {
        return recommendIcon;
    }

    public void setRecommendIcon(String recommendIcon) {
        this.recommendIcon = recommendIcon == null ? null : recommendIcon.trim();
    }

    public String getRecommendDetail() {
        return recommendDetail;
    }

    public void setRecommendDetail(String recommendDetail) {
        this.recommendDetail = recommendDetail == null ? null : recommendDetail.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}