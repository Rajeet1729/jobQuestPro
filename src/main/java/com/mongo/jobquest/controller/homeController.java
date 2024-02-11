package com.mongo.jobquest.controller;

import com.mongo.jobquest.model.Post;
import com.mongo.jobquest.repo.postRepository;
import com.mongo.jobquest.repo.searchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/job")
public class homeController {
    @Autowired
    private searchRepository repo;
    @Autowired
    private postRepository postRepo;

    @GetMapping("/allPosts")
    public List<Post> getAllPost(){
        System.out.println("getAllPosts");
        return repo.findAll();
    }

    @GetMapping("/allPosts/{text}")
    public List<Post> search(@PathVariable String text){
        System.out.println("inSearch");
        List<Post> ans = new ArrayList<>();
        try {
            ans =postRepo.findByText(text);
        }catch(Exception e){
            System.out.println(e);
        }
        return ans;
    }

    @PostMapping("/savePost")
    @CrossOrigin
    public Post savePost(@RequestBody Post post){
        System.out.println("InSavePost");
        return repo.save(post);
    }

    @DeleteMapping("/del/{_id}")
    public void deletePost(@PathVariable int _id){
        System.out.println("deletePost");
        try {
            repo.deleteById(String.valueOf(_id));
        }catch(Exception e){
            System.out.println(e);
        }
    }

}
