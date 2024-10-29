package com.insurancedatagrid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.insurancedatagrid.model.PolicyEntity;

public interface PolicyRepository extends JpaRepository<PolicyEntity, Integer> {
    
}
