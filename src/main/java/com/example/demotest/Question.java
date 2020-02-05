package com.example.demotest;



public class Question {
    private Integer questionId;
    private String  title;
    private String questionDescription;
    private Integer  gmt_create;
    private Integer  gmt_modified;
    private Integer  creator;
    private Integer   comment_count;
    private Integer view_count;
    private Integer like_count;
    private String tag;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(Integer gmt_create) {
        this.gmt_create = gmt_create;
    }

    public Integer getGmt_modified() {
        return gmt_modified;
    }

    public void setGmt_modified(Integer gmt_modified) {
        this.gmt_modified = gmt_modified;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Integer getComment_count() {
        return comment_count;
    }

    public void setComment_count(Integer comment_count) {
        this.comment_count = comment_count;
    }

    public Integer getView_count() {
        return view_count;
    }

    public void setView_count(Integer view_count) {
        this.view_count = view_count;
    }

    public Integer getLike_count() {
        return like_count;
    }

    public void setLike_count(Integer like_count) {
        this.like_count = like_count;
    }

    public String getTag() {
        return tag;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestionDescription() {
        return questionDescription;
    }

    public void setQuestionDescription(String questionDescription) {
        this.questionDescription = questionDescription;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "Qusetion{" +
                "questionId=" + questionId +
                ", title='" + title + '\'' +
                ", questionDescription='" + questionDescription + '\'' +
                ", gmt_create=" + gmt_create +
                ", gmt_modified=" + gmt_modified +
                ", creator=" + creator +
                ", comment_count=" + comment_count +
                ", view_count=" + view_count +
                ", like_count=" + like_count +
                ", tag='" + tag + '\'' +
                '}';
    }


}
