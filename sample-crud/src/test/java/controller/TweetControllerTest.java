package controller;

import com.sample.crud.Application;
import com.sample.crud.controller.TweetController;
import com.sample.crud.entity.Tweet;
import com.sample.crud.service.TweetService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes={Application.class})
@WebMvcTest(TweetController.class)
public class TweetControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TweetService tweetService;

    private Tweet tweet = new Tweet(1L, "Oi", "Felipe", LocalDateTime.now());

    @Test
    public void shouldReturn200WithTheTweetsList() throws Exception {
        List<Tweet> tweetList = new ArrayList();
        tweetList.add(tweet);

        when(tweetService.getAll()).thenReturn(tweetList);

        mockMvc.perform(get("/tweet"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is((int) tweet.getId())))
                .andExpect(jsonPath("$[0].text", is(tweet.getText())))
                .andExpect(jsonPath("$[0].sender", is(tweet.getSender())));
//                .andExpect(jsonPath("$[0].date", is(tweet.getDate().toString())));

        verify(tweetService, times(1)).getAll();
        verifyNoMoreInteractions(tweetService);
    }

    @Test
    public void shouldReturn200TheTweetsFoundById() throws Exception {
        when(tweetService.get(tweet.getId())).thenReturn(tweet);

        mockMvc.perform(get("/tweet/" + tweet.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is((int) tweet.getId())))
                .andExpect(jsonPath("$.text", is(tweet.getText())))
                .andExpect(jsonPath("$.sender", is(tweet.getSender())));
//                .andExpect(jsonPath("$[0].date", is(tweet.getDate().toString())));

        verify(tweetService, times(1)).get(tweet.getId());
        verifyNoMoreInteractions(tweetService);
    }

    @Test
    public void shouldReturn201AndSaveTheNewTweet() throws Exception {
        when(tweetService.save(eq(tweet))).thenReturn(tweet);

        String body = "{" +
                    "\"id\":\"" + tweet.getId() + "\"," +
                    "\"text\":\"" + tweet.getText() + "\"," +
                    "\"sender\":\"" + tweet.getSender() + "\"," +
                    "\"date\":\"" + tweet.getDate().toString() + "\"" +
                "}";

        mockMvc.perform(
                post("/tweet")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body)
                )
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is((int) tweet.getId())))
                .andExpect(jsonPath("$.text", is(tweet.getText())))
                .andExpect(jsonPath("$.sender", is(tweet.getSender())));
//                .andExpect(jsonPath("$.date", is(tweet.getDate().toString())));

        verify(tweetService, times(1)).save(eq(tweet));
        verifyNoMoreInteractions(tweetService);
    }
}
