package edu.mum.cs.cs544.spring.hvp.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.cs.cs544.spring.hvp.data.dao.ProjectDao;
import edu.mum.cs.cs544.spring.hvp.data.domain.Project;
import edu.mum.cs.cs544.spring.hvp.exception.NoSuchResourceException;

@Controller
// @RequestMapping(value="/projects")
public class ProjectController {
	@Resource
	private ProjectDao projectDao;

	@RequestMapping(value = "/projects", method = RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("projects", projectDao.findAll());
		model.addAttribute("project", new Project());		
		System.out.println("ProjectController getAll() " + projectDao.findAll().size());
		return "projectList";
	}

	@RequestMapping(value = "/projects/add", method = RequestMethod.POST)
	public String addOrUpdate(@ModelAttribute("project") Project p) {
		try {
			if (p.getId() == null) {
				// new add it
				this.projectDao.save(p);
			} else {
				// existing , call update
				this.projectDao.update(p);
			}
		} catch(Exception e) {
			
		}
		return "redirect:/projects/u/" + p.getId();
		//return "projectDetail";

	}
	
	@RequestMapping(value = "/projects/add", method = RequestMethod.GET)
	public String detailPage(@ModelAttribute("project") Project p) {
		
		//return "redirect:/projects/add";
		return "projectDetail";
	}

	@RequestMapping(value = "/projects/u/{id}", method = RequestMethod.GET)
	public String get(@PathVariable Long id, Model model) {
		model.addAttribute("project", projectDao.findOne(id));
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
