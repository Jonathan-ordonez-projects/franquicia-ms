package com.api.franquicia.services.impl;

import com.api.franquicia.commons.exceptions.RequestException;
import com.api.franquicia.commons.response.ResponseDto;
import com.api.franquicia.commons.response.ResponseOkDto;
import com.api.franquicia.model.Branch;
import com.api.franquicia.model.Franchise;
import com.api.franquicia.model.Product;
import com.api.franquicia.repositories.FranchiseRepository;
import com.api.franquicia.services.FranchiseService;
import com.api.franquicia.services.dto.BranchDto;
import com.api.franquicia.services.dto.FranchiseDto;
import com.api.franquicia.services.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.api.franquicia.commons.constants.Constants.*;

@Service
public class FranchiseServiceImpl implements FranchiseService {

    @Autowired
    private FranchiseRepository franchiseRepository;

    public ResponseDto createFranchise(Franchise franchise){
        if(franchise.getName()== null || franchise.getName() == ""){
            throw new RequestException(BODYREQUESTINCORRECT, CODEREQUESTINCORRECT, HttpStatus.BAD_REQUEST);
        }
        ResponseDto responseDto = new ResponseDto();
        franchiseRepository.save(franchise);
        new ResponseOkDto(responseDto, FRANCHISECREATEOK, franchise);
        return responseDto;
    }

    public ResponseDto updateFranchise(Franchise franchise){
        Optional<Franchise> franchiseUpdate = franchiseRepository.findById(franchise.getId());
        if(franchiseUpdate.isEmpty()){
            throw new RequestException(IDFRANCHISENOTEXIST, CODEFRANCHISENOTEXIST, HttpStatus.BAD_REQUEST);
        }
        if(franchise.getName()== null || franchise.getName() == ""){
            throw new RequestException(BODYREQUESTINCORRECT, CODEREQUESTINCORRECT, HttpStatus.BAD_REQUEST);
        }
        ResponseDto responseDto = new ResponseDto();
        franchiseRepository.save(franchise);
        new ResponseOkDto(responseDto, FRANCHISEUPDATEOK,franchise);
        return responseDto;
    }

    public ResponseDto getProductsStockForbranchForFranchise(Long id) {
        Optional<Franchise> franchise = franchiseRepository.findById(id);
        if (franchise.isEmpty()){
            throw new RequestException(IDFRANCHISENOTEXIST,CODEFRANCHISENOTEXIST,HttpStatus.BAD_REQUEST);
        }
        List<Branch> branches = franchise.get().getBranches();
        ArrayList<ProductDto> listProduct = new ArrayList<>();
        ArrayList<BranchDto> listBranch = new ArrayList<>();
        for (Branch branch : branches) {
            ProductDto productDto = new ProductDto();
            BranchDto branchDto = new BranchDto();
            List<Product> products = branch.getProducts();
            if(!products.isEmpty()) {
                Product product = products.stream()
                        .max(Comparator.comparingDouble(product1 -> product1.getStock()))
                        .orElse(null);
                productDto.setStock(product.getStock());
                productDto.setName(product.getName());
                listProduct.add(productDto);
                branchDto.setNameBranch(branch.getName());
                branchDto.setProductWithMoreStoke(productDto);
                listBranch.add(branchDto);
            }
        }
        FranchiseDto franchiseDto = new FranchiseDto();
        franchiseDto.setFranchisesName(franchise.get().getName());
        franchiseDto.setBranches(listBranch);
        ResponseDto responseDto = new ResponseDto();
        new ResponseOkDto(responseDto,GETPRODUCTFORBRANCHFORFRANCHISE,franchiseDto);
        return responseDto;
    }
}
