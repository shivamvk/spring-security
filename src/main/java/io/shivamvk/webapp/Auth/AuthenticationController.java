package io.shivamvk.webapp.Auth;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import io.shivamvk.webapp.User.*;

@Controller
public class AuthenticationController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value="/login")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@GetMapping(value="/register")
	public ModelAndView register() {
		ModelAndView modelAndView = new ModelAndView();
		UserModel user = new UserModel();
		modelAndView.addObject("userModel", user);
		modelAndView.setViewName("register");
		return modelAndView;
	}
	
	@GetMapping(value="/home")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home");
		return modelAndView;
	}
	
	@PostMapping(value="/register")
	public ModelAndView register(@Valid UserModel user, BindingResult bindingResult, ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView();
		if(bindingResult.hasErrors()) {
			modelAndView.addObject("successMessage", "Please correct the errors and submit again");
			modelMap.addAttribute("bindingResult", bindingResult);
			modelAndView.setViewName("register");
			return modelAndView;
		} else if(userService.userWithSameEmailExists(user)) {
			modelAndView.addObject("successMessage", "Email already exists");
			modelAndView.setViewName("register");
			return modelAndView;
		} else if(userService.userWithSamePhoneExists(user)) {
			modelAndView.addObject("successMessage", "Phone already exists");
			modelAndView.setViewName("register");
			return modelAndView;
		} else {
			userService.registerNewUser(user);
			modelAndView.setViewName("login");
			return modelAndView;
		}
	}
	
}
