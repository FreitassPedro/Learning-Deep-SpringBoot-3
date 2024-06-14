package com.pedro.demo.config;

import com.pedro.demo.common.Coach;
import com.pedro.demo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    //Usamos isto pois a classe "swimCoach" não está usando @Component neste teste
    @Bean
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
