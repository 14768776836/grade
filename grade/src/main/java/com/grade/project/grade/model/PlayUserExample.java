package com.grade.project.grade.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlayUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PlayUserExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andLanguageIsNull() {
            addCriterion("LANGUAGE is null");
            return (Criteria) this;
        }

        public Criteria andLanguageIsNotNull() {
            addCriterion("LANGUAGE is not null");
            return (Criteria) this;
        }

        public Criteria andLanguageEqualTo(String value) {
            addCriterion("LANGUAGE =", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotEqualTo(String value) {
            addCriterion("LANGUAGE <>", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageGreaterThan(String value) {
            addCriterion("LANGUAGE >", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageGreaterThanOrEqualTo(String value) {
            addCriterion("LANGUAGE >=", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageLessThan(String value) {
            addCriterion("LANGUAGE <", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageLessThanOrEqualTo(String value) {
            addCriterion("LANGUAGE <=", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageLike(String value) {
            addCriterion("LANGUAGE like", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotLike(String value) {
            addCriterion("LANGUAGE not like", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageIn(List<String> values) {
            addCriterion("LANGUAGE in", values, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotIn(List<String> values) {
            addCriterion("LANGUAGE not in", values, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageBetween(String value1, String value2) {
            addCriterion("LANGUAGE between", value1, value2, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotBetween(String value1, String value2) {
            addCriterion("LANGUAGE not between", value1, value2, "language");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("USERNAME is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("USERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("USERNAME =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("USERNAME <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("USERNAME >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("USERNAME >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("USERNAME <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("USERNAME <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("USERNAME like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("USERNAME not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("USERNAME in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("USERNAME not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("USERNAME between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("USERNAME not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("PASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("PASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("PASSWORD =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("PASSWORD <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("PASSWORD >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("PASSWORD >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("PASSWORD <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("PASSWORD <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("PASSWORD like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("PASSWORD not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("PASSWORD in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("PASSWORD not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("PASSWORD between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("PASSWORD not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andSecureconfIsNull() {
            addCriterion("SECURECONF is null");
            return (Criteria) this;
        }

        public Criteria andSecureconfIsNotNull() {
            addCriterion("SECURECONF is not null");
            return (Criteria) this;
        }

        public Criteria andSecureconfEqualTo(String value) {
            addCriterion("SECURECONF =", value, "secureconf");
            return (Criteria) this;
        }

        public Criteria andSecureconfNotEqualTo(String value) {
            addCriterion("SECURECONF <>", value, "secureconf");
            return (Criteria) this;
        }

        public Criteria andSecureconfGreaterThan(String value) {
            addCriterion("SECURECONF >", value, "secureconf");
            return (Criteria) this;
        }

        public Criteria andSecureconfGreaterThanOrEqualTo(String value) {
            addCriterion("SECURECONF >=", value, "secureconf");
            return (Criteria) this;
        }

        public Criteria andSecureconfLessThan(String value) {
            addCriterion("SECURECONF <", value, "secureconf");
            return (Criteria) this;
        }

        public Criteria andSecureconfLessThanOrEqualTo(String value) {
            addCriterion("SECURECONF <=", value, "secureconf");
            return (Criteria) this;
        }

        public Criteria andSecureconfLike(String value) {
            addCriterion("SECURECONF like", value, "secureconf");
            return (Criteria) this;
        }

        public Criteria andSecureconfNotLike(String value) {
            addCriterion("SECURECONF not like", value, "secureconf");
            return (Criteria) this;
        }

        public Criteria andSecureconfIn(List<String> values) {
            addCriterion("SECURECONF in", values, "secureconf");
            return (Criteria) this;
        }

        public Criteria andSecureconfNotIn(List<String> values) {
            addCriterion("SECURECONF not in", values, "secureconf");
            return (Criteria) this;
        }

        public Criteria andSecureconfBetween(String value1, String value2) {
            addCriterion("SECURECONF between", value1, value2, "secureconf");
            return (Criteria) this;
        }

        public Criteria andSecureconfNotBetween(String value1, String value2) {
            addCriterion("SECURECONF not between", value1, value2, "secureconf");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("EMAIL =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("EMAIL <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("EMAIL >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("EMAIL >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("EMAIL <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("EMAIL <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("EMAIL like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("EMAIL not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("EMAIL in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("EMAIL not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("EMAIL between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("EMAIL not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andFirstnameIsNull() {
            addCriterion("FIRSTNAME is null");
            return (Criteria) this;
        }

        public Criteria andFirstnameIsNotNull() {
            addCriterion("FIRSTNAME is not null");
            return (Criteria) this;
        }

        public Criteria andFirstnameEqualTo(String value) {
            addCriterion("FIRSTNAME =", value, "firstname");
            return (Criteria) this;
        }

        public Criteria andFirstnameNotEqualTo(String value) {
            addCriterion("FIRSTNAME <>", value, "firstname");
            return (Criteria) this;
        }

        public Criteria andFirstnameGreaterThan(String value) {
            addCriterion("FIRSTNAME >", value, "firstname");
            return (Criteria) this;
        }

        public Criteria andFirstnameGreaterThanOrEqualTo(String value) {
            addCriterion("FIRSTNAME >=", value, "firstname");
            return (Criteria) this;
        }

        public Criteria andFirstnameLessThan(String value) {
            addCriterion("FIRSTNAME <", value, "firstname");
            return (Criteria) this;
        }

        public Criteria andFirstnameLessThanOrEqualTo(String value) {
            addCriterion("FIRSTNAME <=", value, "firstname");
            return (Criteria) this;
        }

        public Criteria andFirstnameLike(String value) {
            addCriterion("FIRSTNAME like", value, "firstname");
            return (Criteria) this;
        }

        public Criteria andFirstnameNotLike(String value) {
            addCriterion("FIRSTNAME not like", value, "firstname");
            return (Criteria) this;
        }

        public Criteria andFirstnameIn(List<String> values) {
            addCriterion("FIRSTNAME in", values, "firstname");
            return (Criteria) this;
        }

        public Criteria andFirstnameNotIn(List<String> values) {
            addCriterion("FIRSTNAME not in", values, "firstname");
            return (Criteria) this;
        }

        public Criteria andFirstnameBetween(String value1, String value2) {
            addCriterion("FIRSTNAME between", value1, value2, "firstname");
            return (Criteria) this;
        }

        public Criteria andFirstnameNotBetween(String value1, String value2) {
            addCriterion("FIRSTNAME not between", value1, value2, "firstname");
            return (Criteria) this;
        }

        public Criteria andMidnameIsNull() {
            addCriterion("MIDNAME is null");
            return (Criteria) this;
        }

        public Criteria andMidnameIsNotNull() {
            addCriterion("MIDNAME is not null");
            return (Criteria) this;
        }

        public Criteria andMidnameEqualTo(String value) {
            addCriterion("MIDNAME =", value, "midname");
            return (Criteria) this;
        }

        public Criteria andMidnameNotEqualTo(String value) {
            addCriterion("MIDNAME <>", value, "midname");
            return (Criteria) this;
        }

        public Criteria andMidnameGreaterThan(String value) {
            addCriterion("MIDNAME >", value, "midname");
            return (Criteria) this;
        }

        public Criteria andMidnameGreaterThanOrEqualTo(String value) {
            addCriterion("MIDNAME >=", value, "midname");
            return (Criteria) this;
        }

        public Criteria andMidnameLessThan(String value) {
            addCriterion("MIDNAME <", value, "midname");
            return (Criteria) this;
        }

        public Criteria andMidnameLessThanOrEqualTo(String value) {
            addCriterion("MIDNAME <=", value, "midname");
            return (Criteria) this;
        }

        public Criteria andMidnameLike(String value) {
            addCriterion("MIDNAME like", value, "midname");
            return (Criteria) this;
        }

        public Criteria andMidnameNotLike(String value) {
            addCriterion("MIDNAME not like", value, "midname");
            return (Criteria) this;
        }

        public Criteria andMidnameIn(List<String> values) {
            addCriterion("MIDNAME in", values, "midname");
            return (Criteria) this;
        }

        public Criteria andMidnameNotIn(List<String> values) {
            addCriterion("MIDNAME not in", values, "midname");
            return (Criteria) this;
        }

        public Criteria andMidnameBetween(String value1, String value2) {
            addCriterion("MIDNAME between", value1, value2, "midname");
            return (Criteria) this;
        }

        public Criteria andMidnameNotBetween(String value1, String value2) {
            addCriterion("MIDNAME not between", value1, value2, "midname");
            return (Criteria) this;
        }

        public Criteria andLastnameIsNull() {
            addCriterion("LASTNAME is null");
            return (Criteria) this;
        }

        public Criteria andLastnameIsNotNull() {
            addCriterion("LASTNAME is not null");
            return (Criteria) this;
        }

        public Criteria andLastnameEqualTo(String value) {
            addCriterion("LASTNAME =", value, "lastname");
            return (Criteria) this;
        }

        public Criteria andLastnameNotEqualTo(String value) {
            addCriterion("LASTNAME <>", value, "lastname");
            return (Criteria) this;
        }

        public Criteria andLastnameGreaterThan(String value) {
            addCriterion("LASTNAME >", value, "lastname");
            return (Criteria) this;
        }

        public Criteria andLastnameGreaterThanOrEqualTo(String value) {
            addCriterion("LASTNAME >=", value, "lastname");
            return (Criteria) this;
        }

        public Criteria andLastnameLessThan(String value) {
            addCriterion("LASTNAME <", value, "lastname");
            return (Criteria) this;
        }

        public Criteria andLastnameLessThanOrEqualTo(String value) {
            addCriterion("LASTNAME <=", value, "lastname");
            return (Criteria) this;
        }

        public Criteria andLastnameLike(String value) {
            addCriterion("LASTNAME like", value, "lastname");
            return (Criteria) this;
        }

        public Criteria andLastnameNotLike(String value) {
            addCriterion("LASTNAME not like", value, "lastname");
            return (Criteria) this;
        }

        public Criteria andLastnameIn(List<String> values) {
            addCriterion("LASTNAME in", values, "lastname");
            return (Criteria) this;
        }

        public Criteria andLastnameNotIn(List<String> values) {
            addCriterion("LASTNAME not in", values, "lastname");
            return (Criteria) this;
        }

        public Criteria andLastnameBetween(String value1, String value2) {
            addCriterion("LASTNAME between", value1, value2, "lastname");
            return (Criteria) this;
        }

        public Criteria andLastnameNotBetween(String value1, String value2) {
            addCriterion("LASTNAME not between", value1, value2, "lastname");
            return (Criteria) this;
        }

        public Criteria andJobtitleIsNull() {
            addCriterion("JOBTITLE is null");
            return (Criteria) this;
        }

        public Criteria andJobtitleIsNotNull() {
            addCriterion("JOBTITLE is not null");
            return (Criteria) this;
        }

        public Criteria andJobtitleEqualTo(String value) {
            addCriterion("JOBTITLE =", value, "jobtitle");
            return (Criteria) this;
        }

        public Criteria andJobtitleNotEqualTo(String value) {
            addCriterion("JOBTITLE <>", value, "jobtitle");
            return (Criteria) this;
        }

        public Criteria andJobtitleGreaterThan(String value) {
            addCriterion("JOBTITLE >", value, "jobtitle");
            return (Criteria) this;
        }

        public Criteria andJobtitleGreaterThanOrEqualTo(String value) {
            addCriterion("JOBTITLE >=", value, "jobtitle");
            return (Criteria) this;
        }

        public Criteria andJobtitleLessThan(String value) {
            addCriterion("JOBTITLE <", value, "jobtitle");
            return (Criteria) this;
        }

        public Criteria andJobtitleLessThanOrEqualTo(String value) {
            addCriterion("JOBTITLE <=", value, "jobtitle");
            return (Criteria) this;
        }

        public Criteria andJobtitleLike(String value) {
            addCriterion("JOBTITLE like", value, "jobtitle");
            return (Criteria) this;
        }

        public Criteria andJobtitleNotLike(String value) {
            addCriterion("JOBTITLE not like", value, "jobtitle");
            return (Criteria) this;
        }

        public Criteria andJobtitleIn(List<String> values) {
            addCriterion("JOBTITLE in", values, "jobtitle");
            return (Criteria) this;
        }

        public Criteria andJobtitleNotIn(List<String> values) {
            addCriterion("JOBTITLE not in", values, "jobtitle");
            return (Criteria) this;
        }

        public Criteria andJobtitleBetween(String value1, String value2) {
            addCriterion("JOBTITLE between", value1, value2, "jobtitle");
            return (Criteria) this;
        }

        public Criteria andJobtitleNotBetween(String value1, String value2) {
            addCriterion("JOBTITLE not between", value1, value2, "jobtitle");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNull() {
            addCriterion("DEPARTMENT is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNotNull() {
            addCriterion("DEPARTMENT is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentEqualTo(String value) {
            addCriterion("DEPARTMENT =", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotEqualTo(String value) {
            addCriterion("DEPARTMENT <>", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThan(String value) {
            addCriterion("DEPARTMENT >", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("DEPARTMENT >=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThan(String value) {
            addCriterion("DEPARTMENT <", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThanOrEqualTo(String value) {
            addCriterion("DEPARTMENT <=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLike(String value) {
            addCriterion("DEPARTMENT like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotLike(String value) {
            addCriterion("DEPARTMENT not like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentIn(List<String> values) {
            addCriterion("DEPARTMENT in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotIn(List<String> values) {
            addCriterion("DEPARTMENT not in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentBetween(String value1, String value2) {
            addCriterion("DEPARTMENT between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotBetween(String value1, String value2) {
            addCriterion("DEPARTMENT not between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("GENDER is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("GENDER is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(String value) {
            addCriterion("GENDER =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(String value) {
            addCriterion("GENDER <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(String value) {
            addCriterion("GENDER >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(String value) {
            addCriterion("GENDER >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(String value) {
            addCriterion("GENDER <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(String value) {
            addCriterion("GENDER <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLike(String value) {
            addCriterion("GENDER like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotLike(String value) {
            addCriterion("GENDER not like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<String> values) {
            addCriterion("GENDER in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<String> values) {
            addCriterion("GENDER not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(String value1, String value2) {
            addCriterion("GENDER between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(String value1, String value2) {
            addCriterion("GENDER not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("BIRTHDAY is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("BIRTHDAY is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(String value) {
            addCriterion("BIRTHDAY =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(String value) {
            addCriterion("BIRTHDAY <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(String value) {
            addCriterion("BIRTHDAY >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(String value) {
            addCriterion("BIRTHDAY >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(String value) {
            addCriterion("BIRTHDAY <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(String value) {
            addCriterion("BIRTHDAY <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLike(String value) {
            addCriterion("BIRTHDAY like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotLike(String value) {
            addCriterion("BIRTHDAY not like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<String> values) {
            addCriterion("BIRTHDAY in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<String> values) {
            addCriterion("BIRTHDAY not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(String value1, String value2) {
            addCriterion("BIRTHDAY between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(String value1, String value2) {
            addCriterion("BIRTHDAY not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNull() {
            addCriterion("NICKNAME is null");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNotNull() {
            addCriterion("NICKNAME is not null");
            return (Criteria) this;
        }

        public Criteria andNicknameEqualTo(String value) {
            addCriterion("NICKNAME =", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotEqualTo(String value) {
            addCriterion("NICKNAME <>", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThan(String value) {
            addCriterion("NICKNAME >", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("NICKNAME >=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThan(String value) {
            addCriterion("NICKNAME <", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThanOrEqualTo(String value) {
            addCriterion("NICKNAME <=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLike(String value) {
            addCriterion("NICKNAME like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotLike(String value) {
            addCriterion("NICKNAME not like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameIn(List<String> values) {
            addCriterion("NICKNAME in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotIn(List<String> values) {
            addCriterion("NICKNAME not in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameBetween(String value1, String value2) {
            addCriterion("NICKNAME between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotBetween(String value1, String value2) {
            addCriterion("NICKNAME not between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNull() {
            addCriterion("user_type is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNotNull() {
            addCriterion("user_type is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeEqualTo(String value) {
            addCriterion("user_type =", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotEqualTo(String value) {
            addCriterion("user_type <>", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThan(String value) {
            addCriterion("user_type >", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThanOrEqualTo(String value) {
            addCriterion("user_type >=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThan(String value) {
            addCriterion("user_type <", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThanOrEqualTo(String value) {
            addCriterion("user_type <=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLike(String value) {
            addCriterion("user_type like", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotLike(String value) {
            addCriterion("user_type not like", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeIn(List<String> values) {
            addCriterion("user_type in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotIn(List<String> values) {
            addCriterion("user_type not in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeBetween(String value1, String value2) {
            addCriterion("user_type between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotBetween(String value1, String value2) {
            addCriterion("user_type not between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andRulenameIsNull() {
            addCriterion("RULENAME is null");
            return (Criteria) this;
        }

        public Criteria andRulenameIsNotNull() {
            addCriterion("RULENAME is not null");
            return (Criteria) this;
        }

        public Criteria andRulenameEqualTo(String value) {
            addCriterion("RULENAME =", value, "rulename");
            return (Criteria) this;
        }

        public Criteria andRulenameNotEqualTo(String value) {
            addCriterion("RULENAME <>", value, "rulename");
            return (Criteria) this;
        }

        public Criteria andRulenameGreaterThan(String value) {
            addCriterion("RULENAME >", value, "rulename");
            return (Criteria) this;
        }

        public Criteria andRulenameGreaterThanOrEqualTo(String value) {
            addCriterion("RULENAME >=", value, "rulename");
            return (Criteria) this;
        }

        public Criteria andRulenameLessThan(String value) {
            addCriterion("RULENAME <", value, "rulename");
            return (Criteria) this;
        }

        public Criteria andRulenameLessThanOrEqualTo(String value) {
            addCriterion("RULENAME <=", value, "rulename");
            return (Criteria) this;
        }

        public Criteria andRulenameLike(String value) {
            addCriterion("RULENAME like", value, "rulename");
            return (Criteria) this;
        }

        public Criteria andRulenameNotLike(String value) {
            addCriterion("RULENAME not like", value, "rulename");
            return (Criteria) this;
        }

        public Criteria andRulenameIn(List<String> values) {
            addCriterion("RULENAME in", values, "rulename");
            return (Criteria) this;
        }

        public Criteria andRulenameNotIn(List<String> values) {
            addCriterion("RULENAME not in", values, "rulename");
            return (Criteria) this;
        }

        public Criteria andRulenameBetween(String value1, String value2) {
            addCriterion("RULENAME between", value1, value2, "rulename");
            return (Criteria) this;
        }

        public Criteria andRulenameNotBetween(String value1, String value2) {
            addCriterion("RULENAME not between", value1, value2, "rulename");
            return (Criteria) this;
        }

        public Criteria andSearchprojectidIsNull() {
            addCriterion("SEARCHPROJECTID is null");
            return (Criteria) this;
        }

        public Criteria andSearchprojectidIsNotNull() {
            addCriterion("SEARCHPROJECTID is not null");
            return (Criteria) this;
        }

        public Criteria andSearchprojectidEqualTo(String value) {
            addCriterion("SEARCHPROJECTID =", value, "searchprojectid");
            return (Criteria) this;
        }

        public Criteria andSearchprojectidNotEqualTo(String value) {
            addCriterion("SEARCHPROJECTID <>", value, "searchprojectid");
            return (Criteria) this;
        }

        public Criteria andSearchprojectidGreaterThan(String value) {
            addCriterion("SEARCHPROJECTID >", value, "searchprojectid");
            return (Criteria) this;
        }

        public Criteria andSearchprojectidGreaterThanOrEqualTo(String value) {
            addCriterion("SEARCHPROJECTID >=", value, "searchprojectid");
            return (Criteria) this;
        }

        public Criteria andSearchprojectidLessThan(String value) {
            addCriterion("SEARCHPROJECTID <", value, "searchprojectid");
            return (Criteria) this;
        }

        public Criteria andSearchprojectidLessThanOrEqualTo(String value) {
            addCriterion("SEARCHPROJECTID <=", value, "searchprojectid");
            return (Criteria) this;
        }

        public Criteria andSearchprojectidLike(String value) {
            addCriterion("SEARCHPROJECTID like", value, "searchprojectid");
            return (Criteria) this;
        }

        public Criteria andSearchprojectidNotLike(String value) {
            addCriterion("SEARCHPROJECTID not like", value, "searchprojectid");
            return (Criteria) this;
        }

        public Criteria andSearchprojectidIn(List<String> values) {
            addCriterion("SEARCHPROJECTID in", values, "searchprojectid");
            return (Criteria) this;
        }

        public Criteria andSearchprojectidNotIn(List<String> values) {
            addCriterion("SEARCHPROJECTID not in", values, "searchprojectid");
            return (Criteria) this;
        }

        public Criteria andSearchprojectidBetween(String value1, String value2) {
            addCriterion("SEARCHPROJECTID between", value1, value2, "searchprojectid");
            return (Criteria) this;
        }

        public Criteria andSearchprojectidNotBetween(String value1, String value2) {
            addCriterion("SEARCHPROJECTID not between", value1, value2, "searchprojectid");
            return (Criteria) this;
        }

        public Criteria andOrgiIsNull() {
            addCriterion("ORGI is null");
            return (Criteria) this;
        }

        public Criteria andOrgiIsNotNull() {
            addCriterion("ORGI is not null");
            return (Criteria) this;
        }

        public Criteria andOrgiEqualTo(String value) {
            addCriterion("ORGI =", value, "orgi");
            return (Criteria) this;
        }

        public Criteria andOrgiNotEqualTo(String value) {
            addCriterion("ORGI <>", value, "orgi");
            return (Criteria) this;
        }

        public Criteria andOrgiGreaterThan(String value) {
            addCriterion("ORGI >", value, "orgi");
            return (Criteria) this;
        }

        public Criteria andOrgiGreaterThanOrEqualTo(String value) {
            addCriterion("ORGI >=", value, "orgi");
            return (Criteria) this;
        }

        public Criteria andOrgiLessThan(String value) {
            addCriterion("ORGI <", value, "orgi");
            return (Criteria) this;
        }

        public Criteria andOrgiLessThanOrEqualTo(String value) {
            addCriterion("ORGI <=", value, "orgi");
            return (Criteria) this;
        }

        public Criteria andOrgiLike(String value) {
            addCriterion("ORGI like", value, "orgi");
            return (Criteria) this;
        }

        public Criteria andOrgiNotLike(String value) {
            addCriterion("ORGI not like", value, "orgi");
            return (Criteria) this;
        }

        public Criteria andOrgiIn(List<String> values) {
            addCriterion("ORGI in", values, "orgi");
            return (Criteria) this;
        }

        public Criteria andOrgiNotIn(List<String> values) {
            addCriterion("ORGI not in", values, "orgi");
            return (Criteria) this;
        }

        public Criteria andOrgiBetween(String value1, String value2) {
            addCriterion("ORGI between", value1, value2, "orgi");
            return (Criteria) this;
        }

        public Criteria andOrgiNotBetween(String value1, String value2) {
            addCriterion("ORGI not between", value1, value2, "orgi");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNull() {
            addCriterion("CREATER is null");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNotNull() {
            addCriterion("CREATER is not null");
            return (Criteria) this;
        }

        public Criteria andCreaterEqualTo(String value) {
            addCriterion("CREATER =", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotEqualTo(String value) {
            addCriterion("CREATER <>", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThan(String value) {
            addCriterion("CREATER >", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThanOrEqualTo(String value) {
            addCriterion("CREATER >=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThan(String value) {
            addCriterion("CREATER <", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThanOrEqualTo(String value) {
            addCriterion("CREATER <=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLike(String value) {
            addCriterion("CREATER like", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotLike(String value) {
            addCriterion("CREATER not like", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterIn(List<String> values) {
            addCriterion("CREATER in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotIn(List<String> values) {
            addCriterion("CREATER not in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterBetween(String value1, String value2) {
            addCriterion("CREATER between", value1, value2, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotBetween(String value1, String value2) {
            addCriterion("CREATER not between", value1, value2, "creater");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("CREATETIME is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("CREATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("CREATETIME =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("CREATETIME <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("CREATETIME >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATETIME >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("CREATETIME <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATETIME <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("CREATETIME in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("CREATETIME not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("CREATETIME between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATETIME not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andMemoIsNull() {
            addCriterion("MEMO is null");
            return (Criteria) this;
        }

        public Criteria andMemoIsNotNull() {
            addCriterion("MEMO is not null");
            return (Criteria) this;
        }

        public Criteria andMemoEqualTo(String value) {
            addCriterion("MEMO =", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotEqualTo(String value) {
            addCriterion("MEMO <>", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThan(String value) {
            addCriterion("MEMO >", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThanOrEqualTo(String value) {
            addCriterion("MEMO >=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThan(String value) {
            addCriterion("MEMO <", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThanOrEqualTo(String value) {
            addCriterion("MEMO <=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLike(String value) {
            addCriterion("MEMO like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotLike(String value) {
            addCriterion("MEMO not like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoIn(List<String> values) {
            addCriterion("MEMO in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotIn(List<String> values) {
            addCriterion("MEMO not in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoBetween(String value1, String value2) {
            addCriterion("MEMO between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotBetween(String value1, String value2) {
            addCriterion("MEMO not between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("UPDATETIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("UPDATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("UPDATETIME =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("UPDATETIME <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("UPDATETIME >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATETIME >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("UPDATETIME <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATETIME <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("UPDATETIME in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("UPDATETIME not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("UPDATETIME between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATETIME not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("MOBILE is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("MOBILE is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("MOBILE =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("MOBILE <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("MOBILE >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("MOBILE >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("MOBILE <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("MOBILE <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("MOBILE like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("MOBILE not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("MOBILE in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("MOBILE not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("MOBILE between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("MOBILE not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andPassupdatetimeIsNull() {
            addCriterion("passupdatetime is null");
            return (Criteria) this;
        }

        public Criteria andPassupdatetimeIsNotNull() {
            addCriterion("passupdatetime is not null");
            return (Criteria) this;
        }

        public Criteria andPassupdatetimeEqualTo(Date value) {
            addCriterion("passupdatetime =", value, "passupdatetime");
            return (Criteria) this;
        }

        public Criteria andPassupdatetimeNotEqualTo(Date value) {
            addCriterion("passupdatetime <>", value, "passupdatetime");
            return (Criteria) this;
        }

        public Criteria andPassupdatetimeGreaterThan(Date value) {
            addCriterion("passupdatetime >", value, "passupdatetime");
            return (Criteria) this;
        }

        public Criteria andPassupdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("passupdatetime >=", value, "passupdatetime");
            return (Criteria) this;
        }

        public Criteria andPassupdatetimeLessThan(Date value) {
            addCriterion("passupdatetime <", value, "passupdatetime");
            return (Criteria) this;
        }

        public Criteria andPassupdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("passupdatetime <=", value, "passupdatetime");
            return (Criteria) this;
        }

        public Criteria andPassupdatetimeIn(List<Date> values) {
            addCriterion("passupdatetime in", values, "passupdatetime");
            return (Criteria) this;
        }

        public Criteria andPassupdatetimeNotIn(List<Date> values) {
            addCriterion("passupdatetime not in", values, "passupdatetime");
            return (Criteria) this;
        }

        public Criteria andPassupdatetimeBetween(Date value1, Date value2) {
            addCriterion("passupdatetime between", value1, value2, "passupdatetime");
            return (Criteria) this;
        }

        public Criteria andPassupdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("passupdatetime not between", value1, value2, "passupdatetime");
            return (Criteria) this;
        }

        public Criteria andSignIsNull() {
            addCriterion("sign is null");
            return (Criteria) this;
        }

        public Criteria andSignIsNotNull() {
            addCriterion("sign is not null");
            return (Criteria) this;
        }

        public Criteria andSignEqualTo(String value) {
            addCriterion("sign =", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotEqualTo(String value) {
            addCriterion("sign <>", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignGreaterThan(String value) {
            addCriterion("sign >", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignGreaterThanOrEqualTo(String value) {
            addCriterion("sign >=", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLessThan(String value) {
            addCriterion("sign <", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLessThanOrEqualTo(String value) {
            addCriterion("sign <=", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLike(String value) {
            addCriterion("sign like", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotLike(String value) {
            addCriterion("sign not like", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignIn(List<String> values) {
            addCriterion("sign in", values, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotIn(List<String> values) {
            addCriterion("sign not in", values, "sign");
            return (Criteria) this;
        }

        public Criteria andSignBetween(String value1, String value2) {
            addCriterion("sign between", value1, value2, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotBetween(String value1, String value2) {
            addCriterion("sign not between", value1, value2, "sign");
            return (Criteria) this;
        }

        public Criteria andDelIsNull() {
            addCriterion("del is null");
            return (Criteria) this;
        }

        public Criteria andDelIsNotNull() {
            addCriterion("del is not null");
            return (Criteria) this;
        }

        public Criteria andDelEqualTo(Byte value) {
            addCriterion("del =", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelNotEqualTo(Byte value) {
            addCriterion("del <>", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelGreaterThan(Byte value) {
            addCriterion("del >", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelGreaterThanOrEqualTo(Byte value) {
            addCriterion("del >=", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelLessThan(Byte value) {
            addCriterion("del <", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelLessThanOrEqualTo(Byte value) {
            addCriterion("del <=", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelIn(List<Byte> values) {
            addCriterion("del in", values, "del");
            return (Criteria) this;
        }

        public Criteria andDelNotIn(List<Byte> values) {
            addCriterion("del not in", values, "del");
            return (Criteria) this;
        }

        public Criteria andDelBetween(Byte value1, Byte value2) {
            addCriterion("del between", value1, value2, "del");
            return (Criteria) this;
        }

        public Criteria andDelNotBetween(Byte value1, Byte value2) {
            addCriterion("del not between", value1, value2, "del");
            return (Criteria) this;
        }

        public Criteria andLoginIsNull() {
            addCriterion("login is null");
            return (Criteria) this;
        }

        public Criteria andLoginIsNotNull() {
            addCriterion("login is not null");
            return (Criteria) this;
        }

        public Criteria andLoginEqualTo(Byte value) {
            addCriterion("login =", value, "login");
            return (Criteria) this;
        }

        public Criteria andLoginNotEqualTo(Byte value) {
            addCriterion("login <>", value, "login");
            return (Criteria) this;
        }

        public Criteria andLoginGreaterThan(Byte value) {
            addCriterion("login >", value, "login");
            return (Criteria) this;
        }

        public Criteria andLoginGreaterThanOrEqualTo(Byte value) {
            addCriterion("login >=", value, "login");
            return (Criteria) this;
        }

        public Criteria andLoginLessThan(Byte value) {
            addCriterion("login <", value, "login");
            return (Criteria) this;
        }

        public Criteria andLoginLessThanOrEqualTo(Byte value) {
            addCriterion("login <=", value, "login");
            return (Criteria) this;
        }

        public Criteria andLoginIn(List<Byte> values) {
            addCriterion("login in", values, "login");
            return (Criteria) this;
        }

        public Criteria andLoginNotIn(List<Byte> values) {
            addCriterion("login not in", values, "login");
            return (Criteria) this;
        }

        public Criteria andLoginBetween(Byte value1, Byte value2) {
            addCriterion("login between", value1, value2, "login");
            return (Criteria) this;
        }

        public Criteria andLoginNotBetween(Byte value1, Byte value2) {
            addCriterion("login not between", value1, value2, "login");
            return (Criteria) this;
        }

        public Criteria andOnlineIsNull() {
            addCriterion("online is null");
            return (Criteria) this;
        }

        public Criteria andOnlineIsNotNull() {
            addCriterion("online is not null");
            return (Criteria) this;
        }

        public Criteria andOnlineEqualTo(Byte value) {
            addCriterion("online =", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineNotEqualTo(Byte value) {
            addCriterion("online <>", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineGreaterThan(Byte value) {
            addCriterion("online >", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineGreaterThanOrEqualTo(Byte value) {
            addCriterion("online >=", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineLessThan(Byte value) {
            addCriterion("online <", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineLessThanOrEqualTo(Byte value) {
            addCriterion("online <=", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineIn(List<Byte> values) {
            addCriterion("online in", values, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineNotIn(List<Byte> values) {
            addCriterion("online not in", values, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineBetween(Byte value1, Byte value2) {
            addCriterion("online between", value1, value2, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineNotBetween(Byte value1, Byte value2) {
            addCriterion("online not between", value1, value2, "online");
            return (Criteria) this;
        }

        public Criteria andHeadimgIsNull() {
            addCriterion("headimg is null");
            return (Criteria) this;
        }

        public Criteria andHeadimgIsNotNull() {
            addCriterion("headimg is not null");
            return (Criteria) this;
        }

        public Criteria andHeadimgEqualTo(Byte value) {
            addCriterion("headimg =", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgNotEqualTo(Byte value) {
            addCriterion("headimg <>", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgGreaterThan(Byte value) {
            addCriterion("headimg >", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgGreaterThanOrEqualTo(Byte value) {
            addCriterion("headimg >=", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgLessThan(Byte value) {
            addCriterion("headimg <", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgLessThanOrEqualTo(Byte value) {
            addCriterion("headimg <=", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgIn(List<Byte> values) {
            addCriterion("headimg in", values, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgNotIn(List<Byte> values) {
            addCriterion("headimg not in", values, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgBetween(Byte value1, Byte value2) {
            addCriterion("headimg between", value1, value2, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgNotBetween(Byte value1, Byte value2) {
            addCriterion("headimg not between", value1, value2, "headimg");
            return (Criteria) this;
        }

        public Criteria andSecquestionIsNull() {
            addCriterion("secquestion is null");
            return (Criteria) this;
        }

        public Criteria andSecquestionIsNotNull() {
            addCriterion("secquestion is not null");
            return (Criteria) this;
        }

        public Criteria andSecquestionEqualTo(Byte value) {
            addCriterion("secquestion =", value, "secquestion");
            return (Criteria) this;
        }

        public Criteria andSecquestionNotEqualTo(Byte value) {
            addCriterion("secquestion <>", value, "secquestion");
            return (Criteria) this;
        }

        public Criteria andSecquestionGreaterThan(Byte value) {
            addCriterion("secquestion >", value, "secquestion");
            return (Criteria) this;
        }

        public Criteria andSecquestionGreaterThanOrEqualTo(Byte value) {
            addCriterion("secquestion >=", value, "secquestion");
            return (Criteria) this;
        }

        public Criteria andSecquestionLessThan(Byte value) {
            addCriterion("secquestion <", value, "secquestion");
            return (Criteria) this;
        }

        public Criteria andSecquestionLessThanOrEqualTo(Byte value) {
            addCriterion("secquestion <=", value, "secquestion");
            return (Criteria) this;
        }

        public Criteria andSecquestionIn(List<Byte> values) {
            addCriterion("secquestion in", values, "secquestion");
            return (Criteria) this;
        }

        public Criteria andSecquestionNotIn(List<Byte> values) {
            addCriterion("secquestion not in", values, "secquestion");
            return (Criteria) this;
        }

        public Criteria andSecquestionBetween(Byte value1, Byte value2) {
            addCriterion("secquestion between", value1, value2, "secquestion");
            return (Criteria) this;
        }

        public Criteria andSecquestionNotBetween(Byte value1, Byte value2) {
            addCriterion("secquestion not between", value1, value2, "secquestion");
            return (Criteria) this;
        }

        public Criteria andPlayerlevelIsNull() {
            addCriterion("playerlevel is null");
            return (Criteria) this;
        }

        public Criteria andPlayerlevelIsNotNull() {
            addCriterion("playerlevel is not null");
            return (Criteria) this;
        }

        public Criteria andPlayerlevelEqualTo(String value) {
            addCriterion("playerlevel =", value, "playerlevel");
            return (Criteria) this;
        }

        public Criteria andPlayerlevelNotEqualTo(String value) {
            addCriterion("playerlevel <>", value, "playerlevel");
            return (Criteria) this;
        }

        public Criteria andPlayerlevelGreaterThan(String value) {
            addCriterion("playerlevel >", value, "playerlevel");
            return (Criteria) this;
        }

        public Criteria andPlayerlevelGreaterThanOrEqualTo(String value) {
            addCriterion("playerlevel >=", value, "playerlevel");
            return (Criteria) this;
        }

        public Criteria andPlayerlevelLessThan(String value) {
            addCriterion("playerlevel <", value, "playerlevel");
            return (Criteria) this;
        }

        public Criteria andPlayerlevelLessThanOrEqualTo(String value) {
            addCriterion("playerlevel <=", value, "playerlevel");
            return (Criteria) this;
        }

        public Criteria andPlayerlevelLike(String value) {
            addCriterion("playerlevel like", value, "playerlevel");
            return (Criteria) this;
        }

        public Criteria andPlayerlevelNotLike(String value) {
            addCriterion("playerlevel not like", value, "playerlevel");
            return (Criteria) this;
        }

        public Criteria andPlayerlevelIn(List<String> values) {
            addCriterion("playerlevel in", values, "playerlevel");
            return (Criteria) this;
        }

        public Criteria andPlayerlevelNotIn(List<String> values) {
            addCriterion("playerlevel not in", values, "playerlevel");
            return (Criteria) this;
        }

        public Criteria andPlayerlevelBetween(String value1, String value2) {
            addCriterion("playerlevel between", value1, value2, "playerlevel");
            return (Criteria) this;
        }

        public Criteria andPlayerlevelNotBetween(String value1, String value2) {
            addCriterion("playerlevel not between", value1, value2, "playerlevel");
            return (Criteria) this;
        }

        public Criteria andExperienceIsNull() {
            addCriterion("experience is null");
            return (Criteria) this;
        }

        public Criteria andExperienceIsNotNull() {
            addCriterion("experience is not null");
            return (Criteria) this;
        }

        public Criteria andExperienceEqualTo(Integer value) {
            addCriterion("experience =", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceNotEqualTo(Integer value) {
            addCriterion("experience <>", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceGreaterThan(Integer value) {
            addCriterion("experience >", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceGreaterThanOrEqualTo(Integer value) {
            addCriterion("experience >=", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceLessThan(Integer value) {
            addCriterion("experience <", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceLessThanOrEqualTo(Integer value) {
            addCriterion("experience <=", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceIn(List<Integer> values) {
            addCriterion("experience in", values, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceNotIn(List<Integer> values) {
            addCriterion("experience not in", values, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceBetween(Integer value1, Integer value2) {
            addCriterion("experience between", value1, value2, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceNotBetween(Integer value1, Integer value2) {
            addCriterion("experience not between", value1, value2, "experience");
            return (Criteria) this;
        }

        public Criteria andUnameIsNull() {
            addCriterion("uname is null");
            return (Criteria) this;
        }

        public Criteria andUnameIsNotNull() {
            addCriterion("uname is not null");
            return (Criteria) this;
        }

        public Criteria andUnameEqualTo(String value) {
            addCriterion("uname =", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotEqualTo(String value) {
            addCriterion("uname <>", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameGreaterThan(String value) {
            addCriterion("uname >", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameGreaterThanOrEqualTo(String value) {
            addCriterion("uname >=", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLessThan(String value) {
            addCriterion("uname <", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLessThanOrEqualTo(String value) {
            addCriterion("uname <=", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLike(String value) {
            addCriterion("uname like", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotLike(String value) {
            addCriterion("uname not like", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameIn(List<String> values) {
            addCriterion("uname in", values, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotIn(List<String> values) {
            addCriterion("uname not in", values, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameBetween(String value1, String value2) {
            addCriterion("uname between", value1, value2, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotBetween(String value1, String value2) {
            addCriterion("uname not between", value1, value2, "uname");
            return (Criteria) this;
        }

        public Criteria andMusteditpasswordIsNull() {
            addCriterion("musteditpassword is null");
            return (Criteria) this;
        }

        public Criteria andMusteditpasswordIsNotNull() {
            addCriterion("musteditpassword is not null");
            return (Criteria) this;
        }

        public Criteria andMusteditpasswordEqualTo(Byte value) {
            addCriterion("musteditpassword =", value, "musteditpassword");
            return (Criteria) this;
        }

        public Criteria andMusteditpasswordNotEqualTo(Byte value) {
            addCriterion("musteditpassword <>", value, "musteditpassword");
            return (Criteria) this;
        }

        public Criteria andMusteditpasswordGreaterThan(Byte value) {
            addCriterion("musteditpassword >", value, "musteditpassword");
            return (Criteria) this;
        }

        public Criteria andMusteditpasswordGreaterThanOrEqualTo(Byte value) {
            addCriterion("musteditpassword >=", value, "musteditpassword");
            return (Criteria) this;
        }

        public Criteria andMusteditpasswordLessThan(Byte value) {
            addCriterion("musteditpassword <", value, "musteditpassword");
            return (Criteria) this;
        }

        public Criteria andMusteditpasswordLessThanOrEqualTo(Byte value) {
            addCriterion("musteditpassword <=", value, "musteditpassword");
            return (Criteria) this;
        }

        public Criteria andMusteditpasswordIn(List<Byte> values) {
            addCriterion("musteditpassword in", values, "musteditpassword");
            return (Criteria) this;
        }

        public Criteria andMusteditpasswordNotIn(List<Byte> values) {
            addCriterion("musteditpassword not in", values, "musteditpassword");
            return (Criteria) this;
        }

        public Criteria andMusteditpasswordBetween(Byte value1, Byte value2) {
            addCriterion("musteditpassword between", value1, value2, "musteditpassword");
            return (Criteria) this;
        }

        public Criteria andMusteditpasswordNotBetween(Byte value1, Byte value2) {
            addCriterion("musteditpassword not between", value1, value2, "musteditpassword");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andFansIsNull() {
            addCriterion("fans is null");
            return (Criteria) this;
        }

        public Criteria andFansIsNotNull() {
            addCriterion("fans is not null");
            return (Criteria) this;
        }

        public Criteria andFansEqualTo(Integer value) {
            addCriterion("fans =", value, "fans");
            return (Criteria) this;
        }

        public Criteria andFansNotEqualTo(Integer value) {
            addCriterion("fans <>", value, "fans");
            return (Criteria) this;
        }

        public Criteria andFansGreaterThan(Integer value) {
            addCriterion("fans >", value, "fans");
            return (Criteria) this;
        }

        public Criteria andFansGreaterThanOrEqualTo(Integer value) {
            addCriterion("fans >=", value, "fans");
            return (Criteria) this;
        }

        public Criteria andFansLessThan(Integer value) {
            addCriterion("fans <", value, "fans");
            return (Criteria) this;
        }

        public Criteria andFansLessThanOrEqualTo(Integer value) {
            addCriterion("fans <=", value, "fans");
            return (Criteria) this;
        }

        public Criteria andFansIn(List<Integer> values) {
            addCriterion("fans in", values, "fans");
            return (Criteria) this;
        }

        public Criteria andFansNotIn(List<Integer> values) {
            addCriterion("fans not in", values, "fans");
            return (Criteria) this;
        }

        public Criteria andFansBetween(Integer value1, Integer value2) {
            addCriterion("fans between", value1, value2, "fans");
            return (Criteria) this;
        }

        public Criteria andFansNotBetween(Integer value1, Integer value2) {
            addCriterion("fans not between", value1, value2, "fans");
            return (Criteria) this;
        }

        public Criteria andFollowsIsNull() {
            addCriterion("follows is null");
            return (Criteria) this;
        }

        public Criteria andFollowsIsNotNull() {
            addCriterion("follows is not null");
            return (Criteria) this;
        }

        public Criteria andFollowsEqualTo(Integer value) {
            addCriterion("follows =", value, "follows");
            return (Criteria) this;
        }

        public Criteria andFollowsNotEqualTo(Integer value) {
            addCriterion("follows <>", value, "follows");
            return (Criteria) this;
        }

        public Criteria andFollowsGreaterThan(Integer value) {
            addCriterion("follows >", value, "follows");
            return (Criteria) this;
        }

        public Criteria andFollowsGreaterThanOrEqualTo(Integer value) {
            addCriterion("follows >=", value, "follows");
            return (Criteria) this;
        }

        public Criteria andFollowsLessThan(Integer value) {
            addCriterion("follows <", value, "follows");
            return (Criteria) this;
        }

        public Criteria andFollowsLessThanOrEqualTo(Integer value) {
            addCriterion("follows <=", value, "follows");
            return (Criteria) this;
        }

        public Criteria andFollowsIn(List<Integer> values) {
            addCriterion("follows in", values, "follows");
            return (Criteria) this;
        }

        public Criteria andFollowsNotIn(List<Integer> values) {
            addCriterion("follows not in", values, "follows");
            return (Criteria) this;
        }

        public Criteria andFollowsBetween(Integer value1, Integer value2) {
            addCriterion("follows between", value1, value2, "follows");
            return (Criteria) this;
        }

        public Criteria andFollowsNotBetween(Integer value1, Integer value2) {
            addCriterion("follows not between", value1, value2, "follows");
            return (Criteria) this;
        }

        public Criteria andIntegralIsNull() {
            addCriterion("integral is null");
            return (Criteria) this;
        }

        public Criteria andIntegralIsNotNull() {
            addCriterion("integral is not null");
            return (Criteria) this;
        }

        public Criteria andIntegralEqualTo(Integer value) {
            addCriterion("integral =", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralNotEqualTo(Integer value) {
            addCriterion("integral <>", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralGreaterThan(Integer value) {
            addCriterion("integral >", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralGreaterThanOrEqualTo(Integer value) {
            addCriterion("integral >=", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralLessThan(Integer value) {
            addCriterion("integral <", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralLessThanOrEqualTo(Integer value) {
            addCriterion("integral <=", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralIn(List<Integer> values) {
            addCriterion("integral in", values, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralNotIn(List<Integer> values) {
            addCriterion("integral not in", values, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralBetween(Integer value1, Integer value2) {
            addCriterion("integral between", value1, value2, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralNotBetween(Integer value1, Integer value2) {
            addCriterion("integral not between", value1, value2, "integral");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeIsNull() {
            addCriterion("lastlogintime is null");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeIsNotNull() {
            addCriterion("lastlogintime is not null");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeEqualTo(Date value) {
            addCriterion("lastlogintime =", value, "lastlogintime");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeNotEqualTo(Date value) {
            addCriterion("lastlogintime <>", value, "lastlogintime");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeGreaterThan(Date value) {
            addCriterion("lastlogintime >", value, "lastlogintime");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeGreaterThanOrEqualTo(Date value) {
            addCriterion("lastlogintime >=", value, "lastlogintime");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeLessThan(Date value) {
            addCriterion("lastlogintime <", value, "lastlogintime");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeLessThanOrEqualTo(Date value) {
            addCriterion("lastlogintime <=", value, "lastlogintime");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeIn(List<Date> values) {
            addCriterion("lastlogintime in", values, "lastlogintime");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeNotIn(List<Date> values) {
            addCriterion("lastlogintime not in", values, "lastlogintime");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeBetween(Date value1, Date value2) {
            addCriterion("lastlogintime between", value1, value2, "lastlogintime");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeNotBetween(Date value1, Date value2) {
            addCriterion("lastlogintime not between", value1, value2, "lastlogintime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andDeactivetimeIsNull() {
            addCriterion("deactivetime is null");
            return (Criteria) this;
        }

        public Criteria andDeactivetimeIsNotNull() {
            addCriterion("deactivetime is not null");
            return (Criteria) this;
        }

        public Criteria andDeactivetimeEqualTo(Date value) {
            addCriterion("deactivetime =", value, "deactivetime");
            return (Criteria) this;
        }

        public Criteria andDeactivetimeNotEqualTo(Date value) {
            addCriterion("deactivetime <>", value, "deactivetime");
            return (Criteria) this;
        }

        public Criteria andDeactivetimeGreaterThan(Date value) {
            addCriterion("deactivetime >", value, "deactivetime");
            return (Criteria) this;
        }

        public Criteria andDeactivetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("deactivetime >=", value, "deactivetime");
            return (Criteria) this;
        }

        public Criteria andDeactivetimeLessThan(Date value) {
            addCriterion("deactivetime <", value, "deactivetime");
            return (Criteria) this;
        }

        public Criteria andDeactivetimeLessThanOrEqualTo(Date value) {
            addCriterion("deactivetime <=", value, "deactivetime");
            return (Criteria) this;
        }

        public Criteria andDeactivetimeIn(List<Date> values) {
            addCriterion("deactivetime in", values, "deactivetime");
            return (Criteria) this;
        }

        public Criteria andDeactivetimeNotIn(List<Date> values) {
            addCriterion("deactivetime not in", values, "deactivetime");
            return (Criteria) this;
        }

        public Criteria andDeactivetimeBetween(Date value1, Date value2) {
            addCriterion("deactivetime between", value1, value2, "deactivetime");
            return (Criteria) this;
        }

        public Criteria andDeactivetimeNotBetween(Date value1, Date value2) {
            addCriterion("deactivetime not between", value1, value2, "deactivetime");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andDatastatusIsNull() {
            addCriterion("DATASTATUS is null");
            return (Criteria) this;
        }

        public Criteria andDatastatusIsNotNull() {
            addCriterion("DATASTATUS is not null");
            return (Criteria) this;
        }

        public Criteria andDatastatusEqualTo(Byte value) {
            addCriterion("DATASTATUS =", value, "datastatus");
            return (Criteria) this;
        }

        public Criteria andDatastatusNotEqualTo(Byte value) {
            addCriterion("DATASTATUS <>", value, "datastatus");
            return (Criteria) this;
        }

        public Criteria andDatastatusGreaterThan(Byte value) {
            addCriterion("DATASTATUS >", value, "datastatus");
            return (Criteria) this;
        }

        public Criteria andDatastatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("DATASTATUS >=", value, "datastatus");
            return (Criteria) this;
        }

        public Criteria andDatastatusLessThan(Byte value) {
            addCriterion("DATASTATUS <", value, "datastatus");
            return (Criteria) this;
        }

        public Criteria andDatastatusLessThanOrEqualTo(Byte value) {
            addCriterion("DATASTATUS <=", value, "datastatus");
            return (Criteria) this;
        }

        public Criteria andDatastatusIn(List<Byte> values) {
            addCriterion("DATASTATUS in", values, "datastatus");
            return (Criteria) this;
        }

        public Criteria andDatastatusNotIn(List<Byte> values) {
            addCriterion("DATASTATUS not in", values, "datastatus");
            return (Criteria) this;
        }

        public Criteria andDatastatusBetween(Byte value1, Byte value2) {
            addCriterion("DATASTATUS between", value1, value2, "datastatus");
            return (Criteria) this;
        }

        public Criteria andDatastatusNotBetween(Byte value1, Byte value2) {
            addCriterion("DATASTATUS not between", value1, value2, "datastatus");
            return (Criteria) this;
        }

        public Criteria andTokenIsNull() {
            addCriterion("token is null");
            return (Criteria) this;
        }

        public Criteria andTokenIsNotNull() {
            addCriterion("token is not null");
            return (Criteria) this;
        }

        public Criteria andTokenEqualTo(String value) {
            addCriterion("token =", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotEqualTo(String value) {
            addCriterion("token <>", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenGreaterThan(String value) {
            addCriterion("token >", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenGreaterThanOrEqualTo(String value) {
            addCriterion("token >=", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLessThan(String value) {
            addCriterion("token <", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLessThanOrEqualTo(String value) {
            addCriterion("token <=", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLike(String value) {
            addCriterion("token like", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotLike(String value) {
            addCriterion("token not like", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenIn(List<String> values) {
            addCriterion("token in", values, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotIn(List<String> values) {
            addCriterion("token not in", values, "token");
            return (Criteria) this;
        }

        public Criteria andTokenBetween(String value1, String value2) {
            addCriterion("token between", value1, value2, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotBetween(String value1, String value2) {
            addCriterion("token not between", value1, value2, "token");
            return (Criteria) this;
        }

        public Criteria andCardsIsNull() {
            addCriterion("cards is null");
            return (Criteria) this;
        }

        public Criteria andCardsIsNotNull() {
            addCriterion("cards is not null");
            return (Criteria) this;
        }

        public Criteria andCardsEqualTo(Integer value) {
            addCriterion("cards =", value, "cards");
            return (Criteria) this;
        }

        public Criteria andCardsNotEqualTo(Integer value) {
            addCriterion("cards <>", value, "cards");
            return (Criteria) this;
        }

        public Criteria andCardsGreaterThan(Integer value) {
            addCriterion("cards >", value, "cards");
            return (Criteria) this;
        }

        public Criteria andCardsGreaterThanOrEqualTo(Integer value) {
            addCriterion("cards >=", value, "cards");
            return (Criteria) this;
        }

        public Criteria andCardsLessThan(Integer value) {
            addCriterion("cards <", value, "cards");
            return (Criteria) this;
        }

        public Criteria andCardsLessThanOrEqualTo(Integer value) {
            addCriterion("cards <=", value, "cards");
            return (Criteria) this;
        }

        public Criteria andCardsIn(List<Integer> values) {
            addCriterion("cards in", values, "cards");
            return (Criteria) this;
        }

        public Criteria andCardsNotIn(List<Integer> values) {
            addCriterion("cards not in", values, "cards");
            return (Criteria) this;
        }

        public Criteria andCardsBetween(Integer value1, Integer value2) {
            addCriterion("cards between", value1, value2, "cards");
            return (Criteria) this;
        }

        public Criteria andCardsNotBetween(Integer value1, Integer value2) {
            addCriterion("cards not between", value1, value2, "cards");
            return (Criteria) this;
        }

        public Criteria andGoldcoinsIsNull() {
            addCriterion("goldcoins is null");
            return (Criteria) this;
        }

        public Criteria andGoldcoinsIsNotNull() {
            addCriterion("goldcoins is not null");
            return (Criteria) this;
        }

        public Criteria andGoldcoinsEqualTo(Integer value) {
            addCriterion("goldcoins =", value, "goldcoins");
            return (Criteria) this;
        }

        public Criteria andGoldcoinsNotEqualTo(Integer value) {
            addCriterion("goldcoins <>", value, "goldcoins");
            return (Criteria) this;
        }

        public Criteria andGoldcoinsGreaterThan(Integer value) {
            addCriterion("goldcoins >", value, "goldcoins");
            return (Criteria) this;
        }

        public Criteria andGoldcoinsGreaterThanOrEqualTo(Integer value) {
            addCriterion("goldcoins >=", value, "goldcoins");
            return (Criteria) this;
        }

        public Criteria andGoldcoinsLessThan(Integer value) {
            addCriterion("goldcoins <", value, "goldcoins");
            return (Criteria) this;
        }

        public Criteria andGoldcoinsLessThanOrEqualTo(Integer value) {
            addCriterion("goldcoins <=", value, "goldcoins");
            return (Criteria) this;
        }

        public Criteria andGoldcoinsIn(List<Integer> values) {
            addCriterion("goldcoins in", values, "goldcoins");
            return (Criteria) this;
        }

        public Criteria andGoldcoinsNotIn(List<Integer> values) {
            addCriterion("goldcoins not in", values, "goldcoins");
            return (Criteria) this;
        }

        public Criteria andGoldcoinsBetween(Integer value1, Integer value2) {
            addCriterion("goldcoins between", value1, value2, "goldcoins");
            return (Criteria) this;
        }

        public Criteria andGoldcoinsNotBetween(Integer value1, Integer value2) {
            addCriterion("goldcoins not between", value1, value2, "goldcoins");
            return (Criteria) this;
        }

        public Criteria andDiamondsIsNull() {
            addCriterion("diamonds is null");
            return (Criteria) this;
        }

        public Criteria andDiamondsIsNotNull() {
            addCriterion("diamonds is not null");
            return (Criteria) this;
        }

        public Criteria andDiamondsEqualTo(Integer value) {
            addCriterion("diamonds =", value, "diamonds");
            return (Criteria) this;
        }

        public Criteria andDiamondsNotEqualTo(Integer value) {
            addCriterion("diamonds <>", value, "diamonds");
            return (Criteria) this;
        }

        public Criteria andDiamondsGreaterThan(Integer value) {
            addCriterion("diamonds >", value, "diamonds");
            return (Criteria) this;
        }

        public Criteria andDiamondsGreaterThanOrEqualTo(Integer value) {
            addCriterion("diamonds >=", value, "diamonds");
            return (Criteria) this;
        }

        public Criteria andDiamondsLessThan(Integer value) {
            addCriterion("diamonds <", value, "diamonds");
            return (Criteria) this;
        }

        public Criteria andDiamondsLessThanOrEqualTo(Integer value) {
            addCriterion("diamonds <=", value, "diamonds");
            return (Criteria) this;
        }

        public Criteria andDiamondsIn(List<Integer> values) {
            addCriterion("diamonds in", values, "diamonds");
            return (Criteria) this;
        }

        public Criteria andDiamondsNotIn(List<Integer> values) {
            addCriterion("diamonds not in", values, "diamonds");
            return (Criteria) this;
        }

        public Criteria andDiamondsBetween(Integer value1, Integer value2) {
            addCriterion("diamonds between", value1, value2, "diamonds");
            return (Criteria) this;
        }

        public Criteria andDiamondsNotBetween(Integer value1, Integer value2) {
            addCriterion("diamonds not between", value1, value2, "diamonds");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNull() {
            addCriterion("openid is null");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNotNull() {
            addCriterion("openid is not null");
            return (Criteria) this;
        }

        public Criteria andOpenidEqualTo(String value) {
            addCriterion("openid =", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotEqualTo(String value) {
            addCriterion("openid <>", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThan(String value) {
            addCriterion("openid >", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("openid >=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThan(String value) {
            addCriterion("openid <", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThanOrEqualTo(String value) {
            addCriterion("openid <=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLike(String value) {
            addCriterion("openid like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotLike(String value) {
            addCriterion("openid not like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidIn(List<String> values) {
            addCriterion("openid in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotIn(List<String> values) {
            addCriterion("openid not in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidBetween(String value1, String value2) {
            addCriterion("openid between", value1, value2, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotBetween(String value1, String value2) {
            addCriterion("openid not between", value1, value2, "openid");
            return (Criteria) this;
        }

        public Criteria andPayopenidIsNull() {
            addCriterion("payopenid is null");
            return (Criteria) this;
        }

        public Criteria andPayopenidIsNotNull() {
            addCriterion("payopenid is not null");
            return (Criteria) this;
        }

        public Criteria andPayopenidEqualTo(String value) {
            addCriterion("payopenid =", value, "payopenid");
            return (Criteria) this;
        }

        public Criteria andPayopenidNotEqualTo(String value) {
            addCriterion("payopenid <>", value, "payopenid");
            return (Criteria) this;
        }

        public Criteria andPayopenidGreaterThan(String value) {
            addCriterion("payopenid >", value, "payopenid");
            return (Criteria) this;
        }

        public Criteria andPayopenidGreaterThanOrEqualTo(String value) {
            addCriterion("payopenid >=", value, "payopenid");
            return (Criteria) this;
        }

        public Criteria andPayopenidLessThan(String value) {
            addCriterion("payopenid <", value, "payopenid");
            return (Criteria) this;
        }

        public Criteria andPayopenidLessThanOrEqualTo(String value) {
            addCriterion("payopenid <=", value, "payopenid");
            return (Criteria) this;
        }

        public Criteria andPayopenidLike(String value) {
            addCriterion("payopenid like", value, "payopenid");
            return (Criteria) this;
        }

        public Criteria andPayopenidNotLike(String value) {
            addCriterion("payopenid not like", value, "payopenid");
            return (Criteria) this;
        }

        public Criteria andPayopenidIn(List<String> values) {
            addCriterion("payopenid in", values, "payopenid");
            return (Criteria) this;
        }

        public Criteria andPayopenidNotIn(List<String> values) {
            addCriterion("payopenid not in", values, "payopenid");
            return (Criteria) this;
        }

        public Criteria andPayopenidBetween(String value1, String value2) {
            addCriterion("payopenid between", value1, value2, "payopenid");
            return (Criteria) this;
        }

        public Criteria andPayopenidNotBetween(String value1, String value2) {
            addCriterion("payopenid not between", value1, value2, "payopenid");
            return (Criteria) this;
        }

        public Criteria andUnionidIsNull() {
            addCriterion("unionid is null");
            return (Criteria) this;
        }

        public Criteria andUnionidIsNotNull() {
            addCriterion("unionid is not null");
            return (Criteria) this;
        }

        public Criteria andUnionidEqualTo(String value) {
            addCriterion("unionid =", value, "unionid");
            return (Criteria) this;
        }

        public Criteria andUnionidNotEqualTo(String value) {
            addCriterion("unionid <>", value, "unionid");
            return (Criteria) this;
        }

        public Criteria andUnionidGreaterThan(String value) {
            addCriterion("unionid >", value, "unionid");
            return (Criteria) this;
        }

        public Criteria andUnionidGreaterThanOrEqualTo(String value) {
            addCriterion("unionid >=", value, "unionid");
            return (Criteria) this;
        }

        public Criteria andUnionidLessThan(String value) {
            addCriterion("unionid <", value, "unionid");
            return (Criteria) this;
        }

        public Criteria andUnionidLessThanOrEqualTo(String value) {
            addCriterion("unionid <=", value, "unionid");
            return (Criteria) this;
        }

        public Criteria andUnionidLike(String value) {
            addCriterion("unionid like", value, "unionid");
            return (Criteria) this;
        }

        public Criteria andUnionidNotLike(String value) {
            addCriterion("unionid not like", value, "unionid");
            return (Criteria) this;
        }

        public Criteria andUnionidIn(List<String> values) {
            addCriterion("unionid in", values, "unionid");
            return (Criteria) this;
        }

        public Criteria andUnionidNotIn(List<String> values) {
            addCriterion("unionid not in", values, "unionid");
            return (Criteria) this;
        }

        public Criteria andUnionidBetween(String value1, String value2) {
            addCriterion("unionid between", value1, value2, "unionid");
            return (Criteria) this;
        }

        public Criteria andUnionidNotBetween(String value1, String value2) {
            addCriterion("unionid not between", value1, value2, "unionid");
            return (Criteria) this;
        }

        public Criteria andQqidIsNull() {
            addCriterion("qqid is null");
            return (Criteria) this;
        }

        public Criteria andQqidIsNotNull() {
            addCriterion("qqid is not null");
            return (Criteria) this;
        }

        public Criteria andQqidEqualTo(String value) {
            addCriterion("qqid =", value, "qqid");
            return (Criteria) this;
        }

        public Criteria andQqidNotEqualTo(String value) {
            addCriterion("qqid <>", value, "qqid");
            return (Criteria) this;
        }

        public Criteria andQqidGreaterThan(String value) {
            addCriterion("qqid >", value, "qqid");
            return (Criteria) this;
        }

        public Criteria andQqidGreaterThanOrEqualTo(String value) {
            addCriterion("qqid >=", value, "qqid");
            return (Criteria) this;
        }

        public Criteria andQqidLessThan(String value) {
            addCriterion("qqid <", value, "qqid");
            return (Criteria) this;
        }

        public Criteria andQqidLessThanOrEqualTo(String value) {
            addCriterion("qqid <=", value, "qqid");
            return (Criteria) this;
        }

        public Criteria andQqidLike(String value) {
            addCriterion("qqid like", value, "qqid");
            return (Criteria) this;
        }

        public Criteria andQqidNotLike(String value) {
            addCriterion("qqid not like", value, "qqid");
            return (Criteria) this;
        }

        public Criteria andQqidIn(List<String> values) {
            addCriterion("qqid in", values, "qqid");
            return (Criteria) this;
        }

        public Criteria andQqidNotIn(List<String> values) {
            addCriterion("qqid not in", values, "qqid");
            return (Criteria) this;
        }

        public Criteria andQqidBetween(String value1, String value2) {
            addCriterion("qqid between", value1, value2, "qqid");
            return (Criteria) this;
        }

        public Criteria andQqidNotBetween(String value1, String value2) {
            addCriterion("qqid not between", value1, value2, "qqid");
            return (Criteria) this;
        }

        public Criteria andCountryIsNull() {
            addCriterion("country is null");
            return (Criteria) this;
        }

        public Criteria andCountryIsNotNull() {
            addCriterion("country is not null");
            return (Criteria) this;
        }

        public Criteria andCountryEqualTo(String value) {
            addCriterion("country =", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotEqualTo(String value) {
            addCriterion("country <>", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThan(String value) {
            addCriterion("country >", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThanOrEqualTo(String value) {
            addCriterion("country >=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThan(String value) {
            addCriterion("country <", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThanOrEqualTo(String value) {
            addCriterion("country <=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLike(String value) {
            addCriterion("country like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotLike(String value) {
            addCriterion("country not like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryIn(List<String> values) {
            addCriterion("country in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotIn(List<String> values) {
            addCriterion("country not in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryBetween(String value1, String value2) {
            addCriterion("country between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotBetween(String value1, String value2) {
            addCriterion("country not between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andRegionIsNull() {
            addCriterion("region is null");
            return (Criteria) this;
        }

        public Criteria andRegionIsNotNull() {
            addCriterion("region is not null");
            return (Criteria) this;
        }

        public Criteria andRegionEqualTo(String value) {
            addCriterion("region =", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotEqualTo(String value) {
            addCriterion("region <>", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionGreaterThan(String value) {
            addCriterion("region >", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionGreaterThanOrEqualTo(String value) {
            addCriterion("region >=", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLessThan(String value) {
            addCriterion("region <", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLessThanOrEqualTo(String value) {
            addCriterion("region <=", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLike(String value) {
            addCriterion("region like", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotLike(String value) {
            addCriterion("region not like", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionIn(List<String> values) {
            addCriterion("region in", values, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotIn(List<String> values) {
            addCriterion("region not in", values, "region");
            return (Criteria) this;
        }

        public Criteria andRegionBetween(String value1, String value2) {
            addCriterion("region between", value1, value2, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotBetween(String value1, String value2) {
            addCriterion("region not between", value1, value2, "region");
            return (Criteria) this;
        }

        public Criteria andIspIsNull() {
            addCriterion("isp is null");
            return (Criteria) this;
        }

        public Criteria andIspIsNotNull() {
            addCriterion("isp is not null");
            return (Criteria) this;
        }

        public Criteria andIspEqualTo(String value) {
            addCriterion("isp =", value, "isp");
            return (Criteria) this;
        }

        public Criteria andIspNotEqualTo(String value) {
            addCriterion("isp <>", value, "isp");
            return (Criteria) this;
        }

        public Criteria andIspGreaterThan(String value) {
            addCriterion("isp >", value, "isp");
            return (Criteria) this;
        }

        public Criteria andIspGreaterThanOrEqualTo(String value) {
            addCriterion("isp >=", value, "isp");
            return (Criteria) this;
        }

        public Criteria andIspLessThan(String value) {
            addCriterion("isp <", value, "isp");
            return (Criteria) this;
        }

        public Criteria andIspLessThanOrEqualTo(String value) {
            addCriterion("isp <=", value, "isp");
            return (Criteria) this;
        }

        public Criteria andIspLike(String value) {
            addCriterion("isp like", value, "isp");
            return (Criteria) this;
        }

        public Criteria andIspNotLike(String value) {
            addCriterion("isp not like", value, "isp");
            return (Criteria) this;
        }

        public Criteria andIspIn(List<String> values) {
            addCriterion("isp in", values, "isp");
            return (Criteria) this;
        }

        public Criteria andIspNotIn(List<String> values) {
            addCriterion("isp not in", values, "isp");
            return (Criteria) this;
        }

        public Criteria andIspBetween(String value1, String value2) {
            addCriterion("isp between", value1, value2, "isp");
            return (Criteria) this;
        }

        public Criteria andIspNotBetween(String value1, String value2) {
            addCriterion("isp not between", value1, value2, "isp");
            return (Criteria) this;
        }

        public Criteria andOstypeIsNull() {
            addCriterion("ostype is null");
            return (Criteria) this;
        }

        public Criteria andOstypeIsNotNull() {
            addCriterion("ostype is not null");
            return (Criteria) this;
        }

        public Criteria andOstypeEqualTo(String value) {
            addCriterion("ostype =", value, "ostype");
            return (Criteria) this;
        }

        public Criteria andOstypeNotEqualTo(String value) {
            addCriterion("ostype <>", value, "ostype");
            return (Criteria) this;
        }

        public Criteria andOstypeGreaterThan(String value) {
            addCriterion("ostype >", value, "ostype");
            return (Criteria) this;
        }

        public Criteria andOstypeGreaterThanOrEqualTo(String value) {
            addCriterion("ostype >=", value, "ostype");
            return (Criteria) this;
        }

        public Criteria andOstypeLessThan(String value) {
            addCriterion("ostype <", value, "ostype");
            return (Criteria) this;
        }

        public Criteria andOstypeLessThanOrEqualTo(String value) {
            addCriterion("ostype <=", value, "ostype");
            return (Criteria) this;
        }

        public Criteria andOstypeLike(String value) {
            addCriterion("ostype like", value, "ostype");
            return (Criteria) this;
        }

        public Criteria andOstypeNotLike(String value) {
            addCriterion("ostype not like", value, "ostype");
            return (Criteria) this;
        }

        public Criteria andOstypeIn(List<String> values) {
            addCriterion("ostype in", values, "ostype");
            return (Criteria) this;
        }

        public Criteria andOstypeNotIn(List<String> values) {
            addCriterion("ostype not in", values, "ostype");
            return (Criteria) this;
        }

        public Criteria andOstypeBetween(String value1, String value2) {
            addCriterion("ostype between", value1, value2, "ostype");
            return (Criteria) this;
        }

        public Criteria andOstypeNotBetween(String value1, String value2) {
            addCriterion("ostype not between", value1, value2, "ostype");
            return (Criteria) this;
        }

        public Criteria andDisabledIsNull() {
            addCriterion("disabled is null");
            return (Criteria) this;
        }

        public Criteria andDisabledIsNotNull() {
            addCriterion("disabled is not null");
            return (Criteria) this;
        }

        public Criteria andDisabledEqualTo(Byte value) {
            addCriterion("disabled =", value, "disabled");
            return (Criteria) this;
        }

        public Criteria andDisabledNotEqualTo(Byte value) {
            addCriterion("disabled <>", value, "disabled");
            return (Criteria) this;
        }

        public Criteria andDisabledGreaterThan(Byte value) {
            addCriterion("disabled >", value, "disabled");
            return (Criteria) this;
        }

        public Criteria andDisabledGreaterThanOrEqualTo(Byte value) {
            addCriterion("disabled >=", value, "disabled");
            return (Criteria) this;
        }

        public Criteria andDisabledLessThan(Byte value) {
            addCriterion("disabled <", value, "disabled");
            return (Criteria) this;
        }

        public Criteria andDisabledLessThanOrEqualTo(Byte value) {
            addCriterion("disabled <=", value, "disabled");
            return (Criteria) this;
        }

        public Criteria andDisabledIn(List<Byte> values) {
            addCriterion("disabled in", values, "disabled");
            return (Criteria) this;
        }

        public Criteria andDisabledNotIn(List<Byte> values) {
            addCriterion("disabled not in", values, "disabled");
            return (Criteria) this;
        }

        public Criteria andDisabledBetween(Byte value1, Byte value2) {
            addCriterion("disabled between", value1, value2, "disabled");
            return (Criteria) this;
        }

        public Criteria andDisabledNotBetween(Byte value1, Byte value2) {
            addCriterion("disabled not between", value1, value2, "disabled");
            return (Criteria) this;
        }

        public Criteria andUseragentIsNull() {
            addCriterion("useragent is null");
            return (Criteria) this;
        }

        public Criteria andUseragentIsNotNull() {
            addCriterion("useragent is not null");
            return (Criteria) this;
        }

        public Criteria andUseragentEqualTo(String value) {
            addCriterion("useragent =", value, "useragent");
            return (Criteria) this;
        }

        public Criteria andUseragentNotEqualTo(String value) {
            addCriterion("useragent <>", value, "useragent");
            return (Criteria) this;
        }

        public Criteria andUseragentGreaterThan(String value) {
            addCriterion("useragent >", value, "useragent");
            return (Criteria) this;
        }

        public Criteria andUseragentGreaterThanOrEqualTo(String value) {
            addCriterion("useragent >=", value, "useragent");
            return (Criteria) this;
        }

        public Criteria andUseragentLessThan(String value) {
            addCriterion("useragent <", value, "useragent");
            return (Criteria) this;
        }

        public Criteria andUseragentLessThanOrEqualTo(String value) {
            addCriterion("useragent <=", value, "useragent");
            return (Criteria) this;
        }

        public Criteria andUseragentLike(String value) {
            addCriterion("useragent like", value, "useragent");
            return (Criteria) this;
        }

        public Criteria andUseragentNotLike(String value) {
            addCriterion("useragent not like", value, "useragent");
            return (Criteria) this;
        }

        public Criteria andUseragentIn(List<String> values) {
            addCriterion("useragent in", values, "useragent");
            return (Criteria) this;
        }

        public Criteria andUseragentNotIn(List<String> values) {
            addCriterion("useragent not in", values, "useragent");
            return (Criteria) this;
        }

        public Criteria andUseragentBetween(String value1, String value2) {
            addCriterion("useragent between", value1, value2, "useragent");
            return (Criteria) this;
        }

        public Criteria andUseragentNotBetween(String value1, String value2) {
            addCriterion("useragent not between", value1, value2, "useragent");
            return (Criteria) this;
        }

        public Criteria andBrowserIsNull() {
            addCriterion("browser is null");
            return (Criteria) this;
        }

        public Criteria andBrowserIsNotNull() {
            addCriterion("browser is not null");
            return (Criteria) this;
        }

        public Criteria andBrowserEqualTo(String value) {
            addCriterion("browser =", value, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserNotEqualTo(String value) {
            addCriterion("browser <>", value, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserGreaterThan(String value) {
            addCriterion("browser >", value, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserGreaterThanOrEqualTo(String value) {
            addCriterion("browser >=", value, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserLessThan(String value) {
            addCriterion("browser <", value, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserLessThanOrEqualTo(String value) {
            addCriterion("browser <=", value, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserLike(String value) {
            addCriterion("browser like", value, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserNotLike(String value) {
            addCriterion("browser not like", value, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserIn(List<String> values) {
            addCriterion("browser in", values, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserNotIn(List<String> values) {
            addCriterion("browser not in", values, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserBetween(String value1, String value2) {
            addCriterion("browser between", value1, value2, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserNotBetween(String value1, String value2) {
            addCriterion("browser not between", value1, value2, "browser");
            return (Criteria) this;
        }

        public Criteria andPlayertypeIsNull() {
            addCriterion("playertype is null");
            return (Criteria) this;
        }

        public Criteria andPlayertypeIsNotNull() {
            addCriterion("playertype is not null");
            return (Criteria) this;
        }

        public Criteria andPlayertypeEqualTo(String value) {
            addCriterion("playertype =", value, "playertype");
            return (Criteria) this;
        }

        public Criteria andPlayertypeNotEqualTo(String value) {
            addCriterion("playertype <>", value, "playertype");
            return (Criteria) this;
        }

        public Criteria andPlayertypeGreaterThan(String value) {
            addCriterion("playertype >", value, "playertype");
            return (Criteria) this;
        }

        public Criteria andPlayertypeGreaterThanOrEqualTo(String value) {
            addCriterion("playertype >=", value, "playertype");
            return (Criteria) this;
        }

        public Criteria andPlayertypeLessThan(String value) {
            addCriterion("playertype <", value, "playertype");
            return (Criteria) this;
        }

        public Criteria andPlayertypeLessThanOrEqualTo(String value) {
            addCriterion("playertype <=", value, "playertype");
            return (Criteria) this;
        }

        public Criteria andPlayertypeLike(String value) {
            addCriterion("playertype like", value, "playertype");
            return (Criteria) this;
        }

        public Criteria andPlayertypeNotLike(String value) {
            addCriterion("playertype not like", value, "playertype");
            return (Criteria) this;
        }

        public Criteria andPlayertypeIn(List<String> values) {
            addCriterion("playertype in", values, "playertype");
            return (Criteria) this;
        }

        public Criteria andPlayertypeNotIn(List<String> values) {
            addCriterion("playertype not in", values, "playertype");
            return (Criteria) this;
        }

        public Criteria andPlayertypeBetween(String value1, String value2) {
            addCriterion("playertype between", value1, value2, "playertype");
            return (Criteria) this;
        }

        public Criteria andPlayertypeNotBetween(String value1, String value2) {
            addCriterion("playertype not between", value1, value2, "playertype");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlIsNull() {
            addCriterion("headimgurl is null");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlIsNotNull() {
            addCriterion("headimgurl is not null");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlEqualTo(String value) {
            addCriterion("headimgurl =", value, "headimgurl");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlNotEqualTo(String value) {
            addCriterion("headimgurl <>", value, "headimgurl");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlGreaterThan(String value) {
            addCriterion("headimgurl >", value, "headimgurl");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlGreaterThanOrEqualTo(String value) {
            addCriterion("headimgurl >=", value, "headimgurl");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlLessThan(String value) {
            addCriterion("headimgurl <", value, "headimgurl");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlLessThanOrEqualTo(String value) {
            addCriterion("headimgurl <=", value, "headimgurl");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlLike(String value) {
            addCriterion("headimgurl like", value, "headimgurl");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlNotLike(String value) {
            addCriterion("headimgurl not like", value, "headimgurl");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlIn(List<String> values) {
            addCriterion("headimgurl in", values, "headimgurl");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlNotIn(List<String> values) {
            addCriterion("headimgurl not in", values, "headimgurl");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlBetween(String value1, String value2) {
            addCriterion("headimgurl between", value1, value2, "headimgurl");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlNotBetween(String value1, String value2) {
            addCriterion("headimgurl not between", value1, value2, "headimgurl");
            return (Criteria) this;
        }

        public Criteria andInvitationcodeIsNull() {
            addCriterion("invitationcode is null");
            return (Criteria) this;
        }

        public Criteria andInvitationcodeIsNotNull() {
            addCriterion("invitationcode is not null");
            return (Criteria) this;
        }

        public Criteria andInvitationcodeEqualTo(String value) {
            addCriterion("invitationcode =", value, "invitationcode");
            return (Criteria) this;
        }

        public Criteria andInvitationcodeNotEqualTo(String value) {
            addCriterion("invitationcode <>", value, "invitationcode");
            return (Criteria) this;
        }

        public Criteria andInvitationcodeGreaterThan(String value) {
            addCriterion("invitationcode >", value, "invitationcode");
            return (Criteria) this;
        }

        public Criteria andInvitationcodeGreaterThanOrEqualTo(String value) {
            addCriterion("invitationcode >=", value, "invitationcode");
            return (Criteria) this;
        }

        public Criteria andInvitationcodeLessThan(String value) {
            addCriterion("invitationcode <", value, "invitationcode");
            return (Criteria) this;
        }

        public Criteria andInvitationcodeLessThanOrEqualTo(String value) {
            addCriterion("invitationcode <=", value, "invitationcode");
            return (Criteria) this;
        }

        public Criteria andInvitationcodeLike(String value) {
            addCriterion("invitationcode like", value, "invitationcode");
            return (Criteria) this;
        }

        public Criteria andInvitationcodeNotLike(String value) {
            addCriterion("invitationcode not like", value, "invitationcode");
            return (Criteria) this;
        }

        public Criteria andInvitationcodeIn(List<String> values) {
            addCriterion("invitationcode in", values, "invitationcode");
            return (Criteria) this;
        }

        public Criteria andInvitationcodeNotIn(List<String> values) {
            addCriterion("invitationcode not in", values, "invitationcode");
            return (Criteria) this;
        }

        public Criteria andInvitationcodeBetween(String value1, String value2) {
            addCriterion("invitationcode between", value1, value2, "invitationcode");
            return (Criteria) this;
        }

        public Criteria andInvitationcodeNotBetween(String value1, String value2) {
            addCriterion("invitationcode not between", value1, value2, "invitationcode");
            return (Criteria) this;
        }

        public Criteria andPinvitationcodeIsNull() {
            addCriterion("pinvitationcode is null");
            return (Criteria) this;
        }

        public Criteria andPinvitationcodeIsNotNull() {
            addCriterion("pinvitationcode is not null");
            return (Criteria) this;
        }

        public Criteria andPinvitationcodeEqualTo(String value) {
            addCriterion("pinvitationcode =", value, "pinvitationcode");
            return (Criteria) this;
        }

        public Criteria andPinvitationcodeNotEqualTo(String value) {
            addCriterion("pinvitationcode <>", value, "pinvitationcode");
            return (Criteria) this;
        }

        public Criteria andPinvitationcodeGreaterThan(String value) {
            addCriterion("pinvitationcode >", value, "pinvitationcode");
            return (Criteria) this;
        }

        public Criteria andPinvitationcodeGreaterThanOrEqualTo(String value) {
            addCriterion("pinvitationcode >=", value, "pinvitationcode");
            return (Criteria) this;
        }

        public Criteria andPinvitationcodeLessThan(String value) {
            addCriterion("pinvitationcode <", value, "pinvitationcode");
            return (Criteria) this;
        }

        public Criteria andPinvitationcodeLessThanOrEqualTo(String value) {
            addCriterion("pinvitationcode <=", value, "pinvitationcode");
            return (Criteria) this;
        }

        public Criteria andPinvitationcodeLike(String value) {
            addCriterion("pinvitationcode like", value, "pinvitationcode");
            return (Criteria) this;
        }

        public Criteria andPinvitationcodeNotLike(String value) {
            addCriterion("pinvitationcode not like", value, "pinvitationcode");
            return (Criteria) this;
        }

        public Criteria andPinvitationcodeIn(List<String> values) {
            addCriterion("pinvitationcode in", values, "pinvitationcode");
            return (Criteria) this;
        }

        public Criteria andPinvitationcodeNotIn(List<String> values) {
            addCriterion("pinvitationcode not in", values, "pinvitationcode");
            return (Criteria) this;
        }

        public Criteria andPinvitationcodeBetween(String value1, String value2) {
            addCriterion("pinvitationcode between", value1, value2, "pinvitationcode");
            return (Criteria) this;
        }

        public Criteria andPinvitationcodeNotBetween(String value1, String value2) {
            addCriterion("pinvitationcode not between", value1, value2, "pinvitationcode");
            return (Criteria) this;
        }

        public Criteria andTrtProfitIsNull() {
            addCriterion("TRT_PROFIT is null");
            return (Criteria) this;
        }

        public Criteria andTrtProfitIsNotNull() {
            addCriterion("TRT_PROFIT is not null");
            return (Criteria) this;
        }

        public Criteria andTrtProfitEqualTo(BigDecimal value) {
            addCriterion("TRT_PROFIT =", value, "trtProfit");
            return (Criteria) this;
        }

        public Criteria andTrtProfitNotEqualTo(BigDecimal value) {
            addCriterion("TRT_PROFIT <>", value, "trtProfit");
            return (Criteria) this;
        }

        public Criteria andTrtProfitGreaterThan(BigDecimal value) {
            addCriterion("TRT_PROFIT >", value, "trtProfit");
            return (Criteria) this;
        }

        public Criteria andTrtProfitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TRT_PROFIT >=", value, "trtProfit");
            return (Criteria) this;
        }

        public Criteria andTrtProfitLessThan(BigDecimal value) {
            addCriterion("TRT_PROFIT <", value, "trtProfit");
            return (Criteria) this;
        }

        public Criteria andTrtProfitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TRT_PROFIT <=", value, "trtProfit");
            return (Criteria) this;
        }

        public Criteria andTrtProfitIn(List<BigDecimal> values) {
            addCriterion("TRT_PROFIT in", values, "trtProfit");
            return (Criteria) this;
        }

        public Criteria andTrtProfitNotIn(List<BigDecimal> values) {
            addCriterion("TRT_PROFIT not in", values, "trtProfit");
            return (Criteria) this;
        }

        public Criteria andTrtProfitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TRT_PROFIT between", value1, value2, "trtProfit");
            return (Criteria) this;
        }

        public Criteria andTrtProfitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TRT_PROFIT not between", value1, value2, "trtProfit");
            return (Criteria) this;
        }

        public Criteria andPpAmountIsNull() {
            addCriterion("PP_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andPpAmountIsNotNull() {
            addCriterion("PP_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andPpAmountEqualTo(BigDecimal value) {
            addCriterion("PP_AMOUNT =", value, "ppAmount");
            return (Criteria) this;
        }

        public Criteria andPpAmountNotEqualTo(BigDecimal value) {
            addCriterion("PP_AMOUNT <>", value, "ppAmount");
            return (Criteria) this;
        }

        public Criteria andPpAmountGreaterThan(BigDecimal value) {
            addCriterion("PP_AMOUNT >", value, "ppAmount");
            return (Criteria) this;
        }

        public Criteria andPpAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PP_AMOUNT >=", value, "ppAmount");
            return (Criteria) this;
        }

        public Criteria andPpAmountLessThan(BigDecimal value) {
            addCriterion("PP_AMOUNT <", value, "ppAmount");
            return (Criteria) this;
        }

        public Criteria andPpAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PP_AMOUNT <=", value, "ppAmount");
            return (Criteria) this;
        }

        public Criteria andPpAmountIn(List<BigDecimal> values) {
            addCriterion("PP_AMOUNT in", values, "ppAmount");
            return (Criteria) this;
        }

        public Criteria andPpAmountNotIn(List<BigDecimal> values) {
            addCriterion("PP_AMOUNT not in", values, "ppAmount");
            return (Criteria) this;
        }

        public Criteria andPpAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PP_AMOUNT between", value1, value2, "ppAmount");
            return (Criteria) this;
        }

        public Criteria andPpAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PP_AMOUNT not between", value1, value2, "ppAmount");
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