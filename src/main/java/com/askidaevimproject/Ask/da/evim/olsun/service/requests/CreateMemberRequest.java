package com.askidaevimproject.Ask.da.evim.olsun.service.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateMemberRequest {

    @NotNull
    @NotBlank
    @Size(min = 3,max = 25)
    private String memberName;

    @NotNull
    @NotBlank
    @Size(min = 3,max = 25)
    private String memberSurname;

    @NotNull
    @NotBlank
    @Size(min = 10,max = 50)
    private String memberPhone;

    @NotNull
    @NotBlank
    @Size(min = 3,max = 25)
    @Email(regexp = "[A-Za-z0-9._%-+]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}")
    private String memberMail;

    @NotNull
    @NotBlank
    @Size(min = 8)
    private String memberPassword;

    @NotNull
    @NotBlank
    private String memberPhoto;
    @NotNull
    @NotBlank
    private String memberAddress;
    @NotNull
    @NotBlank
    private int isActivate;


}
