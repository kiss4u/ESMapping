package com.my;

import com.my.utils.ESMap;

/**
 * @author my
 * @create 2019/9/5
 * @Description:
 */
public class DynamicInfo {

    @ESMap(type = "keyword")
    private String dynamicId;

    private Long userId;

    private Integer dyType = 0;

    private Integer fileType = 0;

    private String filePath = null;

    @ESMap(type = "text", ignoreAbove = 400)
    private String content = null;

    @ESMap(dateFormat = "epoch_millis")
    private Long createTime;

    private Integer recommendNum = 0;

    private Integer likeNum = 0;

    @ESMap(ignore = true)
    private String mark1;

    public DynamicInfo(String dynamicId, Long userId, Integer fileType, String filePath, String content) {
        this.dynamicId = dynamicId;
        this.userId = userId;
        this.fileType = fileType;
        this.filePath = filePath;
        this.content = content;
        this.createTime = System.currentTimeMillis();
        this.likeNum = 100;
        this.recommendNum = 200;
        this.mark1 = "22";
    }

    public String getDynamicId() {
        return dynamicId;
    }

    public void setDynamicId(String dynamicId) {
        this.dynamicId = dynamicId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getDyType() {
        return dyType;
    }

    public void setDyType(Integer dyType) {
        this.dyType = dyType;
    }

    public Integer getFileType() {
        return fileType;
    }

    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Integer getRecommendNum() {
        return recommendNum;
    }

    public void setRecommendNum(Integer recommendNum) {
        this.recommendNum = recommendNum;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }
}
