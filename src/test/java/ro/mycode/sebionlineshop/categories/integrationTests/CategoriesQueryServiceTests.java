package ro.mycode.sebionlineshop.categories.integrationTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import ro.mycode.sebionlineshop.categories.dtos.CategoryResponse;
import ro.mycode.sebionlineshop.categories.model.Category;
import ro.mycode.sebionlineshop.categories.repository.CategoryRepository;
import ro.mycode.sebionlineshop.categories.service.CategoryQueryService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class CategoriesQueryServiceTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CategoryQueryService categoryQueryService;
    @Autowired
    private CategoryRepository categoryRepository;

    @BeforeEach
    public void setup() {
        categoryRepository.deleteAll();
    }

    @Test
    void testGetAllCategories_Integration() {
        Category cat1 = Category.builder().name("Electronice").thumbnail("dw").description("Gadget-uri").build();
        Category cat2 = Category.builder().name("Haine").thumbnail("dww").description("Modă").build();
        categoryRepository.saveAll(List.of(cat1, cat2));
        List<CategoryResponse> result = categoryQueryService.getAllCategories();

        assertEquals(2, result.size());
        assertEquals("Electronice", result.get(0).name());
        assertEquals("Haine", result.get(1).name());
    }
    @Test
    void testGetCategoryById_Integration()  {
        Category saved = categoryRepository.save(Category.builder().name("Gaming").description("aaaa").thumbnail("dw").build());
        CategoryResponse response = categoryQueryService.getCategoryById(saved.getId());
        assertEquals("Gaming", response.name());
        assertEquals("aaaa", response.description());
        assertEquals(saved.getId(), response.id());
    }



}
