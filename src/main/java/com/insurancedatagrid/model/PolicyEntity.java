package com.insurancedatagrid.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "policy", schema = "public", catalog = "insurance_data_grid")
public class PolicyEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "policy_id", nullable = false)
    private int policyId;

    @JsonIgnoreProperties("policies")
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private ClientEntity client;

    @Column(name = "policy_number", nullable = false, length = 50)
    private String policyNumber;
    @Column(name = "policy_type", nullable = false, length = 20)
    private String policyType;
    @Column(name = "company_name", nullable = false, length = 50)
    private String companyName;
    @Column(name = "sum_insured", nullable = false, precision = 15, scale = 2)
    private BigDecimal sumInsured;
    @Column(name = "premium_amount", nullable = false, precision = 15, scale = 2)
    private BigDecimal premiumAmount;
    @Column(name = "start_date", nullable = false)
    private String startDate;
    @Column(name = "expiry_date", nullable = false)
    private String expiryDate;
    @Column(name = "policy_status", nullable = false, length = 10)
    private String policyStatus;
    @Column(name = "commission_status", nullable = true, length = 10)
    private String commissionStatus;
    @Column(name = "commission_amount", nullable = true, precision = 15, scale = 2)
    private BigDecimal commissionAmount;

    @Column(name = "commission_rate", nullable = true, precision = 5, scale = 2)
    private BigDecimal commissionRate;

    @Column(name = "remarks", nullable = true)
    private String remarks;




}
