package ro.mycode.sebionlineshop.category.unitTests;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import ro.mycode.sebionlineshop.categories.dtos.CategoryResponse;
import ro.mycode.sebionlineshop.categories.model.Category;
import ro.mycode.sebionlineshop.categories.repository.CategoryRepository;
import ro.mycode.sebionlineshop.categories.service.queryService.CategoryQueryService;
import ro.mycode.sebionlineshop.categories.service.queryService.CategoryQueryServiceImpl;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@Slf4j
@WebMvcTest(MockitoExtension.class)
public class CategoryQueryServiceImplTests {
    @MockitoBean
    CategoryQueryService categoryQueryService;
    @MockitoBean
    CategoryRepository categoryRepository;

   @BeforeEach
   void setUp() {
      categoryQueryService = new CategoryQueryServiceImpl(categoryRepository);
   }
   @Test
    void testGetAllCategories() {
       Long categoryId = 1L;
       String categoryName = "categoryName";

      Category cat1 = Category.builder()
              .id(categoryId)
              .name(categoryName)
              .build();

      Category cat2=Category.builder()
              .id(categoryId)
              .name(categoryName)
              .build();
      when(categoryRepository.findAll()).thenReturn(List.of(cat1,cat2));
      List<CategoryResponse>categoryResponses=categoryQueryService.getAllCategories();
      assertEquals(2,categoryResponses.size());
   }
   @Test
    void testGetCategoryById() {
       Long categoryId = 1L;
       String categoryName = "categoryName";
       Category category=Category.builder().id(categoryId).name(categoryName).build();
       when(categoryRepository.findById(categoryId)).thenReturn(Optional.of(category));
       CategoryResponse categoryResponse=categoryQueryService.getCategoryById(categoryId);
       assertEquals(categoryName,categoryResponse.name());
   }
}
