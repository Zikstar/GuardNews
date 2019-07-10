package com.example.zikstar.guardnews.Models;

public class Example {

    /*
    * -----------------------------------com.example.zikstar.guardnews.Edition.java-----------------------------------

package com.example.zikstar.guardnews;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Edition {

@SerializedName("id")
@Expose
private String id;
@SerializedName("webTitle")
@Expose
private String webTitle;
@SerializedName("webUrl")
@Expose
private String webUrl;
@SerializedName("apiUrl")
@Expose
private String apiUrl;
@SerializedName("code")
@Expose
private String code;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getWebTitle() {
return webTitle;
}

public void setWebTitle(String webTitle) {
this.webTitle = webTitle;
}

public String getWebUrl() {
return webUrl;
}

public void setWebUrl(String webUrl) {
this.webUrl = webUrl;
}

public String getApiUrl() {
return apiUrl;
}

public void setApiUrl(String apiUrl) {
this.apiUrl = apiUrl;
}

public String getCode() {
return code;
}

public void setCode(String code) {
this.code = code;
}

}
-----------------------------------com.example.zikstar.guardnews.Edition_.java-----------------------------------

package com.example.zikstar.guardnews;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Edition_ {

@SerializedName("id")
@Expose
private String id;
@SerializedName("webTitle")
@Expose
private String webTitle;
@SerializedName("webUrl")
@Expose
private String webUrl;
@SerializedName("apiUrl")
@Expose
private String apiUrl;
@SerializedName("code")
@Expose
private String code;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getWebTitle() {
return webTitle;
}

public void setWebTitle(String webTitle) {
this.webTitle = webTitle;
}

public String getWebUrl() {
return webUrl;
}

public void setWebUrl(String webUrl) {
this.webUrl = webUrl;
}

public String getApiUrl() {
return apiUrl;
}

public void setApiUrl(String apiUrl) {
this.apiUrl = apiUrl;
}

public String getCode() {
return code;
}

public void setCode(String code) {
this.code = code;
}

}
-----------------------------------com.example.zikstar.guardnews.Fields.java-----------------------------------

package com.example.zikstar.guardnews;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fields {

@SerializedName("thumbnail")
@Expose
private String thumbnail;

public String getThumbnail() {
return thumbnail;
}

public void setThumbnail(String thumbnail) {
this.thumbnail = thumbnail;
}

}
-----------------------------------com.example.zikstar.guardnews.News.java-----------------------------------

package com.example.zikstar.guardnews;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class News {

@SerializedName("response")
@Expose
private Response23 response;

public Response23 getResponse() {
return response;
}

public void setResponse(Response23 response) {
this.response = response;
}

}
-----------------------------------com.example.zikstar.guardnews.Response23.java-----------------------------------

package com.example.zikstar.guardnews;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response23 {

@SerializedName("status")
@Expose
private String status;
@SerializedName("userTier")
@Expose
private String userTier;
@SerializedName("total")
@Expose
private Integer total;
@SerializedName("startIndex")
@Expose
private Integer startIndex;
@SerializedName("pageSize")
@Expose
private Integer pageSize;
@SerializedName("currentPage")
@Expose
private Integer currentPage;
@SerializedName("pages")
@Expose
private Integer pages;
@SerializedName("edition")
@Expose
private Edition edition;
@SerializedName("section")
@Expose
private Section section;
@SerializedName("results")
@Expose
private List<Result> results = null;

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}

public String getUserTier() {
return userTier;
}

public void setUserTier(String userTier) {
this.userTier = userTier;
}

public Integer getTotal() {
return total;
}

public void setTotal(Integer total) {
this.total = total;
}

public Integer getStartIndex() {
return startIndex;
}

public void setStartIndex(Integer startIndex) {
this.startIndex = startIndex;
}

public Integer getPageSize() {
return pageSize;
}

public void setPageSize(Integer pageSize) {
this.pageSize = pageSize;
}

public Integer getCurrentPage() {
return currentPage;
}

public void setCurrentPage(Integer currentPage) {
this.currentPage = currentPage;
}

public Integer getPages() {
return pages;
}

public void setPages(Integer pages) {
this.pages = pages;
}

public Edition getEdition() {
return edition;
}

public void setEdition(Edition edition) {
this.edition = edition;
}

public Section getSection() {
return section;
}

public void setSection(Section section) {
this.section = section;
}

public List<Result> getResults() {
return results;
}

public void setResults(List<Result> results) {
this.results = results;
}

}
-----------------------------------com.example.zikstar.guardnews.Result.java-----------------------------------

package com.example.zikstar.guardnews;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

@SerializedName("id")
@Expose
private String id;
@SerializedName("type")
@Expose
private String type;
@SerializedName("sectionId")
@Expose
private String sectionId;
@SerializedName("sectionName")
@Expose
private String sectionName;
@SerializedName("webPublicationDate")
@Expose
private String webPublicationDate;
@SerializedName("webTitle")
@Expose
private String webTitle;
@SerializedName("webUrl")
@Expose
private String webUrl;
@SerializedName("apiUrl")
@Expose
private String apiUrl;
@SerializedName("fields")
@Expose
private Fields fields;
@SerializedName("isHosted")
@Expose
private Boolean isHosted;
@SerializedName("pillarId")
@Expose
private String pillarId;
@SerializedName("pillarName")
@Expose
private String pillarName;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getType() {
return type;
}

public void setType(String type) {
this.type = type;
}

public String getSectionId() {
return sectionId;
}

public void setSectionId(String sectionId) {
this.sectionId = sectionId;
}

public String getSectionName() {
return sectionName;
}

public void setSectionName(String sectionName) {
this.sectionName = sectionName;
}

public String getWebPublicationDate() {
return webPublicationDate;
}

public void setWebPublicationDate(String webPublicationDate) {
this.webPublicationDate = webPublicationDate;
}

public String getWebTitle() {
return webTitle;
}

public void setWebTitle(String webTitle) {
this.webTitle = webTitle;
}

public String getWebUrl() {
return webUrl;
}

public void setWebUrl(String webUrl) {
this.webUrl = webUrl;
}

public String getApiUrl() {
return apiUrl;
}

public void setApiUrl(String apiUrl) {
this.apiUrl = apiUrl;
}

public Fields getFields() {
return fields;
}

public void setFields(Fields fields) {
this.fields = fields;
}

public Boolean getIsHosted() {
return isHosted;
}

public void setIsHosted(Boolean isHosted) {
this.isHosted = isHosted;
}

public String getPillarId() {
return pillarId;
}

public void setPillarId(String pillarId) {
this.pillarId = pillarId;
}

public String getPillarName() {
return pillarName;
}

public void setPillarName(String pillarName) {
this.pillarName = pillarName;
}

}
-----------------------------------com.example.zikstar.guardnews.Section.java-----------------------------------

package com.example.zikstar.guardnews;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Section {

@SerializedName("id")
@Expose
private String id;
@SerializedName("webTitle")
@Expose
private String webTitle;
@SerializedName("webUrl")
@Expose
private String webUrl;
@SerializedName("apiUrl")
@Expose
private String apiUrl;
@SerializedName("editions")
@Expose
private List<Edition_> editions = null;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getWebTitle() {
return webTitle;
}

public void setWebTitle(String webTitle) {
this.webTitle = webTitle;
}

public String getWebUrl() {
return webUrl;
}

public void setWebUrl(String webUrl) {
this.webUrl = webUrl;
}

public String getApiUrl() {
return apiUrl;
}

public void setApiUrl(String apiUrl) {
this.apiUrl = apiUrl;
}

public List<Edition_> getEditions() {
return editions;
}

public void setEditions(List<Edition_> editions) {
this.editions = editions;
}

}*/
}
