package com.example.wxqserver_sb.form;

import com.example.wxqserver_sb.pojo.Pic;
import lombok.Data;

import java.util.List;

@Data
public class PoiForm {
    private Integer id;
    private String name;
    private String age;
    private String description;
    private Float lng;
    private Float lat;
    private String coverUrl;
    private List<Pic> pics;
}
