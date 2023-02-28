package com.askidaevimproject.Ask.da.evim.olsun.service.abstracts;


import com.askidaevimproject.Ask.da.evim.olsun.service.requests.CreateDistrictRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllDistrictResponse;

import java.util.List;

public interface DistrictService {
    List<GetAllDistrictResponse> getAllDistrict();

    void addDistrict(CreateDistrictRequest createDistrictRequest);

}
