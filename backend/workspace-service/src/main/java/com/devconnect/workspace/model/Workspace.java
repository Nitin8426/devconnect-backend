package com.devconnect.workspace.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Workspace {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String description;

    @ElementCollection
    private List<UUID> members = new ArrayList<>();

    // Constructors
    public Workspace() {
    }

    public Workspace(String name, String description, List<UUID> members) {
        this.name = name;
        this.description = description;
        this.members = members;
    }

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<UUID> getMembers() {
        return members;
    }

    public void setMembers(List<UUID> members) {
        this.members = members;
    }
}
