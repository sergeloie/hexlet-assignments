package exercise.controller;

import exercise.dto.CategoryDTO;
import exercise.mapper.CategoryMapper;
import exercise.model.Category;
import exercise.util.ModelGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static org.assertj.core.api.Assertions.assertThat;

import org.instancio.Instancio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import com.fasterxml.jackson.databind.ObjectMapper;
import exercise.repository.CategoryRepository;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

@SpringBootTest
@AutoConfigureMockMvc
class CategoriesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper om;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper mapper;

    @Autowired
    private ModelGenerator modelGenerator;

    private Category testCategory;

    @BeforeEach
    public void setUp() {
        testCategory = Instancio.of(modelGenerator.getCategoryModel()).create();
    }

    @Test
    public void testIndex() throws Exception {
        categoryRepository.save(testCategory);
        MvcResult result = mockMvc.perform(get("/categories"))
                .andExpect(status().isOk())
                .andReturn();

        String body = result.getResponse().getContentAsString();
        assertThatJson(body).isArray();
    }

    @Test
    public void testShow() throws Exception {

        categoryRepository.save(testCategory);

        MockHttpServletRequestBuilder request = get("/categories/{id}", testCategory.getId());
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();
        String body = result.getResponse().getContentAsString();

        assertThatJson(body).and(
                v -> v.node("name").isEqualTo(testCategory.getName())
        );
    }

    @Test
    public void testCreate() throws Exception {
        CategoryDTO dto = mapper.map(testCategory);

        MockHttpServletRequestBuilder request = post("/categories")
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(dto));

        mockMvc.perform(request)
                .andExpect(status().isCreated());

        Category category = categoryRepository.findByName(testCategory.getName()).get();

        assertThat(category).isNotNull();
        assertThat(category.getName()).isEqualTo(testCategory.getName());
    }

    @Test
    public void testCreateWithNotValidName() throws Exception {
        CategoryDTO dto = mapper.map(testCategory);
        dto.setName("");

        MockHttpServletRequestBuilder request = post("/categories")
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(dto));

        mockMvc.perform(request)
                .andExpect(status().isBadRequest());
    }
}
