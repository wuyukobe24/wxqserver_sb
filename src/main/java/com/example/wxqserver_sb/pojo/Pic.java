package com.example.wxqserver_sb.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("pic_table")
public class Pic {
    private Integer id;
    private Integer poiId;
    private String imgUrl;
}
