package com.example.lishan.answerapp.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/3/4 0004.
 */

public class LoginBean {
    /**
     * error : true
     * data : {"token":"4u7-217819ab148b3e706046","message":[{"timestamp":"1519580150.0","content":"答题器，单选题，多选题，及时反馈，高效教学，趣味抢答，营造课堂学习氛围，提高学生学习兴趣"}],"user":{"nick_name":null,"phone":"15708319324","user_info":null,"gender":null,"province":null,"city":null,"birthday":null,"icon":"http://39.106.219.133/static/icon/KingI-icon.jpg"}}
     * code : 200
     * messgae : 登录成功!
     */
    private boolean error;
    private DataBean data;
    private int code;
    private String messgae;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
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

    public String getMessgae() {
        return messgae;
    }

    public void setMessgae(String messgae) {
        this.messgae = messgae;
    }

    public static class DataBean {
        /**
         * token : 4u7-217819ab148b3e706046
         * message : [{"timestamp":"1519580150.0","content":"答题器，单选题，多选题，及时反馈，高效教学，趣味抢答，营造课堂学习氛围，提高学生学习兴趣"}]
         * user : {"nick_name":null,"phone":"15708319324","user_info":null,"gender":null,"province":null,"city":null,"birthday":null,"icon":"http://39.106.219.133/static/icon/KingI-icon.jpg"}
         */

        private String token;
        private UserBean user;
        private List<MessageBean> message;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public List<MessageBean> getMessage() {
            return message;
        }

        public void setMessage(List<MessageBean> message) {
            this.message = message;
        }

        public static class UserBean {
            /**
             * nick_name : null
             * phone : 15708319324
             * user_info : null
             * gender : null
             * province : null
             * city : null
             * birthday : null
             * icon : http://39.106.219.133/static/icon/KingI-icon.jpg
             */

            private String nick_name;
            private String phone;
            private Object user_info;
            private Object gender;
            private Object province;
            private Object city;
            private Object birthday;
            private String icon;

            public Object getNick_name() {
                return nick_name;
            }

            public void setNick_name(String nick_name) {
                this.nick_name = nick_name;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public Object getUser_info() {
                return user_info;
            }

            public void setUser_info(Object user_info) {
                this.user_info = user_info;
            }

            public Object getGender() {
                return gender;
            }

            public void setGender(Object gender) {
                this.gender = gender;
            }

            public Object getProvince() {
                return province;
            }

            public void setProvince(Object province) {
                this.province = province;
            }

            public Object getCity() {
                return city;
            }

            public void setCity(Object city) {
                this.city = city;
            }

            public Object getBirthday() {
                return birthday;
            }

            public void setBirthday(Object birthday) {
                this.birthday = birthday;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }
        }

        public static class MessageBean {
            /**
             * timestamp : 1519580150.0
             * content : 答题器，单选题，多选题，及时反馈，高效教学，趣味抢答，营造课堂学习氛围，提高学生学习兴趣
             */

            private String timestamp;
            private String content;

            public String getTimestamp() {
                return timestamp;
            }

            public void setTimestamp(String timestamp) {
                this.timestamp = timestamp;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }
        }
    }
}
