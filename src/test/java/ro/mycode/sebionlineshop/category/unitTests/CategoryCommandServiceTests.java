package ro.mycode.sebionlineshop.category.unitTests;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.web.servlet.support.WebContentGenerator;
import ro.mycode.sebionlineshop.categories.dtos.CategoryRequest;
import ro.mycode.sebionlineshop.categories.dtos.CategoryResponse;
import ro.mycode.sebionlineshop.categories.model.Category;
import ro.mycode.sebionlineshop.categories.repository.CategoryRepository;
import ro.mycode.sebionlineshop.categories.service.commandService.CategoryCommandService;
import ro.mycode.sebionlineshop.categories.service.commandService.CategoryCommandServiceImpl;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@Slf4j
@WebMvcTest(MockitoExtension.class)
public class CategoryCommandServiceTests {
    @MockitoBean
    CategoryCommandService categoryCommandService;
    @MockitoBean
    CategoryRepository categoryRepository;

@BeforeEach
    void setUp(){
        categoryCommandService = new CategoryCommandServiceImpl(categoryRepository);
    }
    @Test
    public void testAddCategory(){
        Long categoryId = 1L;
        String categoryName = "categoryName";
        CategoryRequest categoryRequest=CategoryRequest.builder()
                .name(categoryName)
                .build();


        Category savedCategory=Category.builder()
                .id(categoryId)
                .name(categoryName)
                .build();


         when(categoryRepository.save(any(Category.class))).thenReturn(savedCategory);
         CategoryResponse response=categoryCommandService.addCategory(categoryRequest);
         assertEquals(categoryId,response.id());
         assertEquals(categoryName,response.name());


    }
    @Test
    public void testUpdateCategory(){
        Long categoryId = 1L;
        String categoryName = "categoryName";
        CategoryRequest categoryRequest=CategoryRequest.builder()
                .name(categoryName)
                .build();
        Category category=Category.builder()
                .id(categoryId)
                .name(categoryName)
                .build();
        Category category1=Category.builder()
                .id(categoryId)
                .name(categoryName)
                .build();
        when(categoryRepository.save(any(Category.class))).thenReturn(category);
        when(categoryRepository.findByName(categoryName)).thenReturn(Optional.of(category1));
        CategoryResponse categoryResponse=categoryCommandService.updateCategory(categoryRequest);
        assertEquals(categoryId,categoryResponse.id());
        assertEquals(categoryName,categoryResponse.name());

    }

    @Test
    public void testDeleteCategory(){
    Long categoryId = 1L;
    String categoryName = "categoryName";
    CategoryRequest categoryRequest=CategoryRequest.builder()
            .name(categoryName)
            .build();

   Category category=Category.builder()
                   .name(categoryName)
                    .build();
    when(categoryRepository.findByName(categoryName)).thenReturn(Optional.of(category));
    categoryCommandService.deleteCategory(categoryId);

    }







}
