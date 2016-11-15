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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.cs.cs544.spring.hvp.data.dao.ProjectDao;
import edu.mum.cs.cs544.spring.hvp.data.domain.Project;
import edu.mum.cs.cs544.spring.hvp.exception.NoSuchResourceException;

@Controller
// @RequestMapping(value="/projects")
public class ProjectController {
	private static final String MODEL_ATTRIBUTE = "project";
	@Resource
	private ProjectDao projectDao;
	
	@RequestMapping(value = "/projects", method = RequestMethod.GET)
	public String getAll(Model model, @ModelAttribute("project") Project p) {
		model.addAttribute("projects", projectDao.findAll());
		if (p.getId() == null) { 
			p = new Project();
		}
		model.addAttribute("project", p);		
		System.out.println("ProjectController getAll() " + p.getId());
		return "projectList";
	}

	@RequestMapping(value = "/projects/add", method = RequestMethod.POST)
	public String addOrUpdate(@ModelAttribute(MODEL_ATTRIBUTE) Project p, final RedirectAttributes redirectAtt) {
		try {
			p.setBeneficiary(null);;
			p.setSkill(null);
			if (p.getTask() != null && p.getTask().getName() != null) {
				p.getTaskList().add(p.getTask());
			} else {
				p.setTask(null);
			}
			if (p.getId() == null) {
				// new add it
				redirectAtt.addFlashAttribute("msg", "Save Successfully");
			} else {
				// existing , call update
				redirectAtt.addFlashAttribute("msg", "Update Successfully");
			}
			this.projectDao.save(p);
		} catch(Exception e) {
			
		}
		return "redirect:/projects/u/" + p.getId();
		//return "projectDetail";

	}
	
	@RequestMapping(value = "/projects/add", method = RequestMethod.GET)
	public String detailPage(@ModelAttribute(MODEL_ATTRIBUTE) Project p) {
		
		//return "redirect:/projects/add";
		return "projectDetail";
	}

	@RequestMapping(value = "/projects/u/{id}", method = RequestMethod.GET)
	public String get(@PathVariable Long id, Model model, @ModelAttribute(MODEL_ATTRIBUTE) Project p) {
		model.addAttribute(MODEL_ATTRIBUTE, projectDao.findOne(id));
		return "projectDetail";
	}	

	@RequestMapping(value = "/projects/remove", method = RequestMethod.POST)
	public String remove(Project project, Long id) {
		projectDao.delete(id);
		return "redirect:/projects";
	}

	@ExceptionHandler(value = NoSuchResourceException.class)
	public ModelAndView handle(Exception e) {
		ModelAndView mv = new ModelAndView();
		mv.getModel().put("e", e);
		mv.setViewName("noSuchResource");
		return mv;
	}
	
//	@RequestMapping(value = "/projects/addtask", method = RequestMethod.POST)
//	public String addTask(Project project) {		
//		if (project != null && project.getTask() != null) {
//			
//		}
//		return "";
//	}

}
