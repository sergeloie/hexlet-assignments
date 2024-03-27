package exercise.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;
import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static org.assertj.core.api.Assertions.assertThat;
import org.instancio.Instancio;
import org.instancio.Select;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.datafaker.Faker;
import exercise.repository.TaskRepository;
import exercise.model.Task;
import org.springframework.test.web.servlet.MvcResult;

// BEGIN
@SpringBootTest
@AutoConfigureMockMvc
// END
class ApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Faker faker;

    @Autowired
    private ObjectMapper om;

    @Autowired
    private TaskRepository taskRepository;


    @Test
    public void testWelcomePage() throws Exception {
        MvcResult result = mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andReturn();

        String body = result.getResponse().getContentAsString();
        assertThat(body).contains("Welcome to Spring!");
    }

    @Test
    public void testIndex() throws Exception {
        MvcResult result = mockMvc.perform(get("/tasks"))
                .andExpect(status().isOk())
                .andReturn();

        String body = result.getResponse().getContentAsString();
        assertThatJson(body).isArray();
    }


    private Task generateTask() {
        return Instancio.of(Task.class)
                .ignore(Select.field(Task::getId))
                .supply(Select.field(Task::getTitle), () -> faker.lorem().word())
                .supply(Select.field(Task::getDescription), () -> faker.lorem().paragraph())
                .create();
    }

    // BEGIN
    @Test
    public void testShow() throws Exception {
        Task task = generateTask();
        taskRepository.save(task);
        String title = task.getTitle();
        String description = task.getDescription();
        long id = task.getId();
        MvcResult result = mockMvc.perform(get("/tasks/" + id))
                .andExpect(status().isOk())
                .andReturn();
        String body = result.getResponse().getContentAsString();
        assertThat(body).contains(title);
        assertThat(body).contains(description);
    }

    @Test
    public void testCreate() {
        Task task = new Task();
        task.setTitle("Das Title");
        task.setDescription("The Description");
        taskRepository.save(task);
        long id = task.getId();
        Task newTask = taskRepository.findById(id).get();
        assertThat(task.getId()).isEqualTo(newTask.getId());
        assertThat(task.getTitle()).isEqualTo(newTask.getTitle());
        assertThat(task.getDescription()).isEqualTo(newTask.getDescription());
        assertThat(task.getCreatedAt()).isEqualTo(newTask.getCreatedAt());
        assertThat(task.getUpdatedAt()).isEqualTo(newTask.getUpdatedAt());
    }

    @Test
    public void testPost() throws Exception {
        Task task1 = generateTask();
        taskRepository.save(task1);

        Task task2 = generateTask();
        String title = task2.getTitle();
        String description = task2.getDescription();
        var data = new HashMap<>();
        data.put("title", title);
        data.put("description", description);
        var request = post("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(data));
        var result = mockMvc.perform(request)
                .andExpect(status().isCreated())
                .andReturn();
        String body1 = result.getResponse().getContentAsString();
        JsonNode jsonNode = om.readTree(body1);

        System.out.println(body1);

        long id =  jsonNode.get("id").asLong();
        var result2 = mockMvc.perform(get("/tasks/" + id))
                .andExpect(status().isOk())
                .andReturn();

        String body = result2.getResponse().getContentAsString();
        assertThat(body).contains(title);
        assertThat(body).contains(description);
    }

    @Test
    public void testRenew() throws Exception {
        Task task = generateTask();
        var data = new HashMap<>();
        data.put("title", task.getTitle());
        data.put("description", task.getDescription());
        var request1 = post("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(data));
        var result1 = mockMvc.perform(request1)
                .andExpect(status().isCreated())
                .andReturn();
        String body1 = result1.getResponse().getContentAsString();
        JsonNode jsonNode1 = om.readTree(body1);
        long id = jsonNode1.get("id").asLong();

        String newTitle = "newTitle";
        String newDescription = "newDescription";
        data.put("title", newTitle);
        data.put("description", newDescription);
        var request2 = put("/tasks/" + id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(data));
        var result2 = mockMvc.perform(request2)
                .andExpect(status().isOk())
                .andReturn();
        String body2 = result2.getResponse().getContentAsString();
        System.out.println(body2);
        JsonNode jsonNode2 = om.readTree(body2);
        assertThat(newTitle).isEqualTo(jsonNode2.get("title").asText());
        assertThat(newDescription).isEqualTo(jsonNode2.get("description").asText());
    }

    @Test
    public void testDelete() throws Exception{
        Task task = generateTask();
        var data = new HashMap<>();
        data.put("title", task.getTitle());
        data.put("description", task.getDescription());
        var request1 = post("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(data));
        var result1 = mockMvc.perform(request1)
                .andExpect(status().isCreated())
                .andReturn();
        String body1 = result1.getResponse().getContentAsString();
        JsonNode jsonNode1 = om.readTree(body1);
        long id = jsonNode1.get("id").asLong();

        mockMvc.perform(get("/tasks/" + id))
                .andExpect(status().isOk());

        mockMvc.perform(delete("/tasks/" + id));

        mockMvc.perform(get("/tasks/" + id))
                .andExpect(status().isNotFound());

    }


    // END
}
