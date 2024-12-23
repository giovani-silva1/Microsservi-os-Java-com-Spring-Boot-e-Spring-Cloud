package com.giovanidev.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.giovanidev.hrworker.entity.Worker;

@Repository
public interface WorkerRepository extends JpaRepository<Worker,Long> {

}
