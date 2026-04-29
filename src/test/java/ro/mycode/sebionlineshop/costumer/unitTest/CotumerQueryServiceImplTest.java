package ro.mycode.sebionlineshop.costumer.unitTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.mycode.sebionlineshop.costumers.dtos.CostumerResponse;
import ro.mycode.sebionlineshop.costumers.model.Costumer;
import ro.mycode.sebionlineshop.costumers.repository.CostumerRepository;
import ro.mycode.sebionlineshop.costumers.service.CosutmerQueryServiceImpl;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CotumerQueryServiceImplTest {
    @Mock
    CostumerRepository costumerRepository;

    @InjectMocks
    CosutmerQueryServiceImpl cotumerQueryServiceImplTest;

    @Test
    public void testGetAllCostumers(){
        String costumerName="aaaa";
        String costumerEmail="aaaa@gmail.com";
        Costumer costumer= Costumer.builder().fullName(costumerName).email(costumerEmail).build();
        Costumer costumer1=Costumer.builder().fullName(costumerName).email(costumerEmail).build();

        when(costumerRepository.findAll()).thenReturn(List.of(costumer,costumer1));
        List<CostumerResponse> costumerResponses=cotumerQueryServiceImplTest.getAllCostumers();
        assertEquals(2,costumerResponses.size());
    }

    @Test
    public void testGetAllCostumersByEmail(){
        String costumerName="aaaa";
       String costumerEmail="a@gmail.com";
       Costumer costumer= Costumer.builder().fullName(costumerName).email(costumerEmail).build();
       when(costumerRepository.findByEmail(costumerEmail)).thenReturn(Optional.of(costumer));
       CostumerResponse costumerResponse=cotumerQueryServiceImplTest.getCostumerByEmail(costumerEmail);

      assertEquals(costumerEmail,costumerResponse.email());
    }
    @Test
    public void testGetCostumerById(){
        Long costumerId=1L;
        Costumer costumer=Costumer.builder().fullName("aaaa").id(costumerId).build();
        when(costumerRepository.findById(costumerId)).thenReturn(Optional.of(costumer));
        CostumerResponse costumerResponse=cotumerQueryServiceImplTest.getCostumerById(costumerId);
        assertEquals(costumerId,costumerResponse.id());


    }


}
