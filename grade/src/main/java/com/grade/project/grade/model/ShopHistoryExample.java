package com.grade.project.grade.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShopHistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShopHistoryExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andShOrderIsNull() {
            addCriterion("SH_ORDER is null");
            return (Criteria) this;
        }

        public Criteria andShOrderIsNotNull() {
            addCriterion("SH_ORDER is not null");
            return (Criteria) this;
        }

        public Criteria andShOrderEqualTo(String value) {
            addCriterion("SH_ORDER =", value, "shOrder");
            return (Criteria) this;
        }

        public Criteria andShOrderNotEqualTo(String value) {
            addCriterion("SH_ORDER <>", value, "shOrder");
            return (Criteria) this;
        }

        public Criteria andShOrderGreaterThan(String value) {
            addCriterion("SH_ORDER >", value, "shOrder");
            return (Criteria) this;
        }

        public Criteria andShOrderGreaterThanOrEqualTo(String value) {
            addCriterion("SH_ORDER >=", value, "shOrder");
            return (Criteria) this;
        }

        public Criteria andShOrderLessThan(String value) {
            addCriterion("SH_ORDER <", value, "shOrder");
            return (Criteria) this;
        }

        public Criteria andShOrderLessThanOrEqualTo(String value) {
            addCriterion("SH_ORDER <=", value, "shOrder");
            return (Criteria) this;
        }

        public Criteria andShOrderLike(String value) {
            addCriterion("SH_ORDER like", value, "shOrder");
            return (Criteria) this;
        }

        public Criteria andShOrderNotLike(String value) {
            addCriterion("SH_ORDER not like", value, "shOrder");
            return (Criteria) this;
        }

        public Criteria andShOrderIn(List<String> values) {
            addCriterion("SH_ORDER in", values, "shOrder");
            return (Criteria) this;
        }

        public Criteria andShOrderNotIn(List<String> values) {
            addCriterion("SH_ORDER not in", values, "shOrder");
            return (Criteria) this;
        }

        public Criteria andShOrderBetween(String value1, String value2) {
            addCriterion("SH_ORDER between", value1, value2, "shOrder");
            return (Criteria) this;
        }

        public Criteria andShOrderNotBetween(String value1, String value2) {
            addCriterion("SH_ORDER not between", value1, value2, "shOrder");
            return (Criteria) this;
        }

        public Criteria andShUseridIsNull() {
            addCriterion("SH_USERID is null");
            return (Criteria) this;
        }

        public Criteria andShUseridIsNotNull() {
            addCriterion("SH_USERID is not null");
            return (Criteria) this;
        }

        public Criteria andShUseridEqualTo(Integer value) {
            addCriterion("SH_USERID =", value, "shUserid");
            return (Criteria) this;
        }

        public Criteria andShUseridNotEqualTo(Integer value) {
            addCriterion("SH_USERID <>", value, "shUserid");
            return (Criteria) this;
        }

        public Criteria andShUseridGreaterThan(Integer value) {
            addCriterion("SH_USERID >", value, "shUserid");
            return (Criteria) this;
        }

        public Criteria andShUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("SH_USERID >=", value, "shUserid");
            return (Criteria) this;
        }

        public Criteria andShUseridLessThan(Integer value) {
            addCriterion("SH_USERID <", value, "shUserid");
            return (Criteria) this;
        }

        public Criteria andShUseridLessThanOrEqualTo(Integer value) {
            addCriterion("SH_USERID <=", value, "shUserid");
            return (Criteria) this;
        }

        public Criteria andShUseridIn(List<Integer> values) {
            addCriterion("SH_USERID in", values, "shUserid");
            return (Criteria) this;
        }

        public Criteria andShUseridNotIn(List<Integer> values) {
            addCriterion("SH_USERID not in", values, "shUserid");
            return (Criteria) this;
        }

        public Criteria andShUseridBetween(Integer value1, Integer value2) {
            addCriterion("SH_USERID between", value1, value2, "shUserid");
            return (Criteria) this;
        }

        public Criteria andShUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("SH_USERID not between", value1, value2, "shUserid");
            return (Criteria) this;
        }

        public Criteria andHpidIsNull() {
            addCriterion("HPID is null");
            return (Criteria) this;
        }

        public Criteria andHpidIsNotNull() {
            addCriterion("HPID is not null");
            return (Criteria) this;
        }

        public Criteria andHpidEqualTo(Integer value) {
            addCriterion("HPID =", value, "hpid");
            return (Criteria) this;
        }

        public Criteria andHpidNotEqualTo(Integer value) {
            addCriterion("HPID <>", value, "hpid");
            return (Criteria) this;
        }

        public Criteria andHpidGreaterThan(Integer value) {
            addCriterion("HPID >", value, "hpid");
            return (Criteria) this;
        }

        public Criteria andHpidGreaterThanOrEqualTo(Integer value) {
            addCriterion("HPID >=", value, "hpid");
            return (Criteria) this;
        }

        public Criteria andHpidLessThan(Integer value) {
            addCriterion("HPID <", value, "hpid");
            return (Criteria) this;
        }

        public Criteria andHpidLessThanOrEqualTo(Integer value) {
            addCriterion("HPID <=", value, "hpid");
            return (Criteria) this;
        }

        public Criteria andHpidIn(List<Integer> values) {
            addCriterion("HPID in", values, "hpid");
            return (Criteria) this;
        }

        public Criteria andHpidNotIn(List<Integer> values) {
            addCriterion("HPID not in", values, "hpid");
            return (Criteria) this;
        }

        public Criteria andHpidBetween(Integer value1, Integer value2) {
            addCriterion("HPID between", value1, value2, "hpid");
            return (Criteria) this;
        }

        public Criteria andHpidNotBetween(Integer value1, Integer value2) {
            addCriterion("HPID not between", value1, value2, "hpid");
            return (Criteria) this;
        }

        public Criteria andShidIsNull() {
            addCriterion("SHID is null");
            return (Criteria) this;
        }

        public Criteria andShidIsNotNull() {
            addCriterion("SHID is not null");
            return (Criteria) this;
        }

        public Criteria andShidEqualTo(Integer value) {
            addCriterion("SHID =", value, "shid");
            return (Criteria) this;
        }

        public Criteria andShidNotEqualTo(Integer value) {
            addCriterion("SHID <>", value, "shid");
            return (Criteria) this;
        }

        public Criteria andShidGreaterThan(Integer value) {
            addCriterion("SHID >", value, "shid");
            return (Criteria) this;
        }

        public Criteria andShidGreaterThanOrEqualTo(Integer value) {
            addCriterion("SHID >=", value, "shid");
            return (Criteria) this;
        }

        public Criteria andShidLessThan(Integer value) {
            addCriterion("SHID <", value, "shid");
            return (Criteria) this;
        }

        public Criteria andShidLessThanOrEqualTo(Integer value) {
            addCriterion("SHID <=", value, "shid");
            return (Criteria) this;
        }

        public Criteria andShidIn(List<Integer> values) {
            addCriterion("SHID in", values, "shid");
            return (Criteria) this;
        }

        public Criteria andShidNotIn(List<Integer> values) {
            addCriterion("SHID not in", values, "shid");
            return (Criteria) this;
        }

        public Criteria andShidBetween(Integer value1, Integer value2) {
            addCriterion("SHID between", value1, value2, "shid");
            return (Criteria) this;
        }

        public Criteria andShidNotBetween(Integer value1, Integer value2) {
            addCriterion("SHID not between", value1, value2, "shid");
            return (Criteria) this;
        }

        public Criteria andShNameIsNull() {
            addCriterion("SH_NAME is null");
            return (Criteria) this;
        }

        public Criteria andShNameIsNotNull() {
            addCriterion("SH_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andShNameEqualTo(String value) {
            addCriterion("SH_NAME =", value, "shName");
            return (Criteria) this;
        }

        public Criteria andShNameNotEqualTo(String value) {
            addCriterion("SH_NAME <>", value, "shName");
            return (Criteria) this;
        }

        public Criteria andShNameGreaterThan(String value) {
            addCriterion("SH_NAME >", value, "shName");
            return (Criteria) this;
        }

        public Criteria andShNameGreaterThanOrEqualTo(String value) {
            addCriterion("SH_NAME >=", value, "shName");
            return (Criteria) this;
        }

        public Criteria andShNameLessThan(String value) {
            addCriterion("SH_NAME <", value, "shName");
            return (Criteria) this;
        }

        public Criteria andShNameLessThanOrEqualTo(String value) {
            addCriterion("SH_NAME <=", value, "shName");
            return (Criteria) this;
        }

        public Criteria andShNameLike(String value) {
            addCriterion("SH_NAME like", value, "shName");
            return (Criteria) this;
        }

        public Criteria andShNameNotLike(String value) {
            addCriterion("SH_NAME not like", value, "shName");
            return (Criteria) this;
        }

        public Criteria andShNameIn(List<String> values) {
            addCriterion("SH_NAME in", values, "shName");
            return (Criteria) this;
        }

        public Criteria andShNameNotIn(List<String> values) {
            addCriterion("SH_NAME not in", values, "shName");
            return (Criteria) this;
        }

        public Criteria andShNameBetween(String value1, String value2) {
            addCriterion("SH_NAME between", value1, value2, "shName");
            return (Criteria) this;
        }

        public Criteria andShNameNotBetween(String value1, String value2) {
            addCriterion("SH_NAME not between", value1, value2, "shName");
            return (Criteria) this;
        }

        public Criteria andShPriceIsNull() {
            addCriterion("SH_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andShPriceIsNotNull() {
            addCriterion("SH_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andShPriceEqualTo(BigDecimal value) {
            addCriterion("SH_PRICE =", value, "shPrice");
            return (Criteria) this;
        }

        public Criteria andShPriceNotEqualTo(BigDecimal value) {
            addCriterion("SH_PRICE <>", value, "shPrice");
            return (Criteria) this;
        }

        public Criteria andShPriceGreaterThan(BigDecimal value) {
            addCriterion("SH_PRICE >", value, "shPrice");
            return (Criteria) this;
        }

        public Criteria andShPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SH_PRICE >=", value, "shPrice");
            return (Criteria) this;
        }

        public Criteria andShPriceLessThan(BigDecimal value) {
            addCriterion("SH_PRICE <", value, "shPrice");
            return (Criteria) this;
        }

        public Criteria andShPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SH_PRICE <=", value, "shPrice");
            return (Criteria) this;
        }

        public Criteria andShPriceIn(List<BigDecimal> values) {
            addCriterion("SH_PRICE in", values, "shPrice");
            return (Criteria) this;
        }

        public Criteria andShPriceNotIn(List<BigDecimal> values) {
            addCriterion("SH_PRICE not in", values, "shPrice");
            return (Criteria) this;
        }

        public Criteria andShPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SH_PRICE between", value1, value2, "shPrice");
            return (Criteria) this;
        }

        public Criteria andShPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SH_PRICE not between", value1, value2, "shPrice");
            return (Criteria) this;
        }

        public Criteria andShPayIsNull() {
            addCriterion("SH_PAY is null");
            return (Criteria) this;
        }

        public Criteria andShPayIsNotNull() {
            addCriterion("SH_PAY is not null");
            return (Criteria) this;
        }

        public Criteria andShPayEqualTo(BigDecimal value) {
            addCriterion("SH_PAY =", value, "shPay");
            return (Criteria) this;
        }

        public Criteria andShPayNotEqualTo(BigDecimal value) {
            addCriterion("SH_PAY <>", value, "shPay");
            return (Criteria) this;
        }

        public Criteria andShPayGreaterThan(BigDecimal value) {
            addCriterion("SH_PAY >", value, "shPay");
            return (Criteria) this;
        }

        public Criteria andShPayGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SH_PAY >=", value, "shPay");
            return (Criteria) this;
        }

        public Criteria andShPayLessThan(BigDecimal value) {
            addCriterion("SH_PAY <", value, "shPay");
            return (Criteria) this;
        }

        public Criteria andShPayLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SH_PAY <=", value, "shPay");
            return (Criteria) this;
        }

        public Criteria andShPayIn(List<BigDecimal> values) {
            addCriterion("SH_PAY in", values, "shPay");
            return (Criteria) this;
        }

        public Criteria andShPayNotIn(List<BigDecimal> values) {
            addCriterion("SH_PAY not in", values, "shPay");
            return (Criteria) this;
        }

        public Criteria andShPayBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SH_PAY between", value1, value2, "shPay");
            return (Criteria) this;
        }

        public Criteria andShPayNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SH_PAY not between", value1, value2, "shPay");
            return (Criteria) this;
        }

        public Criteria andIsPayIsNull() {
            addCriterion("IS_PAY is null");
            return (Criteria) this;
        }

        public Criteria andIsPayIsNotNull() {
            addCriterion("IS_PAY is not null");
            return (Criteria) this;
        }

        public Criteria andIsPayEqualTo(Integer value) {
            addCriterion("IS_PAY =", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayNotEqualTo(Integer value) {
            addCriterion("IS_PAY <>", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayGreaterThan(Integer value) {
            addCriterion("IS_PAY >", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayGreaterThanOrEqualTo(Integer value) {
            addCriterion("IS_PAY >=", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayLessThan(Integer value) {
            addCriterion("IS_PAY <", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayLessThanOrEqualTo(Integer value) {
            addCriterion("IS_PAY <=", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayIn(List<Integer> values) {
            addCriterion("IS_PAY in", values, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayNotIn(List<Integer> values) {
            addCriterion("IS_PAY not in", values, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayBetween(Integer value1, Integer value2) {
            addCriterion("IS_PAY between", value1, value2, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayNotBetween(Integer value1, Integer value2) {
            addCriterion("IS_PAY not between", value1, value2, "isPay");
            return (Criteria) this;
        }

        public Criteria andShEndIsNull() {
            addCriterion("SH_END is null");
            return (Criteria) this;
        }

        public Criteria andShEndIsNotNull() {
            addCriterion("SH_END is not null");
            return (Criteria) this;
        }

        public Criteria andShEndEqualTo(Date value) {
            addCriterion("SH_END =", value, "shEnd");
            return (Criteria) this;
        }

        public Criteria andShEndNotEqualTo(Date value) {
            addCriterion("SH_END <>", value, "shEnd");
            return (Criteria) this;
        }

        public Criteria andShEndGreaterThan(Date value) {
            addCriterion("SH_END >", value, "shEnd");
            return (Criteria) this;
        }

        public Criteria andShEndGreaterThanOrEqualTo(Date value) {
            addCriterion("SH_END >=", value, "shEnd");
            return (Criteria) this;
        }

        public Criteria andShEndLessThan(Date value) {
            addCriterion("SH_END <", value, "shEnd");
            return (Criteria) this;
        }

        public Criteria andShEndLessThanOrEqualTo(Date value) {
            addCriterion("SH_END <=", value, "shEnd");
            return (Criteria) this;
        }

        public Criteria andShEndIn(List<Date> values) {
            addCriterion("SH_END in", values, "shEnd");
            return (Criteria) this;
        }

        public Criteria andShEndNotIn(List<Date> values) {
            addCriterion("SH_END not in", values, "shEnd");
            return (Criteria) this;
        }

        public Criteria andShEndBetween(Date value1, Date value2) {
            addCriterion("SH_END between", value1, value2, "shEnd");
            return (Criteria) this;
        }

        public Criteria andShEndNotBetween(Date value1, Date value2) {
            addCriterion("SH_END not between", value1, value2, "shEnd");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("GMT_CREATE is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("GMT_CREATE is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Date value) {
            addCriterion("GMT_CREATE =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Date value) {
            addCriterion("GMT_CREATE <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Date value) {
            addCriterion("GMT_CREATE >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("GMT_CREATE >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Date value) {
            addCriterion("GMT_CREATE <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            addCriterion("GMT_CREATE <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Date> values) {
            addCriterion("GMT_CREATE in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Date> values) {
            addCriterion("GMT_CREATE not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Date value1, Date value2) {
            addCriterion("GMT_CREATE between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            addCriterion("GMT_CREATE not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtModifedIsNull() {
            addCriterion("GMT_MODIFED is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifedIsNotNull() {
            addCriterion("GMT_MODIFED is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifedEqualTo(Date value) {
            addCriterion("GMT_MODIFED =", value, "gmtModifed");
            return (Criteria) this;
        }

        public Criteria andGmtModifedNotEqualTo(Date value) {
            addCriterion("GMT_MODIFED <>", value, "gmtModifed");
            return (Criteria) this;
        }

        public Criteria andGmtModifedGreaterThan(Date value) {
            addCriterion("GMT_MODIFED >", value, "gmtModifed");
            return (Criteria) this;
        }

        public Criteria andGmtModifedGreaterThanOrEqualTo(Date value) {
            addCriterion("GMT_MODIFED >=", value, "gmtModifed");
            return (Criteria) this;
        }

        public Criteria andGmtModifedLessThan(Date value) {
            addCriterion("GMT_MODIFED <", value, "gmtModifed");
            return (Criteria) this;
        }

        public Criteria andGmtModifedLessThanOrEqualTo(Date value) {
            addCriterion("GMT_MODIFED <=", value, "gmtModifed");
            return (Criteria) this;
        }

        public Criteria andGmtModifedIn(List<Date> values) {
            addCriterion("GMT_MODIFED in", values, "gmtModifed");
            return (Criteria) this;
        }

        public Criteria andGmtModifedNotIn(List<Date> values) {
            addCriterion("GMT_MODIFED not in", values, "gmtModifed");
            return (Criteria) this;
        }

        public Criteria andGmtModifedBetween(Date value1, Date value2) {
            addCriterion("GMT_MODIFED between", value1, value2, "gmtModifed");
            return (Criteria) this;
        }

        public Criteria andGmtModifedNotBetween(Date value1, Date value2) {
            addCriterion("GMT_MODIFED not between", value1, value2, "gmtModifed");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNull() {
            addCriterion("IS_DEL is null");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNotNull() {
            addCriterion("IS_DEL is not null");
            return (Criteria) this;
        }

        public Criteria andIsDelEqualTo(Integer value) {
            addCriterion("IS_DEL =", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotEqualTo(Integer value) {
            addCriterion("IS_DEL <>", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThan(Integer value) {
            addCriterion("IS_DEL >", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThanOrEqualTo(Integer value) {
            addCriterion("IS_DEL >=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThan(Integer value) {
            addCriterion("IS_DEL <", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThanOrEqualTo(Integer value) {
            addCriterion("IS_DEL <=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelIn(List<Integer> values) {
            addCriterion("IS_DEL in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotIn(List<Integer> values) {
            addCriterion("IS_DEL not in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelBetween(Integer value1, Integer value2) {
            addCriterion("IS_DEL between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotBetween(Integer value1, Integer value2) {
            addCriterion("IS_DEL not between", value1, value2, "isDel");
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