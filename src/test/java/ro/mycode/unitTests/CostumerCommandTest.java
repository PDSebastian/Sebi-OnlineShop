package ro.mycode.unitTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;


import ro.mycode.sebionlineshop.costumers.dtos.CostumerRequest;
import ro.mycode.sebionlineshop.costumers.dtos.CostumerResponse;
import ro.mycode.sebionlineshop.costumers.service.commandService.CostumerCommandservice;
import ro.mycode.sebionlineshop.costumers.service.queryService.CostumerQueryService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@WebMvcTest(MockitoExtension.class)
public class CostumerCommandTest {

    @Autowired
    ObjectMapper objectMapper;
    @MockitoBean
    CostumerCommandservice costumerCommandservice;

    @MockitoBean
    CostumerQueryService costumerQueryService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void addCoustumerReturnsOk() throws Exception {
        Long costumerId = 2L;
        String email = "ddd@gmail.com";
        String name = "name";

        CostumerRequest costumerRequest = CostumerRequest.builder()
                .fullName(name)
                .email(email)
                .build();

        CostumerResponse costumerResponse = CostumerResponse.builder()
                .id(costumerId)
                .fullName(name)
                .email(email)
                .build();


        when(costumerCommandservice.addCostumer(any(CostumerRequest.class))).thenReturn(costumerResponse);
        mockMvc.perform(post("/api/v2/costumer/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(costumerRequest)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(costumerId.intValue()))
                .andExpect(jsonPath("$.fullName").value(name));
    }
    @Test
    void testDeleteCostumerReturnsOk() throws Exception {
        Long costumerId = 2L;
        String name="name";
        CostumerResponse costumerResponse=CostumerResponse.builder()
                .id(costumerId)
                .fullName(name)
                .build();
        when(costumerCommandservice.deleteCostumer(any(CostumerRequest.class))).thenReturn(costumerResponse);
        mockMvc.perform(delete("/api/v2/costumer/delete/{id}",costumerId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(costumerId))
                .andExpect(jsonPath("$.fullName").value(name));
    }
    @Test
    void updateCostumerReturnsOk() throws Exception {
        Long costumerId = 2L;
        String name="name";
        String email="name@gmail.com";
        CostumerRequest costumerRequest=CostumerRequest.builder()
                .fullName(name)
                .email(email)
                .build();
        CostumerResponse costumerResponse=CostumerResponse.builder()
                .id(costumerId)
                .fullName(name)
                .email(email)
                .build();
        when(costumerCommandservice.updateCostumer(any(CostumerRequest.class))).thenReturn(costumerResponse);
        mockMvc.perform(put("/api/v2/costumer/update/{id}",costumerId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(costumerId))
                .andExpect(jsonPath("$.fullName").value(name))
                .andExpect(jsonPath("$.email").value(email));


    }

}
