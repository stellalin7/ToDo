package com.tts.ToDo.repository;

import org.springframework.data.repository.CrudRepository;

import com.tts.ToDo.model.Status;

public interface StatusRepository extends CrudRepository<Status, Long>{
	Status findByStatus(String status);

}
