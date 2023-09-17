package com.example.wxqserver_sb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.wxqserver_sb.pojo.Pic;
import com.example.wxqserver_sb.pojo.Poi;

import java.util.List;

public interface IPoiService extends IService<Poi> {
    void saveMain(Poi poi, List<Pic> pics);
    void deleteMain(Integer id);
    void updateMain(Poi poi, List<Pic> pics);
}
