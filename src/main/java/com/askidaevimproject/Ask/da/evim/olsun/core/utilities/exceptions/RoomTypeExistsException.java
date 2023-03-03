package com.askidaevimproject.Ask.da.evim.olsun.core.utilities.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoomTypeExistsException extends IllegalStateException {

    public RoomTypeExistsException(String s) {
        super(s);
    }

}
