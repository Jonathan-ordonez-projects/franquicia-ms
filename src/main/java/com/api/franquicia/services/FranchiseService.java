package com.api.franquicia.services;

import com.api.franquicia.commons.response.ResponseDto;
import com.api.franquicia.model.Franchise;
import com.api.franquicia.services.dto.FranchiseDto;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FranchiseService {

    ResponseDto createFranchise(Franchise franchise);

    ResponseDto updateFranchise(Franchise franchise);

    ResponseDto getProductsStockForbranchForFranchise(Long id);

}
