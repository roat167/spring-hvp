package edu.mum.cs.cs544.spring.hvp.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.cs.cs544.spring.hvp.data.dao.UserDao;
import edu.mum.cs.cs544.spring.hvp.data.domain.User;

@Controller
public class LoginController {
	@Resource
	UserDao userDao;

	@RequestMapping(value="/")
	public String indexRoot(HttpServletRequest req) {
		if (req.getSession().getAttribute("loginUser") != null) {
			return "dashboard";
		}
		return "index";
	}
	
	@RequestMapping("/login")	
	private String getAuthenticateUser(String username, String password, Model model, HttpServletRequest req) {
		User user = userDao.getUserByUsernameAndPassword(username, password);
		model.addAttribute("loginUser", user);
		req.getSession().setAttribute("loginUser", user);
		return "dashboard";
	}
	
	/**
	 * Hack code
	 * need to remove after implements security 
	 */
	@RequestMapping("/home")	
	private String goToDashboard() {
		return "dashboard";
	}
	
}
