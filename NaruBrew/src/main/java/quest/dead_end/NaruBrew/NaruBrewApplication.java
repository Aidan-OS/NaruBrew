package quest.dead_end.NaruBrew;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import quest.dead_end.NaruBrew.model.Tag;
import quest.dead_end.NaruBrew.repository.TagRepository;

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
			Tag t = new Tag();
			t.setName("Test");
			tagRepo.save(t);

			Tag fetched = tagRepo.findByName("Test");
			System.out.println("Fetched tag: " + fetched.getName());
		};
	}

}
