package lopputyo.sovellus;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import lopputyo.sovellus.domain.FileRepository;
import lopputyo.sovellus.domain.PremiseRepository;
import lopputyo.sovellus.domain.TypeRepository;
import lopputyo.sovellus.domain.UserRepository;
import lopputyo.sovellus.web.FileController;
import lopputyo.sovellus.web.SovellusApplicationController;
import lopputyo.sovellus.web.UserController;


@RunWith(SpringRunner.class)
@WebMvcTest (SovellusApplicationController.class)
public class WebLayerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private SovellusApplicationController controller;
	
	@MockBean
	private UserController ucontroller;
	
	@MockBean
	private FileController fcontroller;	
	
	//repot
	@MockBean
	private PremiseRepository prepo;
	
	@MockBean
	private TypeRepository trepo;
	
	@MockBean
	private UserRepository urepo;
	
	@MockBean
	private FileRepository frepo;	
	
	@Test
	public void testLoginpage() throws Exception {
		this.mockMvc.perform(get("/login")).andDo(print()).andExpect(status().isOk());
	}

}
