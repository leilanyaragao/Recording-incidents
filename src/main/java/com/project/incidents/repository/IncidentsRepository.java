package com.project.incidents.repository;

import com.project.incidents.entities.IncidentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncidentsRepository extends MongoRepository<IncidentEntity, String> {
    IncidentEntity findIncidentByIdIncident(String idIncident);

    IncidentEntity findIncidentByName(String name);

    List<IncidentEntity> findTop20ByOrderByCreatedAtDesc();
}