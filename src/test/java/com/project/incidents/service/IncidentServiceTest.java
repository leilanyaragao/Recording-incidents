package com.project.incidents.service;

import com.project.incidents.entities.IncidentEntity;
import com.project.incidents.repository.IncidentsRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RunWith(SpringRunner.class)
class IncidentServiceTest {

    @BeforeEach
    void setUp() {
        for(int i=1; i<=30; i++){
            incidentsService.saveIncident(new IncidentEntity(null, LocalDateTime.now(), "description" + i, "id" + i, "name" + i, null));
        }
    }

    @AfterEach
    void afterEach() {
        incidentsService.deleteAllIncidents();
    }

    @Test
    void deleteIncidentById() {
        incidentsService.deleteIncidentById("id" + 1);

        assertNull(incidentsService.findByIdIncident("id" + 0));
    }

    @Test
    void deleteIncidentByName() {
        incidentsService.deleteIncidentByName("name" + 1);

        assertNull(incidentsService.findByName("name" + 1));
    }

    @Test
    void findAllIncidents() {
        List<IncidentEntity> allIncidents = incidentsService.findAllIncidents();

        assertEquals(30, allIncidents.size());
    }

    @Test
    void findByIdIncident() {
        assertNotNull(incidentsService.findByIdIncident("id" + 1));
        assertNull(incidentsService.findByIdIncident("id" + 0));
    }

    @Test
    void findByName() {
        assertNotNull(incidentsService.findByName("name" + 1));
        assertNull(incidentsService.findByName("name" + 0));
    }

    @Test
    void findTop20IncidentsByOrderByCreatedAtDesc() {
        List<IncidentEntity> top20IncidentsByOrderByCreatedAtDesc = incidentsService.findTop20IncidentsByOrderByCreatedAtDesc();

        assertEquals(20, top20IncidentsByOrderByCreatedAtDesc.size());
    }

    @Test
    void saveIncident() {
        incidentsService.saveIncident(new IncidentEntity(null, LocalDateTime.now(), "saveDescription", "id44", "saveName", null));

        assertNotNull(incidentsService.findByName("saveName"));
    }

    @Test
    void updateIncident() {
        incidentsService.saveIncident(new IncidentEntity(null, LocalDateTime.now(), "saveDescription", "id44", "saveName", null));

        IncidentEntity incidentEntity = new IncidentEntity(LocalDateTime.now(), "updateDescription", "id44", "updateName");

        incidentsService.updateIncident(incidentEntity);

        assertNotNull(incidentsService.findByName("updateName"));
    }

    @Autowired
    private IncidentService incidentsService;
}