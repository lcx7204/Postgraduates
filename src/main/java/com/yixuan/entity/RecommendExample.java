package com.yixuan.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RecommendExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RecommendExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andRecommendIdIsNull() {
            addCriterion("recommend_id is null");
            return (Criteria) this;
        }

        public Criteria andRecommendIdIsNotNull() {
            addCriterion("recommend_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendIdEqualTo(String value) {
            addCriterion("recommend_id =", value, "recommendId");
            return (Criteria) this;
        }

        public Criteria andRecommendIdNotEqualTo(String value) {
            addCriterion("recommend_id <>", value, "recommendId");
            return (Criteria) this;
        }

        public Criteria andRecommendIdGreaterThan(String value) {
            addCriterion("recommend_id >", value, "recommendId");
            return (Criteria) this;
        }

        public Criteria andRecommendIdGreaterThanOrEqualTo(String value) {
            addCriterion("recommend_id >=", value, "recommendId");
            return (Criteria) this;
        }

        public Criteria andRecommendIdLessThan(String value) {
            addCriterion("recommend_id <", value, "recommendId");
            return (Criteria) this;
        }

        public Criteria andRecommendIdLessThanOrEqualTo(String value) {
            addCriterion("recommend_id <=", value, "recommendId");
            return (Criteria) this;
        }

        public Criteria andRecommendIdLike(String value) {
            addCriterion("recommend_id like", value, "recommendId");
            return (Criteria) this;
        }

        public Criteria andRecommendIdNotLike(String value) {
            addCriterion("recommend_id not like", value, "recommendId");
            return (Criteria) this;
        }

        public Criteria andRecommendIdIn(List<String> values) {
            addCriterion("recommend_id in", values, "recommendId");
            return (Criteria) this;
        }

        public Criteria andRecommendIdNotIn(List<String> values) {
            addCriterion("recommend_id not in", values, "recommendId");
            return (Criteria) this;
        }

        public Criteria andRecommendIdBetween(String value1, String value2) {
            addCriterion("recommend_id between", value1, value2, "recommendId");
            return (Criteria) this;
        }

        public Criteria andRecommendIdNotBetween(String value1, String value2) {
            addCriterion("recommend_id not between", value1, value2, "recommendId");
            return (Criteria) this;
        }

        public Criteria andRecommendCategoryIsNull() {
            addCriterion("recommend_category is null");
            return (Criteria) this;
        }

        public Criteria andRecommendCategoryIsNotNull() {
            addCriterion("recommend_category is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendCategoryEqualTo(String value) {
            addCriterion("recommend_category =", value, "recommendCategory");
            return (Criteria) this;
        }

        public Criteria andRecommendCategoryNotEqualTo(String value) {
            addCriterion("recommend_category <>", value, "recommendCategory");
            return (Criteria) this;
        }

        public Criteria andRecommendCategoryGreaterThan(String value) {
            addCriterion("recommend_category >", value, "recommendCategory");
            return (Criteria) this;
        }

        public Criteria andRecommendCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("recommend_category >=", value, "recommendCategory");
            return (Criteria) this;
        }

        public Criteria andRecommendCategoryLessThan(String value) {
            addCriterion("recommend_category <", value, "recommendCategory");
            return (Criteria) this;
        }

        public Criteria andRecommendCategoryLessThanOrEqualTo(String value) {
            addCriterion("recommend_category <=", value, "recommendCategory");
            return (Criteria) this;
        }

        public Criteria andRecommendCategoryLike(String value) {
            addCriterion("recommend_category like", value, "recommendCategory");
            return (Criteria) this;
        }

        public Criteria andRecommendCategoryNotLike(String value) {
            addCriterion("recommend_category not like", value, "recommendCategory");
            return (Criteria) this;
        }

        public Criteria andRecommendCategoryIn(List<String> values) {
            addCriterion("recommend_category in", values, "recommendCategory");
            return (Criteria) this;
        }

        public Criteria andRecommendCategoryNotIn(List<String> values) {
            addCriterion("recommend_category not in", values, "recommendCategory");
            return (Criteria) this;
        }

        public Criteria andRecommendCategoryBetween(String value1, String value2) {
            addCriterion("recommend_category between", value1, value2, "recommendCategory");
            return (Criteria) this;
        }

        public Criteria andRecommendCategoryNotBetween(String value1, String value2) {
            addCriterion("recommend_category not between", value1, value2, "recommendCategory");
            return (Criteria) this;
        }

        public Criteria andRecommendTitleIsNull() {
            addCriterion("recommend_title is null");
            return (Criteria) this;
        }

        public Criteria andRecommendTitleIsNotNull() {
            addCriterion("recommend_title is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendTitleEqualTo(String value) {
            addCriterion("recommend_title =", value, "recommendTitle");
            return (Criteria) this;
        }

        public Criteria andRecommendTitleNotEqualTo(String value) {
            addCriterion("recommend_title <>", value, "recommendTitle");
            return (Criteria) this;
        }

        public Criteria andRecommendTitleGreaterThan(String value) {
            addCriterion("recommend_title >", value, "recommendTitle");
            return (Criteria) this;
        }

        public Criteria andRecommendTitleGreaterThanOrEqualTo(String value) {
            addCriterion("recommend_title >=", value, "recommendTitle");
            return (Criteria) this;
        }

        public Criteria andRecommendTitleLessThan(String value) {
            addCriterion("recommend_title <", value, "recommendTitle");
            return (Criteria) this;
        }

        public Criteria andRecommendTitleLessThanOrEqualTo(String value) {
            addCriterion("recommend_title <=", value, "recommendTitle");
            return (Criteria) this;
        }

        public Criteria andRecommendTitleLike(String value) {
            addCriterion("recommend_title like", value, "recommendTitle");
            return (Criteria) this;
        }

        public Criteria andRecommendTitleNotLike(String value) {
            addCriterion("recommend_title not like", value, "recommendTitle");
            return (Criteria) this;
        }

        public Criteria andRecommendTitleIn(List<String> values) {
            addCriterion("recommend_title in", values, "recommendTitle");
            return (Criteria) this;
        }

        public Criteria andRecommendTitleNotIn(List<String> values) {
            addCriterion("recommend_title not in", values, "recommendTitle");
            return (Criteria) this;
        }

        public Criteria andRecommendTitleBetween(String value1, String value2) {
            addCriterion("recommend_title between", value1, value2, "recommendTitle");
            return (Criteria) this;
        }

        public Criteria andRecommendTitleNotBetween(String value1, String value2) {
            addCriterion("recommend_title not between", value1, value2, "recommendTitle");
            return (Criteria) this;
        }

        public Criteria andRecommendContentIsNull() {
            addCriterion("recommend_content is null");
            return (Criteria) this;
        }

        public Criteria andRecommendContentIsNotNull() {
            addCriterion("recommend_content is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendContentEqualTo(String value) {
            addCriterion("recommend_content =", value, "recommendContent");
            return (Criteria) this;
        }

        public Criteria andRecommendContentNotEqualTo(String value) {
            addCriterion("recommend_content <>", value, "recommendContent");
            return (Criteria) this;
        }

        public Criteria andRecommendContentGreaterThan(String value) {
            addCriterion("recommend_content >", value, "recommendContent");
            return (Criteria) this;
        }

        public Criteria andRecommendContentGreaterThanOrEqualTo(String value) {
            addCriterion("recommend_content >=", value, "recommendContent");
            return (Criteria) this;
        }

        public Criteria andRecommendContentLessThan(String value) {
            addCriterion("recommend_content <", value, "recommendContent");
            return (Criteria) this;
        }

        public Criteria andRecommendContentLessThanOrEqualTo(String value) {
            addCriterion("recommend_content <=", value, "recommendContent");
            return (Criteria) this;
        }

        public Criteria andRecommendContentLike(String value) {
            addCriterion("recommend_content like", value, "recommendContent");
            return (Criteria) this;
        }

        public Criteria andRecommendContentNotLike(String value) {
            addCriterion("recommend_content not like", value, "recommendContent");
            return (Criteria) this;
        }

        public Criteria andRecommendContentIn(List<String> values) {
            addCriterion("recommend_content in", values, "recommendContent");
            return (Criteria) this;
        }

        public Criteria andRecommendContentNotIn(List<String> values) {
            addCriterion("recommend_content not in", values, "recommendContent");
            return (Criteria) this;
        }

        public Criteria andRecommendContentBetween(String value1, String value2) {
            addCriterion("recommend_content between", value1, value2, "recommendContent");
            return (Criteria) this;
        }

        public Criteria andRecommendContentNotBetween(String value1, String value2) {
            addCriterion("recommend_content not between", value1, value2, "recommendContent");
            return (Criteria) this;
        }

        public Criteria andRecommendIconIsNull() {
            addCriterion("recommend_icon is null");
            return (Criteria) this;
        }

        public Criteria andRecommendIconIsNotNull() {
            addCriterion("recommend_icon is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendIconEqualTo(String value) {
            addCriterion("recommend_icon =", value, "recommendIcon");
            return (Criteria) this;
        }

        public Criteria andRecommendIconNotEqualTo(String value) {
            addCriterion("recommend_icon <>", value, "recommendIcon");
            return (Criteria) this;
        }

        public Criteria andRecommendIconGreaterThan(String value) {
            addCriterion("recommend_icon >", value, "recommendIcon");
            return (Criteria) this;
        }

        public Criteria andRecommendIconGreaterThanOrEqualTo(String value) {
            addCriterion("recommend_icon >=", value, "recommendIcon");
            return (Criteria) this;
        }

        public Criteria andRecommendIconLessThan(String value) {
            addCriterion("recommend_icon <", value, "recommendIcon");
            return (Criteria) this;
        }

        public Criteria andRecommendIconLessThanOrEqualTo(String value) {
            addCriterion("recommend_icon <=", value, "recommendIcon");
            return (Criteria) this;
        }

        public Criteria andRecommendIconLike(String value) {
            addCriterion("recommend_icon like", value, "recommendIcon");
            return (Criteria) this;
        }

        public Criteria andRecommendIconNotLike(String value) {
            addCriterion("recommend_icon not like", value, "recommendIcon");
            return (Criteria) this;
        }

        public Criteria andRecommendIconIn(List<String> values) {
            addCriterion("recommend_icon in", values, "recommendIcon");
            return (Criteria) this;
        }

        public Criteria andRecommendIconNotIn(List<String> values) {
            addCriterion("recommend_icon not in", values, "recommendIcon");
            return (Criteria) this;
        }

        public Criteria andRecommendIconBetween(String value1, String value2) {
            addCriterion("recommend_icon between", value1, value2, "recommendIcon");
            return (Criteria) this;
        }

        public Criteria andRecommendIconNotBetween(String value1, String value2) {
            addCriterion("recommend_icon not between", value1, value2, "recommendIcon");
            return (Criteria) this;
        }

        public Criteria andRecommendDetailIsNull() {
            addCriterion("recommend_detail is null");
            return (Criteria) this;
        }

        public Criteria andRecommendDetailIsNotNull() {
            addCriterion("recommend_detail is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendDetailEqualTo(String value) {
            addCriterion("recommend_detail =", value, "recommendDetail");
            return (Criteria) this;
        }

        public Criteria andRecommendDetailNotEqualTo(String value) {
            addCriterion("recommend_detail <>", value, "recommendDetail");
            return (Criteria) this;
        }

        public Criteria andRecommendDetailGreaterThan(String value) {
            addCriterion("recommend_detail >", value, "recommendDetail");
            return (Criteria) this;
        }

        public Criteria andRecommendDetailGreaterThanOrEqualTo(String value) {
            addCriterion("recommend_detail >=", value, "recommendDetail");
            return (Criteria) this;
        }

        public Criteria andRecommendDetailLessThan(String value) {
            addCriterion("recommend_detail <", value, "recommendDetail");
            return (Criteria) this;
        }

        public Criteria andRecommendDetailLessThanOrEqualTo(String value) {
            addCriterion("recommend_detail <=", value, "recommendDetail");
            return (Criteria) this;
        }

        public Criteria andRecommendDetailLike(String value) {
            addCriterion("recommend_detail like", value, "recommendDetail");
            return (Criteria) this;
        }

        public Criteria andRecommendDetailNotLike(String value) {
            addCriterion("recommend_detail not like", value, "recommendDetail");
            return (Criteria) this;
        }

        public Criteria andRecommendDetailIn(List<String> values) {
            addCriterion("recommend_detail in", values, "recommendDetail");
            return (Criteria) this;
        }

        public Criteria andRecommendDetailNotIn(List<String> values) {
            addCriterion("recommend_detail not in", values, "recommendDetail");
            return (Criteria) this;
        }

        public Criteria andRecommendDetailBetween(String value1, String value2) {
            addCriterion("recommend_detail between", value1, value2, "recommendDetail");
            return (Criteria) this;
        }

        public Criteria andRecommendDetailNotBetween(String value1, String value2) {
            addCriterion("recommend_detail not between", value1, value2, "recommendDetail");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNull() {
            addCriterion("author is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNotNull() {
            addCriterion("author is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorEqualTo(String value) {
            addCriterion("author =", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotEqualTo(String value) {
            addCriterion("author <>", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThan(String value) {
            addCriterion("author >", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("author >=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThan(String value) {
            addCriterion("author <", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThanOrEqualTo(String value) {
            addCriterion("author <=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLike(String value) {
            addCriterion("author like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotLike(String value) {
            addCriterion("author not like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorIn(List<String> values) {
            addCriterion("author in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotIn(List<String> values) {
            addCriterion("author not in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorBetween(String value1, String value2) {
            addCriterion("author between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotBetween(String value1, String value2) {
            addCriterion("author not between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andPublishDateIsNull() {
            addCriterion("publish_date is null");
            return (Criteria) this;
        }

        public Criteria andPublishDateIsNotNull() {
            addCriterion("publish_date is not null");
            return (Criteria) this;
        }

        public Criteria andPublishDateEqualTo(Date value) {
            addCriterionForJDBCDate("publish_date =", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("publish_date <>", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateGreaterThan(Date value) {
            addCriterionForJDBCDate("publish_date >", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("publish_date >=", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateLessThan(Date value) {
            addCriterionForJDBCDate("publish_date <", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("publish_date <=", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateIn(List<Date> values) {
            addCriterionForJDBCDate("publish_date in", values, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("publish_date not in", values, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("publish_date between", value1, value2, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("publish_date not between", value1, value2, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}