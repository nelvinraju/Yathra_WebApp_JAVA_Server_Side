package com.nrk.yathra.server.dao;

import com.nrk.yathra.server.dto.Post;
import com.nrk.yathra.server.dto.User;
import com.nrk.yathra.server.entity.Posts;
import com.nrk.yathra.server.entity.Users;
import com.nrk.yathra.server.repo.PostsRepository;
import com.nrk.yathra.server.repo.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Component
public class UserDAO {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private PostsRepository postsRepository;
    public User registringNewuser(User user) throws Exception {
        try {
            Users users = new Users();
            BeanUtils.copyProperties(user, users);
            usersRepository.save(users);
            return user;
        }catch (Exception e){
            throw new Exception("failed to register new user.");
        }
    }

    public User updatingUserDetails(User user) throws Exception {
        if(usersRepository.existsById(user.getUserId())){
            Users users = new Users();
            BeanUtils.copyProperties(user, users);
            usersRepository.save(users);
            return user;
        }else{
            throw new Exception("failed to update user details.");
        }
    }

    public Boolean deletingUserDetails(int userId) throws Exception {
        if(usersRepository.existsById(userId)){
            usersRepository.deleteById(userId);
            return true;
        }else{
            throw new Exception("failed to delete user details.");
        }
    }

    public List<Post> gettingUserPostsDetails(int userId) throws Exception {
        try{
            List<Posts> posts = postsRepository.findAllByUserId(userId) ;
            List<Post> postList = new ArrayList<>();
            for(Posts eachPost:posts){
                Post post = new Post();
                BeanUtils.copyProperties(eachPost,post);
                postList.add(post);
            }

            return postList;
        }catch (Exception e){
            log.error("Error in reading user posts from database.");
            throw  new Exception("Error in reading user posts from database.");
        }
    }
}
