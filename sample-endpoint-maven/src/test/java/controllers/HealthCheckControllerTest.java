package controllers;

import com.samples.sample.endpoint.maven.Application;
import com.samples.sample.endpoint.maven.controllers.HealthCheckController;
import com.samples.sample.endpoint.maven.services.HealthCheckService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes={Application.class})
@WebMvcTest(HealthCheckController.class)
public class HealthCheckControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HealthCheckService healthCheckService;

    @Test
    public void shouldReturn200WhenBooleanIsTrue() throws Exception {
        Mockito.when(healthCheckService.check()).thenReturn(true);

        mockMvc.perform(get("/healthCheck")).andExpect(status().isOk());

        Mockito.verify(healthCheckService, Mockito.times(1)).check();
    }

    @Test
    public void shouldReturn500WhenBooleanIsFalse() throws Exception {
        Mockito.when(healthCheckService.check()).thenReturn(false);

        mockMvc.perform(get("/healthCheck")).andExpect(status().isInternalServerError());

        Mockito.verify(healthCheckService, Mockito.times(1)).check();
    }
}
