package com.cpuscrp.scrapp.db;

import com.cpuscrp.scrapp.model.Gpu;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GpuRepository extends MongoRepository<Gpu, String>, CustomGpuRepository {

}
