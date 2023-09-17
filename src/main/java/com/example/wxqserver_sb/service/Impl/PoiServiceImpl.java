package com.example.wxqserver_sb.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.wxqserver_sb.exception.PoiException;
import com.example.wxqserver_sb.mapper.PicMapper;
import com.example.wxqserver_sb.mapper.PoiMapper;
import com.example.wxqserver_sb.pojo.Pic;
import com.example.wxqserver_sb.pojo.Poi;
import com.example.wxqserver_sb.service.IPoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoiServiceImpl extends ServiceImpl<PoiMapper, Poi> implements IPoiService {

    @Autowired
    private PoiMapper poiMapper;
    @Autowired
    private PicMapper picMapper;
    @Override
    public void saveMain(Poi poi, List<Pic> pics) {
        int row = poiMapper.insert(poi);
        if (row == 0) {
            throw PoiException.OperateFail();
        }
        if (pics != null) {
            for (Pic pic : pics) {
                pic.setPoiId(poi.getId());
                row = picMapper.insert(pic);
                if (row == 0) {
                    throw PoiException.OperateFail();
                }
            }
        }
    }

    @Override
    public void deleteMain(Integer id) {
        int row = poiMapper.deleteById(id);
        if (row == 0) {
            throw PoiException.OperateFail();
        }
        row = picMapper.deleteByPoiId(id);
        if (row == 0) {
            throw PoiException.OperateFail();
        }
    }

    @Override
    public void updateMain(Poi poi, List<Pic> pics) {
        int row = poiMapper.updateById(poi);
        if (row == 0) {
            throw PoiException.OperateFail();
        }
        picMapper.deleteByPoiId(poi.getId());
        if (pics != null) {
            for (Pic pic : pics) {
                pic.setPoiId(poi.getId());
                row = picMapper.insert(pic);
                if (row == 0) {
                    throw PoiException.OperateFail();
                }
            }
        }
    }
}
