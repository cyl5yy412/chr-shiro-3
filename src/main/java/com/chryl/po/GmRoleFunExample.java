package com.chryl.po;

import java.util.ArrayList;
import java.util.List;

public class GmRoleFunExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GmRoleFunExample() {
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

        public Criteria andRoleFunGRoleIdIsNull() {
            addCriterion("role_fun_g_role_id is null");
            return (Criteria) this;
        }

        public Criteria andRoleFunGRoleIdIsNotNull() {
            addCriterion("role_fun_g_role_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoleFunGRoleIdEqualTo(String value) {
            addCriterion("role_fun_g_role_id =", value, "roleFunGRoleId");
            return (Criteria) this;
        }

        public Criteria andRoleFunGRoleIdNotEqualTo(String value) {
            addCriterion("role_fun_g_role_id <>", value, "roleFunGRoleId");
            return (Criteria) this;
        }

        public Criteria andRoleFunGRoleIdGreaterThan(String value) {
            addCriterion("role_fun_g_role_id >", value, "roleFunGRoleId");
            return (Criteria) this;
        }

        public Criteria andRoleFunGRoleIdGreaterThanOrEqualTo(String value) {
            addCriterion("role_fun_g_role_id >=", value, "roleFunGRoleId");
            return (Criteria) this;
        }

        public Criteria andRoleFunGRoleIdLessThan(String value) {
            addCriterion("role_fun_g_role_id <", value, "roleFunGRoleId");
            return (Criteria) this;
        }

        public Criteria andRoleFunGRoleIdLessThanOrEqualTo(String value) {
            addCriterion("role_fun_g_role_id <=", value, "roleFunGRoleId");
            return (Criteria) this;
        }

        public Criteria andRoleFunGRoleIdLike(String value) {
            addCriterion("role_fun_g_role_id like", value, "roleFunGRoleId");
            return (Criteria) this;
        }

        public Criteria andRoleFunGRoleIdNotLike(String value) {
            addCriterion("role_fun_g_role_id not like", value, "roleFunGRoleId");
            return (Criteria) this;
        }

        public Criteria andRoleFunGRoleIdIn(List<String> values) {
            addCriterion("role_fun_g_role_id in", values, "roleFunGRoleId");
            return (Criteria) this;
        }

        public Criteria andRoleFunGRoleIdNotIn(List<String> values) {
            addCriterion("role_fun_g_role_id not in", values, "roleFunGRoleId");
            return (Criteria) this;
        }

        public Criteria andRoleFunGRoleIdBetween(String value1, String value2) {
            addCriterion("role_fun_g_role_id between", value1, value2, "roleFunGRoleId");
            return (Criteria) this;
        }

        public Criteria andRoleFunGRoleIdNotBetween(String value1, String value2) {
            addCriterion("role_fun_g_role_id not between", value1, value2, "roleFunGRoleId");
            return (Criteria) this;
        }

        public Criteria andRoleFunGFunIdIsNull() {
            addCriterion("role_fun_g_fun_id is null");
            return (Criteria) this;
        }

        public Criteria andRoleFunGFunIdIsNotNull() {
            addCriterion("role_fun_g_fun_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoleFunGFunIdEqualTo(String value) {
            addCriterion("role_fun_g_fun_id =", value, "roleFunGFunId");
            return (Criteria) this;
        }

        public Criteria andRoleFunGFunIdNotEqualTo(String value) {
            addCriterion("role_fun_g_fun_id <>", value, "roleFunGFunId");
            return (Criteria) this;
        }

        public Criteria andRoleFunGFunIdGreaterThan(String value) {
            addCriterion("role_fun_g_fun_id >", value, "roleFunGFunId");
            return (Criteria) this;
        }

        public Criteria andRoleFunGFunIdGreaterThanOrEqualTo(String value) {
            addCriterion("role_fun_g_fun_id >=", value, "roleFunGFunId");
            return (Criteria) this;
        }

        public Criteria andRoleFunGFunIdLessThan(String value) {
            addCriterion("role_fun_g_fun_id <", value, "roleFunGFunId");
            return (Criteria) this;
        }

        public Criteria andRoleFunGFunIdLessThanOrEqualTo(String value) {
            addCriterion("role_fun_g_fun_id <=", value, "roleFunGFunId");
            return (Criteria) this;
        }

        public Criteria andRoleFunGFunIdLike(String value) {
            addCriterion("role_fun_g_fun_id like", value, "roleFunGFunId");
            return (Criteria) this;
        }

        public Criteria andRoleFunGFunIdNotLike(String value) {
            addCriterion("role_fun_g_fun_id not like", value, "roleFunGFunId");
            return (Criteria) this;
        }

        public Criteria andRoleFunGFunIdIn(List<String> values) {
            addCriterion("role_fun_g_fun_id in", values, "roleFunGFunId");
            return (Criteria) this;
        }

        public Criteria andRoleFunGFunIdNotIn(List<String> values) {
            addCriterion("role_fun_g_fun_id not in", values, "roleFunGFunId");
            return (Criteria) this;
        }

        public Criteria andRoleFunGFunIdBetween(String value1, String value2) {
            addCriterion("role_fun_g_fun_id between", value1, value2, "roleFunGFunId");
            return (Criteria) this;
        }

        public Criteria andRoleFunGFunIdNotBetween(String value1, String value2) {
            addCriterion("role_fun_g_fun_id not between", value1, value2, "roleFunGFunId");
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