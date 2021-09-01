package com.sample.crud.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tweet")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Tweet {

    public Tweet() {}

    public Tweet(long id, String text, String sender, LocalDateTime date) {
        this.id = id;
        this.text = text;
        this.sender = sender;
        this.date = date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "text")
    private String text;

    @Column(name = "sender")
    private String sender;

    @Column(name = "data")
    private LocalDateTime date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tweet tweet = (Tweet) o;
        return id == tweet.id &&
                Objects.equals(text, tweet.text) &&
                Objects.equals(sender, tweet.sender) &&
                Objects.equals(date.toString(), tweet.date.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, sender, date);
    }
}
