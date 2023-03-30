package com.askidaevimproject.Ask.da.evim.olsun.service.abstracts;

import com.askidaevimproject.Ask.da.evim.olsun.service.requests.CreateDwellingRequest;

import java.util.List;

public interface DwellingService {

    List<GetAllDwellingResponse> getAllDwelling();

    void addDistrict(CreateDwellingRequest createDwellingRequest);


}
