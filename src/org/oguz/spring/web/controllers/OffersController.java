package org.oguz.spring.web.controllers;

import java.util.List;

import javax.validation.Valid;

import org.oguz.spring.web.model.Offer;
import org.oguz.spring.web.service.OffersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
		//offersService.throwException();
		List<Offer> offers = offersService.getCurrent();

		model.addAttribute("offers", offers);

		return "offers";
	}

	@RequestMapping("/createoffer")
	public String createOffer(Model model)
	{
		model.addAttribute("offer", new Offer());	

		return "createoffer";
	}

	@RequestMapping(value = "/docreate", method = RequestMethod.POST)
	public String doCreate(Model model, @Valid Offer offer, BindingResult result)
	{
		if (result.hasErrors())
		{
			
			List<ObjectError> errors = result.getAllErrors();
			model.addAttribute("errors", errors);

			/*for (ObjectError error : errors)
			{
				System.out.println(error.getDefaultMessage());
			}*/

			return "createoffer";
		}
		else
		{
			offersService.createOffer(offer);
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
