package lopputyo.sovellus;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import lopputyo.sovellus.domain.Premise;
import lopputyo.sovellus.domain.PremiseRepository;
import lopputyo.sovellus.domain.Type;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PremisesRepositoryTest {

	@Autowired 
	private PremiseRepository prepository;
	
	
	@Test
	public void findByCityShouldReturnAddress() {
		List<Premise> premises = prepository.findByCity("Ulvila");
		assertThat(premises).hasSize(1);
		assertThat(premises.get(0).getAddress()).isEqualTo("Ulvilantie");
	}
	
	@Test
	public void findAllShouldReturnTwo() {
		List<Premise> premises = prepository.findByMyynnissa(1);
		assertThat(premises.size()).isEqualTo(2);
	}
	
	
	@Test
	public void creatingPremise() {
		Premise premise = new Premise ("xo", "xo", "xo", "xo", 0, new Type ("Liiketila"));
		prepository.save(premise);
		assertThat(premise.getId()).isNotNull();
	}
	
}
