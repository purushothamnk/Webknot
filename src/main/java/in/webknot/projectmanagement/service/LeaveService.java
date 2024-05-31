package in.webknot.projectmanagement.service;

import in.webknot.projectmanagement.entity.Leave;

import java.util.List;

public interface LeaveService {
    Leave requestLeave(Leave leave);
    List<Leave> getLeavesByEmployee(Long employeeId);
}
