package com.lu.schoolShop.dao;

import com.lu.schoolShop.entity.Shop;

public interface ShopDao {
    int insertShop(Shop shop);
    int updateShop(Shop shop);
}
