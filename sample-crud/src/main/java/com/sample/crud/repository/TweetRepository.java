package com.sample.crud.repository;

import com.sample.crud.entity.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {
    public List<Tweet> findAllByOrderByDateDesc();
}
