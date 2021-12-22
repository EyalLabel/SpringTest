package com.springCoreTest.SpringTest.CLR;

import com.springCoreTest.SpringTest.Facade.Company;
import com.springCoreTest.SpringTest.beans.Employee;
import com.springCoreTest.SpringTest.beans.Job;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
@Order(1)
public class CommandLineClass implements CommandLineRunner {
    private final Company company;

    @Override
    public void run(String... args) throws Exception {
        Job job1 = Job.builder()
                .description("Close a deal with client")
                .endDate(Date.valueOf(LocalDate.of(2021, 7, 20)))
                .build();
        Job job2 = Job.builder()
                .description("File a report")
                .endDate(Date.valueOf(LocalDate.of(2021, 7, 11)))
                .build();
        Employee employee1 = Employee.builder()
                .name("Lior")
                .salary(45_500)
                .jobs(Arrays.asList(job1, job2))
                .build();
        Job job3 = Job.builder()
                .description("Do code maintenance")
                .endDate(Date.valueOf(LocalDate.of(2021, 8, 1)))
                .build();
        Job job4 = Job.builder()
                .description("Sabotage competing company")
                .endDate(Date.valueOf(LocalDate.of(2021, 8, 14)))
                .build();
        Employee employee2 = Employee.builder()
                .name("Natalie")
                .salary(80_000)
                .jobs(Arrays.asList(job3, job4))
                .build();
        company.addEmployee(employee1);
        company.addEmployee(employee2);
        System.out.println(company.getEmployeeByID(2));
        System.out.println(company.getEmployeesByName("Lior"));
        System.out.println(company.getAllEmployees());
        System.out.println(company.getAllJobs());
        System.out.println(company.getJobByEndDate(Date.valueOf(LocalDate.of(2021, 8, 14))));
        System.out.println(company.getJobBetweenDates(Date.valueOf(LocalDate.of(2021, 7, 11)), Date.valueOf(LocalDate.of(2021, 8, 1))));
    }
}
