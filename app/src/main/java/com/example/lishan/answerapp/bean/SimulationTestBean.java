package com.example.lishan.answerapp.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/4/10 0010.
 */

public class SimulationTestBean implements Serializable{

    /**
     * code : 200
     * data : {"questions":[{"answer_D":"机械安全技术D","answer_B":"机械安全技术B","answer_C":"机械安全技术C","answer":"C","questions":"注册安全工程师考试-机械安全技术","questions_id":61,"answer_A":"机械安全技术A","questions_img":"http://p4k36yzp3.bkt.clouddn.com/timg.jpg","questions_type":"单选题","answer_F":"","questions_score":"4","answer_E":""},{"answer_D":"电气安全技术D","answer_B":"电气安全技术B","answer_C":"电气安全技术C","answer":"B","questions":"注册安全工程师考试-电气安全技术","questions_id":62,"answer_A":"电气安全技术A","questions_img":"http://p4k36yzp3.bkt.clouddn.com/q1.jpg","questions_type":"单选题","answer_F":"","questions_score":"4","answer_E":""},{"answer_D":"特种设备安全技术D","answer_B":"特种设备安全技术B","answer_C":"特种设备安全技术C","answer":"A","questions":"注册安全工程师考试-特种设备安全技术","questions_id":63,"answer_A":"特种设备安全技术A","questions_img":"http://p4k36yzp3.bkt.clouddn.com/q2.jpg","questions_type":"单选题","answer_F":"","questions_score":"4","answer_E":""},{"answer_D":"防火防爆安全技术D","answer_B":"防火防爆安全技术B","answer_C":"防火防爆安全技术C","answer":"C","questions":"注册安全工程师考试-防火防爆安全技术","questions_id":64,"answer_A":"防火防爆安全技术A","questions_img":"http://p4k36yzp3.bkt.clouddn.com/q3.jpg","questions_type":"单选题","answer_F":"","questions_score":"4","answer_E":""},{"answer_D":"职业危害控制技术D","answer_B":"职业危害控制技术B","answer_C":"职业危害控制技术C","answer":"A","questions":"注册安全工程师考试-职业危害控制技术","questions_id":65,"answer_A":"职业危害控制技术A","questions_img":"http://p4k36yzp3.bkt.clouddn.com/timg.jpg","questions_type":"单选题","answer_F":"","questions_score":"4","answer_E":""},{"answer_D":"运输安全技术D","answer_B":"运输安全技术B","answer_C":"运输安全技术C","answer":"C","questions":"注册安全工程师考试-运输安全技术","questions_id":66,"answer_A":"运输安全技术A","questions_img":"http://p4k36yzp3.bkt.clouddn.com/q1.jpg","questions_type":"单选题","answer_F":"","questions_score":"4","answer_E":""},{"answer_D":"矿山安全技术D","answer_B":"矿山安全技术B","answer_C":"矿山安全技术C","answer":"B","questions":"注册安全工程师考试-矿山安全技术","questions_id":67,"answer_A":"矿山安全技术A","questions_img":"http://p4k36yzp3.bkt.clouddn.com/q2.jpg","questions_type":"单选题","answer_F":"","questions_score":"4","answer_E":""},{"answer_D":"建筑施工安全技术D","answer_B":"建筑施工安全技术B","answer_C":"建筑施工安全技术C","answer":"C","questions":"注册安全工程师考试-建筑施工安全技术","questions_id":68,"answer_A":"建筑施工安全技术A","questions_img":"http://p4k36yzp3.bkt.clouddn.com/q3.jpg","questions_type":"单选题","answer_F":"","questions_score":"4","answer_E":""},{"answer_D":"危险化学品安全技术D","answer_B":"危险化学品安全技术B","answer_C":"危险化学品安全技术C","answer":"D","questions":"注册安全工程师考试-危险化学品安全技术","questions_id":69,"answer_A":"危险化学品安全技术A","questions_img":"http://p4k36yzp3.bkt.clouddn.com/timg.jpg","questions_type":"单选题","answer_F":"","questions_score":"4","answer_E":""},{"answer_D":"机械安全技术D","answer_B":"机械安全技术B","answer_C":"机械安全技术C","answer":"C","questions":"注册安全工程师考试-机械安全技术","questions_id":70,"answer_A":"机械安全技术A","questions_img":"http://p4k36yzp3.bkt.clouddn.com/q1.jpg","questions_type":"单选题","answer_F":"","questions_score":"4","answer_E":""},{"answer_D":"电气安全技术D","answer_B":"电气安全技术B","answer_C":"电气安全技术C","answer":"A,B","questions":"注册安全工程师考试-电气安全技术","questions_id":71,"answer_A":"电气安全技术A","questions_img":"http://p4k36yzp3.bkt.clouddn.com/q2.jpg","questions_type":"多选题","answer_F":"电气安全技术F","questions_score":"6","answer_E":"电气安全技术E"},{"answer_D":"特种设备安全技术D","answer_B":"特种设备安全技术B","answer_C":"特种设备安全技术C","answer":"A,F","questions":"注册安全工程师考试-特种设备安全技术","questions_id":72,"answer_A":"特种设备安全技术A","questions_img":"http://p4k36yzp3.bkt.clouddn.com/q3.jpg","questions_type":"多选题","answer_F":"特种设备安全技术F","questions_score":"6","answer_E":"特种设备安全技术E"},{"answer_D":"防火防爆安全技术D","answer_B":"防火防爆安全技术B","answer_C":"防火防爆安全技术C","answer":"A,D","questions":"注册安全工程师考试-防火防爆安全技术","questions_id":73,"answer_A":"防火防爆安全技术A","questions_img":"http://p4k36yzp3.bkt.clouddn.com/timg.jpg","questions_type":"多选题","answer_F":"防火防爆安全技术F","questions_score":"6","answer_E":"防火防爆安全技术E"},{"answer_D":"职业危害控制技术D","answer_B":"职业危害控制技术B","answer_C":"职业危害控制技术C","answer":"A,F","questions":"注册安全工程师考试-职业危害控制技术","questions_id":74,"answer_A":"职业危害控制技术A","questions_img":"http://p4k36yzp3.bkt.clouddn.com/q1.jpg","questions_type":"多选题","answer_F":"职业危害控制技术F","questions_score":"6","answer_E":"职业危害控制技术E"},{"answer_D":"运输安全技术D","answer_B":"运输安全技术B","answer_C":"运输安全技术C","answer":"A,E","questions":"注册安全工程师考试-运输安全技术","questions_id":75,"answer_A":"运输安全技术A","questions_img":"http://p4k36yzp3.bkt.clouddn.com/q2.jpg","questions_type":"多选题","answer_F":"运输安全技术F","questions_score":"6","answer_E":"运输安全技术E"},{"answer_D":"矿山安全技术D","answer_B":"矿山安全技术B","answer_C":"矿山安全技术C","answer":"A,F","questions":"注册安全工程师考试-矿山安全技术","questions_id":76,"answer_A":"矿山安全技术A","questions_img":"http://p4k36yzp3.bkt.clouddn.com/q3.jpg","questions_type":"多选题","answer_F":"矿山安全技术F","questions_score":"6","answer_E":"矿山安全技术E"},{"answer_D":"建筑施工安全技术D","answer_B":"建筑施工安全技术B","answer_C":"建筑施工安全技术C","answer":"A,C","questions":"注册安全工程师考试-建筑施工安全技术","questions_id":77,"answer_A":"建筑施工安全技术A","questions_img":"http://p4k36yzp3.bkt.clouddn.com/timg.jpg","questions_type":"多选题","answer_F":"建筑施工安全技术F","questions_score":"6","answer_E":"建筑施工安全技术E"},{"answer_D":"危险化学品安全技术D","answer_B":"危险化学品安全技术B","answer_C":"危险化学品安全技术C","answer":"A,F","questions":"注册安全工程师考试-危险化学品安全技术","questions_id":78,"answer_A":"危险化学品安全技术A","questions_img":"http://p4k36yzp3.bkt.clouddn.com/q1.jpg","questions_type":"多选题","answer_F":"危险化学品安全技术F","questions_score":"6","answer_E":"危险化学品安全技术E"},{"answer_D":"机械安全技术D","answer_B":"机械安全技术B","answer_C":"机械安全技术C","answer":"A,D","questions":"注册安全工程师考试-机械安全技术","questions_id":79,"answer_A":"机械安全技术A","questions_img":"http://p4k36yzp3.bkt.clouddn.com/q2.jpg","questions_type":"多选题","answer_F":"机械安全技术F","questions_score":"6","answer_E":"机械安全技术E"},{"answer_D":"电气安全技术D","answer_B":"电气安全技术B","answer_C":"电气安全技术C","answer":"A,F","questions":"注册安全工程师考试-电气安全技术","questions_id":80,"answer_A":"电气安全技术A","questions_img":"http://p4k36yzp3.bkt.clouddn.com/q3.jpg","questions_type":"多选题","answer_F":"电气安全技术F","questions_score":"6","answer_E":"电气安全技术E"}]}
     * error : true
     * messgae : 计时考试
     */

    private int code;
    private DataBean data;
    private boolean error;
    private String messgae;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
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

    public static class DataBean implements Serializable{
        private List<QuestionsBean> questions;

        public List<QuestionsBean> getQuestions() {
            return questions;
        }

        public void setQuestions(List<QuestionsBean> questions) {
            this.questions = questions;
        }

        public static class QuestionsBean implements Serializable {
            /**
             * answer_D : 机械安全技术D
             * answer_B : 机械安全技术B
             * answer_C : 机械安全技术C
             * answer : C
             * questions : 注册安全工程师考试-机械安全技术
             * questions_id : 61
             * answer_A : 机械安全技术A
             * questions_img : http://p4k36yzp3.bkt.clouddn.com/timg.jpg
             * questions_type : 单选题
             * answer_F :
             * questions_score : 4
             * answer_E :
             */

            private String answer_D;
            private String answer_B;
            private String answer_C;
            private String answer;
            private String questions;
            private int questions_id;
            private String answer_A;
            private String questions_img;
            private String questions_type;
            private String answer_F;
            private String questions_score;
            private String answer_E;

            public boolean isDuoxuan() {
                return duoxuan;
            }

            public void setDuoxuan(boolean duoxuan) {
                this.duoxuan = duoxuan;
            }

            private boolean duoxuan;
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

            public String getQuestions() {
                return questions;
            }

            public void setQuestions(String questions) {
                this.questions = questions;
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

            public String getQuestions_img() {
                return questions_img;
            }

            public void setQuestions_img(String questions_img) {
                this.questions_img = questions_img;
            }

            public String getQuestions_type() {
                return questions_type;
            }

            public void setQuestions_type(String questions_type) {
                this.questions_type = questions_type;
            }

            public String getAnswer_F() {
                return answer_F;
            }

            public void setAnswer_F(String answer_F) {
                this.answer_F = answer_F;
            }

            public String getQuestions_score() {
                return questions_score;
            }

            public void setQuestions_score(String questions_score) {
                this.questions_score = questions_score;
            }

            public String getAnswer_E() {
                return answer_E;
            }

            public void setAnswer_E(String answer_E) {
                this.answer_E = answer_E;
            }
        }
    }
}
