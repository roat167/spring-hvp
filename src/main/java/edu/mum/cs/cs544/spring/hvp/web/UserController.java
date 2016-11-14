package edu.mum.cs.cs544.spring.hvp.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.cs.cs544.spring.hvp.data.dao.UserDao;
import edu.mum.cs.cs544.spring.hvp.data.domain.User;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserDao userDao;

	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("users", userDao.findAll());
		System.out.println(userDao.findAll());
		return "userList";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addOrUpdate(@ModelAttribute("user") User u) {
		if (u.getId() == null) {
			// new user, add it
			this.userDao.save(u);
		} else {
			// existing user, call update
			this.userDao.save(u);
		}
		return "redirect:/userDetail";

	}

	@RequestMapping("/remove/{id}")
	public String remove(@PathVariable("id") int id) {

		this.userDao.delete(id);
		return "redirect:/userList";
	}

	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
		model.addAttribute("user", this.userDao.findOne(id));
		model.addAttribute("users", this.userDao.findAll());
		return "userDetail";
	}
}
