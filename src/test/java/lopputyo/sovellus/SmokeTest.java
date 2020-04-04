package lopputyo.sovellus;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lopputyo.sovellus.web.RestSovellusController;
import lopputyo.sovellus.web.SovellusApplicationController;
import lopputyo.sovellus.web.UserController;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest {
	
	@Autowired
	private SovellusApplicationController controller;
	
	@Autowired
	private UserController ucontroller;
	
	@Autowired
	private RestSovellusController rcontroller;
	
	

	@Test
	public void contextLoadsSovellus() throws Exception{
		assertThat(controller).isNotNull();
	}
	
	@Test
	public void contextLoadsUser() throws Exception{
		assertThat(ucontroller).isNotNull();
	}
	
	@Test
	public void contextLoadsReest() throws Exception{
		assertThat(rcontroller).isNotNull();
	}

}
