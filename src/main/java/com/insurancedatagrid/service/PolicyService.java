package com.insurancedatagrid.service;

import java.util.List;

import com.insurancedatagrid.model.PolicyEntity;
import com.insurancedatagrid.repository.PolicyRepository;

import org.springframework.stereotype.Service;

@Service
public class PolicyService {
    private final PolicyRepository policyRepository;

    public PolicyService(PolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

    public List<PolicyEntity> getAllPolicies() {
        return  policyRepository.findAll();
    }

    public PolicyEntity savePolicy(PolicyEntity policy) {
        return policyRepository.save(policy);
    }

    public PolicyEntity getPolicyById(Integer id) {
        return policyRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Policy not found with id: " + id));
    }

    public void deletePolicy(PolicyEntity policy) {
        policyRepository.delete(policy);
    }
    
}
