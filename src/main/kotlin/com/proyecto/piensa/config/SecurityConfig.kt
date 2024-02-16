package com.proyecto.piensa.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Component

@Component
class SecurityConfig {
    @Autowired
    private val jwtFilter: com.proyecto.piensa.config.JwtFilter? = null

    @Bean
    @Throws(Exception::class)
    open fun filterChain(http: HttpSecurity): SecurityFilterChain? {
        http
            .csrf{csrf->csrf.disable()}
            .cors(Customizer.withDefaults())
            .sessionManagement{sess->sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS)}
            .authorizeHttpRequests{authRequest->
                authRequest
                    .requestMatchers("/auth/**").permitAll()

                    .requestMatchers(HttpMethod.GET,"/product/**","/detail/**").hasAnyRole("admin")
                    .requestMatchers(HttpMethod.GET,"/client/**").hasAnyRole("vendedor")
                    .anyRequest().denyAll()
            }
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter::class.java)

        return http.build()


    }

    @Bean
    @Throws(java.lang.Exception::class)
    fun authenticationManager(configuration: AuthenticationConfiguration): AuthenticationManager? {
        return configuration.authenticationManager
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}
}