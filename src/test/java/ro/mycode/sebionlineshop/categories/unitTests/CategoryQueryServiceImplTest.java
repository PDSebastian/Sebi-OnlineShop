package ro.mycode.sebionlineshop.categories.unitTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.mycode.sebionlineshop.categories.dtos.CategoryResponse;
import ro.mycode.sebionlineshop.categories.model.Category;
import ro.mycode.sebionlineshop.categories.repository.CategoryRepository;
import ro.mycode.sebionlineshop.categories.service.CategoryQueryServiceImpl;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CategoryQueryServiceImplTest {

    @Mock
    private CategoryRepository categoryRepositoryl;

  @InjectMocks
    private CategoryQueryServiceImpl categoryQueryService;

    @Test
    void getAllCategories(){
        Category cat1 = Category.builder().id(1L).name("cat1").build();
        Category cat2 = Category.builder().id(2L).name("cat2").build();

        when(categoryRepositoryl.findAll()).thenReturn(List.of(cat1,cat2));
        List<CategoryResponse> categories = categoryQueryService.getAllCategories();

        assertEquals(2, categories.size());
        assertEquals("cat1", categories.get(0).name());





    }
    @Test
    void getCategoryById(){
        Long id=1L;
        Category cat1 = Category.builder().id(id).name("cat1").build();

        when(categoryRepositoryl.findById(id)).thenReturn(Optional.of(cat1));
        CategoryResponse categoryResponse = categoryQueryService.getCategoryById(id);
        assertEquals(cat1.getName(),categoryResponse.name());

    }



}
