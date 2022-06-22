package com.book.manager.app.config

import com.book.manager.app.core.security.AuthenticationService
import com.book.manager.domain.enum.RoleType
import com.book.manager.app.core.security.handler.BookManagerAccessDeniedHandler
import com.book.manager.app.core.security.handler.BookManagerAuthenticationEntryPoint
import com.book.manager.app.core.security.handler.BookManagerAuthenticationFailureHandler
import com.book.manager.app.core.security.handler.BookManagerAuthenticationSuccessHandler
import com.book.manager.app.core.security.BookManagerUserDetailsService
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@EnableWebSecurity
class SecurityConfig(
    private val authenticationService: AuthenticationService,
) : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
            .mvcMatchers("/login").permitAll()
            .mvcMatchers("/admin/**").hasAuthority(RoleType.ADMIN.toString())
            .anyRequest().authenticated()
            .and()
            .csrf().disable()
            .formLogin()
            .loginProcessingUrl("/login")
            .usernameParameter("email")
            .passwordParameter("pass")
            .successHandler(BookManagerAuthenticationSuccessHandler())
            .failureHandler(BookManagerAuthenticationFailureHandler())
            .and()
            .exceptionHandling()
            .authenticationEntryPoint(BookManagerAuthenticationEntryPoint())
            .accessDeniedHandler(BookManagerAccessDeniedHandler())
            .and()
            .cors()
            .configurationSource(corsConfigurationSource())
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(BookManagerUserDetailsService(authenticationService))
            .passwordEncoder(BCryptPasswordEncoder())
    }

    private fun corsConfigurationSource(): CorsConfigurationSource {
        val corsConfiguration = CorsConfiguration()
        corsConfiguration.addAllowedMethod(CorsConfiguration.ALL)
        corsConfiguration.addAllowedHeader(CorsConfiguration.ALL)
        // 本番、開発環境等でここを切り替えるには？
        corsConfiguration.addAllowedOrigin("http://localhost:8081")
        corsConfiguration.allowCredentials = true

        val corsConfigurationSource = UrlBasedCorsConfigurationSource()
        corsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration)

        return corsConfigurationSource
    }
}
