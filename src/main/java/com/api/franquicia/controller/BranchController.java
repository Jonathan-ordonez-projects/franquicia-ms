package com.api.franquicia.controller;

import com.api.franquicia.commons.response.ResponseDto;
import com.api.franquicia.model.Branch;
import com.api.franquicia.repositories.FranchiseRepository;
import com.api.franquicia.services.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping
public class BranchController {

    @Autowired
    private BranchService branchService;

    @Autowired
    private FranchiseRepository franchiseRepository;

    @PostMapping("branch/edit/{id}")
    public ResponseDto updateBranch(@RequestBody Branch branch, @PathVariable Long id) {
        branch.setId(id);
        return branchService.updateBranch(branch);
    }

    @PostMapping("franchises/{idFranchise}/branch")
    public ResponseDto addBranch(@RequestBody Branch branch, @PathVariable Long idFranchise) {
        return branchService.createBranch(branch, idFranchise);
    }

}
