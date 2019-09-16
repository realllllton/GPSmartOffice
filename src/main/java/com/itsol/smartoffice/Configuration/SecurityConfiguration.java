//package com.itsol.smartoffice.Configuration;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////        http
////                .authorizeRequests()
////                .antMatchers("/apis/**", "/register", "/**").permitAll();
//        http.authorizeRequests()
//                .antMatchers("/register").permitAll()
//                .antMatchers("/confirm").permitAll();
//    }
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new PasswordEncoder() {
//
//            @Override
//            public String encode(CharSequence charSequence) {
//                return null;
//            }
//
//            @Override
//            public boolean matches(CharSequence charSequence, String s) {
//                return false;
//            }
//        };
//
//    }
//
//}
