package com.askidaevimproject.Ask.da.evim.olsun.service.concretes;

import com.askidaevimproject.Ask.da.evim.olsun.core.utilities.mappers.abstracts.ModelMapperService;
import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Advert;
import com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts.AdvertRepository;
import com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts.MemberRepository;
import com.askidaevimproject.Ask.da.evim.olsun.service.abstracts.AdvertService;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.CreateAdvertRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.UpdateAdvertRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllAdvertResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByAdvertTitle;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdvertServiceImpl implements AdvertService {

    private  AdvertRepository advertRepository;
    private  MemberRepository memberRepository;
    private  ModelMapperService modelMapperService;



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
        this.advertRepository.save(advert);
    }
}
