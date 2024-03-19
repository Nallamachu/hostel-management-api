package com.msts.hostel.service;

import com.msts.hostel.document.User;
import com.msts.hostel.model.LoginDto;
import com.msts.hostel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    public User authenticateUser(LoginDto loginDto) {
        User user = mongoTemplate.findOne(
                Query.query(
                        Criteria.where("mobile").is(loginDto.getUsername())
                                .and("password").is(loginDto.getPassword())
                                .and("active").is(true)
                ),User.class);
        return user;
    }

    public User registerUser(User user) {
        user.setActive(true);
        return userRepository.save(user);
    }

    public void blockUser(User user) {
        user = mongoTemplate.findOne(
                Query.query(
                        Criteria.where("mobile").is(user.getMobile())
                                .and("active").is(true)
                ),User.class);
        user.setActive(false);
        userRepository.save(user);
    }
}
