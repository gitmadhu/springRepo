package org.krams.service;

import java.util.List;

import org.krams.domain.PGraph;
import org.krams.repository.PGraphRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PGraphService {

	@Autowired
	private PGraphRepo graphRepo;
	
	
	public PGraph read(PGraph pGraph) {
		return pGraph;
	}
	
	public List<PGraph> readAll() {
		return graphRepo.findAll();
	}
	
	public PGraph update(PGraph pgraph) {
		String id = pgraph.getId();
		PGraph existingUser = graphRepo.findOne(id);
		
		if (existingUser == null) {
			return null;
		}
		
		existingUser.setTask(pgraph.getTask());
		existingUser.setProdF(pgraph.getProdF());
		return graphRepo.save(existingUser);
	}
	
	/*public Boolean delete(User user) {
		User existingUser = userRepository.findByUsername(user.getUsername());
		
		if (existingUser == null) {
			return false;
		}
		
		// We must delete both separately since there is no cascading feature
		// in Spring Data MongoDB (for now)
		roleRepository.delete(existingUser.getRole());
		userRepository.delete(existingUser);
		return true;
	}*/
}
