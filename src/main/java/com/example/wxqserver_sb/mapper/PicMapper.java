package com.example.wxqserver_sb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.wxqserver_sb.pojo.Pic;
import org.apache.ibatis.annotations.Param;

public interface PicMapper extends BaseMapper<Pic> {
    int deleteByPoiId(@Param("poiId") int poiId);
}
