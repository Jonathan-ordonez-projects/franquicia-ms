package com.api.franquicia.services.impl;

import com.api.franquicia.commons.exceptions.RequestException;
import com.api.franquicia.commons.response.ResponseDto;
import com.api.franquicia.commons.response.ResponseOkDto;
import com.api.franquicia.model.Branch;
import com.api.franquicia.model.Franchise;
import com.api.franquicia.repositories.BranchRepository;
import com.api.franquicia.repositories.FranchiseRepository;
import com.api.franquicia.services.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.api.franquicia.commons.constants.Constants.*;

@Service
public class BranchServiceImpl implements BranchService {

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private FranchiseRepository franchiseRepository;

    public ResponseDto createBranch(Branch branch, Long idFranchise) {
        Optional<Franchise> franchise = franchiseRepository.findById(idFranchise);
        if(franchise.isEmpty()){
            throw new RequestException(IDFRANCHISENOTEXIST, CODEFRANCHISENOTEXIST, HttpStatus.BAD_REQUEST);
        }
        if(branch.getName()== null || branch.getName() == ""){
            throw new RequestException(BODYREQUESTINCORRECT, CODEREQUESTINCORRECT, HttpStatus.BAD_REQUEST);
        }
        ResponseDto responseDto = new ResponseDto();
        branch.setFranchise(franchise.get());
        branchRepository.save(branch);
        new ResponseOkDto(responseDto,IDBRANCHCREATEOK,branch);
        return responseDto;
    }

    public ResponseDto updateBranch(Branch branch) {
        Optional<Branch> branchExist = branchRepository.findById(branch.getId());
        if (branchExist.isEmpty()){
            throw new RequestException(IDBRANCHNOTEXIST, CODEBRANCHNOTEXIST, HttpStatus.BAD_REQUEST);
        }
        if(branch.getName()== null || branch.getName() == ""){
            throw new RequestException(BODYREQUESTINCORRECT, CODEREQUESTINCORRECT, HttpStatus.BAD_REQUEST);
        }
        Branch branchActual = branchExist.get();
        branch.setFranchise(branchActual.getFranchise());
        branchRepository.save(branch);
        ResponseDto responseDto = new ResponseDto();
        new ResponseOkDto(responseDto,IDBRANCHUPDATEOK,branch);
        return responseDto;
    }
}
