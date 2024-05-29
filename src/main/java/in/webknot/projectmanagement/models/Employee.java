package in.webknot.projectmanagement.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTechStack() {
        return techStack;
    }

    public void setTechStack(String techStack) {
        this.techStack = techStack;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public int getYearsInWebknot() {
        return yearsInWebknot;
    }

    public void setYearsInWebknot(int yearsInWebknot) {
        this.yearsInWebknot = yearsInWebknot;
    }

    public List<Allocation> getAllocations() {
        return allocations;
    }

    public void setAllocations(List<Allocation> allocations) {
        this.allocations = allocations;
    }

    private String name;
    private String email;
    private String techStack;
    private int yearsOfExperience;
    private int yearsInWebknot;

    @OneToMany(mappedBy = "employee")
    private List<Allocation> allocations;

    // Getters and Setters
}
