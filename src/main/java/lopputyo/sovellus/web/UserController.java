package lopputyo.sovellus.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lopputyo.sovellus.domain.SignUpForm;
import lopputyo.sovellus.domain.User;
import lopputyo.sovellus.domain.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository urepository;
	
	@RequestMapping(value= "/signUp")
	public String newUser(Model model) {
		model.addAttribute("signUp", new SignUpForm());
		return "signup";
	}
	
	
	@PostMapping(value= "/saveuser")
	public String saveUser(@Valid @ModelAttribute("signUp") SignUpForm signup, BindingResult result) {
		if (!result.hasErrors()) { //jos ei ole virheitä
			if(signup.getPsw().equals(signup.getPswCheck())) {
				String salasana = signup.getPsw();
				BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
				String hashSalasana = bc.encode(salasana);
				
				User user = new User();
				user.setPasswordHash(hashSalasana);
				user.setUsername(signup.getUser());
				user.setRole(signup.getRole());
					if (urepository.findByUsername(signup.getUser()) == null) {
						urepository.save(user);
					} else {
						result.rejectValue("user", "user", "Käyttäjä tunnus on jo olemassa");
						return "signup";
					}
				
			} else {
				result.rejectValue("pswCheck", "err.pswCheck", "Salasanat eivät täsmää");
				return "signup";
			}
		} else {
			return "signup";
		}
		
		return "redirect:/login"; 
		
		
	}
	
}
