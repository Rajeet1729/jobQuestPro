package com.mongo.jobquest.repo;

import com.mongo.jobquest.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface searchRepository extends MongoRepository<Post, String>{

}
