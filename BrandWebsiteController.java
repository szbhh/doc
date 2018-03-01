package com.sekorm.das.controller;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sekorm.common.beans.DataReturn;
import com.sekorm.common.beans.Page;
import com.sekorm.common.das.security.SecurityUtils;
import com.sekorm.common.das.security.vo.User;
import com.sekorm.common.util.WebUtils;
import com.sekorm.core.common.Constants;
import com.sekorm.core.model.BrandWebsite;
import com.sekorm.core.model.BrandWebsiteRemark;
import com.sekorm.core.model.ExtendedDomain;
import com.sekorm.core.model.ExtendedDomainLog;
import com.sekorm.core.service.BrandWebsiteService;
import com.sekorm.core.service.ExtendedDomainLogService;
import com.sekorm.core.service.ExtendedDomainService;



@Controller
@RequestMapping("/brandwebsite")
public class BrandWebsiteController extends MainController{
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired	
	private BrandWebsiteService brandWebsiteService;	
	@Autowired	
	private ExtendedDomainService extendedDomainService;
	@Autowired	
	private ExtendedDomainLogService extendedDomainLogService;

	
    @RequestMapping(value = "/main")
    public Object main(HttpServletRequest request, HttpServletResponse response) {
        return "/brandwebsite/brandwebsite";
    }
  
 
	@RequestMapping("/edit")
	public String toAddOrUpdatePage(String id,HttpServletRequest request) {			
		if (StringUtils.isNotEmpty(id)) {
			BrandWebsite brandWebsite=brandWebsiteService.selectByPrimaryKey(Integer.valueOf(id));	
			if(null != brandWebsite) {
				String brandName = "";
	    		if(null != brandWebsite.getBrandCode()) {
	    			brandName = brandWebsiteService.getBrandName(brandWebsite.getBrandCode());
	    		}
				brandWebsite.setBrandName(brandName);
				request.setAttribute("brandWebsite", brandWebsite);
			}
		}
		return "/brandwebsite/editbrandwebsite";
	}
}
