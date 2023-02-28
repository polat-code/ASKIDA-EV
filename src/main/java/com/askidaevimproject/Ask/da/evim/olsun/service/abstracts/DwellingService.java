package com.askidaevimproject.Ask.da.evim.olsun.service.abstracts;

import com.askidaevimproject.Ask.da.evim.olsun.service.requests.CreateDwellingRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllDwellingResponse;

import java.util.List;

public interface DwellingService {

    List<GetAllDwellingResponse> getAllDwelling();

    void addDistrict(CreateDwellingRequest createDwellingRequest);


}
