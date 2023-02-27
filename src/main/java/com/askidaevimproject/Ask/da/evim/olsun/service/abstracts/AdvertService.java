package com.askidaevimproject.Ask.da.evim.olsun.service.abstracts;

import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Advert;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.CreateAdvertRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.UpdateAdvertRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllAdvertResponse;

import java.util.List;

public interface AdvertService {

    List<GetAllAdvertResponse> getAllAdvert();

    void addAdvert(CreateAdvertRequest createAdvertRequest);

    void deleteAdvert(Long advert_id);

    void updateAdvert(UpdateAdvertRequest updateAdvertRequest);
}
