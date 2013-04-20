package org.krams.repository;

import org.krams.domain.PGraph;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PGraphRepo extends MongoRepository<PGraph, String> {
	
}
