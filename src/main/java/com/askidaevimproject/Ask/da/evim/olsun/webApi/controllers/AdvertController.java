package com.askidaevimproject.Ask.da.evim.olsun.webApi.controllers;

import com.askidaevimproject.Ask.da.evim.olsun.service.abstracts.AdvertService;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.CreateAdvertRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.UpdateAdvertRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllAdvertResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/advert")
@AllArgsConstructor
public class AdvertController {

    private AdvertService advertService;



    @GetMapping("")
    public List<GetAllAdvertResponse> getAllAdvert(){
        return advertService.getAllAdvert();
    }

    @PostMapping("")
    public void addAdvert(@RequestBody CreateAdvertRequest createAdvertRequest) {

        advertService.addAdvert(createAdvertRequest);
    }


    @DeleteMapping("/{advert_id}")
    public void deleteAdvert(@PathVariable Long advert_id) {
        advertService.deleteAdvert(advert_id);
    }
    @PutMapping("")
    public void updateAdvert(@RequestBody UpdateAdvertRequest updateAdvertRequest) {
        advertService.updateAdvert(updateAdvertRequest);
    }


}
