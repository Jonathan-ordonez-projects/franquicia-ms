package com.api.franquicia.services.dto;

import com.api.franquicia.model.Branch;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FranchiseDto {

    private String franchisesName;
    private List<BranchDto> branches;
}
