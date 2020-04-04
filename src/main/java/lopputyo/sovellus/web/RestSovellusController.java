package lopputyo.sovellus.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lopputyo.sovellus.domain.Premise;
import lopputyo.sovellus.domain.PremiseRepository;
import lopputyo.sovellus.domain.TypeRepository;

@RestController
public class RestSovellusController {
	
	@Autowired
	private PremiseRepository prepository;
	
	@Autowired
	private TypeRepository trepository;
	
	
	@RequestMapping(value="/restInHki", method = RequestMethod.GET)
	public @ResponseBody List<Premise> premisesRest(){
		return (List<Premise>) prepository.findByCity("Helsinki");
	}
	
	@RequestMapping(value="/restMyynnissa", method = RequestMethod.GET)
	public @ResponseBody List<Premise> premisesRestMyynnissa(){
		return (List<Premise>) prepository.findByMyynnissa(1);
	}

}
