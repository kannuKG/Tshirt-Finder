package com.nagarro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.FileWatcher.FileWatcher;
import com.nagarro.model.Tshirts;
import com.nagarro.service.FindService;
import com.opencsv.exceptions.CsvValidationException;

@Controller
public class FindController {
	
	@Autowired
	FindService findService;
	
	@RequestMapping("/find")
	public ModelAndView find(HttpServletRequest req,HttpServletRequest resp) throws CsvValidationException, IOException {
		ModelAndView mv=new ModelAndView();
		String clr=req.getParameter("color");
		String size=req.getParameter("size");
		String gen=req.getParameter("gender");
		String sortBy=req.getParameter("preference");
		findService.readData();
		FileWatcher watcher=new FileWatcher();
		watcher.run();
		Thread thread=new Thread(watcher);
		thread.start();
		List<Tshirts> searchResult=findService.getSearchResult(clr,size,gen,sortBy);
		//searchResult.forEach(x -> System.out.println(x.display()));
		mv.addObject("result",searchResult);
		mv.setViewName("SearchTable.jsp");
		return mv;
	}
}
