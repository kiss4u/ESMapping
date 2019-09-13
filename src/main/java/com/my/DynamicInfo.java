package com.my;

import com.my.utils.ESMap;

/**
 * @author my
 * @create 2019/9/5
 * @Description:
 */
public class DynamicInfo {

    /**
     * 动态id
     */
    @ESMap(type = "keyword")
    private String dynamicId;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 动态类型
     */
    @ESMap(ignoreMalformed = true)
    private Integer dyType = 0;
    /**
     * 资源类型
     */
    private Integer fileType = 0;
    /**
     * 资源路径
     */
    @ESMap(type = "keyword")
    private String filePath = null;
    /**
     * 动态文本
     */
    @ESMap(type = "text")
    private String content = null;
    /**
     * 创建时间
     */
    @ESMap(dateFormat = "epoch_millis")
    private Long createTime;
    /**
     * 推荐度
     */
    @ESMap(ignoreMalformed = true)
    private Integer recommendNum = 0;
    /**
     * 点赞数
     */
    @ESMap(ignoreMalformed = true)
    private Integer likeNum = 0;
    /**
     * 阅读数
     */
    private Integer readNum = 0;
    /**
     * 话题id
     */
    @ESMap(ignoreMalformed = true)
    private Integer topicId;
    /**
     * 话题名称
     */
    @ESMap(type = "keyword")
    private String topicName;
    /**
     * 主题id
     */
    @ESMap(ignoreMalformed = true)
    private Integer themeId;

    /**
     * 活动id
     */
    @ESMap(ignoreMalformed = true)
    private Integer activityId;

    public DynamicInfo(String dynamicId, Long userId, Integer fileType, String filePath, String content) {
        this.dynamicId = dynamicId;
        this.userId = userId;
        this.fileType = fileType;
        this.filePath = filePath;
        this.content = content;
        this.createTime = System.currentTimeMillis();
        this.likeNum = 100;
        this.recommendNum = 200;
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

    public Integer getReadNum() {
        return readNum;
    }

    public void setReadNum(Integer readNum) {
        this.readNum = readNum;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public Integer getThemeId() {
        return themeId;
    }

    public void setThemeId(Integer themeId) {
        this.themeId = themeId;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }
}
