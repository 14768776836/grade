package com.grade.project.grade.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andTelnoIsNull() {
            addCriterion("TELNO is null");
            return (Criteria) this;
        }

        public Criteria andTelnoIsNotNull() {
            addCriterion("TELNO is not null");
            return (Criteria) this;
        }

        public Criteria andTelnoEqualTo(Integer value) {
            addCriterion("TELNO =", value, "telno");
            return (Criteria) this;
        }

        public Criteria andTelnoNotEqualTo(Integer value) {
            addCriterion("TELNO <>", value, "telno");
            return (Criteria) this;
        }

        public Criteria andTelnoGreaterThan(Integer value) {
            addCriterion("TELNO >", value, "telno");
            return (Criteria) this;
        }

        public Criteria andTelnoGreaterThanOrEqualTo(Integer value) {
            addCriterion("TELNO >=", value, "telno");
            return (Criteria) this;
        }

        public Criteria andTelnoLessThan(Integer value) {
            addCriterion("TELNO <", value, "telno");
            return (Criteria) this;
        }

        public Criteria andTelnoLessThanOrEqualTo(Integer value) {
            addCriterion("TELNO <=", value, "telno");
            return (Criteria) this;
        }

        public Criteria andTelnoIn(List<Integer> values) {
            addCriterion("TELNO in", values, "telno");
            return (Criteria) this;
        }

        public Criteria andTelnoNotIn(List<Integer> values) {
            addCriterion("TELNO not in", values, "telno");
            return (Criteria) this;
        }

        public Criteria andTelnoBetween(Integer value1, Integer value2) {
            addCriterion("TELNO between", value1, value2, "telno");
            return (Criteria) this;
        }

        public Criteria andTelnoNotBetween(Integer value1, Integer value2) {
            addCriterion("TELNO not between", value1, value2, "telno");
            return (Criteria) this;
        }

        public Criteria andExtensionCodeIsNull() {
            addCriterion("EXTENSION_CODE is null");
            return (Criteria) this;
        }

        public Criteria andExtensionCodeIsNotNull() {
            addCriterion("EXTENSION_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andExtensionCodeEqualTo(String value) {
            addCriterion("EXTENSION_CODE =", value, "extensionCode");
            return (Criteria) this;
        }

        public Criteria andExtensionCodeNotEqualTo(String value) {
            addCriterion("EXTENSION_CODE <>", value, "extensionCode");
            return (Criteria) this;
        }

        public Criteria andExtensionCodeGreaterThan(String value) {
            addCriterion("EXTENSION_CODE >", value, "extensionCode");
            return (Criteria) this;
        }

        public Criteria andExtensionCodeGreaterThanOrEqualTo(String value) {
            addCriterion("EXTENSION_CODE >=", value, "extensionCode");
            return (Criteria) this;
        }

        public Criteria andExtensionCodeLessThan(String value) {
            addCriterion("EXTENSION_CODE <", value, "extensionCode");
            return (Criteria) this;
        }

        public Criteria andExtensionCodeLessThanOrEqualTo(String value) {
            addCriterion("EXTENSION_CODE <=", value, "extensionCode");
            return (Criteria) this;
        }

        public Criteria andExtensionCodeLike(String value) {
            addCriterion("EXTENSION_CODE like", value, "extensionCode");
            return (Criteria) this;
        }

        public Criteria andExtensionCodeNotLike(String value) {
            addCriterion("EXTENSION_CODE not like", value, "extensionCode");
            return (Criteria) this;
        }

        public Criteria andExtensionCodeIn(List<String> values) {
            addCriterion("EXTENSION_CODE in", values, "extensionCode");
            return (Criteria) this;
        }

        public Criteria andExtensionCodeNotIn(List<String> values) {
            addCriterion("EXTENSION_CODE not in", values, "extensionCode");
            return (Criteria) this;
        }

        public Criteria andExtensionCodeBetween(String value1, String value2) {
            addCriterion("EXTENSION_CODE between", value1, value2, "extensionCode");
            return (Criteria) this;
        }

        public Criteria andExtensionCodeNotBetween(String value1, String value2) {
            addCriterion("EXTENSION_CODE not between", value1, value2, "extensionCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeIsNull() {
            addCriterion("PARENT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andParentCodeIsNotNull() {
            addCriterion("PARENT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andParentCodeEqualTo(String value) {
            addCriterion("PARENT_CODE =", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeNotEqualTo(String value) {
            addCriterion("PARENT_CODE <>", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeGreaterThan(String value) {
            addCriterion("PARENT_CODE >", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PARENT_CODE >=", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeLessThan(String value) {
            addCriterion("PARENT_CODE <", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeLessThanOrEqualTo(String value) {
            addCriterion("PARENT_CODE <=", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeLike(String value) {
            addCriterion("PARENT_CODE like", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeNotLike(String value) {
            addCriterion("PARENT_CODE not like", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeIn(List<String> values) {
            addCriterion("PARENT_CODE in", values, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeNotIn(List<String> values) {
            addCriterion("PARENT_CODE not in", values, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeBetween(String value1, String value2) {
            addCriterion("PARENT_CODE between", value1, value2, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeNotBetween(String value1, String value2) {
            addCriterion("PARENT_CODE not between", value1, value2, "parentCode");
            return (Criteria) this;
        }

        public Criteria andFactionIsNull() {
            addCriterion("FACTION is null");
            return (Criteria) this;
        }

        public Criteria andFactionIsNotNull() {
            addCriterion("FACTION is not null");
            return (Criteria) this;
        }

        public Criteria andFactionEqualTo(String value) {
            addCriterion("FACTION =", value, "faction");
            return (Criteria) this;
        }

        public Criteria andFactionNotEqualTo(String value) {
            addCriterion("FACTION <>", value, "faction");
            return (Criteria) this;
        }

        public Criteria andFactionGreaterThan(String value) {
            addCriterion("FACTION >", value, "faction");
            return (Criteria) this;
        }

        public Criteria andFactionGreaterThanOrEqualTo(String value) {
            addCriterion("FACTION >=", value, "faction");
            return (Criteria) this;
        }

        public Criteria andFactionLessThan(String value) {
            addCriterion("FACTION <", value, "faction");
            return (Criteria) this;
        }

        public Criteria andFactionLessThanOrEqualTo(String value) {
            addCriterion("FACTION <=", value, "faction");
            return (Criteria) this;
        }

        public Criteria andFactionLike(String value) {
            addCriterion("FACTION like", value, "faction");
            return (Criteria) this;
        }

        public Criteria andFactionNotLike(String value) {
            addCriterion("FACTION not like", value, "faction");
            return (Criteria) this;
        }

        public Criteria andFactionIn(List<String> values) {
            addCriterion("FACTION in", values, "faction");
            return (Criteria) this;
        }

        public Criteria andFactionNotIn(List<String> values) {
            addCriterion("FACTION not in", values, "faction");
            return (Criteria) this;
        }

        public Criteria andFactionBetween(String value1, String value2) {
            addCriterion("FACTION between", value1, value2, "faction");
            return (Criteria) this;
        }

        public Criteria andFactionNotBetween(String value1, String value2) {
            addCriterion("FACTION not between", value1, value2, "faction");
            return (Criteria) this;
        }

        public Criteria andTruenameIsNull() {
            addCriterion("TRUENAME is null");
            return (Criteria) this;
        }

        public Criteria andTruenameIsNotNull() {
            addCriterion("TRUENAME is not null");
            return (Criteria) this;
        }

        public Criteria andTruenameEqualTo(String value) {
            addCriterion("TRUENAME =", value, "truename");
            return (Criteria) this;
        }

        public Criteria andTruenameNotEqualTo(String value) {
            addCriterion("TRUENAME <>", value, "truename");
            return (Criteria) this;
        }

        public Criteria andTruenameGreaterThan(String value) {
            addCriterion("TRUENAME >", value, "truename");
            return (Criteria) this;
        }

        public Criteria andTruenameGreaterThanOrEqualTo(String value) {
            addCriterion("TRUENAME >=", value, "truename");
            return (Criteria) this;
        }

        public Criteria andTruenameLessThan(String value) {
            addCriterion("TRUENAME <", value, "truename");
            return (Criteria) this;
        }

        public Criteria andTruenameLessThanOrEqualTo(String value) {
            addCriterion("TRUENAME <=", value, "truename");
            return (Criteria) this;
        }

        public Criteria andTruenameLike(String value) {
            addCriterion("TRUENAME like", value, "truename");
            return (Criteria) this;
        }

        public Criteria andTruenameNotLike(String value) {
            addCriterion("TRUENAME not like", value, "truename");
            return (Criteria) this;
        }

        public Criteria andTruenameIn(List<String> values) {
            addCriterion("TRUENAME in", values, "truename");
            return (Criteria) this;
        }

        public Criteria andTruenameNotIn(List<String> values) {
            addCriterion("TRUENAME not in", values, "truename");
            return (Criteria) this;
        }

        public Criteria andTruenameBetween(String value1, String value2) {
            addCriterion("TRUENAME between", value1, value2, "truename");
            return (Criteria) this;
        }

        public Criteria andTruenameNotBetween(String value1, String value2) {
            addCriterion("TRUENAME not between", value1, value2, "truename");
            return (Criteria) this;
        }

        public Criteria andLoginPswdIsNull() {
            addCriterion("LOGIN_PSWD is null");
            return (Criteria) this;
        }

        public Criteria andLoginPswdIsNotNull() {
            addCriterion("LOGIN_PSWD is not null");
            return (Criteria) this;
        }

        public Criteria andLoginPswdEqualTo(String value) {
            addCriterion("LOGIN_PSWD =", value, "loginPswd");
            return (Criteria) this;
        }

        public Criteria andLoginPswdNotEqualTo(String value) {
            addCriterion("LOGIN_PSWD <>", value, "loginPswd");
            return (Criteria) this;
        }

        public Criteria andLoginPswdGreaterThan(String value) {
            addCriterion("LOGIN_PSWD >", value, "loginPswd");
            return (Criteria) this;
        }

        public Criteria andLoginPswdGreaterThanOrEqualTo(String value) {
            addCriterion("LOGIN_PSWD >=", value, "loginPswd");
            return (Criteria) this;
        }

        public Criteria andLoginPswdLessThan(String value) {
            addCriterion("LOGIN_PSWD <", value, "loginPswd");
            return (Criteria) this;
        }

        public Criteria andLoginPswdLessThanOrEqualTo(String value) {
            addCriterion("LOGIN_PSWD <=", value, "loginPswd");
            return (Criteria) this;
        }

        public Criteria andLoginPswdLike(String value) {
            addCriterion("LOGIN_PSWD like", value, "loginPswd");
            return (Criteria) this;
        }

        public Criteria andLoginPswdNotLike(String value) {
            addCriterion("LOGIN_PSWD not like", value, "loginPswd");
            return (Criteria) this;
        }

        public Criteria andLoginPswdIn(List<String> values) {
            addCriterion("LOGIN_PSWD in", values, "loginPswd");
            return (Criteria) this;
        }

        public Criteria andLoginPswdNotIn(List<String> values) {
            addCriterion("LOGIN_PSWD not in", values, "loginPswd");
            return (Criteria) this;
        }

        public Criteria andLoginPswdBetween(String value1, String value2) {
            addCriterion("LOGIN_PSWD between", value1, value2, "loginPswd");
            return (Criteria) this;
        }

        public Criteria andLoginPswdNotBetween(String value1, String value2) {
            addCriterion("LOGIN_PSWD not between", value1, value2, "loginPswd");
            return (Criteria) this;
        }

        public Criteria andPayPswdIsNull() {
            addCriterion("PAY_PSWD is null");
            return (Criteria) this;
        }

        public Criteria andPayPswdIsNotNull() {
            addCriterion("PAY_PSWD is not null");
            return (Criteria) this;
        }

        public Criteria andPayPswdEqualTo(String value) {
            addCriterion("PAY_PSWD =", value, "payPswd");
            return (Criteria) this;
        }

        public Criteria andPayPswdNotEqualTo(String value) {
            addCriterion("PAY_PSWD <>", value, "payPswd");
            return (Criteria) this;
        }

        public Criteria andPayPswdGreaterThan(String value) {
            addCriterion("PAY_PSWD >", value, "payPswd");
            return (Criteria) this;
        }

        public Criteria andPayPswdGreaterThanOrEqualTo(String value) {
            addCriterion("PAY_PSWD >=", value, "payPswd");
            return (Criteria) this;
        }

        public Criteria andPayPswdLessThan(String value) {
            addCriterion("PAY_PSWD <", value, "payPswd");
            return (Criteria) this;
        }

        public Criteria andPayPswdLessThanOrEqualTo(String value) {
            addCriterion("PAY_PSWD <=", value, "payPswd");
            return (Criteria) this;
        }

        public Criteria andPayPswdLike(String value) {
            addCriterion("PAY_PSWD like", value, "payPswd");
            return (Criteria) this;
        }

        public Criteria andPayPswdNotLike(String value) {
            addCriterion("PAY_PSWD not like", value, "payPswd");
            return (Criteria) this;
        }

        public Criteria andPayPswdIn(List<String> values) {
            addCriterion("PAY_PSWD in", values, "payPswd");
            return (Criteria) this;
        }

        public Criteria andPayPswdNotIn(List<String> values) {
            addCriterion("PAY_PSWD not in", values, "payPswd");
            return (Criteria) this;
        }

        public Criteria andPayPswdBetween(String value1, String value2) {
            addCriterion("PAY_PSWD between", value1, value2, "payPswd");
            return (Criteria) this;
        }

        public Criteria andPayPswdNotBetween(String value1, String value2) {
            addCriterion("PAY_PSWD not between", value1, value2, "payPswd");
            return (Criteria) this;
        }

        public Criteria andNoPriceIsNull() {
            addCriterion("NO_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andNoPriceIsNotNull() {
            addCriterion("NO_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andNoPriceEqualTo(BigDecimal value) {
            addCriterion("NO_PRICE =", value, "noPrice");
            return (Criteria) this;
        }

        public Criteria andNoPriceNotEqualTo(BigDecimal value) {
            addCriterion("NO_PRICE <>", value, "noPrice");
            return (Criteria) this;
        }

        public Criteria andNoPriceGreaterThan(BigDecimal value) {
            addCriterion("NO_PRICE >", value, "noPrice");
            return (Criteria) this;
        }

        public Criteria andNoPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("NO_PRICE >=", value, "noPrice");
            return (Criteria) this;
        }

        public Criteria andNoPriceLessThan(BigDecimal value) {
            addCriterion("NO_PRICE <", value, "noPrice");
            return (Criteria) this;
        }

        public Criteria andNoPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("NO_PRICE <=", value, "noPrice");
            return (Criteria) this;
        }

        public Criteria andNoPriceIn(List<BigDecimal> values) {
            addCriterion("NO_PRICE in", values, "noPrice");
            return (Criteria) this;
        }

        public Criteria andNoPriceNotIn(List<BigDecimal> values) {
            addCriterion("NO_PRICE not in", values, "noPrice");
            return (Criteria) this;
        }

        public Criteria andNoPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NO_PRICE between", value1, value2, "noPrice");
            return (Criteria) this;
        }

        public Criteria andNoPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NO_PRICE not between", value1, value2, "noPrice");
            return (Criteria) this;
        }

        public Criteria andIsPriceIsNull() {
            addCriterion("IS_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andIsPriceIsNotNull() {
            addCriterion("IS_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andIsPriceEqualTo(BigDecimal value) {
            addCriterion("IS_PRICE =", value, "isPrice");
            return (Criteria) this;
        }

        public Criteria andIsPriceNotEqualTo(BigDecimal value) {
            addCriterion("IS_PRICE <>", value, "isPrice");
            return (Criteria) this;
        }

        public Criteria andIsPriceGreaterThan(BigDecimal value) {
            addCriterion("IS_PRICE >", value, "isPrice");
            return (Criteria) this;
        }

        public Criteria andIsPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("IS_PRICE >=", value, "isPrice");
            return (Criteria) this;
        }

        public Criteria andIsPriceLessThan(BigDecimal value) {
            addCriterion("IS_PRICE <", value, "isPrice");
            return (Criteria) this;
        }

        public Criteria andIsPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("IS_PRICE <=", value, "isPrice");
            return (Criteria) this;
        }

        public Criteria andIsPriceIn(List<BigDecimal> values) {
            addCriterion("IS_PRICE in", values, "isPrice");
            return (Criteria) this;
        }

        public Criteria andIsPriceNotIn(List<BigDecimal> values) {
            addCriterion("IS_PRICE not in", values, "isPrice");
            return (Criteria) this;
        }

        public Criteria andIsPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("IS_PRICE between", value1, value2, "isPrice");
            return (Criteria) this;
        }

        public Criteria andIsPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("IS_PRICE not between", value1, value2, "isPrice");
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

        public Criteria andUserTypeIsNull() {
            addCriterion("USER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNotNull() {
            addCriterion("USER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeEqualTo(Integer value) {
            addCriterion("USER_TYPE =", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotEqualTo(Integer value) {
            addCriterion("USER_TYPE <>", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThan(Integer value) {
            addCriterion("USER_TYPE >", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("USER_TYPE >=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThan(Integer value) {
            addCriterion("USER_TYPE <", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThanOrEqualTo(Integer value) {
            addCriterion("USER_TYPE <=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeIn(List<Integer> values) {
            addCriterion("USER_TYPE in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotIn(List<Integer> values) {
            addCriterion("USER_TYPE not in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeBetween(Integer value1, Integer value2) {
            addCriterion("USER_TYPE between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("USER_TYPE not between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andTokenIsNull() {
            addCriterion("TOKEN is null");
            return (Criteria) this;
        }

        public Criteria andTokenIsNotNull() {
            addCriterion("TOKEN is not null");
            return (Criteria) this;
        }

        public Criteria andTokenEqualTo(String value) {
            addCriterion("TOKEN =", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotEqualTo(String value) {
            addCriterion("TOKEN <>", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenGreaterThan(String value) {
            addCriterion("TOKEN >", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenGreaterThanOrEqualTo(String value) {
            addCriterion("TOKEN >=", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLessThan(String value) {
            addCriterion("TOKEN <", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLessThanOrEqualTo(String value) {
            addCriterion("TOKEN <=", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLike(String value) {
            addCriterion("TOKEN like", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotLike(String value) {
            addCriterion("TOKEN not like", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenIn(List<String> values) {
            addCriterion("TOKEN in", values, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotIn(List<String> values) {
            addCriterion("TOKEN not in", values, "token");
            return (Criteria) this;
        }

        public Criteria andTokenBetween(String value1, String value2) {
            addCriterion("TOKEN between", value1, value2, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotBetween(String value1, String value2) {
            addCriterion("TOKEN not between", value1, value2, "token");
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