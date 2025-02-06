package com.StarkIndustries.NotesAppBackend.Cloudinary.Configuration;

import com.StarkIndustries.NotesAppBackend.Keys.Keys;
import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfigurations {

    @Value("${API_KEY:316185456453451}")
    public String API_KEY;

    @Value("${API_SECRETE:QrkDeLlcsz9z2maFx1grSIE4wDA}")
    public String API_SECRETE;

    @Value("${CLOUD_NAME:dhdrzsxor}")
    public String CLOUD_NAME;

    @Bean
    public Cloudinary cloudinary(){
        Map<String,Object> configurations = new HashMap<>();
        configurations.put(Keys.CLOUD_NAME,CLOUD_NAME);
        configurations.put(Keys.API_KEY,API_KEY);
        configurations.put(Keys.API_SECRET,API_SECRETE);
        configurations.put(Keys.SECURE,true);
        return new Cloudinary(configurations);
    }
}
