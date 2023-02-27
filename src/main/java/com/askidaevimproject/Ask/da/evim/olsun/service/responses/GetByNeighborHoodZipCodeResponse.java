package com.askidaevimproject.Ask.da.evim.olsun.service.responses;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByNeighborHoodZipCodeResponse {

    @Column(name="zip_code")
    private String zipCode;

}
