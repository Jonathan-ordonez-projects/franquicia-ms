package com.api.franquicia.services.impl;

import com.api.franquicia.commons.exceptions.RequestException;
import com.api.franquicia.commons.response.ResponseDto;
import com.api.franquicia.commons.response.ResponseOkDto;
import com.api.franquicia.model.Branch;
import com.api.franquicia.model.Product;
import com.api.franquicia.repositories.BranchRepository;
import com.api.franquicia.repositories.ProductRepository;
import com.api.franquicia.services.ProductService;
import com.api.franquicia.services.dto.ProductRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.api.franquicia.commons.constants.Constants.*;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BranchRepository branchRepository;

    public ResponseDto createProduct(ProductRequestDto productRequestDto, Long idBranch){
        Optional<Branch> branch = branchRepository.findById(idBranch);
        if (branch.isEmpty()){
            throw new RequestException(IDBRANCHNOTEXIST, CODEBRANCHNOTEXIST, HttpStatus.BAD_REQUEST);
        }
        if(productRequestDto.getName() == null || productRequestDto.getStock() == null){
            throw new RequestException(BODYREQUESTINCORRECT, CODEREQUESTINCORRECT, HttpStatus.BAD_REQUEST);
        }

        List<Branch> branches = new ArrayList<>();
        branches.add(branch.get());
        Product product = Product.builder().name(productRequestDto.getName())
                .stock(productRequestDto.getStock()).branches(branches).build();
        productRepository.save(product);
        ResponseDto responseDto = new ResponseDto();
        new ResponseOkDto(responseDto,PRODUCTCREATEOK,product);
        return responseDto;
    }

    public ResponseDto updateProduct(ProductRequestDto productRequestDto, Long id) {
        Optional<Product> productExist = productRepository.findById(id);
        if (!productExist.isPresent()){
            throw new RequestException(IDPRODUCTNOTEXIST, CODEPRODUCTNOTEXIST, HttpStatus.BAD_REQUEST);
        }
        if(productRequestDto.getName() == null || productRequestDto.getStock() == null){
            throw new RequestException(BODYREQUESTINCORRECT, CODEREQUESTINCORRECT, HttpStatus.BAD_REQUEST);
        }
        if(!Objects.isNull(productRequestDto.getName())){
            productExist.get().setName(productRequestDto.getName());
        }
        if(Objects.nonNull(productRequestDto.getStock())){
            productExist.get().setStock(productRequestDto.getStock());
        }
        productRepository.save(productExist.get());
        ResponseDto responseDto = new ResponseDto();
        new ResponseOkDto(responseDto,"",productExist.get());
        return responseDto;
    }
}
