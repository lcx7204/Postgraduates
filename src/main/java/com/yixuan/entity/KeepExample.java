package com.yixuan.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KeepExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public KeepExample() {
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

        public Criteria andCollectionIdIsNull() {
            addCriterion("collection_id is null");
            return (Criteria) this;
        }

        public Criteria andCollectionIdIsNotNull() {
            addCriterion("collection_id is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionIdEqualTo(String value) {
            addCriterion("collection_id =", value, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdNotEqualTo(String value) {
            addCriterion("collection_id <>", value, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdGreaterThan(String value) {
            addCriterion("collection_id >", value, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdGreaterThanOrEqualTo(String value) {
            addCriterion("collection_id >=", value, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdLessThan(String value) {
            addCriterion("collection_id <", value, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdLessThanOrEqualTo(String value) {
            addCriterion("collection_id <=", value, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdLike(String value) {
            addCriterion("collection_id like", value, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdNotLike(String value) {
            addCriterion("collection_id not like", value, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdIn(List<String> values) {
            addCriterion("collection_id in", values, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdNotIn(List<String> values) {
            addCriterion("collection_id not in", values, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdBetween(String value1, String value2) {
            addCriterion("collection_id between", value1, value2, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdNotBetween(String value1, String value2) {
            addCriterion("collection_id not between", value1, value2, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionUserIsNull() {
            addCriterion("collection_user is null");
            return (Criteria) this;
        }

        public Criteria andCollectionUserIsNotNull() {
            addCriterion("collection_user is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionUserEqualTo(String value) {
            addCriterion("collection_user =", value, "collectionUser");
            return (Criteria) this;
        }

        public Criteria andCollectionUserNotEqualTo(String value) {
            addCriterion("collection_user <>", value, "collectionUser");
            return (Criteria) this;
        }

        public Criteria andCollectionUserGreaterThan(String value) {
            addCriterion("collection_user >", value, "collectionUser");
            return (Criteria) this;
        }

        public Criteria andCollectionUserGreaterThanOrEqualTo(String value) {
            addCriterion("collection_user >=", value, "collectionUser");
            return (Criteria) this;
        }

        public Criteria andCollectionUserLessThan(String value) {
            addCriterion("collection_user <", value, "collectionUser");
            return (Criteria) this;
        }

        public Criteria andCollectionUserLessThanOrEqualTo(String value) {
            addCriterion("collection_user <=", value, "collectionUser");
            return (Criteria) this;
        }

        public Criteria andCollectionUserLike(String value) {
            addCriterion("collection_user like", value, "collectionUser");
            return (Criteria) this;
        }

        public Criteria andCollectionUserNotLike(String value) {
            addCriterion("collection_user not like", value, "collectionUser");
            return (Criteria) this;
        }

        public Criteria andCollectionUserIn(List<String> values) {
            addCriterion("collection_user in", values, "collectionUser");
            return (Criteria) this;
        }

        public Criteria andCollectionUserNotIn(List<String> values) {
            addCriterion("collection_user not in", values, "collectionUser");
            return (Criteria) this;
        }

        public Criteria andCollectionUserBetween(String value1, String value2) {
            addCriterion("collection_user between", value1, value2, "collectionUser");
            return (Criteria) this;
        }

        public Criteria andCollectionUserNotBetween(String value1, String value2) {
            addCriterion("collection_user not between", value1, value2, "collectionUser");
            return (Criteria) this;
        }

        public Criteria andCollectionInfoIsNull() {
            addCriterion("collection_info is null");
            return (Criteria) this;
        }

        public Criteria andCollectionInfoIsNotNull() {
            addCriterion("collection_info is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionInfoEqualTo(String value) {
            addCriterion("collection_info =", value, "collectionInfo");
            return (Criteria) this;
        }

        public Criteria andCollectionInfoNotEqualTo(String value) {
            addCriterion("collection_info <>", value, "collectionInfo");
            return (Criteria) this;
        }

        public Criteria andCollectionInfoGreaterThan(String value) {
            addCriterion("collection_info >", value, "collectionInfo");
            return (Criteria) this;
        }

        public Criteria andCollectionInfoGreaterThanOrEqualTo(String value) {
            addCriterion("collection_info >=", value, "collectionInfo");
            return (Criteria) this;
        }

        public Criteria andCollectionInfoLessThan(String value) {
            addCriterion("collection_info <", value, "collectionInfo");
            return (Criteria) this;
        }

        public Criteria andCollectionInfoLessThanOrEqualTo(String value) {
            addCriterion("collection_info <=", value, "collectionInfo");
            return (Criteria) this;
        }

        public Criteria andCollectionInfoLike(String value) {
            addCriterion("collection_info like", value, "collectionInfo");
            return (Criteria) this;
        }

        public Criteria andCollectionInfoNotLike(String value) {
            addCriterion("collection_info not like", value, "collectionInfo");
            return (Criteria) this;
        }

        public Criteria andCollectionInfoIn(List<String> values) {
            addCriterion("collection_info in", values, "collectionInfo");
            return (Criteria) this;
        }

        public Criteria andCollectionInfoNotIn(List<String> values) {
            addCriterion("collection_info not in", values, "collectionInfo");
            return (Criteria) this;
        }

        public Criteria andCollectionInfoBetween(String value1, String value2) {
            addCriterion("collection_info between", value1, value2, "collectionInfo");
            return (Criteria) this;
        }

        public Criteria andCollectionInfoNotBetween(String value1, String value2) {
            addCriterion("collection_info not between", value1, value2, "collectionInfo");
            return (Criteria) this;
        }

        public Criteria andCollectionDateIsNull() {
            addCriterion("collection_date is null");
            return (Criteria) this;
        }

        public Criteria andCollectionDateIsNotNull() {
            addCriterion("collection_date is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionDateEqualTo(Date value) {
            addCriterion("collection_date =", value, "collectionDate");
            return (Criteria) this;
        }

        public Criteria andCollectionDateNotEqualTo(Date value) {
            addCriterion("collection_date <>", value, "collectionDate");
            return (Criteria) this;
        }

        public Criteria andCollectionDateGreaterThan(Date value) {
            addCriterion("collection_date >", value, "collectionDate");
            return (Criteria) this;
        }

        public Criteria andCollectionDateGreaterThanOrEqualTo(Date value) {
            addCriterion("collection_date >=", value, "collectionDate");
            return (Criteria) this;
        }

        public Criteria andCollectionDateLessThan(Date value) {
            addCriterion("collection_date <", value, "collectionDate");
            return (Criteria) this;
        }

        public Criteria andCollectionDateLessThanOrEqualTo(Date value) {
            addCriterion("collection_date <=", value, "collectionDate");
            return (Criteria) this;
        }

        public Criteria andCollectionDateIn(List<Date> values) {
            addCriterion("collection_date in", values, "collectionDate");
            return (Criteria) this;
        }

        public Criteria andCollectionDateNotIn(List<Date> values) {
            addCriterion("collection_date not in", values, "collectionDate");
            return (Criteria) this;
        }

        public Criteria andCollectionDateBetween(Date value1, Date value2) {
            addCriterion("collection_date between", value1, value2, "collectionDate");
            return (Criteria) this;
        }

        public Criteria andCollectionDateNotBetween(Date value1, Date value2) {
            addCriterion("collection_date not between", value1, value2, "collectionDate");
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