package br.com.hoffmann.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class MainConfiguration extends WebSecurityConfigurerAdapter {

  private static final String CADASTRA_USUARIO = "/v1/security/cadastraUsuario";
  private static final String DELETE_USUARIO = "/v1/security/deletaUsuario/**";
  private static final String BUSCA_USUARIO = "/v1/security/buscaUsuarios";
  private static final String BUSCA_USUARIO_ID = "/v1/security/buscaUsuariosPeloID";
  private static final String LOGIN = "/v1/security/login";

  @Autowired
  private UserDetailsService userDetailsService;

  @Override
  protected void configure(HttpSecurity httpSecurity) throws Exception {
    httpSecurity.csrf().disable().authorizeRequests()
        .antMatchers("/").permitAll()
        .antMatchers(HttpMethod.POST, LOGIN).permitAll()
        .antMatchers(HttpMethod.POST, CADASTRA_USUARIO).permitAll()
        .antMatchers(HttpMethod.DELETE, DELETE_USUARIO).permitAll()
        .antMatchers(HttpMethod.GET, BUSCA_USUARIO).permitAll()
        .antMatchers(HttpMethod.GET, BUSCA_USUARIO_ID).permitAll()
        .anyRequest().authenticated()
        .and()
        .addFilterBefore(new JWTLoginFilter(LOGIN, authenticationManager()),
            UsernamePasswordAuthenticationFilter.class)
        .addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService);
  }
}
