package com.api.franquicia.repositories;

import com.api.franquicia.model.Franchise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FranchiseRepository extends JpaRepository<Franchise, Long> {

}
