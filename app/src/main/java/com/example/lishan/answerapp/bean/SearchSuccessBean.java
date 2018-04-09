package com.example.lishan.answerapp.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/3/14 0014.
 */

public class SearchSuccessBean  {

    /**
     * messgae : 查询成功
     * code : 200
     * error : true
     * data : [{"unit_man":"2000","unit":"注册安全工程师-精选考题-考试-3","section":[{"section":"考试-3-第1章","section_man":"200"},{"section":"考试-3-第2章","section_man":"200"},{"section":"考试-3-第3章","section_man":"200"},{"section":"考试-3-第4章","section_man":"200"},{"section":"考试-3-第5章","section_man":"200"}],"group":"注册安全工程师","group_type":"精选考题"}]
     */

    private String messgae;
    private int code;
    private boolean error;
    private List<DataBean> data;

    public String getMessgae() {
        return messgae;
    }

    public void setMessgae(String messgae) {
        this.messgae = messgae;
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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * unit_man : 2000
         * unit : 注册安全工程师-精选考题-考试-3
         * section : [{"section":"考试-3-第1章","section_man":"200"},{"section":"考试-3-第2章","section_man":"200"},{"section":"考试-3-第3章","section_man":"200"},{"section":"考试-3-第4章","section_man":"200"},{"section":"考试-3-第5章","section_man":"200"}]
         * group : 注册安全工程师
         * group_type : 精选考题
         */

        private String unit_man;
        private String unit;
        private String group;
        private String group_type;

        public boolean isIskaiguan() {
            return iskaiguan;
        }

        public void setIskaiguan(boolean iskaiguan) {
            this.iskaiguan = iskaiguan;
        }

        private boolean iskaiguan;
        private List<SectionBean> section;

        public String getUnit_man() {
            return unit_man;
        }

        public void setUnit_man(String unit_man) {
            this.unit_man = unit_man;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public String getGroup() {
            return group;
        }

        public void setGroup(String group) {
            this.group = group;
        }

        public String getGroup_type() {
            return group_type;
        }

        public void setGroup_type(String group_type) {
            this.group_type = group_type;
        }

        public List<SectionBean> getSection() {
            return section;
        }

        public void setSection(List<SectionBean> section) {
            this.section = section;
        }

        public static class SectionBean {
            /**
             * section : 考试-3-第1章
             * section_man : 200
             */

            private String section;
            private String section_man;

            public String getSection() {
                return section;
            }

            public void setSection(String section) {
                this.section = section;
            }

            public String getSection_man() {
                return section_man;
            }

            public void setSection_man(String section_man) {
                this.section_man = section_man;
            }
        }
    }
}
