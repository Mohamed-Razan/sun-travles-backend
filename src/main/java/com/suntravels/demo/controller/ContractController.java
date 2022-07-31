package com.suntravels.demo.controller;

import com.suntravels.demo.model.Contract;
import com.suntravels.demo.request.ContractRequest;
import com.suntravels.demo.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContractController {

    @Autowired
    private IContractService service;

    @PostMapping("/create-contract")
    public Contract createContract(@RequestBody ContractRequest contractRequest){
        return service.createContract(contractRequest);
    }

    @GetMapping("/get-all-contracts")
    public List<Contract> getAllContract(){
        return service.getAllContract();
    }

    @GetMapping("/get-contract-by-id/{cid}")
    public Contract getContractById(@PathVariable long cid){
        return service.getContractById(cid);
    }

    @PutMapping("/update-contract")
    public String updateContract(@RequestBody ContractRequest contractRequest){
        return service.updateContract(contractRequest);
    }

    @DeleteMapping("/delete-contract/{cid}")
    public void deleteContract(@PathVariable long cid){
        service.deleteContract(cid);
    }
}
