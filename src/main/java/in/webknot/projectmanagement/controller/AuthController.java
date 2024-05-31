package in.webknot.projectmanagement.controller;

import in.webknot.projectmanagement.entity.Allocation;
import in.webknot.projectmanagement.service.AllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AllocationService allocationService;

    @PostMapping("/allocations")
    public ResponseEntity<Allocation> createAllocation(@RequestBody Allocation allocation) {
        Allocation createdAllocation = allocationService.createAllocation(allocation);
        return ResponseEntity.ok(createdAllocation);
    }

    @DeleteMapping("/allocations/{id}")
    public ResponseEntity<Void> deleteAllocation(@PathVariable Long id) {
        allocationService.deleteAllocation(id);
        return ResponseEntity.noContent().build();
    }

    // Other methods as needed
}
