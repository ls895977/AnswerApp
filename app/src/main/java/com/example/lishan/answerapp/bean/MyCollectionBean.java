package com.example.lishan.answerapp.bean;

import java.util.List;

/**
 * Created by lishan on 2018/1/27.
 */

public class MyCollectionBean {

    /**
     * code : 200
     * data : [{"unit":"注册安全工程师-精选考题-考试-7","section":[{"section_man":"233","section_year":"2018年1月","section_info":"单项选择题(共5题，每题8分),多项选择题(共5题，每题12分)","section":"考试-7-第1章","unit_man":"2037","section_full":"100","unit":"注册安全工程师-精选考题-考试-7","section_pass":"60","questions":[{"answer_D":"选项D的内容","answer_B":"选项B的内容","answer_C":"选项C的内容","answer":"C","answer_F":null,"questions":"注册安全工程师-精选考题-第1章-单选题-题目-1","answer_info":"事故发生后，事故调查组委托专业检测机构对钢丝绳进行了检测，检测结论为φ14mm钢丝绳无明显缺陷","questions_id":301,"answer_A":"选项A的内容","questions_type":"单选题","questions_img":"http://p4k36yzp3.bkt.clouddn.com/timg.jpg","answer_E":null},{"answer_D":"选项D的内容","answer_B":"选项B的内容","answer_C":"选项C的内容","answer":"C","answer_F":null,"questions":"注册安全工程师-精选考题-第1章-单选题-题目-2","answer_info":"事故发生后，事故调查组委托专业检测机构对钢丝绳进行了检测，检测结论为φ14mm钢丝绳无明显缺陷","questions_id":302,"answer_A":"选项A的内容","questions_type":"单选题","questions_img":"http://p4k36yzp3.bkt.clouddn.com/timg.jpg","answer_E":null},{"answer_D":"选项D的内容","answer_B":"选项B的内容","answer_C":"选项C的内容","answer":"C","answer_F":null,"questions":"注册安全工程师-精选考题-第1章-单选题-题目-3","answer_info":"事故发生后，事故调查组委托专业检测机构对钢丝绳进行了检测，检测结论为φ14mm钢丝绳无明显缺陷","questions_id":303,"answer_A":"选项A的内容","questions_type":"单选题","questions_img":"http://p4k36yzp3.bkt.clouddn.com/timg.jpg","answer_E":null},{"answer_D":"选项D的内容","answer_B":"选项B的内容","answer_C":"选项C的内容","answer":"C","answer_F":null,"questions":"注册安全工程师-精选考题-第1章-单选题-题目-4","answer_info":"事故发生后，事故调查组委托专业检测机构对钢丝绳进行了检测，检测结论为φ14mm钢丝绳无明显缺陷","questions_id":304,"answer_A":"选项A的内容","questions_type":"单选题","questions_img":"http://p4k36yzp3.bkt.clouddn.com/timg.jpg","answer_E":null}],"section_time":"120"}],"unit_man":"2037"},{"unit":"注册安全工程师-历年真题-考试-9","section":[{"section_man":"233","section_year":"2018年1月","section_info":"单项选择题(共5题，每题8分),多项选择题(共5题，每题12分)","section":"考试-9-第1章","unit_man":"2037","section_full":"100","unit":"注册安全工程师-历年真题-考试-9","section_pass":"60","questions":[{"answer_D":"选项D的内容","answer_B":"选项B的内容","answer_C":"选项C的内容","answer":"C","answer_F":null,"questions":"注册安全工程师-历年真题-第1章-单选题-题目-1","answer_info":"事故发生后，事故调查组委托专业检测机构对钢丝绳进行了检测，检测结论为φ14mm钢丝绳无明显缺陷","questions_id":3794,"answer_A":"选项A的内容","questions_type":"单选题","questions_img":"http://p4k36yzp3.bkt.clouddn.com/timg.jpg","answer_E":null}],"section_time":"120"},{"section_man":"233","section_year":"2018年1月","section_info":"单项选择题(共5题，每题8分),多项选择题(共5题，每题12分)","section":"考试-9-第3章","unit_man":"2037","section_full":"100","unit":"注册安全工程师-历年真题-考试-9","section_pass":"60","questions":[{"answer_D":"选项D的内容","answer_B":"选项B的内容","answer_C":"选项C的内容","answer":"C","answer_F":null,"questions":"注册安全工程师-历年真题-第3章-单选题-题目-1","answer_info":"事故发生后，事故调查组委托专业检测机构对钢丝绳进行了检测，检测结论为φ14mm钢丝绳无明显缺陷","questions_id":3814,"answer_A":"选项A的内容","questions_type":"单选题","questions_img":"http://p4k36yzp3.bkt.clouddn.com/timg.jpg","answer_E":null}],"section_time":"120"}],"unit_man":"2037"}]
     * error : true
     * messgae : 查询收藏成功
     */

    private int code;
    private boolean error;
    private String messgae;
    private List<DataBean> data;

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

    public String getMessgae() {
        return messgae;
    }

    public void setMessgae(String messgae) {
        this.messgae = messgae;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * unit : 注册安全工程师-精选考题-考试-7
         * section : [{"section_man":"233","section_year":"2018年1月","section_info":"单项选择题(共5题，每题8分),多项选择题(共5题，每题12分)","section":"考试-7-第1章","unit_man":"2037","section_full":"100","unit":"注册安全工程师-精选考题-考试-7","section_pass":"60","questions":[{"answer_D":"选项D的内容","answer_B":"选项B的内容","answer_C":"选项C的内容","answer":"C","answer_F":null,"questions":"注册安全工程师-精选考题-第1章-单选题-题目-1","answer_info":"事故发生后，事故调查组委托专业检测机构对钢丝绳进行了检测，检测结论为φ14mm钢丝绳无明显缺陷","questions_id":301,"answer_A":"选项A的内容","questions_type":"单选题","questions_img":"http://p4k36yzp3.bkt.clouddn.com/timg.jpg","answer_E":null},{"answer_D":"选项D的内容","answer_B":"选项B的内容","answer_C":"选项C的内容","answer":"C","answer_F":null,"questions":"注册安全工程师-精选考题-第1章-单选题-题目-2","answer_info":"事故发生后，事故调查组委托专业检测机构对钢丝绳进行了检测，检测结论为φ14mm钢丝绳无明显缺陷","questions_id":302,"answer_A":"选项A的内容","questions_type":"单选题","questions_img":"http://p4k36yzp3.bkt.clouddn.com/timg.jpg","answer_E":null},{"answer_D":"选项D的内容","answer_B":"选项B的内容","answer_C":"选项C的内容","answer":"C","answer_F":null,"questions":"注册安全工程师-精选考题-第1章-单选题-题目-3","answer_info":"事故发生后，事故调查组委托专业检测机构对钢丝绳进行了检测，检测结论为φ14mm钢丝绳无明显缺陷","questions_id":303,"answer_A":"选项A的内容","questions_type":"单选题","questions_img":"http://p4k36yzp3.bkt.clouddn.com/timg.jpg","answer_E":null},{"answer_D":"选项D的内容","answer_B":"选项B的内容","answer_C":"选项C的内容","answer":"C","answer_F":null,"questions":"注册安全工程师-精选考题-第1章-单选题-题目-4","answer_info":"事故发生后，事故调查组委托专业检测机构对钢丝绳进行了检测，检测结论为φ14mm钢丝绳无明显缺陷","questions_id":304,"answer_A":"选项A的内容","questions_type":"单选题","questions_img":"http://p4k36yzp3.bkt.clouddn.com/timg.jpg","answer_E":null}],"section_time":"120"}]
         * unit_man : 2037
         */

        private String unit;
        private String unit_man;
        private List<SectionBean> section;
        private boolean derail;

        public boolean isDerail() {
            return derail;
        }

        public void setDerail(boolean derail) {
            this.derail = derail;
        }
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
             * section_man : 233
             * section_year : 2018年1月
             * section_info : 单项选择题(共5题，每题8分),多项选择题(共5题，每题12分)
             * section : 考试-7-第1章
             * unit_man : 2037
             * section_full : 100
             * unit : 注册安全工程师-精选考题-考试-7
             * section_pass : 60
             * questions : [{"answer_D":"选项D的内容","answer_B":"选项B的内容","answer_C":"选项C的内容","answer":"C","answer_F":null,"questions":"注册安全工程师-精选考题-第1章-单选题-题目-1","answer_info":"事故发生后，事故调查组委托专业检测机构对钢丝绳进行了检测，检测结论为φ14mm钢丝绳无明显缺陷","questions_id":301,"answer_A":"选项A的内容","questions_type":"单选题","questions_img":"http://p4k36yzp3.bkt.clouddn.com/timg.jpg","answer_E":null},{"answer_D":"选项D的内容","answer_B":"选项B的内容","answer_C":"选项C的内容","answer":"C","answer_F":null,"questions":"注册安全工程师-精选考题-第1章-单选题-题目-2","answer_info":"事故发生后，事故调查组委托专业检测机构对钢丝绳进行了检测，检测结论为φ14mm钢丝绳无明显缺陷","questions_id":302,"answer_A":"选项A的内容","questions_type":"单选题","questions_img":"http://p4k36yzp3.bkt.clouddn.com/timg.jpg","answer_E":null},{"answer_D":"选项D的内容","answer_B":"选项B的内容","answer_C":"选项C的内容","answer":"C","answer_F":null,"questions":"注册安全工程师-精选考题-第1章-单选题-题目-3","answer_info":"事故发生后，事故调查组委托专业检测机构对钢丝绳进行了检测，检测结论为φ14mm钢丝绳无明显缺陷","questions_id":303,"answer_A":"选项A的内容","questions_type":"单选题","questions_img":"http://p4k36yzp3.bkt.clouddn.com/timg.jpg","answer_E":null},{"answer_D":"选项D的内容","answer_B":"选项B的内容","answer_C":"选项C的内容","answer":"C","answer_F":null,"questions":"注册安全工程师-精选考题-第1章-单选题-题目-4","answer_info":"事故发生后，事故调查组委托专业检测机构对钢丝绳进行了检测，检测结论为φ14mm钢丝绳无明显缺陷","questions_id":304,"answer_A":"选项A的内容","questions_type":"单选题","questions_img":"http://p4k36yzp3.bkt.clouddn.com/timg.jpg","answer_E":null}]
             * section_time : 120
             */

            private String section_man;
            private String section_year;
            private String section_info;
            private String section;
            private String unit_man;
            private String section_full;
            private String unit;
            private String section_pass;
            private String section_time;
            private List<QuestionsBean> questions;

            public String getSection_man() {
                return section_man;
            }

            public void setSection_man(String section_man) {
                this.section_man = section_man;
            }

            public String getSection_year() {
                return section_year;
            }

            public void setSection_year(String section_year) {
                this.section_year = section_year;
            }

            public String getSection_info() {
                return section_info;
            }

            public void setSection_info(String section_info) {
                this.section_info = section_info;
            }

            public String getSection() {
                return section;
            }

            public void setSection(String section) {
                this.section = section;
            }

            public String getUnit_man() {
                return unit_man;
            }

            public void setUnit_man(String unit_man) {
                this.unit_man = unit_man;
            }

            public String getSection_full() {
                return section_full;
            }

            public void setSection_full(String section_full) {
                this.section_full = section_full;
            }

            public String getUnit() {
                return unit;
            }

            public void setUnit(String unit) {
                this.unit = unit;
            }

            public String getSection_pass() {
                return section_pass;
            }

            public void setSection_pass(String section_pass) {
                this.section_pass = section_pass;
            }

            public String getSection_time() {
                return section_time;
            }

            public void setSection_time(String section_time) {
                this.section_time = section_time;
            }

            public List<QuestionsBean> getQuestions() {
                return questions;
            }

            public void setQuestions(List<QuestionsBean> questions) {
                this.questions = questions;
            }

            public static class QuestionsBean {
                /**
                 * answer_D : 选项D的内容
                 * answer_B : 选项B的内容
                 * answer_C : 选项C的内容
                 * answer : C
                 * answer_F : null
                 * questions : 注册安全工程师-精选考题-第1章-单选题-题目-1
                 * answer_info : 事故发生后，事故调查组委托专业检测机构对钢丝绳进行了检测，检测结论为φ14mm钢丝绳无明显缺陷
                 * questions_id : 301
                 * answer_A : 选项A的内容
                 * questions_type : 单选题
                 * questions_img : http://p4k36yzp3.bkt.clouddn.com/timg.jpg
                 * answer_E : null
                 */

                private String answer_D;
                private String answer_B;
                private String answer_C;
                private String answer;
                private Object answer_F;
                private String questions;
                private String answer_info;
                private int questions_id;
                private String answer_A;
                private String questions_type;
                private String questions_img;
                private Object answer_E;

                public String getAnswer_D() {
                    return answer_D;
                }

                public void setAnswer_D(String answer_D) {
                    this.answer_D = answer_D;
                }

                public String getAnswer_B() {
                    return answer_B;
                }

                public void setAnswer_B(String answer_B) {
                    this.answer_B = answer_B;
                }

                public String getAnswer_C() {
                    return answer_C;
                }

                public void setAnswer_C(String answer_C) {
                    this.answer_C = answer_C;
                }

                public String getAnswer() {
                    return answer;
                }

                public void setAnswer(String answer) {
                    this.answer = answer;
                }

                public Object getAnswer_F() {
                    return answer_F;
                }

                public void setAnswer_F(Object answer_F) {
                    this.answer_F = answer_F;
                }

                public String getQuestions() {
                    return questions;
                }

                public void setQuestions(String questions) {
                    this.questions = questions;
                }

                public String getAnswer_info() {
                    return answer_info;
                }

                public void setAnswer_info(String answer_info) {
                    this.answer_info = answer_info;
                }

                public int getQuestions_id() {
                    return questions_id;
                }

                public void setQuestions_id(int questions_id) {
                    this.questions_id = questions_id;
                }

                public String getAnswer_A() {
                    return answer_A;
                }

                public void setAnswer_A(String answer_A) {
                    this.answer_A = answer_A;
                }

                public String getQuestions_type() {
                    return questions_type;
                }

                public void setQuestions_type(String questions_type) {
                    this.questions_type = questions_type;
                }

                public String getQuestions_img() {
                    return questions_img;
                }

                public void setQuestions_img(String questions_img) {
                    this.questions_img = questions_img;
                }

                public Object getAnswer_E() {
                    return answer_E;
                }

                public void setAnswer_E(Object answer_E) {
                    this.answer_E = answer_E;
                }
            }
        }
    }
}
