package com.hackathon.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "CTODETAILS")
public class CTODetails  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "UUNAME",nullable = false)
    private String uuname;

    @Column(name = "EMAIL" , nullable = false)
    private String email;

    @Column(name = "FILENAME" , nullable = false)
    private String fileName;

    @Column(name = "STATUS_DSC")
    private String status_dsc;

    @Column(name = "CREATED_DATE")
    private Instant created_date;

    @Column(name = "UPDATED_DATE")
    @LastModifiedDate
    private Instant updated_date;

    @Column(name = "FILECONTENT")
    @Lob
    private byte[] fileContent;

    public CTODetails(String uuname, String email, String fileName, String status_dsc, Instant created_date, Instant updated_date, byte[] fileContent) {
    this.uuname=uuname;
    this.email=email;
    this.fileName=fileName;
    this.status_dsc=status_dsc;
    this.created_date=created_date;
    this.updated_date=updated_date;
    this.fileContent=fileContent;
    }
}
