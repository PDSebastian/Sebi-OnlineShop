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
import ro.mycode.sebionlineshop.costumers.repository.CostumerRepository;
import ro.mycode.sebionlineshop.costumers.service.CostumerCommandservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")


public class CostumerCommandServiceTests {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    CostumerCommandservice costumerCommandservice;
    @Autowired
    CostumerRepository costumerRepository;
    @Autowired
    private DefaultParameterNameDiscoverer defaultParameterNameDiscoverer;

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

        MvcResult mvcResult = mockMvc.perform(post("/api/v2/costumers").
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

        CostumerResponse costumerResponse = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), CostumerResponse.class);
        mockMvc.perform(post("/api/v2/costumers").
                        contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(costumerResponse)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.email").value(email))
                .andExpect(jsonPath("$.fullName").value(fullName))
                .andExpect(jsonPath("$.defaultShippingAddress").value(defaultShippingAddress))
                .andExpect(jsonPath("$.country").value(country))
                .andExpect(jsonPath("$.billingAddress").value(billingAddress))
                .andExpect(jsonPath("$.phoneNumber").value(phoneNumber))
                .andExpect(jsonPath("$.password").value(password));


    }
}






