package com.hackathon.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class PK_CtoDetails implements Serializable {

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "FILENAME")
    private String fileName;

    @Override
    public int hashCode() {
        return Objects.hash(email, fileName);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof PK_CtoDetails) {
            PK_CtoDetails pk_ctoDetails = (PK_CtoDetails)obj;
            if(this.getEmail() == pk_ctoDetails.getEmail() &&
                    this.getFileName() == pk_ctoDetails.getFileName()) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

}
