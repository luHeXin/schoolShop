package com.lu.schoolShop.service;

import com.lu.schoolShop.BaseTest;
import com.lu.schoolShop.entity.Area;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AreaServiceTest extends BaseTest {
    @Autowired
    private AreaService areaService;//因为在实现类中标注了@service，所以会注入实现类
    @Test
    public void testGetAreaList(){
        List<Area> areaList=areaService.getAreaList();//调用dao层返回的数值
        Assert.assertEquals("西苑",areaList.get(0).getAreaName());
    }
}
