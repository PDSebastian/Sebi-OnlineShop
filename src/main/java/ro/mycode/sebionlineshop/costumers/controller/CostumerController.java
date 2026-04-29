package ro.mycode.sebionlineshop.costumers.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.mycode.sebionlineshop.costumers.dtos.CostumerPatchRequest;
import ro.mycode.sebionlineshop.costumers.dtos.CostumerRequest;
import ro.mycode.sebionlineshop.costumers.dtos.CostumerResponse;
import ro.mycode.sebionlineshop.costumers.mapper.CostumerMapper;
import ro.mycode.sebionlineshop.costumers.model.Costumer;
import ro.mycode.sebionlineshop.costumers.service.CostumerCommandservice;
import ro.mycode.sebionlineshop.costumers.service.CostumerQueryService;

import java.util.List;

@RequestMapping("/api/v2/costumers")
@RestController
@Slf4j
public class CostumerController {
   private CostumerQueryService costumerQueryService;
   private CostumerCommandservice costumerCommandservice;

   public CostumerController(CostumerQueryService costumerQueryService, CostumerCommandservice  costumerCommandservice) {
       this.costumerCommandservice  = costumerCommandservice;
       this.costumerQueryService=costumerQueryService;
   }

    @PostMapping({"", "/", "/add"})
    public ResponseEntity<CostumerResponse> addCostumer(@RequestBody CostumerRequest  costumerRequest){
       log.debug(" http://localhost:8080/api/v2/costumers/add");
        CostumerResponse response = costumerCommandservice.addCostumer(costumerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response) ;

    }
    @DeleteMapping("/delete/{costumerId}")
    public ResponseEntity<CostumerResponse> deleteCostumer(@PathVariable Long costumerId){
       log.debug(" http://localhost:8080/api/v2/costumers/delete/{costumerId}",costumerId);
        CostumerResponse response = costumerCommandservice.deleteCostumer(costumerId);
        return ResponseEntity.status(HttpStatus.OK).body(response) ;
    }
    @PutMapping("update")
    public ResponseEntity<CostumerResponse> updateCostumer(@RequestBody CostumerRequest costumerRequest) {
        log.debug("http://localhost:8080/api/v2/costumers/update");
        CostumerResponse response = costumerCommandservice.updateCostumer(costumerRequest);
        return ResponseEntity.ok(response);
    }
    @PatchMapping("/patch/{id}")
    public ResponseEntity<CostumerResponse> patchCostumer(@PathVariable Long id, @RequestBody CostumerPatchRequest patchRequest) {
        log.debug("http://localhost:8080/api/v2/costumers/patch/{id}", id);
        CostumerResponse response = costumerCommandservice.patchCostumer(id, patchRequest);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/all")
    public ResponseEntity<List<CostumerResponse>> getAllCostumers() {
        log.debug(" http://localhost:8080/api/v2/costumers/all");
        List<CostumerResponse> response = costumerQueryService.getAllCostumers();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CostumerResponse> getCostumerById(@PathVariable Long id) {
        log.debug(" http://localhost:8080/api/v2/costumers/{id}", id);
        CostumerResponse response = costumerQueryService.getCostumerById(id);
        return ResponseEntity.ok(response);
    }













}
