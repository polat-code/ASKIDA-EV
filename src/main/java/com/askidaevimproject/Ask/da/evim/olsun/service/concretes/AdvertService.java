package com.askidaevimproject.Ask.da.evim.olsun.service.concretes;

import com.askidaevimproject.Ask.da.evim.olsun.exception.AdvertNotFoundException;
import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Advert;
import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Dwelling;
import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Member;
import com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts.AdvertRepository;
import com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts.DwellingRepository;
import com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdvertService {

    private  AdvertRepository advertRepository;
    private  MemberRepository memberRepository;
    private  DwellingRepository dwellingRepository;



    public List<Advert> getAllAdvert() {
        return advertRepository.findAll();
    }


    public void deleteAdvert(Long advert_id) throws AdvertNotFoundException {
        if(advertRepository.existsById(advert_id))
            if(memberRepository.existsById(advertRepository.findById(advert_id).get().getMember().getMember_id()))
                if(dwellingRepository.existsById(advertRepository.findById(advert_id).get().getAdvert_id()))
                    advertRepository.deleteById(advert_id);
        else
            throw new AdvertNotFoundException("The Advert is not Found Exception ");
    }



    public Advert updateAdvert(Advert advert, Long advert_id) throws AdvertNotFoundException {

        Advert updatedAdvert = advertRepository.findById(advert_id).get();
        if(advertRepository.existsById(updatedAdvert.getAdvert_id())){
            updatedAdvert.setAdvert_title(advert.getAdvert_title());
        }
        else
            throw new AdvertNotFoundException("The Advert is not Found Exception ");

        return advertRepository.save(updatedAdvert);

    }

    public Advert addAdvert(Advert advert) throws Exception {
        Member member = memberRepository.findById(advert.getMember().getMember_id()).get();
        Dwelling dwelling = dwellingRepository.findById(advert.getDwelling().getDwelling_id()).get();

        if(!(memberRepository.existsById(member.getMember_id())
                || !(dwellingRepository.existsById(dwelling.getDwelling_id())))){
            throw new Exception("Error");
        }
        return advertRepository.save(advert);


    }
}