package com.hackathon.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadFileService {


    void uploadFile(MultipartFile file);
}
