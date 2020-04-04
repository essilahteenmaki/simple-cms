package lopputyo.sovellus;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lopputyo.sovellus.domain.Premise;
import lopputyo.sovellus.domain.PremiseRepository;
import lopputyo.sovellus.domain.Type;
import lopputyo.sovellus.domain.TypeRepository;
import lopputyo.sovellus.domain.User;
import lopputyo.sovellus.domain.UserRepository;

@SpringBootApplication
public class SovellusApplication {

	public static void main(String[] args) {
		SpringApplication.run(SovellusApplication.class, args);
	}

//testidata testausta varten
	/*@Bean
	public CommandLineRunner testData(PremiseRepository prepository, TypeRepository trepository, UserRepository urepository ) {
		return (args) -> {
			trepository.save(new Type("Liiketila"));
			trepository.save(new Type("Varasto"));
			trepository.save(new Type("Toimisto"));
			
			prepository.save(new Premise("Kaupintiellä 44", "Helsinki", "Ihana koti", "https://icon-library.net/images/placeholder-image-icon/placeholder-image-icon-7.jpg", 1, trepository.findByName("Liiketila").get(0)));
			prepository.save(new Premise("Ulvilantie", "Ulvila", "Ihana koti", "https://icon-library.net/images/placeholder-image-icon/placeholder-image-icon-7.jpg", 1, trepository.findByName("Varasto").get(0)));
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);

		};

	
}*/
}
