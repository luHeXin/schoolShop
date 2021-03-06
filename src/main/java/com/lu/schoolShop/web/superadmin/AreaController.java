package com.lu.schoolShop.web.superadmin;

import com.lu.schoolShop.entity.Area;
import com.lu.schoolShop.service.AreaService;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Controller
@RequestMapping("/superadmin")
public class AreaController {
//    Logger logger= (Logger) LoggerFactory.getLogger(AreaController.class);

    @Autowired//用到areaService时，自动注入其实现类
    private AreaService areaService;

    @RequestMapping(value = "/listarea",method = RequestMethod.GET)//get的传插会反映到url中
    @ResponseBody//将modelMap转换为json对象，返回给前端
    private Map<String,Object> listArea(){
//        logger.info("====start====");
        long startTime=System.currentTimeMillis();
        Map<String,Object> modelMap=new HashMap<String,Object>();
        List<Area> list=new ArrayList<Area>();
        try {
            list=areaService.getAreaList();
            modelMap.put("rows",list);
            modelMap.put("total",list.size());
        }catch (Exception e){
            e.printStackTrace();
            modelMap.put("success",false);
            modelMap.put("errMsg",e.toString());
        }
        long endTime=System.currentTimeMillis();
//        logger.info("====end====");
        return modelMap;
    }
}
