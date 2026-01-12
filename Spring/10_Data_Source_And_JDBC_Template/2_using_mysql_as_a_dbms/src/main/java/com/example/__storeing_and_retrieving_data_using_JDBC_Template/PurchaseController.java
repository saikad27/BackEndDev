package com.example.__storeing_and_retrieving_data_using_JDBC_Template;

import com.example.__storeing_and_retrieving_data_using_JDBC_Template.dao.PurchaseRepository;
import com.example.__storeing_and_retrieving_data_using_JDBC_Template.model.Purchase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PurchaseController {

    PurchaseRepository purchaseRepo;

    public PurchaseController(PurchaseRepository purchaseRepo){
        this.purchaseRepo = purchaseRepo;
    }

    @GetMapping("/purchase")
    public List<Purchase> get(){
        return purchaseRepo.findAllPurchases();
    }

    @PostMapping("/purchase")
    public void post(@RequestBody Purchase purchase){
        purchaseRepo.storePurchase(purchase);
    }
}
