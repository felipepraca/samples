package com.sample.crud.controller;

import com.sample.crud.entity.Tweet;
import com.sample.crud.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tweet")
public class TweetController {

    @Autowired
    public TweetService tweetService;

    @GetMapping
    public List<Tweet> getAll() {
        return tweetService.getAll();
    }

    @GetMapping("/{id}")
    public Tweet get(@PathVariable("id") long id) {
        return tweetService.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tweet save(@RequestBody Tweet tweet) {
        return tweetService.save(tweet);
    }

    @PutMapping("/{id}")
    public Tweet update(@PathVariable("id") long id, @RequestBody Tweet tweet) {
        tweet.setId(id);
        return tweetService.save(tweet);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id) {
        tweetService.delete(id);
    }


}
