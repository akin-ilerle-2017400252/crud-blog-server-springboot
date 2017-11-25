package com.example.demo.model;

public class CreateBodyModel {
    private String post;
    private String header;

    public CreateBodyModel(String post, String header) {
        this.post = post;
        this.header = header;
    }

    public CreateBodyModel() {
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }


}
