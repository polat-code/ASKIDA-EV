package com.askidaevimproject.Ask.da.evim.olsun.service.concretes;

import com.askidaevimproject.Ask.da.evim.olsun.core.utilities.mappers.abstracts.ModelMapperService;
import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Advert;
import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Media;
import com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts.AdvertRepository;
import com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts.MediaRepository;
import com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts.MemberRepository;
import com.askidaevimproject.Ask.da.evim.olsun.service.abstracts.AdvertService;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.CreateAdvertRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.UpdateAdvertRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllAdvertResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByAdvertTitle;
import com.askidaevimproject.Ask.da.evim.olsun.service.rules.AdvertBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdvertServiceImpl implements AdvertService {

    private  AdvertRepository advertRepository;
    private  MemberRepository memberRepository;
    private  ModelMapperService modelMapperService;

    private AdvertBusinessRules advertBusinessRules;
    private MediaRepository mediaRepository;



    public List<GetAllAdvertResponse> getAllAdvert() {
        List<Advert> adverts = this.advertRepository.findAll();

        return adverts
                .stream()
                .map(advert ->
                        this.
                                modelMapperService.
                                forResponse().
                                map(advert,GetAllAdvertResponse.class)).
                toList();
    }


    public void deleteAdvert(Long advert_id) {

        if(advertRepository.existsById(advert_id))
            if(memberRepository.existsById(advertRepository.findById(advert_id).get().getMember().getMemberId()))
                    advertRepository.deleteById(advert_id);

    }

    @Override
    public void updateAdvert(UpdateAdvertRequest updateAdvertRequest) {
        // There will be error here because there is id in updateAdvertRequest but in Advert.class , there is object.
        // They cannot be mapped each other.
        Advert advert=this.modelMapperService.forRequest().map(updateAdvertRequest,Advert.class);

        this.advertRepository.save(advert);
    }

    @Override
    public GetByAdvertTitle getByAdvertTitle(String advert_title) {

        Advert advert= this.advertRepository.findByAdvertTitle(advert_title);
        return this.modelMapperService.forResponse().map(advert,GetByAdvertTitle.class);
    }

    public void addAdvert(CreateAdvertRequest createAdvertRequest) {
        // There will be error here because there is id in updateAdvertRequest but in Advert.class , there is object.
        // They cannot be mapped each other.
        Advert advert = this.modelMapperService.forRequest().map(createAdvertRequest,Advert.class);

        advert.setIsActivate(0);

        List<String> photoWays = createAdvertRequest.getPhotoWays();
        if(photoWays != null) {
            for (String photoWay : photoWays) {
                Media media = new Media();
                media.setAdvert(advert);
                media.setPhotoWay(photoWay);
                mediaRepository.save(media);
            }
        }

        boolean flag = this.advertBusinessRules.checkPointBeforeUserAddAdvert(advert);
        if(flag)
            this.advertRepository.save(advert);

    }

}
