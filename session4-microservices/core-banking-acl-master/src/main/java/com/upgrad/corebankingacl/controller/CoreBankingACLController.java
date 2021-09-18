package com.upgrad.corebankingacl.controller;

import com.upgrad.corebankingacl.model.CoreBankingResponseVO;
import com.upgrad.corebankingacl.model.CustomerOnboardRequestVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class CoreBankingACLController {

    @PostMapping("/customer/v1/validate")
    public ResponseEntity<CoreBankingResponseVO> validateCustomer(@RequestBody CustomerOnboardRequestVO customerOnboardRequestVO) throws InterruptedException {
        //Thread.sleep(2000);
        return ResponseEntity.ok(CoreBankingResponseVO
                .builder()
                .coreBankingCustomerId(UUID.randomUUID().toString()) //hardcoded response
                .build());
    }

}
