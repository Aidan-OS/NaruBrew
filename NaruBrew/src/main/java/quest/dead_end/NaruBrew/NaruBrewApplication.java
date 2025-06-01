package quest.dead_end.NaruBrew;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import quest.dead_end.NaruBrew.model.Tag;
import quest.dead_end.NaruBrew.repositories.TagRepository;

@SpringBootApplication
public class NaruBrewApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(NaruBrewApplication.class, args);
	}

	@Bean
	CommandLineRunner run(TagRepository tagRepo)
	{
		return args -> {
//			tagRepo.save(new Tag("2"));
//			tagRepo.findAll().forEach(tag -> System.out.println(tag.getName()));
		};
	}

}
