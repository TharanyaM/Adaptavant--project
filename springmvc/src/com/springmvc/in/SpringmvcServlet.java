package com.springmvc.in;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class SpringmvcServlet{
 
@RequestMapping("/hello")
public ModelAndView helloWorld() {
 
   String message =  "Welcome to all";
   message += "<br>You Did it....!";
 
   return new ModelAndView("welcomePage", "welcomeMessage", message);
}//ModelAndView closed
 
}
