package com.askidaevimproject.Ask.da.evim.olsun.service.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAdvertRequest {


    @NotNull
    @NotBlank
    @Size(min = 6)
    private String advertTitle;

    @NotNull
    @NotBlank
    private Long dwellingId;

    @NotNull
    @NotBlank
    private Long memberId;

}
