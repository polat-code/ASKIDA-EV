package com.askidaevimproject.Ask.da.evim.olsun.webApi.controllers;

import com.askidaevimproject.Ask.da.evim.olsun.service.abstracts.AdvertService;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.CreateAdvertRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAdvertByIdResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.UpdateAdvertRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllAdvertResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByAdvertTitle;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/adverts")
@AllArgsConstructor
@CrossOrigin("http://localhost:3000")
public class AdvertController {

    private AdvertService advertService;


    @GetMapping("")
    public List<GetAllAdvertResponse> getAllAdvert(){
        return advertService.getAllAdvert();
    }



    @PostMapping("")
    public void addAdvert(@RequestBody @Valid CreateAdvertRequest createAdvertRequest
                          ) {
        advertService.addAdvert(createAdvertRequest);
    }


    @DeleteMapping("/{advert_id}")
    public void deleteAdvert(@PathVariable Long advert_id) {
        advertService.deleteAdvert(advert_id);
    }
    @PutMapping("")
    public void updateAdvert(@RequestBody @Valid UpdateAdvertRequest updateAdvertRequest) {
        advertService.updateAdvert(updateAdvertRequest);
    }

    @GetMapping("/{advert_title}")
    public GetByAdvertTitle getByAdvertTitle(@PathVariable String advert_title){
        return advertService.getByAdvertTitle(advert_title);
    }

   @GetMapping("/advert-id/{advertId}")
    public GetAdvertByIdResponse getAdvertById(@PathVariable("advertId") Long advertId) {
        return advertService.getAdvertById(advertId);
   }
}
