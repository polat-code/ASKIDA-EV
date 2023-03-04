package com.askidaevimproject.Ask.da.evim.olsun.core.utilities.exceptions;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;





@NoArgsConstructor
public class MemberIdNotFoundException extends IdProblemDetails {


    public MemberIdNotFoundException(String message) {
        super(message);
    }
}
