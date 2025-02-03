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

    @Bean
    public Cloudinary cloudinary(){
        Map<String,Object> configurations = new HashMap<>();
        configurations.put(Keys.CLOUD_NAME,System.getenv("CLOUD_NAME"));
        configurations.put(Keys.API_KEY,System.getenv("API_KEY"));
        configurations.put(Keys.API_SECRET,System.getenv("API_SECRETE"));
        configurations.put(Keys.SECURE,true);
        return new Cloudinary(configurations);
    }
}
