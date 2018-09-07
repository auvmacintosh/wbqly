//package info.natebowang.wbqly.conf;
//
//import info.natebowang.wbqly.qlyuser.QlyuserDetailsService;
//import info.natebowang.wbqly.qlyuser.QlyuserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConf extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    QlyuserRepository qlyuserRepository;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(new QlyuserDetailsService(qlyuserRepository)).
//                passwordEncoder(new BCryptPasswordEncoder());
//    }
//
//
//}
