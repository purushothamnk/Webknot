package in.webknot.projectmanagement.repositories;

import in.webknot.projectmanagement.models.Allocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllocationRepository extends JpaRepository<Allocation, Long> {
}