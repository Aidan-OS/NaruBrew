package quest.dead_end.NaruBrew;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        http.authorizeHttpRequests(auth -> auth
                        // Public pages
                        .requestMatchers("/", "/home", "/css/**", "/images/**").permitAll()

                        // Restrict upload and other future routes
                        .requestMatchers("/upload/**", "/account/**").authenticated()

                        // Everything else requires login by default
                        .anyRequest().permitAll()
                )
                .formLogin() // enables default login form
                .and()
                .logout();

        return http.build();
    }
}
