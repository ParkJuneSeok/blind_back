package com.blind.back.blind_back.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/css/**").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/member/login")
                .usernameParameter("memId")
                .passwordParameter("memPw")
                .permitAll()
                .and()
            .logout()
            .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(new BCryptPasswordEncoder())
                .usersByUsernameQuery("SELECT MEMID, MEMNICK, ENABLED FROM mysqlvs.MEMBER WHERE MEMID = ?")
                .authoritiesByUsernameQuery(
                    "SELECT  M.MEMID, R.ROLENAME    " +
                    "FROM mysqlvs.MEMBER M                  " +
                    "INNER JOIN mysqlvs.MEMBER_ROLE MR      " +
                    "ON M.MEMNO = MR.MEMNO          " +
                    "INNER JOIN mysqlvs.ROLE R              " +
                    "ON R.ROLENO = MR.ROLENO        " +
                    "WHERE M.MEMID = ?              "
                );
    }
}