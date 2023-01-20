package com.nrk.yathra.server.controller;

import com.nrk.yathra.server.dto.Post;
import com.nrk.yathra.server.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Post")
@CrossOrigin
public class PostController {
    @Autowired
    private PostServiceImpl postServiceImpl;

    @PostMapping("/createNewPost")
    public Post createNewPost(@RequestBody Post post) throws Exception {
       return postServiceImpl.createNewPost(post);
    }
    @PostMapping("/updatePost")
    public Post updatePost(@RequestBody Post post) throws Exception {
        return postServiceImpl.updatePost(post);
    }
    @DeleteMapping ("/deletePost/{postId}")
    public String deletePost(@PathVariable int postId) throws Exception {
        return postServiceImpl.deletePost(postId);
    }
    @GetMapping("/readAllPosts")
    public List<Post> readAllPosts() throws Exception {
        return postServiceImpl.readAllPosts();
    }

    @GetMapping("/readSpecificPost/{postId}")
    public Post readSpecificPost(@PathVariable int postId) throws Exception {
        return postServiceImpl.readSpecificPost(postId);
    }
    @PostMapping("/addNewComment/{postId}/{comment}")
    public String addNewComment(@PathVariable int postId ,@PathVariable String comment) throws Exception {
        return postServiceImpl.addNewComment(postId,comment);
    }

}
