package com.paper.question.domain.dto.common;

import java.io.Serializable;

public class ImageResource implements Serializable {
    private Integer id;

    private String url;

    private String type;

    private Integer size;

    private Short width;

    private Short height;

    private static final long serialVersionUID = 1L;


    public ImageResource() {
    }

    @Override
    public String toString() {
        return "ProductResource{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", type='" + type + '\'' +
                ", size=" + size +
                ", width=" + width +
                ", height=" + height +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Short getWidth() {
        return width;
    }

    public void setWidth(Short width) {
        this.width = width;
    }

    public Short getHeight() {
        return height;
    }

    public void setHeight(Short height) {
        this.height = height;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
