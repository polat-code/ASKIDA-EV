package com.askidaevimproject.Ask.da.evim.olsun.service.abstracts;

import com.askidaevimproject.Ask.da.evim.olsun.service.requests.CreateNeighborhoodRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllNeighBorHoodResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByNeighborHoodZipCodeResponse;

import java.util.List;

public interface NeighborhoodService {

    List<GetAllNeighBorHoodResponse> getAllNeighBorHood();

    GetByNeighborHoodZipCodeResponse getByZipcode(String zip_code);

    void addNeighborhood(CreateNeighborhoodRequest createNeighborhoodRequest);


}
