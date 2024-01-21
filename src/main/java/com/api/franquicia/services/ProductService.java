package com.api.franquicia.services;

import com.api.franquicia.commons.response.ResponseDto;
import com.api.franquicia.model.Product;
import com.api.franquicia.services.dto.ProductRequestDto;

import java.util.List;

public interface ProductService {

    ResponseDto createProduct(ProductRequestDto productRequestDto, Long idBranch) ;

    ResponseDto updateProduct(ProductRequestDto productRequestDto, Long id) ;

}
