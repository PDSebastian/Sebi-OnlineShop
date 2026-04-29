package ro.mycode.sebionlineshop.categories.unitTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Transactional;
import ro.mycode.sebionlineshop.categories.dtos.CategoryRequest;
import ro.mycode.sebionlineshop.categories.dtos.CategoryResponse;
import ro.mycode.sebionlineshop.categories.exceptions.CategoryAlreadyexistsException;
import ro.mycode.sebionlineshop.categories.exceptions.CategoryNotFoundException;
import ro.mycode.sebionlineshop.categories.model.Category;
import ro.mycode.sebionlineshop.categories.repository.CategoryRepository;
import ro.mycode.sebionlineshop.categories.service.CategoryCommandServiceImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CategoryCommandServiceImplTest {
    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryCommandServiceImpl categoryCommandService;

    @Test
    @Transactional
    public void createCategoryTest() {
        Category category = Category.builder().name("wdwdwdw").description("wdwdww").thumbnail("a").build();
        CategoryRequest categoryRequest = CategoryRequest.builder().name("wdwdwdw").description("aaaa").build();
        when(categoryRepository.findByName(categoryRequest.name())).thenReturn(Optional.empty());
        when(categoryRepository.save(any(Category.class))).thenReturn(category);

        CategoryResponse categoryResponse=categoryCommandService.addCategory(categoryRequest);
        assertEquals("wdwdwdw",categoryResponse.name());

    }
    @Test
    @Transactional
    public void testAddCategoryThrowsError(){
        CategoryRequest categoryRequest=CategoryRequest.builder().name("wdwdwdw").description("aaaa").build();
        Category category=Category.builder().name("wdwdwdw").description("aaaa").build();
        when(categoryRepository.findByName(categoryRequest.name())).thenReturn(Optional.of(category));

        assertThrows(CategoryAlreadyexistsException.class,() -> categoryCommandService.addCategory(categoryRequest));
    }
    @Test
    @Transactional
    public void testUpdateCategory(){
        String categoryName="wdwdwdw";
        String categoryNewName="aaaa";
        String description="aaaa";
        CategoryRequest categoryRequest=CategoryRequest.builder().name(categoryNewName).description(description).build();
        Category category=Category.builder().name(categoryName).description(description).build();

        when(categoryRepository.findByName(categoryNewName)).thenReturn(Optional.of(category));
        when(categoryRepository.save(any(Category.class))).thenReturn(category);

        CategoryResponse categoryResponse=categoryCommandService.updateCategory(categoryRequest);
        assertEquals(categoryNewName,categoryResponse.name());
        assertEquals(categoryNewName,categoryResponse.description());




    }
    @Test
    @Transactional
    public void testUpdateCategoryThrowsError(){
        String categoryName="wdwdwdw";
        CategoryRequest categoryRequest=CategoryRequest.builder().name(categoryName).build();

        when(categoryRepository.findByName(categoryRequest.name())).thenReturn(Optional.empty());
        assertThrows(CategoryNotFoundException.class,() -> categoryCommandService.updateCategory(categoryRequest));

    }
    @Test
    @Transactional
    public void testDeleteCategory(){
        Long id=1L;
        when(categoryRepository.findById(id)).thenReturn(Optional.of(Category.builder().id(id).build()));
        categoryCommandService.deleteCategory(id);

    }
}
