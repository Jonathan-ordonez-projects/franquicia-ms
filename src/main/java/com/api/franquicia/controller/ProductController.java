package com.api.franquicia.controller;

import com.api.franquicia.commons.response.ResponseDto;
import com.api.franquicia.services.ProductService;
import com.api.franquicia.services.dto.ProductRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("product/edit/{id}")
    public ResponseDto updateProduct(@RequestBody ProductRequestDto productRequestDto, @PathVariable Long id){
        return productService.updateProduct(productRequestDto, id);
    }

    @PostMapping("branch/{idBranch}/product")
    public ResponseDto addProduct(@RequestBody ProductRequestDto productRequestDto, @PathVariable Long idBranch){
        return productService.createProduct(productRequestDto, idBranch);
    }

}