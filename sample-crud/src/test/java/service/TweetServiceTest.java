package service;

import com.sample.crud.entity.Tweet;
import com.sample.crud.repository.TweetRepository;
import com.sample.crud.service.TweetService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TweetServiceTest {

    @Mock
    private TweetRepository tweetRepository;

    @InjectMocks
    private TweetService tweetService;

    private Tweet tweet = new Tweet(1L, "Oi", "Felipe", LocalDateTime.now());

    @Test
    public void shouldSaveTheTweetAndReturnTheSomeTweet() {
        Mockito.when(tweetRepository.save(eq(tweet))).thenReturn(tweet);

        Tweet saveTweet = tweetService.save(tweet);

        assertEquals(tweet, saveTweet);

        verify(tweetRepository, times(1)).save(eq(tweet));
        verifyNoMoreInteractions(tweetRepository);
    }

    @Test
    public void shouldReturnTheTweetFoundById() {
        Mockito.when(tweetRepository.getById(tweet.getId())).thenReturn(tweet);

        Tweet saveTweet = tweetService.get(tweet.getId());

        assertEquals(tweet, saveTweet);

        verify(tweetRepository, times(1)).getById(tweet.getId());
        verifyNoMoreInteractions(tweetRepository);
    }
}
