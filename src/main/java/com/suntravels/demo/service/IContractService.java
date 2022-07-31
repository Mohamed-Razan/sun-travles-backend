package com.suntravels.demo.service;

import com.suntravels.demo.model.Contract;
import com.suntravels.demo.request.ContractRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IContractService {

    Contract createContract(ContractRequest contractRequest);
    List<Contract> getAllContract();
    Contract getContractById(long cid);
    String updateContract(ContractRequest contractRequest);
    void deleteContract(long cid);

}
