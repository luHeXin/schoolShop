package com.lu.schoolShop.dao;

import com.lu.schoolShop.BaseTest;
import com.lu.schoolShop.entity.Area;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AreaDaoTest extends BaseTest{//继承BaseTest加载spring-dao配置文件
    @Autowired
    private AreaDao areaDao;

    @Test
    public void testQueryArea(){
        List<Area> areaList=areaDao.queryArea();
        Assert.assertEquals(3,areaList.size());
    }

}
