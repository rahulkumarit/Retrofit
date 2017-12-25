package com.rnd.retofitsample.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.rnd.retofitsample.interfaces.WsResponse;

import java.util.List;

/**
 * Created by Devrepublic-14 on 9/12/2017.
 */

public class AllLanguage extends BaseModel implements WsResponse {

    @SerializedName("featured")
    @Expose
    private List<Featured> featured = null;
    @SerializedName("other")
    @Expose
    private List<Other> other = null;

    public List<Featured> getFeatured() {
        return featured;
    }

    public void setFeatured(List<Featured> featured) {
        this.featured = featured;
    }

    public List<Other> getOther() {
        return other;
    }


    public static class Featured {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("lang_name")
        @Expose
        private String langName;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("order")
        @Expose
        private String order;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("featured")
        @Expose
        private String featured;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLangName() {
            return langName;
        }

        public void setLangName(String langName) {
            this.langName = langName;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getFeatured() {
            return featured;
        }

        public void setFeatured(String featured) {
            this.featured = featured;
        }
    }

    public static class Other {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("lang_name")
        @Expose
        private String langName;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("order")
        @Expose
        private String order;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("featured")
        @Expose
        private String featured;

        private boolean checked=false;

        public boolean isChecked() {
            return checked;
        }

        public void setChecked(boolean checked) {
            this.checked = checked;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLangName() {
            return langName;
        }

        public void setLangName(String langName) {
            this.langName = langName;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getFeatured() {
            return featured;
        }

        public void setFeatured(String featured) {
            this.featured = featured;
        }

    }


}
