package com.mongo.jobquest.repo;

import com.mongo.jobquest.model.Post;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface postRepository {
    List<Post> findByText(String text);
}
