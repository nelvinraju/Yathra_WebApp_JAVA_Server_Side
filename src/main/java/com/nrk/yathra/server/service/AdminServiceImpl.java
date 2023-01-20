package com.nrk.yathra.server.service;

import com.nrk.yathra.server.dao.AdminDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminServiceImpl {
    @Autowired
    private AdminDAO adminDAO;

    public Boolean approvePostsByUser(int postId) throws Exception {
        return  approvingPostsByUser(postId);
    }

    private Boolean approvingPostsByUser(int postId) throws Exception {
        return adminDAO.approvingPostsByUser(postId);
    }
}
