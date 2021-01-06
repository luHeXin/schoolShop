package com.lu.schoolShop.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.lu.schoolShop.cache.JedisUtil;
import com.lu.schoolShop.dao.ShopCategoryDao;
import com.lu.schoolShop.dto.ImageHolder;
import com.lu.schoolShop.dto.ShopCategoryExecution;
import com.lu.schoolShop.entity.ShopCategory;
import com.lu.schoolShop.enums.ShopCategoryStateEnum;
import com.lu.schoolShop.exceptions.ShopCategoryOperationException;
import com.lu.schoolShop.service.ShopCategoryService;
import com.lu.schoolShop.util.ImageUtil;
import com.lu.schoolShop.util.PathUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {

	@Autowired
	private ShopCategoryDao shopCategoryDao;

	@Override
	public List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition) {
		// 定义redis的key前缀
		String key = SCLISTKEY;
		// 定义接收对象
		List<ShopCategory> shopCategoryList = null;
		// 定义jackson数据转换操作类
		ObjectMapper mapper = new ObjectMapper();
		// 拼接出redis的key
		if (shopCategoryCondition == null) {
			// 若查询条件为空，则列出所有首页大类，即parentId为空的店铺类别
			key = key + "_allfirstlevel";
		} else if (shopCategoryCondition != null && shopCategoryCondition.getParent() != null
				&& shopCategoryCondition.getParent().getShopCategoryId() != null) {
			// 若parentId为非空，则列出该parentId下的所有子类别
			key = key + "_parent" + shopCategoryCondition.getParent().getShopCategoryId();
		} else if (shopCategoryCondition != null) {
			// 列出所有子类别，不管其属于哪个类，都列出来
			key = key + "_allsecondlevel";
		}

		return shopCategoryDao.queryShopCategory(shopCategoryCondition);
	}

	@Override
	public ShopCategoryExecution addShopCategory(ShopCategory shopCategory, ImageHolder thumbnail) {
		return null;
	}

	@Override
	public ShopCategoryExecution modifyShopCategory(ShopCategory shopCategory, ImageHolder thumbnail) {
		return null;
	}

	@Override
	public ShopCategory getShopCategoryById(Long shopCategoryId) {
		return null;
	}
}
