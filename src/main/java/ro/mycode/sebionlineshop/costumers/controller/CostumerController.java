package ro.mycode.sebionlineshop.costumers.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.mycode.sebionlineshop.costumers.dtos.CostumerResponse;
import ro.mycode.sebionlineshop.costumers.model.Costumer;
import ro.mycode.sebionlineshop.costumers.service.commandService.CostumerCommandservice;
import ro.mycode.sebionlineshop.costumers.service.queryService.CostumerQueryService;

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

//    @PostMapping("/add")
//    public ResponseEntity<CostumerResponse> addCostumer(@RequestBody Costumer costumer){
//
//
//
//    }









}
