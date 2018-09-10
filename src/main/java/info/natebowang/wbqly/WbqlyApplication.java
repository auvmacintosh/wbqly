package info.natebowang.wbqly;

import info.natebowang.wbqly.qlyuser.QlyuserDetailsService;
import info.natebowang.wbqly.qlyuser.QlyuserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
            http.httpBasic()
                    .and().authorizeRequests()
                    .antMatchers(HttpMethod.GET, "qlyusers").permitAll()
                    .antMatchers(HttpMethod.POST, "/qlyusers").permitAll()
            ;
        }
    }

    @Configuration
    @EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
    public static class MethodSecurityConf extends GlobalMethodSecurityConfiguration {
    }

    public static void main(String[] args) {
        SpringApplication.run(WbqlyApplication.class, args);
    }

}
