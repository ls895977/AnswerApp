package com.example.lishan.answerapp.bean;

import java.util.List;

/**
 * Created by lishan on 2018/2/2.
 */

public class HomeBean  {
    private String name;
    /**
     * messgae : 成功刷新数据！
     * data : {"unit":[{"unit":"2017年注册安全工程师考试-16","section":[{"section_man":"200","section":"第1章"},{"section_man":"200","section":"第2章"},{"section_man":"200","section":"第3章"},{"section_man":"200","section":"第4章"},{"section_man":"200","section":"第5章"}],"unit_man":"2000"},{"unit":"2017年注册安全工程师考试-11","section":[{"section_man":"201","section":"第1章"},{"section_man":"200","section":"第2章"},{"section_man":"200","section":"第3章"},{"section_man":"200","section":"第4章"},{"section_man":"200","section":"第5章"}],"unit_man":"2001"},{"unit":"2017年注册安全工程师考试-13","section":[{"section_man":"200","section":"第1章"},{"section_man":"200","section":"第2章"},{"section_man":"200","section":"第3章"},{"section_man":"200","section":"第4章"},{"section_man":"200","section":"第5章"}],"unit_man":"2000"},{"unit":"2017年注册安全工程师考试-18","section":[{"section_man":"200","section":"第1章"},{"section_man":"200","section":"第2章"},{"section_man":"200","section":"第3章"},{"section_man":"200","section":"第4章"},{"section_man":"200","section":"第5章"}],"unit_man":"2000"},{"unit":"2017年注册安全工程师考试-20","section":[{"section_man":"200","section":"第1章"},{"section_man":"200","section":"第2章"},{"section_man":"200","section":"第3章"},{"section_man":"200","section":"第4章"},{"section_man":"200","section":"第5章"}],"unit_man":"2000"},{"unit":"2017年注册安全工程师考试-14","section":[{"section_man":"200","section":"第1章"},{"section_man":"200","section":"第2章"},{"section_man":"200","section":"第3章"},{"section_man":"200","section":"第4章"},{"section_man":"200","section":"第5章"}],"unit_man":"2000"},{"unit":"2017年注册安全工程师考试-19","section":[{"section_man":"200","section":"第1章"},{"section_man":"200","section":"第2章"},{"section_man":"200","section":"第3章"},{"section_man":"200","section":"第4章"},{"section_man":"200","section":"第5章"}],"unit_man":"2000"},{"unit":"2017年注册安全工程师考试-15","section":[{"section_man":"200","section":"第1章"},{"section_man":"200","section":"第2章"},{"section_man":"200","section":"第3章"},{"section_man":"200","section":"第4章"},{"section_man":"200","section":"第5章"}],"unit_man":"2000"},{"unit":"2017年注册安全工程师考试-17","section":[{"section_man":"200","section":"第1章"},{"section_man":"200","section":"第2章"},{"section_man":"200","section":"第3章"},{"section_man":"200","section":"第4章"},{"section_man":"200","section":"第5章"}],"unit_man":"2000"},{"unit":"2017年注册安全工程师考试-12","section":[{"section_man":"200","section":"第1章"},{"section_man":"200","section":"第2章"},{"section_man":"200","section":"第3章"},{"section_man":"200","section":"第4章"},{"section_man":"200","section":"第5章"}],"unit_man":"2000"}],"group_type":"精选考题","group":"注册安全工程师"}
     * code : 200
     * error : true
     */

    private String messgae;
    private DataBean data;
    private int code;
    private boolean error;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessgae() {
        return messgae;
    }

    public void setMessgae(String messgae) {
        this.messgae = messgae;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public static class DataBean {
        /**
         * unit : [{"unit":"2017年注册安全工程师考试-16","section":[{"section_man":"200","section":"第1章"},{"section_man":"200","section":"第2章"},{"section_man":"200","section":"第3章"},{"section_man":"200","section":"第4章"},{"section_man":"200","section":"第5章"}],"unit_man":"2000"},{"unit":"2017年注册安全工程师考试-11","section":[{"section_man":"201","section":"第1章"},{"section_man":"200","section":"第2章"},{"section_man":"200","section":"第3章"},{"section_man":"200","section":"第4章"},{"section_man":"200","section":"第5章"}],"unit_man":"2001"},{"unit":"2017年注册安全工程师考试-13","section":[{"section_man":"200","section":"第1章"},{"section_man":"200","section":"第2章"},{"section_man":"200","section":"第3章"},{"section_man":"200","section":"第4章"},{"section_man":"200","section":"第5章"}],"unit_man":"2000"},{"unit":"2017年注册安全工程师考试-18","section":[{"section_man":"200","section":"第1章"},{"section_man":"200","section":"第2章"},{"section_man":"200","section":"第3章"},{"section_man":"200","section":"第4章"},{"section_man":"200","section":"第5章"}],"unit_man":"2000"},{"unit":"2017年注册安全工程师考试-20","section":[{"section_man":"200","section":"第1章"},{"section_man":"200","section":"第2章"},{"section_man":"200","section":"第3章"},{"section_man":"200","section":"第4章"},{"section_man":"200","section":"第5章"}],"unit_man":"2000"},{"unit":"2017年注册安全工程师考试-14","section":[{"section_man":"200","section":"第1章"},{"section_man":"200","section":"第2章"},{"section_man":"200","section":"第3章"},{"section_man":"200","section":"第4章"},{"section_man":"200","section":"第5章"}],"unit_man":"2000"},{"unit":"2017年注册安全工程师考试-19","section":[{"section_man":"200","section":"第1章"},{"section_man":"200","section":"第2章"},{"section_man":"200","section":"第3章"},{"section_man":"200","section":"第4章"},{"section_man":"200","section":"第5章"}],"unit_man":"2000"},{"unit":"2017年注册安全工程师考试-15","section":[{"section_man":"200","section":"第1章"},{"section_man":"200","section":"第2章"},{"section_man":"200","section":"第3章"},{"section_man":"200","section":"第4章"},{"section_man":"200","section":"第5章"}],"unit_man":"2000"},{"unit":"2017年注册安全工程师考试-17","section":[{"section_man":"200","section":"第1章"},{"section_man":"200","section":"第2章"},{"section_man":"200","section":"第3章"},{"section_man":"200","section":"第4章"},{"section_man":"200","section":"第5章"}],"unit_man":"2000"},{"unit":"2017年注册安全工程师考试-12","section":[{"section_man":"200","section":"第1章"},{"section_man":"200","section":"第2章"},{"section_man":"200","section":"第3章"},{"section_man":"200","section":"第4章"},{"section_man":"200","section":"第5章"}],"unit_man":"2000"}]
         * group_type : 精选考题
         * group : 注册安全工程师
         */

        private String group_type;
        private String group;
        private List<UnitBean> unit;

        public String getGroup_type() {
            return group_type;
        }

        public void setGroup_type(String group_type) {
            this.group_type = group_type;
        }

        public String getGroup() {
            return group;
        }

        public void setGroup(String group) {
            this.group = group;
        }

        public List<UnitBean> getUnit() {
            return unit;
        }

        public void setUnit(List<UnitBean> unit) {
            this.unit = unit;
        }

        public static class UnitBean {
            /**
             * unit : 2017年注册安全工程师考试-16
             * section : [{"section_man":"200","section":"第1章"},{"section_man":"200","section":"第2章"},{"section_man":"200","section":"第3章"},{"section_man":"200","section":"第4章"},{"section_man":"200","section":"第5章"}]
             * unit_man : 2000
             */

            private String unit;
            private String unit_man;
            private boolean derail;

            public boolean isDerail() {
                return derail;
            }

            public void setDerail(boolean derail) {
                this.derail = derail;
            }

            private List<SectionBean> section;

            public String getUnit() {
                return unit;
            }

            public void setUnit(String unit) {
                this.unit = unit;
            }

            public String getUnit_man() {
                return unit_man;
            }

            public void setUnit_man(String unit_man) {
                this.unit_man = unit_man;
            }

            public List<SectionBean> getSection() {
                return section;
            }

            public void setSection(List<SectionBean> section) {
                this.section = section;
            }

            public static class SectionBean {
                /**
                 * section_man : 200
                 * section : 第1章
                 */

                private String section_man;
                private String section;

                public String getSection_man() {
                    return section_man;
                }

                public void setSection_man(String section_man) {
                    this.section_man = section_man;
                }

                public String getSection() {
                    return section;
                }

                public void setSection(String section) {
                    this.section = section;
                }
            }
        }
    }
}
