package com.exam.demo.repositories;

import com.exam.demo.models.Supervisor;
import org.springframework.data.repository.CrudRepository;

public interface SupervisorRepository extends CrudRepository<Supervisor, Long> {
}
