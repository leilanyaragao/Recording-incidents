package com.project.incidents.repository;

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
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
class IncidentsRepositoryTest {

    @BeforeEach
    void setUp() {
        for(int i=1; i<=30; i++){
            incidentsRepository.save(new IncidentEntity(null, LocalDateTime.now(), "description" + i, "id" + i, "name" + i, null));
        }
    }

    @AfterEach
    void afterEach() {
        incidentsRepository.deleteAll();
    }

    @Test
    void findIncidentByIdIncident() {
        assertNotNull(incidentsRepository.findIncidentByIdIncident("id" + 26));
        assertNull(incidentsRepository.findIncidentByIdIncident("id" + 0));
    }

    @Test
    void findIncidentByName() {
        assertNotNull(incidentsRepository.findIncidentByName("name" + 1));
        assertNull(incidentsRepository.findIncidentByName("name" + 33));
    }

    @Test
    void findTop20ByOrderByCreatedAtDesc() {
        List<IncidentEntity> top20IncidentsByOrderByCreatedAtDesc = incidentsRepository.findTop20ByOrderByCreatedAtDesc();

        assertEquals(20, top20IncidentsByOrderByCreatedAtDesc.size());
    }

    @Autowired
    private IncidentsRepository incidentsRepository;
}