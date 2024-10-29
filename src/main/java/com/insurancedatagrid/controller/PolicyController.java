package com.insurancedatagrid.controller;

import com.insurancedatagrid.model.ClientEntity;
import com.insurancedatagrid.model.PolicyEntity;
import com.insurancedatagrid.service.ClientService;
import com.insurancedatagrid.service.PolicyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.insurancedatagrid.dto.PolicyRequestDTO;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/policies")
@CrossOrigin(origins = "*")
public class PolicyController {

    private final ClientService clientService;
    private final PolicyService policyService;

    public PolicyController(ClientService clientService, PolicyService policyService) {
        this.clientService = clientService;
        this.policyService = policyService;
    }

    @GetMapping
    public List<PolicyRequestDTO> findAllPolicies() {
        return policyService.getAllPolicies().stream()
                .<PolicyRequestDTO>map(policy -> PolicyRequestDTO.builder()
                        .clientName(policy.getClient().getClientName())
                        .clientPhone(policy.getClient().getClientPhone())
                        .clientContact(policy.getClient().getClientContact())
                        .policyType(policy.getPolicyType())
                        .companyName(policy.getCompanyName())
                        .policyNumber(policy.getPolicyNumber())
                        .policyStatus(policy.getPolicyStatus())
                        .sumInsured(policy.getSumInsured())
                        .premiumAmount(policy.getPremiumAmount())
                        .startDate(policy.getStartDate())
                        .expiryDate(policy.getExpiryDate())
                        .commissionStatus(policy.getCommissionStatus())
                        .commissionAmount(policy.getCommissionAmount())
                        .commissionRate(policy.getCommissionRate())
                        .remarks(policy.getRemarks())
                        .build())
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<PolicyEntity> createPolicy(@RequestBody PolicyRequestDTO policyRequest) {
        ClientEntity client = ClientEntity.builder()
                .clientName(policyRequest.getClientName())
                .clientPhone(policyRequest.getClientPhone())
                .clientContact(policyRequest.getClientContact())
                .build();
        
        client = clientService.findOrCreateClient(client);
        
        PolicyEntity policy = PolicyEntity.builder()
                .client(client)
                .policyType(policyRequest.getPolicyType())
                .companyName(policyRequest.getCompanyName())
                .policyNumber(policyRequest.getPolicyNumber())
                .policyStatus(policyRequest.getPolicyStatus())
                .sumInsured(policyRequest.getSumInsured())
                .premiumAmount(policyRequest.getPremiumAmount())
                .startDate(policyRequest.getStartDate())
                .expiryDate(policyRequest.getExpiryDate())
                .commissionStatus(policyRequest.getCommissionStatus())
                .commissionAmount(policyRequest.getCommissionAmount())
                .commissionRate(policyRequest.getCommissionRate())
                .remarks(policyRequest.getRemarks())
                .build();
        
        policy = policyService.savePolicy(policy);
        
        return ResponseEntity.ok(policy);
    }
}
