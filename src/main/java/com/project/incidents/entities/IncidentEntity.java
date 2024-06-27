package com.project.incidents.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "urls")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IncidentEntity {

    public IncidentEntity(LocalDateTime closedAt, String description, String idIncident, String name) {
        this.closedAt = closedAt;
        this.description = description;
        this.idIncident = idIncident;
        this.name = name;
    }

    private LocalDateTime closedAt;
    private LocalDateTime createdAt;
    private String description;
    @Id
    private String idIncident;
    private String name;
    private LocalDateTime updatedAt;
}