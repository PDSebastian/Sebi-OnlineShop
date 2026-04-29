package ro.mycode.sebionlineshop.costumer.unitTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Transactional;
import ro.mycode.sebionlineshop.costumers.dtos.CostumerPatchRequest;
import ro.mycode.sebionlineshop.costumers.dtos.CostumerRequest;
import ro.mycode.sebionlineshop.costumers.dtos.CostumerResponse;
import ro.mycode.sebionlineshop.costumers.exceptions.CostumerAlreadyExistsException;
import ro.mycode.sebionlineshop.costumers.exceptions.CostumerNotFoundException;
import ro.mycode.sebionlineshop.costumers.model.Costumer;
import ro.mycode.sebionlineshop.costumers.repository.CostumerRepository;
import ro.mycode.sebionlineshop.costumers.service.CostumerCommandServiceImpl;
import ro.mycode.sebionlineshop.costumers.service.CosutmerQueryServiceImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CostumerCommandServiceImplTests {
    @Mock
    CostumerRepository costumerRepository;
    @InjectMocks
    CostumerCommandServiceImpl costumerCommandService;

    @Test
    @Transactional
    public void testAddCostumerReturnsOk() {
        String costumerEmail="c@gmail.com";
        String costumerName="c";
        CostumerRequest costumerRequest=CostumerRequest
                .builder()
                .fullName(costumerName)
                .email(costumerEmail)
                .build();

        Costumer costumer=Costumer.builder()
                .fullName(costumerName)
                .email(costumerEmail)
                .build();

        when(costumerRepository.findByEmail(costumerEmail)).thenReturn(Optional.empty());
        when(costumerRepository.save(any(Costumer.class))).thenReturn(costumer);

        CostumerResponse costumerResponse=costumerCommandService.addCostumer(costumerRequest);
        assertEquals(costumerEmail,costumerResponse.email());
        assertEquals(costumerName,costumerResponse.fullName());
    }
    @Test
    @Transactional
    public void testAddCostumerThrowsException(){
        String costumerEmail="c@gmail.com";
        String costumerName="c";
        CostumerRequest costumerRequest=CostumerRequest.builder()
                .fullName(costumerName)
                .email(costumerEmail)
                .build();
        Costumer costumer=Costumer.builder()
                .fullName(costumerName)
                .email(costumerEmail)
                .build();
        when(costumerRepository.findByEmail(costumerEmail)).thenReturn(Optional.of(costumer));
        assertThrows(CostumerAlreadyExistsException.class, ()->costumerCommandService.addCostumer(costumerRequest));
    }
    @Test
    @Transactional
    public void testUpdateCostumerReturnsOk() {
        String costumerEmail="c@gmail.com";
        String costumerName="c";
        String costumerNewEmail="b@gmail.com";

        CostumerRequest costumerRequest=CostumerRequest.builder()
                .fullName(costumerName)
                .email(costumerNewEmail)
                .build();
        Costumer costumer=Costumer.builder()
                .fullName(costumerName)
                .email(costumerEmail)
                .build();


        when(costumerRepository.findByEmail(costumerNewEmail)).thenReturn(Optional.of(costumer));
        when(costumerRepository.save(any(Costumer.class))).thenReturn(costumer);

        CostumerResponse costumerResponse=costumerCommandService.updateCostumer(costumerRequest);
        assertEquals(costumerEmail,costumerResponse.email());

    }
    @Test
    @Transactional
    public void testUpdateCostumerThrowsException(){
        String costumerEmail="c@gmail.com";
        String costumerName="c";
        CostumerRequest costumerRequest=CostumerRequest.builder()
                .fullName(costumerName)
                .email(costumerEmail)
                .build();
        when(costumerRepository.findByEmail(costumerEmail)).thenReturn(Optional.empty());
        assertThrows(CostumerNotFoundException.class, ()->costumerCommandService.updateCostumer(costumerRequest));
    }
    @Test
    @Transactional
    public void testDeleteCostumerReturnsOk() {
        String costumerEmail="c@gmail.com";
        String costumerName="c";

        Long costumerId=1L;
        Costumer costumer=Costumer.builder()
                .fullName(costumerName)
                .email(costumerEmail)
                .build();
        when(costumerRepository.findById(costumerId)).thenReturn(Optional.of(costumer));
        costumerCommandService.deleteCostumer(costumerId);



    }


}
