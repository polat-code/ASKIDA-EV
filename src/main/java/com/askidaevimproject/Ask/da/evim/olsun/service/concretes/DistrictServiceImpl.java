package com.askidaevimproject.Ask.da.evim.olsun.service.concretes;

import com.askidaevimproject.Ask.da.evim.olsun.core.utilities.mappers.abstracts.ModelMapperService;
import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.District;
import com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts.CityRepository;
import com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts.DistrictRepository;
import com.askidaevimproject.Ask.da.evim.olsun.service.abstracts.DistrictService;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.CreateDistrictRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.UpdateDistrictRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllDistrictResponse;

import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByDistrictIdResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByDistrictName;
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

    private CityRepository cityRepository;


    @Override
    public List<GetAllDistrictResponse> getAllDistrict() {
        List<District> districts = districtRepository.findAll();

        return districts.stream().map(district -> this.
                modelMapperService.forResponse().
                map(district,GetAllDistrictResponse.class)).
                toList();
    }



    @Override
    public void addDistrict(CreateDistrictRequest createDistrictRequest) {

        District district = this.modelMapperService.forRequest().map(createDistrictRequest,District.class);

        District district1 = new District().builder()
                .districtName(createDistrictRequest.getDistrictName())
                .city(cityRepository.getById(createDistrictRequest.getCityId()))
                .build();

        this.districtRepository.save(district1);

    }

    @Override
    public GetByDistrictName getByDistrictName(String district_name) {
        District district = this.districtRepository.findByDistrictName(district_name);
        return this.modelMapperService.forResponse().map(district,GetByDistrictName.class);
    }

    @Override
    public void deleteDistrict(Long district_id) {
        if(this.districtRepository.existsById(district_id))

            this.districtRepository.deleteById(district_id);
    }

    @Override
    public void updateDistrict(UpdateDistrictRequest updateDistrictRequest) {
        District district = this.modelMapperService.forRequest().map(updateDistrictRequest,District.class);
        this.districtRepository.save(district);
    }

    @Override
    public GetByDistrictIdResponse getById(Long district_id) {
        District district = this.districtRepository.findById(district_id).orElseThrow();
        return this.modelMapperService.forResponse().map(district,GetByDistrictIdResponse.class);
    }


}
