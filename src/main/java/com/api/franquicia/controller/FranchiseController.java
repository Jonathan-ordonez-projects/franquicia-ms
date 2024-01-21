package com.api.franquicia.controller;

import com.api.franquicia.commons.response.ResponseDto;
import com.api.franquicia.model.Franchise;
import com.api.franquicia.services.FranchiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "franchises", produces = MediaType.APPLICATION_JSON_VALUE)
public class FranchiseController {

    @Autowired
    private FranchiseService franchiseService;

    @PostMapping
    public ResponseDto createFranchise(@RequestBody Franchise franchise){
        return franchiseService.createFranchise(franchise);
    }

    @PostMapping("edit/{id}")
    public ResponseDto updateFranchise(@RequestBody Franchise franchise, @PathVariable Long id){
        franchise.setId(id);
        return franchiseService.updateFranchise(franchise);
    }

    @GetMapping("/{id}/max-product-for-branch")
    public ResponseDto getProductMaxStock(@PathVariable Long id){
        return franchiseService.getProductsStockForbranchForFranchise(id);
    }
}
