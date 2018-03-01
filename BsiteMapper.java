package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;



public interface BsiteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BrandWebsite record);

    int insertSelective(BrandWebsite record);

    Bsite selectByPrimaryKey(Integer id);
    
   
    List<Bsite> getListBysiteType(@Param("siteType")Integer type);
    
    int updateByPrimaryKeySelective(Bsite record);

    int updateByPrimaryKey(Bsite record);
}
