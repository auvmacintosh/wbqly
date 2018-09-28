package info.natebowang.wbqly;

import info.natebowang.wbqly.qlyuser.QlyuserDetailsService;
import info.natebowang.wbqly.qlyuser.QlyuserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@SpringBootApplication
public class WbqlyApplication {

    @Autowired
    QlyuserRepository qlyuserRepository;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new QlyuserDetailsService(qlyuserRepository)).
                passwordEncoder(new BCryptPasswordEncoder());
    }

    @Configuration
    @EnableWebSecurity
    public class WebSecurityConf extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.cors()
                    .and().httpBasic()
                    .and().authorizeRequests()
                    .antMatchers(HttpMethod.GET, "qlyusers").permitAll()
                    .antMatchers(HttpMethod.POST, "/qlyusers").permitAll()
            ;
        }
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://home.sina.com/"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Configuration
    @EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
    public static class MethodSecurityConf extends GlobalMethodSecurityConfiguration {
    }

    public static void main(String[] args) {
        SpringApplication.run(WbqlyApplication.class, args);
    }

}
