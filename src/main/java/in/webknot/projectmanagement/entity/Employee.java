package in.webknot.projectmanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String techStack;
    private int yearsOfExperience;
    private int yearsOfExperienceInWebknot;

    @OneToMany(mappedBy = "employee")
    private List<ProjectAllocation> allocations;

    // getters and setters
}

