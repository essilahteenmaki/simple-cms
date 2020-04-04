package lopputyo.sovellus.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface PremiseRepository extends CrudRepository<Premise, Long> {
	
	List<Premise> findByMyynnissa (int myynnissa);
	List<Premise> findByCity (String city);

}

