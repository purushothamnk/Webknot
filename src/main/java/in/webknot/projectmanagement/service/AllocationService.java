package in.webknot.projectmanagement.service;

import in.webknot.projectmanagement.entity.Allocation;
import in.webknot.projectmanagement.repository.AllocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import in.webknot.projectmanagement.entity.Allocation;



public interface AllocationService {
    Allocation allocateEmployeeToProject(Allocation allocation);
    void removeEmployeeFromProject(Long allocationId);
    List<Allocation> getAllocationsByProject(Long projectId);
}
