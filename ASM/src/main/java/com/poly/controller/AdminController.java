package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	  @RequestMapping("/admin")
	    public String index() {
	        return "admin/_order";
	    }
	  @RequestMapping("/admin/account")
	    public String index1() {
	        return "admin/_account";
	    }
	  @RequestMapping("/admin/category")
	    public String index2() {
	        return "admin/_category";
	    }
	  @RequestMapping("/admin/product")
	    public String index3() {
	        return "admin/_adproduct";
	    }
	  @RequestMapping("/admin/orderdetail")
	    public String index4() {
	        return "admin/_category";
	    }
}
