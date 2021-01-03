package com.lu.schoolShop.service.impl;

import com.lu.schoolShop.dao.AreaDao;
import com.lu.schoolShop.entity.Area;
import com.lu.schoolShop.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//告诉springIOC，AreaServiceImpl是需要托管的，别的类调用AreaService时，会将AreaServiceImpl注入到接口
@Service
public class AreaServiceImpl implements AreaService {
    //spring容器在程序运行时，自动将dao的实现注入
    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }
}
