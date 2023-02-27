package com.askidaevimproject.Ask.da.evim.olsun.service.responses;

import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Dwelling;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class GetAllAdvertResponse {
    private GetAllMemberResponse getAllMemberResponse;
    private Dwelling dwelling;
    private String advertTitle;
}
