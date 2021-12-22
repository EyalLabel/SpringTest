package com.springCoreTest.SpringTest.repositories;

import com.springCoreTest.SpringTest.beans.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface JobRepository extends JpaRepository<Job,Integer> {
    List<Job> findByEndDate(Date date);
    List<Job> findByEndDateBetween(Date startDate, Date endDate);
}
