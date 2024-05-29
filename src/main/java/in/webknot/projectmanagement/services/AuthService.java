package in.webknot.projectmanagement.services;

import in.webknot.projectmanagement.models.Allocation;
import in.webknot.projectmanagement.repositories.AllocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AllocationRepository allocationRepository;

    public Allocation createAllocation(Allocation allocation) {
        return allocationRepository.save(allocation);
    }

    public void deleteAllocation(Long id) {
        Allocation allocation = allocationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Allocation not found"));
        allocationRepository.delete(allocation);
    }

    // Other methods as needed
}
