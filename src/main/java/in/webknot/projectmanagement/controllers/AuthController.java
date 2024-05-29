package in.webknot.projectmanagement.controllers;

import in.webknot.projectmanagement.models.Allocation;
import in.webknot.projectmanagement.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/allocations")
    public ResponseEntity<Allocation> createAllocation(@RequestBody Allocation allocation) {
        Allocation createdAllocation = authService.createAllocation(allocation);
        return ResponseEntity.ok(createdAllocation);
    }

    @DeleteMapping("/allocations/{id}")
    public ResponseEntity<Void> deleteAllocation(@PathVariable Long id) {
        authService.deleteAllocation(id);
        return ResponseEntity.noContent().build();
    }

    // Other methods as needed
}
