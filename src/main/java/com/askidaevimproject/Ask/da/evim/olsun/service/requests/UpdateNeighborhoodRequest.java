package com.askidaevimproject.Ask.da.evim.olsun.service.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateNeighborhoodRequest {

    private Long neighborhood_id;
    private String zip_code;
    private String neighborhood_name;
}
