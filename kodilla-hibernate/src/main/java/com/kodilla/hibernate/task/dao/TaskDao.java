package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.Task;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public interface TaskDao extends CrudRepository<Task, Integer> {

    List<Task> findByDuration(int duration);
}
