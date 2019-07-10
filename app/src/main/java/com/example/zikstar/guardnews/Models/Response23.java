package com.example.zikstar.guardnews.Models;


import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response23 {

//    @SerializedName("status")
//    @Expose
//    private String status;
//    @SerializedName("userTier")
//    @Expose
//    private String userTier;
//    @SerializedName("total")
//    @Expose
//    private Integer total;
//    @SerializedName("startIndex")
//    @Expose
//    private Integer startIndex;
//    @SerializedName("pageSize")
//    @Expose
//    private Integer pageSize;
//    @SerializedName("currentPage")
//    @Expose
//    private Integer currentPage;
//    @SerializedName("pages")
//    @Expose
//    private Integer pages;
//    @SerializedName("edition")
//    @Expose
//    private Edition_ edition;
//    @SerializedName("section")
//    @Expose
//    private Section section;
    @SerializedName("results")
    @Expose
    private List<Result> results = null;

//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public String getUserTier() {
//        return userTier;
//    }
//
//    public void setUserTier(String userTier) {
//        this.userTier = userTier;
//    }
//
//    public Integer getTotal() {
//        return total;
//    }
//
//    public void setTotal(Integer total) {
//        this.total = total;
//    }
//
//    public Integer getStartIndex() {
//        return startIndex;
//    }
//
//    public void setStartIndex(Integer startIndex) {
//        this.startIndex = startIndex;
//    }
//
//    public Integer getPageSize() {
//        return pageSize;
//    }
//
//    public void setPageSize(Integer pageSize) {
//        this.pageSize = pageSize;
//    }
//
//    public Integer getCurrentPage() {
//        return currentPage;
//    }
//
//    public void setCurrentPage(Integer currentPage) {
//        this.currentPage = currentPage;
//    }
//
//    public Integer getPages() {
//        return pages;
//    }
//
//    public void setPages(Integer pages) {
//        this.pages = pages;
//    }
//
//    public Edition_ getEdition() {
//        return edition;
//    }
//
//    public void setEdition(Edition_ edition) {
//        this.edition = edition;
//    }
//
//    public Section getSection() {
//        return section;
//    }
//
//    public void setSection(Section section) {
//        this.section = section;
//    }
//
    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

}