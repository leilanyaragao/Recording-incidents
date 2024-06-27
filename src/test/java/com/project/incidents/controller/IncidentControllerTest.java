package com.project.incidents.controller;

import com.project.incidents.entities.IncidentEntity;
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
class IncidentControllerTest {

    @BeforeEach
    void setUp() {
        for(int i=1; i<=30; i++){
            incidentController.postIncident(new IncidentEntity(null, LocalDateTime.now(), "description" + i, "id" + i, "name" + i, null));
        }
    }

    @AfterEach
    void afterEach() {
        incidentController.deleteAllIncidents();
    }

    @Test
    void deleteIncidentById() {
        incidentController.deleteIncidentById("id" + 1);

        assertNull(incidentController.getIncidentById("id" + 0));
    }

    @Test
    void deleteIncidentByName() {
        incidentController.deleteIncidentByName("name" + 1);

        assertNull(incidentController.getIncidentByName("name" + 1));
    }

    @Test
    void getAllIncident() {
        List<IncidentEntity> allIncidents = incidentController.getAllIncidents();

        assertEquals(30, allIncidents.size());
    }

    @Test
    void getIncidentById() {
        assertNotNull(incidentController.getIncidentById("id" + 1));
        assertNull(incidentController.getIncidentById("id" + 0));
    }

    @Test
    void getIncidentByName() {
        assertNotNull(incidentController.getIncidentByName("name" + 1));
        assertNull(incidentController.getIncidentByName("name" + 0));
    }

    @Test
    void getTop20IncidentByOrderByCreatedAtDesc() {
        List<IncidentEntity> top20IncidentsByOrderByCreatedAtDesc = incidentController.getTop20IncidentByOrderByCreatedAtDesc();

        assertEquals(20, top20IncidentsByOrderByCreatedAtDesc.size());
    }

    @Test
    void postIncident() {
        incidentController.postIncident(new IncidentEntity(null, LocalDateTime.now(), "saveDescription", "id44", "saveName", null));

        assertNotNull(incidentController.getIncidentByName("saveName"));
    }

    @Test
    void updateIncident() {
        incidentController.postIncident(new IncidentEntity(null, LocalDateTime.now(), "saveDescription", "id44", "saveName", null));

        IncidentEntity incidentEntity = new IncidentEntity(LocalDateTime.now(), "updateDescription", "id44", "updateName");

        incidentController.updateIncident(incidentEntity);

        assertNotNull(incidentController.getIncidentByName("updateName"));
    }

    @Autowired
    private IncidentController incidentController;
}