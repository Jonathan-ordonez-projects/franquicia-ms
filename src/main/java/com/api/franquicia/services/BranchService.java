package com.api.franquicia.services;

import com.api.franquicia.commons.response.ResponseDto;
import com.api.franquicia.model.Branch;

public interface BranchService {

    ResponseDto createBranch(Branch branch, Long idFranchise);

    ResponseDto updateBranch(Branch branch) ;
}
