package com.example.wxqserver_sb.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

// 和数据库名称 poi_table 保持一致
@Data // 自动添加setter和getter方法
@TableName("poi_table")
public class  Poi {
    public Integer id;
    public String name;
    public String age;
    public String description;
    public Float lng;
    public Float lat;
    public String coverUrl;
}
