package com.viewnext.api;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "garbage", path = "garbage")
public interface GarbageRepository extends CrudRepository<Garbage, Integer> {

}
