package org.oguz.spring.web.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.oguz.spring.web.model.Offer;
import org.oguz.spring.web.service.OffersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OffersController
{
	private OffersService offersService;


	@Autowired
	public void setOffersService(OffersService offersService)
	{
		this.offersService = offersService;
	}


	// mapping root (/localhost:8080/SpringMVC/) url to home.jsp
	@RequestMapping(("/"))
	public String showHome(HttpSession session)
	{
		session.setAttribute("name", "OguzHan");
		return "home";
	}


	/*
	 * mapping '/localhost:8080/SpringMVC/hello' url to helloworld.jsp
	 * 
	 * here is the two way for set variables to request context and use them in helloworld.jsp page.
	 */

	
	@RequestMapping("/offers")
	public String showHello(Model model)
	{
		List<Offer> offers = offersService.getCurrent();
		
		model.addAttribute("offers", offers);

		return "offers";
	}
	/*
	 * @RequestMapping(("/hello")) public ModelAndView showHello(){
	 * 
	 * ModelAndView mv = new ModelAndView("helloworld");
	 * 
	 * Map<String, Object> model = mv.getModel();
	 * 
	 * model.put("name", "Oguz");
	 * 
	 * 
	 * return mv; }
	 */


}
