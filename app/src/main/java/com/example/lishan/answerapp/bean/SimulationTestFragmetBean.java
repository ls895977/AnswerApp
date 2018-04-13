package com.example.lishan.answerapp.bean;

/**
 * Created by lishan on 2018/4/12.
 */

public class SimulationTestFragmetBean {
    /**
     * code : 200
     * data : {"end_time":1523556754,"user_answer":"B","user_judge":"Yes","end_data":"2018-04-13 02:12:34","answer":"B"}
     * error : true
     * messgae : 考试成绩提交成功
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

    public static class DataBean {
        /**
         * end_time : 1523556754
         * user_answer : B
         * user_judge : Yes
         * end_data : 2018-04-13 02:12:34
         * answer : B
         */

        private int end_time;
        private String user_answer;
        private String user_judge;
        private String end_data;
        private String answer;

        public int getEnd_time() {
            return end_time;
        }

        public void setEnd_time(int end_time) {
            this.end_time = end_time;
        }

        public String getUser_answer() {
            return user_answer;
        }

        public void setUser_answer(String user_answer) {
            this.user_answer = user_answer;
        }

        public String getUser_judge() {
            return user_judge;
        }

        public void setUser_judge(String user_judge) {
            this.user_judge = user_judge;
        }

        public String getEnd_data() {
            return end_data;
        }

        public void setEnd_data(String end_data) {
            this.end_data = end_data;
        }

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }
    }
}
