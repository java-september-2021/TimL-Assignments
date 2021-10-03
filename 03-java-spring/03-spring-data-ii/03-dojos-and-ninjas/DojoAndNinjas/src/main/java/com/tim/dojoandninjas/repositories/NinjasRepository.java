package com.tim.dojoandninjas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tim.dojoandninjas.models.Ninjas;

@Repository
public interface NinjasRepository extends CrudRepository<Ninjas, Long>  {

}
