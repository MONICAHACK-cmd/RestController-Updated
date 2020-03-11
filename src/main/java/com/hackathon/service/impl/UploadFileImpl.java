package com.hackathon.service.impl;

import com.hackathon.model.CTODetails;
import com.hackathon.model.PK_CtoDetails;
import com.hackathon.repository.CTOFileRepository;
import com.hackathon.service.UploadFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;

@Slf4j
@Service
@Transactional
public class UploadFileImpl implements UploadFileService {

    @Autowired
    private CTOFileRepository ctoFileRepository;

    @Override
    public void uploadFile(MultipartFile multipartFile) {
        try {
            String mainPath= "F:\\IntelliJ\\hackathon\\sendMail\\src\\main\\resources";
            String filename = multipartFile.getOriginalFilename();
            Path filepath = Paths.get(mainPath,filename);
            multipartFile.transferTo(filepath);
            CTODetails obj = new CTODetails("me15007","uma.priya@ubs.com","wma-validator-test-api.yaml","Pending", Instant.now(),Instant.now(),multipartFile.getBytes());
            ctoFileRepository.save(obj);
            ctoFileRepository.flush();
            log.info("File Saved SuccessFully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
