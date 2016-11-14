package edu.mum.cs.cs544.spring.hvp.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.cs.cs544.spring.hvp.data.dao.IProjectDao;
import edu.mum.cs.cs544.spring.hvp.data.domain.Project;
import edu.mum.cs.cs544.spring.hvp.exception.NoSuchResourceException;

@Controller
// @RequestMapping(value="/projects")
public class ProjectController {
	@Resource
	private IProjectDao projectDao;

	@RequestMapping(value = "/projects", method = RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("projects", projectDao.findAll());
		System.out.println("projects Get");
		return "projectList";
	}

	@RequestMapping(value = "/projects", method = RequestMethod.POST)
	public String addOrUpdate(Project project) {
		projectDao.save(project);
		System.out.println("projects Post");

		return "redirect:/projects";
	}

	@RequestMapping(value = "/projects/{id}", method = RequestMethod.GET)
	public String get(@PathVariable int id, Model model) {
		model.addAttribute("car", projectDao.findOne(id));
		return "projectDetail";
	}

	// @RequestMapping(value="/{id}", method=RequestMethod.POST)
	// public String update(Project project, @PathVariable int id) {
	// projectDao.update(id, project); // car.id already set by binding
	// return "redirect:/projects";
	// }

	@ExceptionHandler(value = NoSuchResourceException.class)
	public ModelAndView handle(Exception e) {
		ModelAndView mv = new ModelAndView();
		mv.getModel().put("e", e);
		mv.setViewName("noSuchResource");
		return mv;
	}

}
