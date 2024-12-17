package com.baggiovictor.creditsimulation.infrastructure.persistence;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditSimulationRepository extends JpaRepository<CreditSimulationEntity, String> {

  Page<CreditSimulationEntity> findAll(Pageable pageable);

  Optional<CreditSimulationEntity> findById(String id);
}
