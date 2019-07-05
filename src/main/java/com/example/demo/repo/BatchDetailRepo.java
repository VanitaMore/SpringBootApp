package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.BatchDetail;

@Repository
public interface BatchDetailRepo extends JpaRepository<BatchDetail, String> {

	BatchDetail findBatchDetailByChunkID(final String chunkID);


	
}
