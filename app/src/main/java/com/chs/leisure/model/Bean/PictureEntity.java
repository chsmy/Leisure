package com.chs.leisure.model.Bean;

import java.util.List;

/**
 * 作者：chs on 2016/4/26 10:22
 * 邮箱：657083984@qq.com
 */
public class PictureEntity {
    /**
     * status : true
     * total : 78
     * tngou : [{"count":3385,"fcount":0,"galleryclass":6,"id":723,"img":"/ext/160415/11c1b32ba00145b351390941b97c0224.jpg","rcount":0,"size":8,"time":1460697305000,"title":"清纯女孩清新照"},{"count":3783,"fcount":0,"galleryclass":6,"id":721,"img":"/ext/160408/e65ae3efd6d166c3c88e1679c7d5a383.jpg","rcount":0,"size":10,"time":1460114354000,"title":"小萝莉清纯照 "},{"count":2132,"fcount":0,"galleryclass":6,"id":720,"img":"/ext/160408/fcacfc698fc887758af9528c87e111ec.jpg","rcount":0,"size":9,"time":1460114312000,"title":"清凉秋日清纯少女"},{"count":1472,"fcount":0,"galleryclass":6,"id":719,"img":"/ext/160408/728c12c0936d89e4af50719aefd57611.jpg","rcount":0,"size":8,"time":1460114274000,"title":"90后卖萌女女 "},{"count":1439,"fcount":0,"galleryclass":6,"id":718,"img":"/ext/160408/57417c559e8fb923bcafce294a20f49c.jpg","rcount":0,"size":6,"time":1460114248000,"title":"国内最清纯漂亮大学校花"},{"count":1315,"fcount":0,"galleryclass":6,"id":712,"img":"/ext/160408/5768277643936ae4c565ce24bb8e003b.jpg","rcount":0,"size":20,"time":1460114061000,"title":"台湾E胸果小糖迷人自拍图片"},{"count":4001,"fcount":0,"galleryclass":6,"id":694,"img":"/ext/160317/b7e4565e631d58fa1c7c57694f4594a1.jpg","rcount":0,"size":13,"time":1458208095000,"title":"台电性感mm吴荣可爱写真"},{"count":3301,"fcount":0,"galleryclass":6,"id":692,"img":"/ext/160317/bf7f59929d82820ccc73ead819dca660.jpg","rcount":0,"size":11,"time":1458208032000,"title":"巨乳李玲Angel蓝色比基尼写真"},{"count":2403,"fcount":0,"galleryclass":6,"id":690,"img":"/ext/160310/2eb07b4e9d55133f27fa434f73e1f766.jpg","rcount":0,"size":24,"time":1457573190000,"title":"清纯美女赵婉妮甜美笑容窈窕身材"},{"count":1232,"fcount":0,"galleryclass":6,"id":689,"img":"/ext/160310/93696ec46785a0cadb11b48495222112.jpg","rcount":0,"size":12,"time":1457573151000,"title":"校园萝莉制服可爱写真图片"},{"count":966,"fcount":0,"galleryclass":6,"id":683,"img":"/ext/160310/96ac5ec68c48e05272cf8767e663f977.jpg","rcount":0,"size":8,"time":1457572851000,"title":"长发白衣少女唯美气质写真"},{"count":1330,"fcount":0,"galleryclass":6,"id":682,"img":"/ext/160307/ad7ae31f54db380a91647a0c6569d81b.jpg","rcount":0,"size":12,"time":1457312604000,"title":"清纯美女青涩甜美私房写真"},{"count":916,"fcount":0,"galleryclass":6,"id":676,"img":"/ext/160307/76aa3423eff73658aeff550bdb98f924.jpg","rcount":0,"size":54,"time":1457312159000,"title":"台湾清纯美女Kila晶晶校园外拍写真"},{"count":556,"fcount":0,"galleryclass":6,"id":670,"img":"/ext/160304/719373c7b19116fdbd5a609f5c06a1a5.jpg","rcount":0,"size":28,"time":1457085761000,"title":"清纯美女Winnie小雪条纹短裙性感可爱"},{"count":681,"fcount":0,"galleryclass":6,"id":669,"img":"/ext/160301/906baebd978a1d44f2133209819fc8ab.jpg","rcount":0,"size":64,"time":1456798959000,"title":"大眼女神张齐郡JULIE清纯唯美外拍"},{"count":736,"fcount":0,"galleryclass":6,"id":668,"img":"/ext/160301/6abf0a98fbc8acf718a157ffd2b66f8a.jpg","rcount":0,"size":26,"time":1456798777000,"title":"清纯美女Dudu俏皮可爱私房图片"},{"count":647,"fcount":0,"galleryclass":6,"id":658,"img":"/ext/160227/89c4df7b8e3ac49f9617e2632ae6382b.jpg","rcount":0,"size":8,"time":1456536420000,"title":"可爱的兔女郎 "},{"count":2553,"fcount":0,"galleryclass":6,"id":653,"img":"/ext/160225/eae15290f946ae832f2aac8a840d2322.jpg","rcount":0,"size":23,"time":1456359596000,"title":"兔女郎思淇Sukiii性感私房写真"},{"count":653,"fcount":0,"galleryclass":6,"id":647,"img":"/ext/160223/22adc9425c45395124c6c58a78f011e0.jpg","rcount":0,"size":6,"time":1456205912000,"title":"清纯可爱萝莉萌兔妹"},{"count":1663,"fcount":0,"galleryclass":6,"id":627,"img":"/ext/160215/f369d10c05f6eb3e797e1db0ebc42aba.jpg","rcount":0,"size":23,"time":1455514811000,"title":"护士MM雪颜丰满巨乳诱惑十足 "}]
     */

    private boolean status;
    private int total;
    /**
     * count : 3385
     * fcount : 0
     * galleryclass : 6
     * id : 723
     * img : /ext/160415/11c1b32ba00145b351390941b97c0224.jpg
     * rcount : 0
     * size : 8
     * time : 1460697305000
     * title : 清纯女孩清新照
     */

    private List<TngouEntity> tngou;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<TngouEntity> getTngou() {
        return tngou;
    }

    public void setTngou(List<TngouEntity> tngou) {
        this.tngou = tngou;
    }

    public static class TngouEntity {
        private int count;
        private int fcount;
        private int galleryclass;
        private int id;
        private String img;
        private int rcount;
        private int size;
        private long time;
        private String title;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getFcount() {
            return fcount;
        }

        public void setFcount(int fcount) {
            this.fcount = fcount;
        }

        public int getGalleryclass() {
            return galleryclass;
        }

        public void setGalleryclass(int galleryclass) {
            this.galleryclass = galleryclass;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public int getRcount() {
            return rcount;
        }

        public void setRcount(int rcount) {
            this.rcount = rcount;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
