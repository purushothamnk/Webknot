package in.webknot.projectmanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.ArrayList;
import java.util.List;


import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String projectType;
    private String sourceClient;
    private String endClient;
    private String projectDescription;
    private String projectStatus;

    @ManyToOne
    private Employee accountManager;

    @ManyToOne
    private Employee projectManager;

    @OneToMany(mappedBy = "project")
    private List<ProjectAllocation> allocations;


}

