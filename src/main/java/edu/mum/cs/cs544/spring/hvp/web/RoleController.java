package edu.mum.cs.cs544.spring.hvp.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.cs.cs544.spring.hvp.data.dao.RoleDao;
import edu.mum.cs.cs544.spring.hvp.data.domain.Role;
import edu.mum.cs.cs544.spring.hvp.data.domain.User;

@Controller
@RequestMapping("/role")
public class RoleController {
	@Resource
	private RoleDao roleDao;

	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("role", new User());
		model.addAttribute("roles", roleDao.findAll());
		return "roleList";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addOrUpdate(@ModelAttribute("role") Role role) {
		if (role.getId() == null) {
			// new user, add it
			this.roleDao.save(role);
		} else {
			// existing user, call update
			this.roleDao.save(role);
		}
		return "redirect:/roleDetail";

	}

	@RequestMapping("/remove/{id}")
	public String remove(@PathVariable("id") int id) {

		this.roleDao.delete(id);
		return "redirect:/roleList";
	}

	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
		model.addAttribute("role", this.roleDao.findOne(id));
		model.addAttribute("roles", this.roleDao.findAll());
		return "roleDetail";
	}
}
