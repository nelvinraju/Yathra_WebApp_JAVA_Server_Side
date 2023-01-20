package com.nrk.yathra.server.service;

import com.nrk.yathra.server.dao.UserDAO;
import com.nrk.yathra.server.dto.Post;
import com.nrk.yathra.server.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl {
    @Autowired
    private UserDAO userDAO;

    public User newUserRegister(User user) throws Exception {
        return registringNewuser(user);
    }

    private User registringNewuser(User user) throws Exception {
        return userDAO.registringNewuser(user);
    }

    public User updateUserDetails(User user) throws Exception {
        return updatingUserDetails(user);
    }

    private User updatingUserDetails(User user) throws Exception {
        return userDAO.updatingUserDetails(user);

    }

    public Boolean deleteUserDetails(int userId) throws Exception {
        return deletingUserDetails(userId);
    }

    private Boolean deletingUserDetails(int userId) throws Exception {
        return userDAO.deletingUserDetails(userId);
    }

    public List<Post> getUserPostsDetails(int userId) throws Exception {
        return gettingUserPostsDetails(userId);
    }

    private List<Post> gettingUserPostsDetails(int userId) throws Exception {
        return userDAO.gettingUserPostsDetails(userId);

    }
}
