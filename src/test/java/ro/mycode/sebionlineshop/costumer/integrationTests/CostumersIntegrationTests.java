package ro.mycode.sebionlineshop.costumer.integrationTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import ro.mycode.sebionlineshop.costumers.dtos.CostumerRequest;
import ro.mycode.sebionlineshop.costumers.dtos.CostumerResponse;
import ro.mycode.sebionlineshop.costumers.model.Costumer;
import ro.mycode.sebionlineshop.costumers.repository.CostumerRepository;
import ro.mycode.sebionlineshop.costumers.service.CostumerCommandservice;
import ro.mycode.sebionlineshop.costumers.service.CostumerQueryService;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")


public class CostumersIntegrationTests {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    CostumerRepository costumerRepository;
    @Autowired
    private CostumerQueryService costumerQueryService;

    @BeforeEach
    public void setup() {
        costumerRepository.deleteAll();

    }

    @Test
    public void createCostumerSuccess() throws Exception {
        String fullName = "a";
        String email = "b";
        String password = "c";
        String phoneNumber = "d";
        String billingAddress = "e";
        String defaultShippingAddress = "f";
        String country = "g";

        CostumerRequest costumerRequest = CostumerRequest.builder()
                .fullName(fullName)
                .email(email)
                .password(password)
                .phone(phoneNumber)
                .billingAddress(billingAddress)
                .defaultShippingAddress(defaultShippingAddress)
                .country(country)
                .build();

        MvcResult mvcResult = mockMvc.perform(post("/api/v2/costumers/add").
                        contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(costumerRequest)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.email").value(email))
                .andExpect(jsonPath("$.fullName").value(fullName))
                .andExpect(jsonPath("$.defaultShippingAddress").value(defaultShippingAddress))
                .andExpect(jsonPath("$.country").value(country))
                .andExpect(jsonPath("$.billingAddress").value(billingAddress))
                .andExpect(jsonPath("$.phoneNumber").value(phoneNumber))
                .andExpect(jsonPath("$.password").value(password))

                .andReturn();



    }
    @Test
    public void updateCostumerSuccess() throws Exception {
        String fullName = "a";
        String email = "b";
        String password = "c";
        String phoneNumber = "d";
        String billingAddress = "e";
        String defaultShippingAddress = "f";
        String country = "g";
        Costumer costmer=Costumer.builder()
                .fullName(fullName)
                .email(email)
                .password(password)
                .phone(phoneNumber)
                .billingAddress(billingAddress)
                .defaultShippingAddress(defaultShippingAddress)
                .country(country)
                .build();
        costumerRepository.save(costmer);

        CostumerRequest costumerRequest = CostumerRequest.builder()
                .fullName(fullName)
                .email(email)
                .password(password)
                .phone(phoneNumber)
                .billingAddress(billingAddress)
                .defaultShippingAddress(defaultShippingAddress)
                .country(country)
                .build();

        mockMvc.perform(put("/api/v2/costumers/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(costumerRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fullName").value(fullName))
                .andExpect(jsonPath("$.email").value(email))
                .andExpect(jsonPath("$.password").value(password))
                .andExpect(jsonPath("$.billingAddress").value(billingAddress))
                .andExpect(jsonPath("$.defaultShippingAddress").value(defaultShippingAddress))
                .andExpect(jsonPath("$.country").value(country))
                .andExpect(jsonPath("$.phoneNumber").value(phoneNumber));

    }
    @Test
    public void deleteCostumerSuccess() throws Exception {
        String fullName = "a";
        String email = "b";
        String password = "c";
        String phoneNumber = "d";
        String billingAddress = "e";
        String defaultShippingAddress = "f";
        String country = "g";
        Costumer costmer=Costumer.builder()
                .fullName(fullName)
                .email(email)
                .password(password)
                .phone(phoneNumber)
                .billingAddress(billingAddress)
                .defaultShippingAddress(defaultShippingAddress)
                .country(country)
                .build();
        costumerRepository.save(costmer);

        mockMvc.perform(delete("/api/v2/costumers/delete/"+costmer.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(costmer.getId()));
    }
    @Test
    public void getAllCostumersSuccess() throws Exception {
        String fullName = "John Doe";
        String email = "JD@gmail.com";
        String password = "pass123";
        String phoneNumber = "0722222222";
        String billingAddress = "str abc";
        String defaultShippingAddress = "str xyz";
        String country = "Romania";

        Costumer costumer = Costumer.builder()
                .fullName(fullName)
                .email(email)
                .password(password)
                .phone(phoneNumber)
                .billingAddress(billingAddress)
                .defaultShippingAddress(defaultShippingAddress)
                .country(country)
                .build();

        costumerRepository.save(costumer);



        mockMvc.perform(get("/api/v2/costumers/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].fullName").value(fullName))
                .andExpect(jsonPath("$[0].email").value(email));
    }
//    @Test
//    public void testGetCostumerByEmail(){
//        String fullName = "John Doe";
//        String email = "JD@gmail.com";
//        String password = "pass123";
//        String phoneNumber = "0722222222";
//        String billingAddress = "str abc";
//        String defaultShippingAddress = "str xyz";
//        String country = "Romania";
//
//        Costumer costumer = Costumer.builder()
//                .fullName(fullName)
//                .email(email)
//                .password(password)
//                .phone(phoneNumber)
//                .billingAddress(billingAddress)
//                .defaultShippingAddress(defaultShippingAddress)
//                .country(country)
//                .build();
//
//        costumerRepository.save(costumer);
//        mockMvc.perform(get(""))
//
//
//
//    }

}




