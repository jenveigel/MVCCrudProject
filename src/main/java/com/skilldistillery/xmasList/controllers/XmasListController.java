package com.skilldistillery.xmasList.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.xmasList.data.XmasList;
import com.skilldistillery.xmasList.data.XmasListDAO;

@Controller
@SessionAttributes({"giftsToBuy", "giftsPurchased"})
public class XmasListController {
	
	@Autowired
	XmasListDAO dao;
	
	@ModelAttribute("giftsToBuy")
	public XmasList newXmasList() {
		return new XmasList();
	}
	
	@RequestMapping(path="details.do")
	public ModelAndView getXmasListById(@RequestParam("xmasListId") Integer id) {
		ModelAndView mv = new ModelAndView("details");
		XmasList toBuy = dao.getXmasListById(id);
		mv.addObject("giftsToBuy", toBuy);
		return mv;
	}
	
	@RequestMapping(path="delete.do")
	public ModelAndView delete(@RequestParam("id") Integer id) {
		ModelAndView mv = new ModelAndView("deleted");
		
		XmasList toBuy = dao.getXmasListById(id);
		mv.addObject("name", toBuy.getRecipient());
		dao.deleteXmasList(toBuy);
		
		return mv;
	}
	
	@RequestMapping(path = "index.do", method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	
}
