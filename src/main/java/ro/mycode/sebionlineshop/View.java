package ro.mycode.sebionlineshop;

import org.springframework.stereotype.Component;
import ro.mycode.sebionlineshop.categories.exceptions.CategoryNotFoundException;
import ro.mycode.sebionlineshop.categories.model.Category;
import ro.mycode.sebionlineshop.categories.repository.CategoryRepository;
import ro.mycode.sebionlineshop.categories.service.CategoryCommandService;
import ro.mycode.sebionlineshop.categories.service.CategoryQueryService;
import ro.mycode.sebionlineshop.costumers.repository.CostumerRepository;
import ro.mycode.sebionlineshop.costumers.service.CostumerCommandservice;
import ro.mycode.sebionlineshop.costumers.service.CostumerQueryService;
import ro.mycode.sebionlineshop.options.exceptions.OptionNotFoundException;
import ro.mycode.sebionlineshop.options.model.Option;
import ro.mycode.sebionlineshop.options.repository.Optionrepository;
import ro.mycode.sebionlineshop.options.service.OptionCommandService;
import ro.mycode.sebionlineshop.options.service.OptionQueryService;
import ro.mycode.sebionlineshop.products.exceptions.ProductNotFoundException;
import ro.mycode.sebionlineshop.products.model.Product;
import ro.mycode.sebionlineshop.products.repository.ProductRepository;
import ro.mycode.sebionlineshop.products.service.ProductCommandService;
import ro.mycode.sebionlineshop.products.service.ProductQueryService;

import java.util.List;
public class View {
    private final CostumerRepository costumerRepository;
    private final Optionrepository optionrepository;
    ProductCommandService  productCommandService;
    ProductRepository productRepository;
    ProductQueryService productQueryService;
    CategoryCommandService categoryCommandService;
    CategoryRepository categoryRepository;
    CategoryQueryService categoryQueryService;
    CostumerCommandservice costumerCommandservice;
    CostumerQueryService costumerQueryService;
    OptionCommandService optionCommandService;
    OptionQueryService optionQueryService;
    public View(ProductCommandService productCommandService, ProductRepository productRepository, ProductQueryService productQueryService,
                CategoryCommandService categoryCommandService, CategoryRepository categoryRepository, CategoryQueryService categoryQueryServic,
                CostumerCommandservice costumerCommandservice, CostumerQueryService costumerQueryService, CostumerRepository costumerRepository,
                OptionCommandService optionCommandService, OptionQueryService optionQueryService, Optionrepository optionrepository) {
        this.productCommandService = productCommandService;
        this.productRepository = productRepository;
        this.productQueryService = productQueryService;
        this.categoryCommandService = categoryCommandService;
        this.categoryRepository = categoryRepository;
        this.costumerQueryService = costumerQueryService;
        this.costumerCommandservice = costumerCommandservice;
        this.costumerRepository = costumerRepository;
        this.optionCommandService = optionCommandService;
        this.optionQueryService = optionQueryService;
        this.optionrepository = optionrepository;
        testDeleteProduct();

    }
    void testAddProduct() {
            Product p = Product.builder()
                    .sku("SKU-10003")
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
                .orElseThrow(() -> new ProductNotFoundException());
        s.setName("Nuwdwdwdwdw");
        s.setPrice(15);
        s.setDescription("O ddwdwdwdwd");
        productRepository.save(s);
        Product p=productRepository.save(s);

    }
    void testDeleteProduct() {
       if(productRepository.existsById(11L)) {
           productRepository.deleteById(11L);
       }
       else {
           throw new ProductNotFoundException();
       }

    }
    void testGetAllProducts() {
        List<Product> products =productRepository.findAll();
        products.forEach(System.out::println);

    }
    void testGetProductById() {
       Product p=productRepository.findById(10L).orElseThrow(() -> new ProductNotFoundException());
       System.out.println(p);
    }
    void testAddCategory() {
        Category c = Category.builder().name("category").description("category description").thumbnail("wdwdw").build();
        categoryRepository.save(c);
    }
    void testUpdateCategory() {
        Category c=categoryRepository.findById(3L)
                .orElseThrow(()-> new CategoryNotFoundException());
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
            throw new CategoryNotFoundException();
        }
    }
    void testGetAllCategories() {
        List<Category> categories =categoryRepository.findAll();
        categories.forEach(System.out::println);
    }
    void testGetCategoryById() {
        Category c=categoryRepository.findById(1L).orElseThrow(() -> new CategoryNotFoundException());
        System.out.println(c);
    }
    void testAddOption() {
        Option o=Option.builder().optionName("dwfwfwfw").build();
        optionrepository.save(o);
    }
    void testUpdateOption() {
        Option o=optionrepository.findById(4L).orElseThrow(()->new OptionNotFoundException());
        o.setOptionName("Nuwdwdwdw");
        optionrepository.save(o);

    }
    void testDeleteOption() {
        if(optionrepository.existsById(4L))
        {
            optionrepository.deleteById(4L);
        }
        else {
            throw new OptionNotFoundException();
        }
    }
    void testGetAllOptions() {
        List<Option> options =optionrepository.findAll();
        options.forEach(System.out::println);
    }
    void testGetOptionById() {
        if(optionrepository.existsById(6L)) {
            System.out.println(optionrepository.findById(6L).get());
        }
        else {
            throw new OptionNotFoundException();
        }
    }
    void testGetOptionByName() {
        if(optionrepository.findByOptionName("dwfwfwfw").isPresent()) {
            System.out.println(optionrepository.findByOptionName("dwfwfwfw").get());
        }
        else {
            throw new OptionNotFoundException();
        }
    }


}
