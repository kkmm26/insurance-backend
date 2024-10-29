package com.insurancedatagrid.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client", schema = "public", catalog = "insurance_data_grid")
public class ClientEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "client_id", nullable = false)
    private int clientId;

    @Column(name = "client_name", nullable = false, length = 255)
    private String clientName;

    @Column(name = "client_phone", nullable = false)
    private Integer clientPhone;


    @Column(name = "client_contact", nullable = false)
    private String clientContact;

    @JsonIgnoreProperties("client")
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PolicyEntity> policies;
}
