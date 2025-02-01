package com.StarkIndustries.NotesAppBackend.Cloudinary.Service;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
@Component
public class CloudinaryService {

    @Autowired
    public Cloudinary cloudinary;

    public Map uploadProfilePic(MultipartFile multipartFile){
        try{
            return this.cloudinary.uploader().upload(multipartFile.getBytes(), Map.of());
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
