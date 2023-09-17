package com.example.wxqserver_sb.controllers;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.wxqserver_sb.exception.PoiException;
import com.example.wxqserver_sb.form.PoiForm;
import com.example.wxqserver_sb.pojo.Pic;
import com.example.wxqserver_sb.pojo.Poi;
import com.example.wxqserver_sb.service.IPicService;
import com.example.wxqserver_sb.service.IPoiService;
import com.example.wxqserver_sb.vo.PoiVo;
import com.example.wxqserver_sb.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@Slf4j
@RequestMapping("/poi")
public class PoiController  {

    @Autowired
    private IPoiService poiService;

    @Autowired
    private IPicService picService;

    // get请求第一种：以参数形式
    // RequestParam 标识设置默认值
    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        log.info("poi list pageNum={}, pageSize={}",pageNum,pageSize);

        Page<Poi> page = new Page<Poi>(pageNum, pageSize);
        IPage<Poi> pageResult = poiService.page(page);

        List voList = pageResult.getRecords().stream().map( poi -> {
            PoiVo poivo = new PoiVo();
            QueryWrapper query = new QueryWrapper();
            query.eq("poi_id", poi.getId());
            List<Pic> pics = picService.list(query);
            BeanUtils.copyProperties(poi, poivo);
            poivo.setPics(pics);
            return poivo;
        }).collect(Collectors.toList());

        pageResult.setRecords(voList);

        return Result.success(pageResult);
    }

    // get请求第二种：参数以路径形式
    @GetMapping("/detail/{id}")
    public Result detail(@PathVariable String id) {
        log.info("poi detail id = {}",id);

        PoiVo poivo = new PoiVo();
        Poi poi = poiService.getById(id);
        if (poi == null) {
            throw PoiException.NotFound();
        }
        QueryWrapper query = new QueryWrapper();
        query.eq("poi_id", poi.getId());
        List<Pic> pics = picService.list(query);
        BeanUtils.copyProperties(poi, poivo);
        poivo.setPics(pics);

        return Result.success(poivo);
    }

    // post 使用RequestBody接收参数
    @PostMapping("/add")
    public Result add(@RequestBody PoiForm poiForm) {
        log.info("poi add poi = {}",poiForm);

        Poi poi = new Poi();
        BeanUtils.copyProperties(poiForm, poi);
        poiService.saveMain(poi, poiForm.getPics());

        // 插入数据到数据库
//        poiService.save(poi);
        // 将生成的id返回出去
//        PoiVo poivo = new PoiVo();
//        BeanUtils.copyProperties(poi, poivo);
//        return Result.success(poivo);

        return detail(String.valueOf(poi.getId()));
    }

    // edit 使用RequestBody接收参数
    @PutMapping("/edit/{id}")
    public Result edit(@RequestBody PoiForm poiForm, @PathVariable int id) {
        log.info("poi edit poi = {}",poiForm);

        Poi poi = new Poi();
        BeanUtils.copyProperties(poiForm, poi);
        poi.setId(id);
        poiService.updateMain(poi, poiForm.getPics());
        return Result.success();
    }

    // deleta 参考get请求 参数以路径形式
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable String id) {
        log.info("poi delete id = {}",id);

        poiService.deleteMain(Integer.valueOf(id));
        return Result.success();
    }
}
