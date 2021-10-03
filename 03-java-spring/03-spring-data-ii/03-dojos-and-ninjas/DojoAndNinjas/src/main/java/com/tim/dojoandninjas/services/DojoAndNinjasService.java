package com.tim.dojoandninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tim.dojoandninjas.models.Dojo;
import com.tim.dojoandninjas.models.Ninjas;
import com.tim.dojoandninjas.repositories.DojoRepository;
import com.tim.dojoandninjas.repositories.NinjasRepository;

@Service
public class DojoAndNinjasService {
	@Autowired
	private DojoRepository dRepo;
	@Autowired
	private NinjasRepository nRepo;

	public List<Dojo> allDojos(){
		return this.dRepo.findAll();
	}
	
	public Dojo createDojo(Dojo dojo){
		return this.dRepo.save(dojo);
	}
	
	public Ninjas createNinja(Ninjas ninjas) {
		return this.nRepo.save(ninjas);
	}
	
	public Dojo getOneDojo(Long id) {
		return this.dRepo.findById(id).orElse(null);
	}
	
}
