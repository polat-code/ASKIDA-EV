package com.askidaevimproject.Ask.da.evim.olsun.service.concretes;

import com.askidaevimproject.Ask.da.evim.olsun.core.mappers.abstracts.ModelMapperService;
import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.District;
import com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts.DistrictRepository;
import com.askidaevimproject.Ask.da.evim.olsun.service.abstracts.DistrictService;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.CreateDistrictRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllDistrictResponse;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
@Transactional
public class DistrictServiceImpl implements DistrictService {


    private DistrictRepository districtRepository;
    private ModelMapperService modelMapperService;


    @Override
    public List<GetAllDistrictResponse> getAllDistrict() {
        List<District> districts = districtRepository.findAll();

        return districts.stream().map(district -> this.modelMapperService.forResponse().map(district,GetAllDistrictResponse.class)).toList();
    }

    @Override
    public void addDistrict(CreateDistrictRequest createDistrictRequest) {

    }
}
