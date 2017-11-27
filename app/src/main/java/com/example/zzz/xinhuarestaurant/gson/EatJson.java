package com.example.zzz.xinhuarestaurant.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by zzz on 2017/11/20.
 */

public class EatJson {

    /**
     * 0 : {"class_title":"早餐分类2","class_id":1}
     * 1 : {"class_title":"早餐分类1","class_id":3}
     * 2 : {"class_title":"早餐3","class_id":5}
     * default_info : [{"cm_id":13,"cm_time":"1234567890","cm_title":"1","cm_price":"888888.00","cm_number":10,"cm_class":"1","cm_thumb":10},{"cm_id":14,"cm_time":"1234567890","cm_title":"2","cm_price":"231200.00","cm_number":10,"cm_class":"3","cm_thumb":10},{"cm_id":15,"cm_time":"1234567890","cm_title":"3","cm_price":"123.00","cm_number":10,"cm_class":"3","cm_thumb":10},{"cm_id":16,"cm_time":"1234567890","cm_title":"4","cm_price":"400.00","cm_number":10,"cm_class":"3","cm_thumb":10},{"cm_id":17,"cm_time":"1234567890","cm_title":"5","cm_price":"500.00","cm_number":10,"cm_class":"3","cm_thumb":10},{"cm_id":18,"cm_time":"1234567890","cm_title":"6","cm_price":"600.00","cm_number":10,"cm_class":"1","cm_thumb":10},{"cm_id":19,"cm_time":"1234567890","cm_title":"7","cm_price":"700.00","cm_number":10,"cm_class":"1","cm_thumb":10},{"cm_id":20,"cm_time":"1234567890","cm_title":"范德萨范德萨范德萨","cm_price":"800.00","cm_number":10,"cm_class":"1","cm_thumb":10}]
     */

    @SerializedName("0")
    private _$0Bean _$0;
    @SerializedName("1")
    private _$1Bean _$1;
    @SerializedName("2")
    private _$2Bean _$2;
    private List<DefaultInfoBean> default_info;

    public _$0Bean get_$0() {
        return _$0;
    }

    public void set_$0(_$0Bean _$0) {
        this._$0 = _$0;
    }

    public _$1Bean get_$1() {
        return _$1;
    }

    public void set_$1(_$1Bean _$1) {
        this._$1 = _$1;
    }

    public _$2Bean get_$2() {
        return _$2;
    }

    public void set_$2(_$2Bean _$2) {
        this._$2 = _$2;
    }

    public List<DefaultInfoBean> getDefault_info() {
        return default_info;
    }

    public void setDefault_info(List<DefaultInfoBean> default_info) {
        this.default_info = default_info;
    }

    public static class _$0Bean {
        /**
         * class_title : 早餐分类2
         * class_id : 1
         */

        private String class_title;
        private int class_id;

        public String getClass_title() {
            return class_title;
        }

        public void setClass_title(String class_title) {
            this.class_title = class_title;
        }

        public int getClass_id() {
            return class_id;
        }

        public void setClass_id(int class_id) {
            this.class_id = class_id;
        }
    }

    public static class _$1Bean {
        /**
         * class_title : 早餐分类1
         * class_id : 3
         */

        private String class_title;
        private int class_id;

        public String getClass_title() {
            return class_title;
        }

        public void setClass_title(String class_title) {
            this.class_title = class_title;
        }

        public int getClass_id() {
            return class_id;
        }

        public void setClass_id(int class_id) {
            this.class_id = class_id;
        }
    }

    public static class _$2Bean {
        /**
         * class_title : 早餐3
         * class_id : 5
         */

        private String class_title;
        private int class_id;

        public String getClass_title() {
            return class_title;
        }

        public void setClass_title(String class_title) {
            this.class_title = class_title;
        }

        public int getClass_id() {
            return class_id;
        }

        public void setClass_id(int class_id) {
            this.class_id = class_id;
        }
    }

    public static class DefaultInfoBean {
        /**
         * cm_id : 13
         * cm_time : 1234567890
         * cm_title : 1
         * cm_price : 888888.00
         * cm_number : 10
         * cm_class : 1
         * cm_thumb : 10
         */

        private int cm_id;
        private String cm_time;
        private String cm_title;
        private String cm_price;
        private int cm_number;
        private String cm_class;
        private int cm_thumb;

        public int getCm_id() {
            return cm_id;
        }

        public void setCm_id(int cm_id) {
            this.cm_id = cm_id;
        }

        public String getCm_time() {
            return cm_time;
        }

        public void setCm_time(String cm_time) {
            this.cm_time = cm_time;
        }

        public String getCm_title() {
            return cm_title;
        }

        public void setCm_title(String cm_title) {
            this.cm_title = cm_title;
        }

        public String getCm_price() {
            return cm_price;
        }

        public void setCm_price(String cm_price) {
            this.cm_price = cm_price;
        }

        public int getCm_number() {
            return cm_number;
        }

        public void setCm_number(int cm_number) {
            this.cm_number = cm_number;
        }

        public String getCm_class() {
            return cm_class;
        }

        public void setCm_class(String cm_class) {
            this.cm_class = cm_class;
        }

        public int getCm_thumb() {
            return cm_thumb;
        }

        public void setCm_thumb(int cm_thumb) {
            this.cm_thumb = cm_thumb;
        }
    }
}
