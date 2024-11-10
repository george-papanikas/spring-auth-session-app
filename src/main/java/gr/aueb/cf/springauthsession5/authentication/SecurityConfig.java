package gr.aueb.cf.springauthsession5.authentication;

import gr.aueb.cf.springauthsession5.model.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("https://codingfactory.aueb.gr", "http://localhost:4200"));
        configuration.setAllowedMethods(List.of("*"));    //List.of("GET", "POST")
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors(cors -> cors
                        .configurationSource(corsConfigurationSource())
                        )
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/img/**").permitAll()
                        .requestMatchers("/styles/**").permitAll()
                        .requestMatchers("/js/**").permitAll()
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/teachers/register").permitAll()
                        .requestMatchers("/students/**").hasAnyAuthority(Role.STUDENT.name())
                        .requestMatchers("/teachers/**").hasAnyAuthority(Role.TEACHER.name())
                        .anyRequest().authenticated()
                )
                .formLogin(formLogin -> formLogin
                        .loginPage("/login")  // login controller
                        .defaultSuccessUrl("/dashboard")      //default
                        //.loginProcessingUrl("/login")         //default
                        //.usernameParameter("username")        //default
                        //.passwordParameter("password")        //default
                        //.failureUrl("/login?error")           //default
                )
                .httpBasic(withDefaults())                    //session-based auth + cookies
                //.sessionManagement(session ->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))    //Angular so jwt
                .logout(logout -> logout
                        //.logoutUrl("/logout")                 //default
                        .logoutSuccessUrl("/login")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                )
                .rememberMe(rememberMeConfigurer -> rememberMeConfigurer
                        .alwaysRemember(true)
                        .rememberMeParameter("rememberMe")
                        .rememberMeCookieName("remember-me")
                        .tokenValiditySeconds(24 * 60 * 60)
                );

        return http.build();
    }
}
