 package com.example.wxqserver_sb.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.wxqserver_sb.mapper.PicMapper;
import com.example.wxqserver_sb.pojo.Pic;
import com.example.wxqserver_sb.service.IPicService;
import org.springframework.stereotype.Service;

@Service
public class PicServiceImpl extends ServiceImpl<PicMapper, Pic> implements IPicService {
}
