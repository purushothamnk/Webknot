package in.webknot.projectmanagement.service.impl;

import in.webknot.projectmanagement.entity.Allocation;
import in.webknot.projectmanagement.repository.AllocationRepository;
import in.webknot.projectmanagement.service.AllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectAllocationServiceImpl implements AllocationService {
    @Autowired
    private AllocationRepository projectAllocationRepository;

    @Override
    public Allocation allocateEmployeeToProject(Allocation allocation) {
        return projectAllocationRepository.save(allocation);
    }

    @Override
    public void removeEmployeeFromProject(Long allocationId) {
        projectAllocationRepository.deleteById(allocationId);
    }

    @Override
    public List<Allocation> getAllocationsByProject(Long projectId) {
        return projectAllocationRepository.findAll().stream()
                .filter(allocation -> allocation.getProject().getId().equals(projectId))
                .collect(Collectors.toList());
    }
}
