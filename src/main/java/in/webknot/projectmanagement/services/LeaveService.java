package in.webknot.projectmanagement.services;


import in.webknot.projectmanagement.models.Leave;
import in.webknot.projectmanagement.repositories.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveService {

    @Autowired
    private LeaveRepository leaveRepository;

    public Leave addLeave(Leave leave) {
        return leaveRepository.save(leave);
    }

    public List<Leave> getLeavesByEmployeeId(Long employeeId) {
        // Logic to fetch leaves by employee ID
    }
}
