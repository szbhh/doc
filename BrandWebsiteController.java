package com.controller;

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





@Controller
@RequestMapping("/bsite")
public class BController extends MainController{
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired	
	private BService bService;	
	

	
    @RequestMapping(value = "/main")
    public Object main(HttpServletRequest request, HttpServletResponse response) {
        return "/brandwebsite/brandwebsite";
    }
  
 
	@RequestMapping("/edit")
	public String toAddOrUpdatePage(String id,HttpServletRequest request) {			
		if (StringUtils.isNotEmpty(id)) {
			Bsite bsite=brandWebsiteService.selectByPrimaryKey(Integer.valueOf(id));	
			
				
			request.setAttribute("bsite", bsite);
			
		}
		return "/bsite/editsite";
	}
}
