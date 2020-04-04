package lopputyo.sovellus.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

import lopputyo.sovellus.domain.Premise;
import lopputyo.sovellus.domain.PremiseRepository;
import lopputyo.sovellus.domain.TypeRepository;

@Controller

public class SovellusApplicationController {

	@Autowired
	private PremiseRepository prepository;
	
	@Autowired
	private TypeRepository trepository;
	
	//Login sivu
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	

	//kaikki kiinteistöt, vain admin
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value= {"/all"})
	public String premises(Model model, Premise premise) {
		model.addAttribute("premises", prepository.findAll() );
		return "all";
	}
	
	//myynnissä olevat kiinteistöt, kaikille
	@RequestMapping(value= {"/premises", "/index", "/"})
	public String premisesSold(Model model) {
		model.addAttribute("premises", prepository.findByMyynnissa(1));
		return "premises";
	}

	
	
	//lisää tuote, vain admin
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping(value="/add" ) 
	public String addPremise(Model model) {
		model.addAttribute("premise", new Premise());
		model.addAttribute("types", trepository.findAll());
		return "add";
	}
	
	//poista kokonaan, vain admin
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/delete/{id}")
	public String delete(@PathVariable ("id") Long premiseId, Model model) {
		prepository.deleteById(premiseId);
		return "redirect:../all";
	}
	
	//poista myynnistä, vain admin
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/deletesold/{id}")
	public String deleteSold(@PathVariable ("id") Long premiseId, Model model) {
		Premise premise = prepository.findById(premiseId).get();
		System.out.println(premise.getDescription());
		premise.setMyynnissa(0);
		prepository.save(premise);
		return "redirect:../premises";
	}
	
	//muokkaa, vain admin
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping(value = "/edit/{id}")
	public String edit(@PathVariable ("id") Long premiseId, Model model) {
		Premise premise = prepository.findById(premiseId).get();
		model.addAttribute("premise", premise);
		model.addAttribute("types", trepository.findAll());
		return "edit";
	}
	
	
	//tallenna ja validoi, vain admin
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="save",  method= RequestMethod.POST) 
    public String save(@Valid Premise premise, BindingResult bindingResult, Model model){
		
        if (bindingResult.hasErrors()) {
        	model.addAttribute("types", trepository.findAll());
        	return "add";
        }
			 else {
				prepository.save(premise);
			}
        return "redirect:premises"; 
    }   
	
	
	//tallenna muutos ja validoi, vain admin
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="saveEdit",  method= RequestMethod.POST) 
    public String saveEdit(@Valid Premise premise, BindingResult bindingResult, Model model){
		
        if (bindingResult.hasErrors()) {
        	model.addAttribute("types", trepository.findAll());
        	return "edit";
        }
			 else {
				prepository.save(premise);
			}
        return "redirect:premises"; 
    } 
	
	
	
}
