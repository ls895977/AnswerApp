package com.example.lishan.answerapp.bean;

import java.util.List;

/**
 * Created by lishan on 2018/2/9.
 */

public class AnswerCardBean {

    /**
     * code : 200
     * data : [{"user_answer":"C","answer_D":"答案D的内容","answer_B":"答案B的内容","answer_C":"答案C的内容","answer":"C","id":1,"questions":"会计考试-单选题-问题-1","answer_info":"暂无解析内容","answer_A":"答案A的内容","questions_img":"http://p4k36yzp3.bkt.clouddn.com/timg.jpg","questions_type":"单选题","answer_F":"","questions_score":"4","answer_E":""},{"user_answer":"C","answer_D":"答案D的内容","answer_B":"答案B的内容","answer_C":"答案C的内容","answer":"C","id":2,"questions":"会计考试-单选题-问题-2","answer_info":"暂无解析内容","answer_A":"答案A的内容","questions_img":"http://p4k36yzp3.bkt.clouddn.com/timg.jpg","questions_type":"单选题","answer_F":"","questions_score":"4","answer_E":""},{"user_answer":"C","answer_D":"答案D的内容","answer_B":"答案B的内容","answer_C":"答案C的内容","answer":"C","id":3,"questions":"会计考试-单选题-问题-3","answer_info":"暂无解析内容","answer_A":"答案A的内容","questions_img":"http://p4k36yzp3.bkt.clouddn.com/timg.jpg","questions_type":"单选题","answer_F":"","questions_score":"4","answer_E":""},{"user_answer":"D","answer_D":"答案D的内容","answer_B":"答案B的内容","answer_C":"答案C的内容","answer":"C","id":4,"questions":"会计考试-单选题-问题-4","answer_info":"暂无解析内容","answer_A":"答案A的内容","questions_img":"http://p4k36yzp3.bkt.clouddn.com/timg.jpg","questions_type":"单选题","answer_F":"","questions_score":"4","answer_E":""},{"user_answer":"C","answer_D":"答案D的内容","answer_B":"答案B的内容","answer_C":"答案C的内容","answer":"C","id":5,"questions":"会计考试-单选题-问题-5","answer_info":"暂无解析内容","answer_A":"答案A的内容","questions_img":"http://p4k36yzp3.bkt.clouddn.com/timg.jpg","questions_type":"单选题","answer_F":"","questions_score":"4","answer_E":""},{"user_answer":"C","answer_D":"答案D的内容","answer_B":"答案B的内容","answer_C":"答案C的内容","answer":"C","id":6,"questions":"会计考试-单选题-问题-6","answer_info":"暂无解析内容","answer_A":"答案A的内容","questions_img":"http://p4k36yzp3.bkt.clouddn.com/timg.jpg","questions_type":"单选题","answer_F":"","questions_score":"4","answer_E":""},{"user_answer":"A","answer_D":"答案D的内容","answer_B":"答案B的内容","answer_C":"答案C的内容","answer":"C","id":7,"questions":"会计考试-单选题-问题-7","answer_info":"暂无解析内容","answer_A":"答案A的内容","questions_img":"http://p4k36yzp3.bkt.clouddn.com/timg.jpg","questions_type":"单选题","answer_F":"","questions_score":"4","answer_E":""},{"user_answer":"B","answer_D":"答案D的内容","answer_B":"答案B的内容","answer_C":"答案C的内容","answer":"C","id":8,"questions":"会计考试-单选题-问题-8","answer_info":"暂无解析内容","answer_A":"答案A的内容","questions_img":"http://p4k36yzp3.bkt.clouddn.com/timg.jpg","questions_type":"单选题","answer_F":"","questions_score":"4","answer_E":""},{"user_answer":"B","answer_D":"答案D的内容","answer_B":"答案B的内容","answer_C":"答案C的内容","answer":"C","id":9,"questions":"会计考试-单选题-问题-9","answer_info":"暂无解析内容","answer_A":"答案A的内容","questions_img":"http://p4k36yzp3.bkt.clouddn.com/timg.jpg","questions_type":"单选题","answer_F":"","questions_score":"4","answer_E":""},{"user_answer":"C","answer_D":"答案D的内容","answer_B":"答案B的内容","answer_C":"答案C的内容","answer":"C","id":10,"questions":"会计考试-单选题-问题-10","answer_info":"暂无解析内容","answer_A":"答案A的内容","questions_img":"http://p4k36yzp3.bkt.clouddn.com/timg.jpg","questions_type":"单选题","answer_F":"","questions_score":"4","answer_E":""},{"user_answer":"A,F","answer_D":"答案D的内容","answer_B":"答案B的内容","answer_C":"答案C的内容","answer":"A,F","id":11,"questions":"会计考试-多选题-问题-11","answer_info":"暂无解析内容","answer_A":"答案A的内容","questions_img":"http://p4k36yzp3.bkt.clouddn.com/timg.jpg","questions_type":"多选题","answer_F":"答案F的内容","questions_score":"6","answer_E":"答案E的内容"},{"user_answer":"A,D","answer_D":"答案D的内容","answer_B":"答案B的内容","answer_C":"答案C的内容","answer":"A,F","id":12,"questions":"会计考试-多选题-问题-12","answer_info":"暂无解析内容","answer_A":"答案A的内容","questions_img":"http://p4k36yzp3.bkt.clouddn.com/timg.jpg","questions_type":"多选题","answer_F":"答案F的内容","questions_score":"6","answer_E":"答案E的内容"},{"user_answer":"A,F","answer_D":"答案D的内容","answer_B":"答案B的内容","answer_C":"答案C的内容","answer":"A,F","id":13,"questions":"会计考试-多选题-问题-13","answer_info":"暂无解析内容","answer_A":"答案A的内容","questions_img":"http://p4k36yzp3.bkt.clouddn.com/timg.jpg","questions_type":"多选题","answer_F":"答案F的内容","questions_score":"6","answer_E":"答案E的内容"},{"user_answer":"A,B","answer_D":"答案D的内容","answer_B":"答案B的内容","answer_C":"答案C的内容","answer":"A,F","id":14,"questions":"会计考试-多选题-问题-14","answer_info":"暂无解析内容","answer_A":"答案A的内容","questions_img":"http://p4k36yzp3.bkt.clouddn.com/timg.jpg","questions_type":"多选题","answer_F":"答案F的内容","questions_score":"6","answer_E":"答案E的内容"},{"user_answer":null,"answer_D":"答案D的内容","answer_B":"答案B的内容","answer_C":"答案C的内容","answer":"A,F","id":15,"questions":"会计考试-多选题-问题-15","answer_info":"暂无解析内容","answer_A":"答案A的内容","questions_img":"http://p4k36yzp3.bkt.clouddn.com/timg.jpg","questions_type":"多选题","answer_F":"答案F的内容","questions_score":"6","answer_E":"答案E的内容"},{"user_answer":null,"answer_D":"答案D的内容","answer_B":"答案B的内容","answer_C":"答案C的内容","answer":"A,F","id":16,"questions":"会计考试-多选题-问题-16","answer_info":"暂无解析内容","answer_A":"答案A的内容","questions_img":"http://p4k36yzp3.bkt.clouddn.com/timg.jpg","questions_type":"多选题","answer_F":"答案F的内容","questions_score":"6","answer_E":"答案E的内容"},{"user_answer":null,"answer_D":"答案D的内容","answer_B":"答案B的内容","answer_C":"答案C的内容","answer":"A,F","id":17,"questions":"会计考试-多选题-问题-17","answer_info":"暂无解析内容","answer_A":"答案A的内容","questions_img":"http://p4k36yzp3.bkt.clouddn.com/timg.jpg","questions_type":"多选题","answer_F":"答案F的内容","questions_score":"6","answer_E":"答案E的内容"},{"user_answer":null,"answer_D":"答案D的内容","answer_B":"答案B的内容","answer_C":"答案C的内容","answer":"A,F","id":18,"questions":"会计考试-多选题-问题-18","answer_info":"暂无解析内容","answer_A":"答案A的内容","questions_img":"http://p4k36yzp3.bkt.clouddn.com/timg.jpg","questions_type":"多选题","answer_F":"答案F的内容","questions_score":"6","answer_E":"答案E的内容"},{"user_answer":null,"answer_D":"答案D的内容","answer_B":"答案B的内容","answer_C":"答案C的内容","answer":"A,F","id":19,"questions":"会计考试-多选题-问题-19","answer_info":"暂无解析内容","answer_A":"答案A的内容","questions_img":"http://p4k36yzp3.bkt.clouddn.com/timg.jpg","questions_type":"多选题","answer_F":"答案F的内容","questions_score":"6","answer_E":"答案E的内容"},{"user_answer":null,"answer_D":"答案D的内容","answer_B":"答案B的内容","answer_C":"答案C的内容","answer":"A,F","id":20,"questions":"会计考试-多选题-问题-20","answer_info":"暂无解析内容","answer_A":"答案A的内容","questions_img":"http://p4k36yzp3.bkt.clouddn.com/timg.jpg","questions_type":"多选题","answer_F":"答案F的内容","questions_score":"6","answer_E":"答案E的内容"}]
     * error : true
     * messgae : 查询记录成功
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
         * user_answer : C
         * answer_D : 答案D的内容
         * answer_B : 答案B的内容
         * answer_C : 答案C的内容
         * answer : C
         * id : 1
         * questions : 会计考试-单选题-问题-1
         * answer_info : 暂无解析内容
         * answer_A : 答案A的内容
         * questions_img : http://p4k36yzp3.bkt.clouddn.com/timg.jpg
         * questions_type : 单选题
         * answer_F :
         * questions_score : 4
         * answer_E :
         */

        private String user_answer;
        private String answer_D;
        private String answer_B;
        private String answer_C;
        private String answer;
        private int id;
        private String questions;
        private String answer_info;
        private String answer_A;
        private String questions_img;
        private String questions_type;
        private String answer_F;
        private String questions_score;
        private String answer_E;

        public String getUser_answer() {
            return user_answer;
        }

        public void setUser_answer(String user_answer) {
            this.user_answer = user_answer;
        }

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

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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
