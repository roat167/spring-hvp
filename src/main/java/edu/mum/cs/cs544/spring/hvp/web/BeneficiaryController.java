package edu.mum.cs.cs544.spring.hvp.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.cs.cs544.spring.hvp.data.dao.BeneficiaryDao;
import edu.mum.cs.cs544.spring.hvp.data.domain.Beneficiary;
import edu.mum.cs.cs544.spring.hvp.data.domain.User;

@Controller
@RequestMapping("/beneficiary")
public class BeneficiaryController {
	@Resource
	private BeneficiaryDao beneficiaryDao;

	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("beneficiary", new User());
		model.addAttribute("beneficiaries", beneficiaryDao.findAll());
		return "beneficiaryList";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addOrUpdate(@ModelAttribute("beneficiary") Beneficiary b) {
		if (b.getId() == null) {
			// new user, add it
			this.beneficiaryDao.save(b);
		} else {
			// existing, call update
			this.beneficiaryDao.save(b);
		}
		return "redirect:/beneficiaryDetail";

	}

	@RequestMapping("/remove/{id}")
	public String remove(@PathVariable("id") int id) {

		this.beneficiaryDao.delete(id);
		return "redirect:/beneficiaryList";
	}

	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
		model.addAttribute("beneficiary", this.beneficiaryDao.findOne(id));
		model.addAttribute("beneficiaries", this.beneficiaryDao.findAll());
		return "beneficiaryDetail";
	}
}
