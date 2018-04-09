package com.example.lishan.answerapp.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lishan on 2018/3/10.
 */

public class HomePageBean implements Serializable {

    /**
     * code : 200
     * messgae : 已获取精选考题第一分页
     * data : {"slideshow":[{"url":"https://www.baidu.com/","img":"http://p4k36yzp3.bkt.clouddn.com/KingI-index-1.jpg"},{"url":"https://www.baidu.com/","img":"http://p4k36yzp3.bkt.clouddn.com/KingI-index-2.jpg"},{"url":"https://www.baidu.com/","img":"http://p4k36yzp3.bkt.clouddn.com/KingI-index-3.jpg"},{"url":"https://www.baidu.com/","img":"http://p4k36yzp3.bkt.clouddn.com/KingI-index-4.jpg"},{"url":"https://www.baidu.com/","img":"http://p4k36yzp3.bkt.clouddn.com/KingI-index-5.jpg"}],"group":["注册安全工程师","机电工程","建筑工程"],"infoArr":["2018得分王！您考试的首选app","2018得分王！您考试的首选app"],"exam":{"group_type":"精选考题","group":"注册安全工程师","unit":[{"unit_man":"2023","section":[{"section":"第1章","section_man":"221"},{"section":"第2章","section_man":"202"},{"section":"第3章","section_man":"200"},{"section":"第4章","section_man":"200"},{"section":"第5章","section_man":"200"}],"unit":"2017年注册安全工程师考试-8"},{"unit_man":"2000","section":[{"section":"第1章","section_man":"200"},{"section":"第2章","section_man":"200"},{"section":"第3章","section_man":"200"},{"section":"第4章","section_man":"200"},{"section":"第5章","section_man":"200"}],"unit":"2017年注册安全工程师考试-3"},{"unit_man":"2021","section":[{"section":"第1章","section_man":"201"},{"section":"第2章","section_man":"200"},{"section":"第3章","section_man":"220"},{"section":"第4章","section_man":"200"},{"section":"第5章","section_man":"200"}],"unit":"2017年注册安全工程师考试-1"},{"unit_man":"2001","section":[{"section":"第1章","section_man":"201"},{"section":"第2章","section_man":"200"},{"section":"第3章","section_man":"200"},{"section":"第4章","section_man":"200"},{"section":"第5章","section_man":"200"}],"unit":"2017年注册安全工程师考试-9"},{"unit_man":"2000","section":[{"section":"第1章","section_man":"200"},{"section":"第2章","section_man":"200"},{"section":"第3章","section_man":"200"},{"section":"第4章","section_man":"200"},{"section":"第5章","section_man":"200"}],"unit":"2017年注册安全工程师考试-6"},{"unit_man":"2000","section":[{"section":"第1章","section_man":"200"},{"section":"第2章","section_man":"200"},{"section":"第3章","section_man":"200"},{"section":"第4章","section_man":"200"},{"section":"第5章","section_man":"200"}],"unit":"2017年注册安全工程师考试-7"},{"unit_man":"2000","section":[{"section":"第1章","section_man":"200"},{"section":"第2章","section_man":"200"},{"section":"第3章","section_man":"200"},{"section":"第4章","section_man":"200"},{"section":"第5章","section_man":"200"}],"unit":"2017年注册安全工程师考试-10"},{"unit_man":"2000","section":[{"section":"第1章","section_man":"200"},{"section":"第2章","section_man":"200"},{"section":"第3章","section_man":"200"},{"section":"第4章","section_man":"200"},{"section":"第5章","section_man":"200"}],"unit":"2017年注册安全工程师考试-5"},{"unit_man":"2000","section":[{"section":"第1章","section_man":"200"},{"section":"第2章","section_man":"200"},{"section":"第3章","section_man":"200"},{"section":"第4章","section_man":"200"},{"section":"第5章","section_man":"200"}],"unit":"2017年注册安全工程师考试-4"},{"unit_man":"2000","section":[{"section":"第1章","section_man":"200"},{"section":"第2章","section_man":"200"},{"section":"第3章","section_man":"200"},{"section":"第4章","section_man":"200"},{"section":"第5章","section_man":"200"}],"unit":"2017年注册安全工程师考试-2"}]},"hotArr":["2017年注册安全工程师考试-1","2017年注册安全工程师考试-3"]}
     * error : true
     */

    private int code;
    private String messgae;
    private DataBean data;
    private boolean error;

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

    public static class DataBean implements Serializable{
        /**
         * slideshow : [{"url":"https://www.baidu.com/","img":"http://p4k36yzp3.bkt.clouddn.com/KingI-index-1.jpg"},{"url":"https://www.baidu.com/","img":"http://p4k36yzp3.bkt.clouddn.com/KingI-index-2.jpg"},{"url":"https://www.baidu.com/","img":"http://p4k36yzp3.bkt.clouddn.com/KingI-index-3.jpg"},{"url":"https://www.baidu.com/","img":"http://p4k36yzp3.bkt.clouddn.com/KingI-index-4.jpg"},{"url":"https://www.baidu.com/","img":"http://p4k36yzp3.bkt.clouddn.com/KingI-index-5.jpg"}]
         * group : ["注册安全工程师","机电工程","建筑工程"]
         * infoArr : ["2018得分王！您考试的首选app","2018得分王！您考试的首选app"]
         * exam : {"group_type":"精选考题","group":"注册安全工程师","unit":[{"unit_man":"2023","section":[{"section":"第1章","section_man":"221"},{"section":"第2章","section_man":"202"},{"section":"第3章","section_man":"200"},{"section":"第4章","section_man":"200"},{"section":"第5章","section_man":"200"}],"unit":"2017年注册安全工程师考试-8"},{"unit_man":"2000","section":[{"section":"第1章","section_man":"200"},{"section":"第2章","section_man":"200"},{"section":"第3章","section_man":"200"},{"section":"第4章","section_man":"200"},{"section":"第5章","section_man":"200"}],"unit":"2017年注册安全工程师考试-3"},{"unit_man":"2021","section":[{"section":"第1章","section_man":"201"},{"section":"第2章","section_man":"200"},{"section":"第3章","section_man":"220"},{"section":"第4章","section_man":"200"},{"section":"第5章","section_man":"200"}],"unit":"2017年注册安全工程师考试-1"},{"unit_man":"2001","section":[{"section":"第1章","section_man":"201"},{"section":"第2章","section_man":"200"},{"section":"第3章","section_man":"200"},{"section":"第4章","section_man":"200"},{"section":"第5章","section_man":"200"}],"unit":"2017年注册安全工程师考试-9"},{"unit_man":"2000","section":[{"section":"第1章","section_man":"200"},{"section":"第2章","section_man":"200"},{"section":"第3章","section_man":"200"},{"section":"第4章","section_man":"200"},{"section":"第5章","section_man":"200"}],"unit":"2017年注册安全工程师考试-6"},{"unit_man":"2000","section":[{"section":"第1章","section_man":"200"},{"section":"第2章","section_man":"200"},{"section":"第3章","section_man":"200"},{"section":"第4章","section_man":"200"},{"section":"第5章","section_man":"200"}],"unit":"2017年注册安全工程师考试-7"},{"unit_man":"2000","section":[{"section":"第1章","section_man":"200"},{"section":"第2章","section_man":"200"},{"section":"第3章","section_man":"200"},{"section":"第4章","section_man":"200"},{"section":"第5章","section_man":"200"}],"unit":"2017年注册安全工程师考试-10"},{"unit_man":"2000","section":[{"section":"第1章","section_man":"200"},{"section":"第2章","section_man":"200"},{"section":"第3章","section_man":"200"},{"section":"第4章","section_man":"200"},{"section":"第5章","section_man":"200"}],"unit":"2017年注册安全工程师考试-5"},{"unit_man":"2000","section":[{"section":"第1章","section_man":"200"},{"section":"第2章","section_man":"200"},{"section":"第3章","section_man":"200"},{"section":"第4章","section_man":"200"},{"section":"第5章","section_man":"200"}],"unit":"2017年注册安全工程师考试-4"},{"unit_man":"2000","section":[{"section":"第1章","section_man":"200"},{"section":"第2章","section_man":"200"},{"section":"第3章","section_man":"200"},{"section":"第4章","section_man":"200"},{"section":"第5章","section_man":"200"}],"unit":"2017年注册安全工程师考试-2"}]}
         * hotArr : ["2017年注册安全工程师考试-1","2017年注册安全工程师考试-3"]
         */

        private ExamBean exam;
        private List<SlideshowBean> slideshow;
        private List<String> group;
        private List<String> infoArr;
        private List<String> hotArr;

        public ExamBean getExam() {
            return exam;
        }

        public void setExam(ExamBean exam) {
            this.exam = exam;
        }

        public List<SlideshowBean> getSlideshow() {
            return slideshow;
        }

        public void setSlideshow(List<SlideshowBean> slideshow) {
            this.slideshow = slideshow;
        }

        public List<String> getGroup() {
            return group;
        }

        public void setGroup(List<String> group) {
            this.group = group;
        }

        public List<String> getInfoArr() {
            return infoArr;
        }

        public void setInfoArr(List<String> infoArr) {
            this.infoArr = infoArr;
        }

        public List<String> getHotArr() {
            return hotArr;
        }

        public void setHotArr(List<String> hotArr) {
            this.hotArr = hotArr;
        }

        public static class ExamBean implements Serializable{
            /**
             * group_type : 精选考题
             * group : 注册安全工程师
             * unit : [{"unit_man":"2023","section":[{"section":"第1章","section_man":"221"},{"section":"第2章","section_man":"202"},{"section":"第3章","section_man":"200"},{"section":"第4章","section_man":"200"},{"section":"第5章","section_man":"200"}],"unit":"2017年注册安全工程师考试-8"},{"unit_man":"2000","section":[{"section":"第1章","section_man":"200"},{"section":"第2章","section_man":"200"},{"section":"第3章","section_man":"200"},{"section":"第4章","section_man":"200"},{"section":"第5章","section_man":"200"}],"unit":"2017年注册安全工程师考试-3"},{"unit_man":"2021","section":[{"section":"第1章","section_man":"201"},{"section":"第2章","section_man":"200"},{"section":"第3章","section_man":"220"},{"section":"第4章","section_man":"200"},{"section":"第5章","section_man":"200"}],"unit":"2017年注册安全工程师考试-1"},{"unit_man":"2001","section":[{"section":"第1章","section_man":"201"},{"section":"第2章","section_man":"200"},{"section":"第3章","section_man":"200"},{"section":"第4章","section_man":"200"},{"section":"第5章","section_man":"200"}],"unit":"2017年注册安全工程师考试-9"},{"unit_man":"2000","section":[{"section":"第1章","section_man":"200"},{"section":"第2章","section_man":"200"},{"section":"第3章","section_man":"200"},{"section":"第4章","section_man":"200"},{"section":"第5章","section_man":"200"}],"unit":"2017年注册安全工程师考试-6"},{"unit_man":"2000","section":[{"section":"第1章","section_man":"200"},{"section":"第2章","section_man":"200"},{"section":"第3章","section_man":"200"},{"section":"第4章","section_man":"200"},{"section":"第5章","section_man":"200"}],"unit":"2017年注册安全工程师考试-7"},{"unit_man":"2000","section":[{"section":"第1章","section_man":"200"},{"section":"第2章","section_man":"200"},{"section":"第3章","section_man":"200"},{"section":"第4章","section_man":"200"},{"section":"第5章","section_man":"200"}],"unit":"2017年注册安全工程师考试-10"},{"unit_man":"2000","section":[{"section":"第1章","section_man":"200"},{"section":"第2章","section_man":"200"},{"section":"第3章","section_man":"200"},{"section":"第4章","section_man":"200"},{"section":"第5章","section_man":"200"}],"unit":"2017年注册安全工程师考试-5"},{"unit_man":"2000","section":[{"section":"第1章","section_man":"200"},{"section":"第2章","section_man":"200"},{"section":"第3章","section_man":"200"},{"section":"第4章","section_man":"200"},{"section":"第5章","section_man":"200"}],"unit":"2017年注册安全工程师考试-4"},{"unit_man":"2000","section":[{"section":"第1章","section_man":"200"},{"section":"第2章","section_man":"200"},{"section":"第3章","section_man":"200"},{"section":"第4章","section_man":"200"},{"section":"第5章","section_man":"200"}],"unit":"2017年注册安全工程师考试-2"}]
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

            public static class UnitBean implements Serializable{
                /**
                 * unit_man : 2023
                 * section : [{"section":"第1章","section_man":"221"},{"section":"第2章","section_man":"202"},{"section":"第3章","section_man":"200"},{"section":"第4章","section_man":"200"},{"section":"第5章","section_man":"200"}]
                 * unit : 2017年注册安全工程师考试-8
                 */

                private String unit_man;
                private String unit;
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

                public List<SectionBean> getSection() {
                    return section;
                }

                public void setSection(List<SectionBean> section) {
                    this.section = section;
                }

                public static class SectionBean implements Serializable{
                    /**
                     * section : 第1章
                     * section_man : 221
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

        public static class SlideshowBean implements Serializable{
            /**
             * url : https://www.baidu.com/
             * img : http://p4k36yzp3.bkt.clouddn.com/KingI-index-1.jpg
             */

            private String url;
            private String img;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }
        }
    }
}
