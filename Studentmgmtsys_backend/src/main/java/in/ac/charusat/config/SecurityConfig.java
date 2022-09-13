package in.ac.charusat.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;


public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource)
                .withDefaultSchema()
                .withUser(
                        User.withUsername("admin")
                                .password("admin")
                                .roles("ADMIN")
                )
                .withUser(
                        User.withUsername("user")
                                .password("user")
                                .roles("USER")
                );
//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password("admin")
//                .roles("USER");
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//        http.headers().frameOptions().disable();
//    }

    @Bean
    public PasswordEncoder getPasswordEncode() {
        return NoOpPasswordEncoder.getInstance();


    }
}
