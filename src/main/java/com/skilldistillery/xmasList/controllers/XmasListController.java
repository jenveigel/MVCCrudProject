package com.skilldistillery.xmasList.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
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
	
	@RequestMapping(path = "update.do", params="id")
	public ModelAndView update(@RequestParam("id") Integer id) {
		ModelAndView mv = new ModelAndView("update");
		XmasList toBuy = dao.getXmasListById(id);
		mv.addObject("xmasList", toBuy);
		return mv;
	}
	
	@RequestMapping(path="getXmasList.do", method=RequestMethod.POST)
	public ModelAndView getXmasListByIdForm(@Valid @ModelAttribute("idForm")XmasListIdForm xlif, Errors e) {
		ModelAndView mv = new ModelAndView("index2");
		if (e.hasErrors()) {
			mv.setViewName("index");
			return mv;
		}
		mv.setViewName("details");
		XmasList toBuy = dao.getXmasListById(xlif.getId());
		mv.addObject("xmasList", toBuy);	
		return mv;
	}
	
	public String index() {
		return "index";
	}
	
	@RequestMapping(path="home.do", method=RequestMethod.GET)
	public ModelAndView homeWithValidation() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		XmasListIdForm xlif = new XmasListIdForm();
		mv.addObject("idForm", xlif);
		
		List<XmasList> allLists = dao.getAllXmasLists();
		mv.addObject("list", allLists);
		return mv;
	}
	
	@RequestMapping(path="add.do", method=RequestMethod.GET)
	public String addXmasList(Model model) {
		XmasList xl = new XmasList();
		model.addAttribute("xmasList", xl);
		
		return "add";
	}
	
	@RequestMapping(path="addXmasList.do", method=RequestMethod.POST)
	public ModelAndView doAdd(@Valid XmasList xmasList, Errors e) {
		ModelAndView mv = new ModelAndView();
		if(e.hasErrors()) {
			mv.setViewName("add");
			return mv;
		}
		dao.addXmasList(xmasList);
		mv.setViewName("added");
		return mv;
	}
	
	@RequestMapping(path="updateXmasList.do", method=RequestMethod.POST)
	public ModelAndView doUpdate(@Valid XmasList xmasList, Errors e) {
		ModelAndView mv = new ModelAndView();
		if(e.hasErrors()) {
			mv.setViewName("update");
			return mv;
		}
		dao.updateXmasList(xmasList);
		mv.setViewName("added");
		return mv;
	}
	
}
