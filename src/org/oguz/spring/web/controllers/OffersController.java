package org.oguz.spring.web.controllers;

import java.util.List;
import javax.validation.Valid;

import org.oguz.spring.web.model.Offer;
import org.oguz.spring.web.service.OffersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OffersController
{
	private OffersService offersService;


	@Autowired
	public void setOffersService(OffersService offersService)
	{
		this.offersService = offersService;
	}


	@RequestMapping("/offers")
	public String showOffers(Model model)
	{
		List<Offer> offers = offersService.getCurrent();

		model.addAttribute("offers", offers);

		return "offers";
	}

	@RequestMapping("/createoffer")
	public String createOffer()
	{


		return "createoffer";
	}

	@RequestMapping(value = "/docreate", method = RequestMethod.POST)
	public String doCreate(Model model, @Valid Offer offer, BindingResult result)
	{
		if (result.hasErrors())
		{
			System.out.println("form doesnt validate.");
			List<ObjectError> errors = result.getAllErrors();
			model.addAttribute("errors", errors);

			for (ObjectError error : errors)
			{
				System.out.println(error.getDefaultMessage());
			}

			return "error";
		}
		else
		{
			System.out.println("form validated");
			return "offercreated";
		}


	}

	/*
	 * mapping '/localhost:8080/SpringMVC/hello' url to helloworld.jsp
	 * 
	 * here is the two way for set variables to request context and use them in helloworld.jsp page.
	 */

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
