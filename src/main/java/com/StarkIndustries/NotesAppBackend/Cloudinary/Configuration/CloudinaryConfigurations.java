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

    @Value("${api.key}")
    private String apiKey;

    @Value("${api.secret}")
    private String apiSecret;

    @Bean
    public Cloudinary cloudinary(){
        Map<String,Object> configurations = new HashMap<>();
        configurations.put(Keys.CLOUD_NAME,"dhdrzsxor");
        configurations.put(Keys.API_KEY,apiKey);
        configurations.put(Keys.API_SECRET,apiSecret);
        configurations.put(Keys.SECURE,true);
        return new Cloudinary(configurations);
    }
}
