//package ro.mycode.sebionlineshop.category.integrationTests;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.web.servlet.MockMvc;
//import ro.mycode.sebionlineshop.categories.dtos.CategoryRequest;
//import ro.mycode.sebionlineshop.categories.repository.CategoryRepository;
//
//import static org.springframework.http.RequestEntity.post;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//@ActiveProfiles("test")
//public class CategoryIntegrationTest {
//    @Autowired
//    MockMvc mockMvc;
//    @Autowired
//    ObjectMapper objectMapper;
//    @Autowired
//    CategoryRepository categoryRepository;
//
//    @BeforeEach
//    void setUp() {
//        categoryRepository.deleteAll();
//    }
//    @Test
//    public void addCategoryTest() throws Exception {
//        CategoryRequest categoryRequest=CategoryRequest.builder().name("Test").description("Test").build();
//        mockMvc.perform(post())
//    }











//}
