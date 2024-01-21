package com.api.franquicia.commons.response;

import com.api.franquicia.model.Franchise;
import lombok.Builder;
import org.springframework.http.HttpStatus;

import java.util.List;
public class ResponseOkDto{


    public ResponseOkDto(ResponseDto responseDto, String message, Object data){

        responseDto.setCode(HttpStatus.OK.value());
        responseDto.setMessage(message);
        responseDto.setData(data);

    }
}
