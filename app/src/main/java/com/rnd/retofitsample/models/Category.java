package com.rnd.retofitsample.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.rnd.retofitsample.interfaces.WsResponse;
import java.util.List;

/**
 * Created by Devrepublic-14 on 7/14/2017.
 */

public class Category implements WsResponse {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public static class Datum {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("sequence")
        @Expose
        private Integer sequence;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("valid_to")
        @Expose
        private Object validTo;
        @SerializedName("valid_from")
        @Expose
        private Object validFrom;
        @SerializedName("is_active")
        @Expose
        private Integer isActive;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public Integer getSequence() {
            return sequence;
        }

        public void setSequence(Integer sequence) {
            this.sequence = sequence;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Object getValidTo() {
            return validTo;
        }

        public void setValidTo(Object validTo) {
            this.validTo = validTo;
        }

        public Object getValidFrom() {
            return validFrom;
        }

        public void setValidFrom(Object validFrom) {
            this.validFrom = validFrom;
        }

        public Integer getIsActive() {
            return isActive;
        }

        public void setIsActive(Integer isActive) {
            this.isActive = isActive;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }
    }

}

