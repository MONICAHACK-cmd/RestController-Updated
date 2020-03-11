package com.hackathon.repository;

import com.hackathon.model.CTODetails;
import com.hackathon.model.PK_CtoDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface CTOFileRepository extends JpaRepository<CTODetails, PK_CtoDetails> {
}
