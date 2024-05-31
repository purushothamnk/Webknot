package in.webknot.projectmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
//@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
public class Allocation {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String projectRole;
        private int allocationPercentage;
        private int durationWeeks;

        @ManyToOne
        private Project project;

        @ManyToOne
        private Employee employee;

        // getters and setters
    }
