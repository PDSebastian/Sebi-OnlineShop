package ro.mycode.sebionlineshop;

import org.springframework.stereotype.Component;
import ro.mycode.sebionlineshop.categories.exceptions.CategoryNotFoundException;
import ro.mycode.sebionlineshop.categories.model.Category;
import ro.mycode.sebionlineshop.categories.repository.CategoryRepository;
import ro.mycode.sebionlineshop.categories.service.commandService.CategoryCommandService;
import ro.mycode.sebionlineshop.categories.service.queryService.CategoryQueryService;
import ro.mycode.sebionlineshop.costumers.model.Costumer;
import ro.mycode.sebionlineshop.costumers.repository.CostumerRepository;
import ro.mycode.sebionlineshop.costumers.service.commandService.CostumerCommandservice;
import ro.mycode.sebionlineshop.costumers.service.queryService.CostumerQueryService;
import ro.mycode.sebionlineshop.products.exceptions.ProductNotFoundException;
import ro.mycode.sebionlineshop.products.model.Product;
import ro.mycode.sebionlineshop.products.repository.ProductRepository;
import ro.mycode.sebionlineshop.products.service.commandService.ProductCommandService;
import ro.mycode.sebionlineshop.products.service.queryService.ProductQueryService;

import java.util.List;

@Component
public class View {
    private final CostumerRepository costumerRepository;
    ProductCommandService  productCommandService;
    ProductRepository productRepository;
    ProductQueryService productQueryService;
    CategoryCommandService categoryCommandService;
    CategoryRepository categoryRepository;
    CategoryQueryService categoryQueryService;
    CostumerCommandservice costumerCommandservice;
    CostumerQueryService costumerQueryService;
    public View(ProductCommandService productCommandService, ProductRepository productRepository, ProductQueryService productQueryService,
                CategoryCommandService categoryCommandService, CategoryRepository categoryRepository, CategoryQueryService categoryQueryServic,
                CostumerCommandservice costumerCommandservice, CostumerQueryService costumerQueryService, CostumerRepository costumerRepository) {
        this.productCommandService = productCommandService;
        this.productRepository = productRepository;
        this.productQueryService = productQueryService;
        this.categoryCommandService = categoryCommandService;
        this.categoryRepository = categoryRepository;
        this.costumerQueryService = costumerQueryService;
        this.costumerCommandservice = costumerCommandservice;
        this.costumerRepository = costumerRepository;
    }
    void testAddProduct() {
            Product p = Product.builder()
                    .sku("SKU-123")
                    .name("p1")
                    .description("p1 description")
                    .weight(2121)
                    .image("wdwdw")
                    .thumbnail("fwfwfw")
                    .price(11)
                    .category("category")
                    .build();
            productRepository.save(p);

    }
    void testUpdateProduct() {
        Product s = productRepository.findById(1L)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));
        s.setName("Nuwdwdwdwdw");
        s.setPrice(15);
        s.setDescription("O ddwdwdwdwd");
        productRepository.save(s);
        Product p=productRepository.save(s);

    }
    void testDeleteProduct() {
       if(productRepository.existsById(10L)) {
           productRepository.deleteById(10L);
       }
       else {
           throw new ProductNotFoundException("Product not found");
       }

    }
    void testGetAllProducts() {
        List<Product> products =productRepository.findAll();
        products.forEach(System.out::println);

    }
    void testGetProductById() {
       Product p=productRepository.findById(10L).orElseThrow(() -> new ProductNotFoundException("Product not found"));
       System.out.println(p);
    }
    void testAddCategory() {
        Category c = Category.builder().name("category").description("category description").thumbnail("wdwdw").build();
        categoryRepository.save(c);
    }
    void testUpdateCategory() {
        Category c=categoryRepository.findById(3L)
                .orElseThrow(()-> new CategoryNotFoundException("Category not found"));
        c.setName("Nuwdwdwdwdw");
        c.setDescription("O ddwdwdwdw");
        c.setThumbnail("fwfwfw");
        categoryRepository.save(c);
    }
    void testDeleteCategory() {
        if(categoryRepository.existsById(3L)) {
            categoryRepository.deleteById(3L);
        }
        else {
            throw new CategoryNotFoundException("Category not found");
        }
    }
    void testGetAllCategories() {
        List<Category> categories =categoryRepository.findAll();
        categories.forEach(System.out::println);
    }
    void testGetCategoryById() {
        Category c=categoryRepository.findById(1L).orElseThrow(() -> new CategoryNotFoundException("Category not found"));
        System.out.println(c);
    }


}
