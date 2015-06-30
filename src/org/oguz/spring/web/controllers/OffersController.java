package org.oguz.spring.web.controllers;

import java.security.Principal;
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
import org.springframework.web.bind.annotation.RequestParam;

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
		// offersService.throwException();
		List<Offer> offers = offersService.getCurrent();

		model.addAttribute("offers", offers);

		return "offers";
	}

	@RequestMapping("/createoffer")
	public String createOffer(Model model, Principal principal)
	{
		Offer offer = null;
		if (principal != null)
		{
			String username = principal.getName();
			offer = offersService.getOffer(username);
		}
		if (offer == null)
		{
			offer = new Offer();
		}

		model.addAttribute("offer", offer);

		return "createoffer";
	}


	@RequestMapping(value = "/docreate", method = RequestMethod.POST)
	public String doCreate(Model model, @Valid Offer offer, BindingResult result,
		Principal principal,@RequestParam(value="delete", required=false) String delete)
	{
		if (result.hasErrors())
		{
			List<ObjectError> errors = result.getAllErrors();
			model.addAttribute("errors", errors);
			/*
			 * for (ObjectError error : errors) { System.out.println(error.getDefaultMessage()); }
			 */
			return "createoffer";
		}	
			if(delete == null){
				String username = principal.getName();
				offer.getUser().setUsername(username);
				offersService.saveOrUpdateOffer(offer);
				return "redirect:offers";
			}else{
				offersService.delete(offer.getId());
				return  "offerdeleted";
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
