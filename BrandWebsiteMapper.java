package com.sekorm.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sekorm.common.beans.Page;
import com.sekorm.core.model.BrandWebsite;

public interface BrandWebsiteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BrandWebsite record);

    int insertSelective(BrandWebsite record);

    BrandWebsite selectByPrimaryKey(Integer id);
    
    BrandWebsite selectByIdNameWebsite(@Param("id")String id,@Param("name")String name,@Param("website")String website);
    
    List<BrandWebsite> getAllValidList(@Param("websiteType")Integer websiteType);
    
    Page<BrandWebsite> getPageList(Page<BrandWebsite> page,@Param("brandCode")Integer brandCode,@Param("name")String name, @Param("statuss")int statuss[],@Param("sortColumn")String sortColumn,@Param("sort")String sort);

    List<BrandWebsite> getListByWebsiteType(@Param("websiteType")Integer websiteType);
    
    int updateByPrimaryKeySelective(BrandWebsite record);

    int updateByPrimaryKey(BrandWebsite record);
}
