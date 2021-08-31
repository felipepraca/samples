package com.sample.crud.service;

import com.sample.crud.entity.Tweet;
import com.sample.crud.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TweetService {

    @Autowired
    private TweetRepository repository;

    public Tweet save(Tweet tweet) {
        return repository.save(tweet);
    }

    public Tweet get(long id) {
        return repository.getById(id);
    }

    public List<Tweet> getAll() {
        return repository.findAllByOrderByDateDesc();
    }

    public void delete(long id) {
        repository.deleteById(id);
    }
}
