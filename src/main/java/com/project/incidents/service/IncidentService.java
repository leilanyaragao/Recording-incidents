package com.project.incidents.service;

import com.project.incidents.entities.IncidentEntity;
import com.project.incidents.repository.IncidentsRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
@Service
public class IncidentService {

    public ResponseEntity deleteAllIncidents() {
        incidentsRepository.deleteAll();

        return new ResponseEntity<>(HttpStatus.OK);
    }
    public ResponseEntity deleteIncidentById(String idIncident) {

        IncidentEntity incident = incidentsRepository.findIncidentByIdIncident(idIncident);

        if (incident != null) {
            incidentsRepository.delete(incident);

            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity deleteIncidentByName(String nameIncident) {
        IncidentEntity incident = incidentsRepository.findIncidentByName(nameIncident);

        if (incident != null) {
            incidentsRepository.delete(incident);

            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public List<IncidentEntity> findAllIncidents() {
        return incidentsRepository.findAll();
    }

    public IncidentEntity findByIdIncident(String idIncident) {
        return incidentsRepository.findIncidentByIdIncident(idIncident);
    }

    public IncidentEntity findByName(String name) {
        return incidentsRepository.findIncidentByName(name);
    }


    public List<IncidentEntity> findTop20IncidentsByOrderByCreatedAtDesc() {
        return incidentsRepository.findTop20ByOrderByCreatedAtDesc();
    }

    public IncidentEntity saveIncident(IncidentEntity incident) {
        if(incident.getIdIncident() != null){
            return incidentsRepository.save(new IncidentEntity(incident.getClosedAt(), LocalDateTime.now(), incident.getDescription(), incident.getIdIncident(), incident.getName(), incident.getUpdatedAt()));
        }

        return incidentsRepository.save(new IncidentEntity(incident.getClosedAt(), LocalDateTime.now(), incident.getDescription(), new Random().toString(), incident.getName(), incident.getUpdatedAt()));
    }

    public IncidentEntity updateIncident(IncidentEntity incident) {

        IncidentEntity incidentByIdIncident = incidentsRepository.findIncidentByIdIncident(incident.getIdIncident());

        if (incident.getName() != null) {
            incidentByIdIncident.setName(incident.getName());
        }

        if (incident.getDescription() != null) {
            incidentByIdIncident.setDescription(incident.getDescription());
        }

        if (incident.getClosedAt() != null) {
            incidentByIdIncident.setClosedAt(incident.getClosedAt());
        }

        incidentByIdIncident.setUpdatedAt(LocalDateTime.now());

        return incidentsRepository.save(incidentByIdIncident);
    }

    private final IncidentsRepository incidentsRepository;
}
