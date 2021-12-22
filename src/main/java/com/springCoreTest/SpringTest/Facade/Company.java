package com.springCoreTest.SpringTest.Facade;

import com.springCoreTest.SpringTest.beans.Employee;
import com.springCoreTest.SpringTest.beans.Job;
import com.springCoreTest.SpringTest.repositories.EmployeeRepository;
import com.springCoreTest.SpringTest.repositories.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Company {
  private final  EmployeeRepository employeeRepo;
   private final JobRepository jobRepo;

    public void addEmployee(Employee employee){
        employeeRepo.save(employee);
    }
    public Employee getEmployeeByID(long id){return employeeRepo.findById(id);}
    public List<Employee> getEmployeesByName(String name){return employeeRepo.findByName(name);}
    public List<Employee> getAllEmployees(){return employeeRepo.findAll();}
    public List<Job> getAllJobs(){return jobRepo.findAll();}
    public List<Job> getJobByEndDate(Date date){return jobRepo.findByEndDate(date);}
    public List<Job> getJobBetweenDates(Date startDate, Date endDate){return jobRepo.findByEndDateBetween(startDate,endDate);}

}
