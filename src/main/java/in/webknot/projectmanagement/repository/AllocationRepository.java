package in.webknot.projectmanagement.repository;

import in.webknot.projectmanagement.entity.Allocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllocationRepository extends JpaRepository<Allocation, Long> {
}