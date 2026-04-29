package ro.mycode.sebionlineshop.categories.integrationTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import ro.mycode.sebionlineshop.categories.dtos.CategoryRequest;
import ro.mycode.sebionlineshop.categories.dtos.CategoryResponse;
import ro.mycode.sebionlineshop.categories.exceptions.CategoryAlreadyexistsException;
import ro.mycode.sebionlineshop.categories.exceptions.CategoryNotFoundException;
import ro.mycode.sebionlineshop.categories.model.Category;
import ro.mycode.sebionlineshop.categories.repository.CategoryRepository;
import ro.mycode.sebionlineshop.categories.service.CategoryCommandService;
import ro.mycode.sebionlineshop.categories.service.CategoryCommandServiceImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class CategoriesCommandServiceTests {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
   private CategoryRepository categoryRepository;
    @Autowired
    private CategoryCommandService categoryCommandService;

    @BeforeEach
    public void setup() {
        categoryRepository.deleteAll();
    }
    @Test
    public void addCaregorySuccess()  {
        String name="a";
        String description="b";
        String thumbnail="c";
        CategoryRequest request = CategoryRequest.builder()
                .name(name)
                .description(description)
                .thumbnail(thumbnail)
                .build();
        CategoryResponse response = categoryCommandService.addCategory(request);
        assertEquals(name, response.name());
        assertEquals(description, response.description());


    }
    @Test
    public void addCategoryThrowExceptionWhenNameAlreadyExists()  {
        String name="a";
        String description="b";
        String thumbnail="c";
        categoryRepository.save(Category.builder()
                .name(name)
                .thumbnail(description)
                .description(thumbnail)
                .build());
        CategoryRequest categoryRequest=CategoryRequest.builder()
                .name(name)
                .description(description)
                .thumbnail(thumbnail)
                .build();
        assertThrows(CategoryAlreadyexistsException.class, ()->categoryCommandService.addCategory(categoryRequest));

    }
    @Test
    public void deleteCategorySuccess() {
        String name="a";
        String description="b";
        String thumbnail="c";
        Category category = Category.builder()
                .name(name)
                .description(description)
                .thumbnail(thumbnail)
                .build();

        Category savedCategory = categoryRepository.save(category);

        categoryCommandService.deleteCategory(savedCategory.getId());
        assertFalse(categoryRepository.existsById(savedCategory.getId()));
    }
    @Test
    public void deleteCategoryThrowExceptionWhenCategoryDoesNotExist() throws Exception {
        Long id=1L;
        assertThrows(CategoryNotFoundException.class, () -> {
            categoryCommandService.deleteCategory(id);
        });
    }



}
