# ESMapping

------------

### 1. 注解添加

``` Java
    @ESMap(type = "text", ignoreAbove = 400)
    private String content = null;

    @ESMap(dateFormat = "epoch_millis")
    private Long createTime;
    
    @ESMap(ignore = true)
    private String mark1;
``` 

### 2. 转化输出

    [main] INFO com.my.utils.ESMapUtil - {"properties":{"dynamicId":{"type":"keyword"},"createTime":{"format":"epoch_millis","type":"date"},"filePath":{"type":"keyword"},"dyType":{"type":"integer"},"recommendNum":{"type":"integer"},"userId":{"type":"long"},"fileType":{"type":"integer"},"content":{"type":"text","fields":{"keyword":{"ignore_above":256,"type":"keyword"}}},"likeNum":{"type":"integer"}}}
    
    
### 3. 注解参数

| 参数 | 类型 | 默认值 | 备注 | 
| :----- | :----- | :------| :------ |
| ignore | boolean  |  false |是否忽略 | 
| type | String  | | ES类型  | 
| analyzer | String |  | 分词器 |  
| analyzerSearch | String|   | 搜索分词器  | 
| ignoreAbove | int| 256 | 超过该长度不写入索引 |
| dateFormat | String |  | 日期类型格式化 |
| ...... |  |  |  |
