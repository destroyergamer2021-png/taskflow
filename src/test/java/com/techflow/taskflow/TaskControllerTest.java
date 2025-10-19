package com.techflow.taskflow;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techflow.taskflow.model.Task;
import com.techflow.taskflow.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class TaskControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private TaskRepository repository;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void createAndGetAndDeleteTask() throws Exception {
        repository.deleteAll();

        Task task = new Task("Teste", "Descrição de teste", "TODO");
        String json = mapper.writeValueAsString(task);

        // Create
        mvc.perform(post("/api/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists());

        // Get all
        mvc.perform(get("/api/tasks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(1)));
    }
}
