package com.project.incidents.controller;

import com.project.incidents.entities.IncidentEntity;
import com.project.incidents.service.IncidentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Controller
public class IncidentController {

    @DeleteMapping
    public ResponseEntity deleteAllIncidents() {
        return incidentService.deleteAllIncidents();
    }

    @DeleteMapping("deleteById/{idIncident}")
    public ResponseEntity deleteIncidentById(@PathVariable(value = "idIncident") String idIncident) {
        return incidentService.deleteIncidentById(idIncident);
    }

    @DeleteMapping("deleteByName/{incidentName}")
    public ResponseEntity<Object> deleteIncidentByName(@PathVariable(value = "incidentName") String incidentName) {
        return incidentService.deleteIncidentByName(incidentName);
    }

    @GetMapping
    public List<IncidentEntity> getAllIncidents() {
        return incidentService.findAllIncidents();
    }

    @GetMapping("/id/{idIncident}")
    public IncidentEntity getIncidentById(@PathVariable("idIncident") String idIncident) {
        return incidentService.findByIdIncident(idIncident);
    }

    @GetMapping("/name/{incidentName}")
    public IncidentEntity getIncidentByName(@PathVariable("incidentName") String incidentName) {
        return incidentService.findByName(incidentName);
    }

    @GetMapping("/find")
    public List<IncidentEntity> getTop20IncidentByOrderByCreatedAtDesc() {
        return incidentService.findTop20IncidentsByOrderByCreatedAtDesc();
    }

    @PostMapping
    public IncidentEntity postIncident(@RequestBody IncidentEntity incident) {
        return incidentService.saveIncident(incident);
    }

    @PutMapping
    public IncidentEntity updateIncident(@RequestBody IncidentEntity incident) {
        return incidentService.updateIncident(incident);
    }

    private final IncidentService incidentService;
}