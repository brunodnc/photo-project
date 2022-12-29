package jpb.photoproject.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {

    /**
     * string
     */
    @Value("${crossOrigin}")
    private String _crossOrigin;

//
//    @Bean
//    public UserDetailsService users( ) {
//        UserDetails user = User.builder()
//                .username( "pm_user" )
//                .password( "{noop}E&2Awln#O7152yne#O6ia@4F5yGBTHSV" )
//                .roles( "USER" )
//                .build();
//        return new InMemoryUserDetailsManager( user );
//    }

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .cors()
                .and()
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/**").permitAll()
                .and()
                .exceptionHandling()
                .and()
                .httpBasic()
                .and()
                .build();
    }

    //CONFIGURA CORS
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {

        final String[] methods = new String[]{"GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"};
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Collections.singletonList(this._crossOrigin));
        configuration.setAllowedMethods(
                Arrays.asList(methods)
        );
        configuration.setAllowCredentials(true);
        configuration.setMaxAge(120L);
//        configuration.setExposedHeaders();

        //the below three lines will add the relevant CORS response headers

        configuration.addAllowedOrigin(this._crossOrigin);
        configuration.addAllowedHeader("*");
        for (final String method : methods) {
            configuration.addAllowedMethod(
                    HttpMethod.valueOf(method)
            );
        }

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}