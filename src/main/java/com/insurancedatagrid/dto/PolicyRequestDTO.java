package com.insurancedatagrid.dto;

import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PolicyRequestDTO {
    private int id;
    // Client fields
    private String clientName;
    private Integer clientPhone;
    private String clientContact;
    
    // Policy fields
    private String policyType;
    private String companyName;
    private String policyNumber;
    private String policyStatus;
    private BigDecimal sumInsured;
    private BigDecimal premiumAmount;
    private String startDate;
    private String expiryDate;
    private String commissionStatus;
    private BigDecimal commissionAmount;
    private BigDecimal commissionRate;
    private String remarks;
}
