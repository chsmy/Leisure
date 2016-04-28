package com.chs.leisure.model.Bean;

import java.util.List;

/**
 * 作者：chs on 2016/4/28 10:33
 * 邮箱：657083984@qq.com
 */
public class NewsEntity {
    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2016-04-28 10:40","title":"意大利中国女留学生欲轻生 美国警长跨国相救（图）","description":"网易社会","picUrl":"http://s.cimg.163.com/catchpic/6/62/627EEFFC52F2A42C06A30B1EE6DC8B69.jpg.119x83.jpg","url":"http://news.163.com/16/0428/10/BLO065H800014JB6.html#f=slist"},{"ctime":"2016-04-28 10:40","title":"小学生被校车轧倒身亡 警方:肇事司机已刑拘","description":"网易社会","picUrl":"http://s.cimg.163.com/catchpic/B/B6/B65B600F3A30D2D681F5051C4E6328A7.jpg.119x83.jpg","url":"http://news.163.com/16/0428/10/BLO067V000011229.html#f=slist"},{"ctime":"2016-04-28 10:42","title":"芜湖麦当劳砍人案追踪：军事迷砍伤军事迷","description":"网易社会","picUrl":"http://s.cimg.163.com/cnews/2016/4/28/201604281038236a66a_550.jpg.119x83.jpg","url":"http://news.163.com/16/0428/10/BLO0BA0000011229.html#f=slist"},{"ctime":"2016-04-28 10:43","title":"大学生公益调查：近六成人称若参加公益后没人知道就不","description":"网易社会","picUrl":"http://s.cimg.163.com/catchpic/8/8E/8ED23EF109BAFE26CDD714D7299B9325.jpg.119x83.jpg","url":"http://news.163.com/16/0428/10/BLO0C0HM00014AED.html#f=slist"},{"ctime":"2016-04-28 09:08","title":"延安路高架早高峰飘浓烟 原是一旁工地焚烧垃圾(组图)","description":"网易社会","picUrl":"http://s.cimg.163.com/catchpic/2/2C/2C6DAF27881ECF6B021EA5F5EE040482.jpg.119x83.jpg","url":"http://news.163.com/16/0428/09/BLNQUM8J00014AEE.html#f=slist"},{"ctime":"2016-04-28 09:11","title":"湖师大、湖大女厕接连发现有人泼粪水 警方调查","description":"网易社会","picUrl":"http://s.cimg.163.com/catchpic/9/97/9725B4D399668D2C73BF46A7AC8382A9.jpg.119x83.jpg","url":"http://news.163.com/16/0428/09/BLNR3EQ100014AEE.html#f=slist"},{"ctime":"2016-04-28 09:16","title":"女公务员实名举报村主任:骗我生孩子罚款加骚扰","description":"网易社会","picUrl":"http://s.cimg.163.com/cnews/2016/4/28/2016042809131562383_550.jpg.119x83.jpg","url":"http://news.163.com/16/0428/09/BLNRC5ST00011229.html#f=slist"},{"ctime":"2016-04-28 09:33","title":"杭州协警礼为奇被授予一等治安荣誉奖章(图)","description":"网易社会","picUrl":"http://s.cimg.163.com/catchpic/2/29/297E75D7C2D7BE744F2292D66250AD95.png.119x83.jpg","url":"http://news.163.com/16/0428/09/BLNSBH340001124J.html#f=slist"},{"ctime":"2016-04-28 09:33","title":"3岁女童称脚底遭老师牙签扎 幼儿园:蚊子咬的","description":"网易社会","picUrl":"http://s.cimg.163.com/cnews/2016/4/28/201604280931173ce1a_550.jpg.119x83.jpg","url":"http://news.163.com/16/0428/09/BLNSCOF800011229.html#f=slist"},{"ctime":"2016-04-28 09:44","title":"广东警方缴获碰瓷团队专用高级轿车28台(图)","description":"网易社会","picUrl":"http://s.cimg.163.com/catchpic/4/49/49FB978602BE4D0080BF7811136D88E6.jpg.119x83.jpg","url":"http://news.163.com/16/0428/09/BLNSVG910001124J.html#f=slist"}]
     */

    private int code;
    private String msg;
    /**
     * ctime : 2016-04-28 10:40
     * title : 意大利中国女留学生欲轻生 美国警长跨国相救（图）
     * description : 网易社会
     * picUrl : http://s.cimg.163.com/catchpic/6/62/627EEFFC52F2A42C06A30B1EE6DC8B69.jpg.119x83.jpg
     * url : http://news.163.com/16/0428/10/BLO065H800014JB6.html#f=slist
     */

    private List<NewslistEntity> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewslistEntity> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistEntity> newslist) {
        this.newslist = newslist;
    }

    public static class NewslistEntity {
        private String ctime;
        private String title;
        private String description;
        private String picUrl;
        private String url;

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
