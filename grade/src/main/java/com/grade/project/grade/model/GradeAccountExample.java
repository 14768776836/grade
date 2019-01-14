package com.grade.project.grade.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GradeAccountExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GradeAccountExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andGzNameIsNull() {
            addCriterion("GZ_NAME is null");
            return (Criteria) this;
        }

        public Criteria andGzNameIsNotNull() {
            addCriterion("GZ_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andGzNameEqualTo(String value) {
            addCriterion("GZ_NAME =", value, "gzName");
            return (Criteria) this;
        }

        public Criteria andGzNameNotEqualTo(String value) {
            addCriterion("GZ_NAME <>", value, "gzName");
            return (Criteria) this;
        }

        public Criteria andGzNameGreaterThan(String value) {
            addCriterion("GZ_NAME >", value, "gzName");
            return (Criteria) this;
        }

        public Criteria andGzNameGreaterThanOrEqualTo(String value) {
            addCriterion("GZ_NAME >=", value, "gzName");
            return (Criteria) this;
        }

        public Criteria andGzNameLessThan(String value) {
            addCriterion("GZ_NAME <", value, "gzName");
            return (Criteria) this;
        }

        public Criteria andGzNameLessThanOrEqualTo(String value) {
            addCriterion("GZ_NAME <=", value, "gzName");
            return (Criteria) this;
        }

        public Criteria andGzNameLike(String value) {
            addCriterion("GZ_NAME like", value, "gzName");
            return (Criteria) this;
        }

        public Criteria andGzNameNotLike(String value) {
            addCriterion("GZ_NAME not like", value, "gzName");
            return (Criteria) this;
        }

        public Criteria andGzNameIn(List<String> values) {
            addCriterion("GZ_NAME in", values, "gzName");
            return (Criteria) this;
        }

        public Criteria andGzNameNotIn(List<String> values) {
            addCriterion("GZ_NAME not in", values, "gzName");
            return (Criteria) this;
        }

        public Criteria andGzNameBetween(String value1, String value2) {
            addCriterion("GZ_NAME between", value1, value2, "gzName");
            return (Criteria) this;
        }

        public Criteria andGzNameNotBetween(String value1, String value2) {
            addCriterion("GZ_NAME not between", value1, value2, "gzName");
            return (Criteria) this;
        }

        public Criteria andAppidIsNull() {
            addCriterion("APPID is null");
            return (Criteria) this;
        }

        public Criteria andAppidIsNotNull() {
            addCriterion("APPID is not null");
            return (Criteria) this;
        }

        public Criteria andAppidEqualTo(String value) {
            addCriterion("APPID =", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotEqualTo(String value) {
            addCriterion("APPID <>", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThan(String value) {
            addCriterion("APPID >", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThanOrEqualTo(String value) {
            addCriterion("APPID >=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThan(String value) {
            addCriterion("APPID <", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThanOrEqualTo(String value) {
            addCriterion("APPID <=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLike(String value) {
            addCriterion("APPID like", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotLike(String value) {
            addCriterion("APPID not like", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidIn(List<String> values) {
            addCriterion("APPID in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotIn(List<String> values) {
            addCriterion("APPID not in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidBetween(String value1, String value2) {
            addCriterion("APPID between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotBetween(String value1, String value2) {
            addCriterion("APPID not between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andAppSecrectIsNull() {
            addCriterion("APP_SECRECT is null");
            return (Criteria) this;
        }

        public Criteria andAppSecrectIsNotNull() {
            addCriterion("APP_SECRECT is not null");
            return (Criteria) this;
        }

        public Criteria andAppSecrectEqualTo(String value) {
            addCriterion("APP_SECRECT =", value, "appSecrect");
            return (Criteria) this;
        }

        public Criteria andAppSecrectNotEqualTo(String value) {
            addCriterion("APP_SECRECT <>", value, "appSecrect");
            return (Criteria) this;
        }

        public Criteria andAppSecrectGreaterThan(String value) {
            addCriterion("APP_SECRECT >", value, "appSecrect");
            return (Criteria) this;
        }

        public Criteria andAppSecrectGreaterThanOrEqualTo(String value) {
            addCriterion("APP_SECRECT >=", value, "appSecrect");
            return (Criteria) this;
        }

        public Criteria andAppSecrectLessThan(String value) {
            addCriterion("APP_SECRECT <", value, "appSecrect");
            return (Criteria) this;
        }

        public Criteria andAppSecrectLessThanOrEqualTo(String value) {
            addCriterion("APP_SECRECT <=", value, "appSecrect");
            return (Criteria) this;
        }

        public Criteria andAppSecrectLike(String value) {
            addCriterion("APP_SECRECT like", value, "appSecrect");
            return (Criteria) this;
        }

        public Criteria andAppSecrectNotLike(String value) {
            addCriterion("APP_SECRECT not like", value, "appSecrect");
            return (Criteria) this;
        }

        public Criteria andAppSecrectIn(List<String> values) {
            addCriterion("APP_SECRECT in", values, "appSecrect");
            return (Criteria) this;
        }

        public Criteria andAppSecrectNotIn(List<String> values) {
            addCriterion("APP_SECRECT not in", values, "appSecrect");
            return (Criteria) this;
        }

        public Criteria andAppSecrectBetween(String value1, String value2) {
            addCriterion("APP_SECRECT between", value1, value2, "appSecrect");
            return (Criteria) this;
        }

        public Criteria andAppSecrectNotBetween(String value1, String value2) {
            addCriterion("APP_SECRECT not between", value1, value2, "appSecrect");
            return (Criteria) this;
        }

        public Criteria andApiKeyIsNull() {
            addCriterion("API_KEY is null");
            return (Criteria) this;
        }

        public Criteria andApiKeyIsNotNull() {
            addCriterion("API_KEY is not null");
            return (Criteria) this;
        }

        public Criteria andApiKeyEqualTo(String value) {
            addCriterion("API_KEY =", value, "apiKey");
            return (Criteria) this;
        }

        public Criteria andApiKeyNotEqualTo(String value) {
            addCriterion("API_KEY <>", value, "apiKey");
            return (Criteria) this;
        }

        public Criteria andApiKeyGreaterThan(String value) {
            addCriterion("API_KEY >", value, "apiKey");
            return (Criteria) this;
        }

        public Criteria andApiKeyGreaterThanOrEqualTo(String value) {
            addCriterion("API_KEY >=", value, "apiKey");
            return (Criteria) this;
        }

        public Criteria andApiKeyLessThan(String value) {
            addCriterion("API_KEY <", value, "apiKey");
            return (Criteria) this;
        }

        public Criteria andApiKeyLessThanOrEqualTo(String value) {
            addCriterion("API_KEY <=", value, "apiKey");
            return (Criteria) this;
        }

        public Criteria andApiKeyLike(String value) {
            addCriterion("API_KEY like", value, "apiKey");
            return (Criteria) this;
        }

        public Criteria andApiKeyNotLike(String value) {
            addCriterion("API_KEY not like", value, "apiKey");
            return (Criteria) this;
        }

        public Criteria andApiKeyIn(List<String> values) {
            addCriterion("API_KEY in", values, "apiKey");
            return (Criteria) this;
        }

        public Criteria andApiKeyNotIn(List<String> values) {
            addCriterion("API_KEY not in", values, "apiKey");
            return (Criteria) this;
        }

        public Criteria andApiKeyBetween(String value1, String value2) {
            addCriterion("API_KEY between", value1, value2, "apiKey");
            return (Criteria) this;
        }

        public Criteria andApiKeyNotBetween(String value1, String value2) {
            addCriterion("API_KEY not between", value1, value2, "apiKey");
            return (Criteria) this;
        }

        public Criteria andMchIdIsNull() {
            addCriterion("MCH_ID is null");
            return (Criteria) this;
        }

        public Criteria andMchIdIsNotNull() {
            addCriterion("MCH_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMchIdEqualTo(String value) {
            addCriterion("MCH_ID =", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotEqualTo(String value) {
            addCriterion("MCH_ID <>", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdGreaterThan(String value) {
            addCriterion("MCH_ID >", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdGreaterThanOrEqualTo(String value) {
            addCriterion("MCH_ID >=", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdLessThan(String value) {
            addCriterion("MCH_ID <", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdLessThanOrEqualTo(String value) {
            addCriterion("MCH_ID <=", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdLike(String value) {
            addCriterion("MCH_ID like", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotLike(String value) {
            addCriterion("MCH_ID not like", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdIn(List<String> values) {
            addCriterion("MCH_ID in", values, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotIn(List<String> values) {
            addCriterion("MCH_ID not in", values, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdBetween(String value1, String value2) {
            addCriterion("MCH_ID between", value1, value2, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotBetween(String value1, String value2) {
            addCriterion("MCH_ID not between", value1, value2, "mchId");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("STATUS not between", value1, value2, "status");
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

        public Criteria andGmtModifiedIsNull() {
            addCriterion("GMT_MODIFIED is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNotNull() {
            addCriterion("GMT_MODIFIED is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedEqualTo(Date value) {
            addCriterion("GMT_MODIFIED =", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotEqualTo(Date value) {
            addCriterion("GMT_MODIFIED <>", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThan(Date value) {
            addCriterion("GMT_MODIFIED >", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("GMT_MODIFIED >=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThan(Date value) {
            addCriterion("GMT_MODIFIED <", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThanOrEqualTo(Date value) {
            addCriterion("GMT_MODIFIED <=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIn(List<Date> values) {
            addCriterion("GMT_MODIFIED in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotIn(List<Date> values) {
            addCriterion("GMT_MODIFIED not in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedBetween(Date value1, Date value2) {
            addCriterion("GMT_MODIFIED between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotBetween(Date value1, Date value2) {
            addCriterion("GMT_MODIFIED not between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andFilePathIsNull() {
            addCriterion("FILE_PATH is null");
            return (Criteria) this;
        }

        public Criteria andFilePathIsNotNull() {
            addCriterion("FILE_PATH is not null");
            return (Criteria) this;
        }

        public Criteria andFilePathEqualTo(String value) {
            addCriterion("FILE_PATH =", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotEqualTo(String value) {
            addCriterion("FILE_PATH <>", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathGreaterThan(String value) {
            addCriterion("FILE_PATH >", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathGreaterThanOrEqualTo(String value) {
            addCriterion("FILE_PATH >=", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLessThan(String value) {
            addCriterion("FILE_PATH <", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLessThanOrEqualTo(String value) {
            addCriterion("FILE_PATH <=", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLike(String value) {
            addCriterion("FILE_PATH like", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotLike(String value) {
            addCriterion("FILE_PATH not like", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathIn(List<String> values) {
            addCriterion("FILE_PATH in", values, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotIn(List<String> values) {
            addCriterion("FILE_PATH not in", values, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathBetween(String value1, String value2) {
            addCriterion("FILE_PATH between", value1, value2, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotBetween(String value1, String value2) {
            addCriterion("FILE_PATH not between", value1, value2, "filePath");
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