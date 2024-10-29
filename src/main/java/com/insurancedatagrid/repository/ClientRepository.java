package com.insurancedatagrid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.insurancedatagrid.model.ClientEntity;

public interface ClientRepository extends JpaRepository<ClientEntity, Integer> {
    Optional<ClientEntity> findByClientPhone(Integer phone);
    Optional<ClientEntity> findByClientName(String name);
    ClientEntity findByClientPhoneAndClientName(Integer phone, String name);
}
