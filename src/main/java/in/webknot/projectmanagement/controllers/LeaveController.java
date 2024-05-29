package in.webknot.projectmanagement.controllers;

import in.webknot.projectmanagement.models.Leave;
import in.webknot.projectmanagement.services.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leaves")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    @PostMapping
    public ResponseEntity<Leave> createLeave(@RequestBody Leave leave) {
        Leave createdLeave = leaveService.createLeave(leave);
        return ResponseEntity.ok(createdLeave);
    }

    // Implement other endpoints for leave management as needed
}
