package com.suntravels.demo.serviceImpl;

import com.suntravels.demo.model.Contract;
import com.suntravels.demo.model.Hotel;
import com.suntravels.demo.repository.ContractRepository;
import com.suntravels.demo.request.ContractRequest;
import com.suntravels.demo.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private HotelService hotelService;

    public Contract createContract(ContractRequest contractRequest){

        Hotel hotel = hotelService.getHotelById(contractRequest.getHid());
        Contract contract = new Contract(contractRequest.getStartDate(), contractRequest.getEndDate(), true, hotel);
        return contractRepository.save(contract);
    }

    public List<Contract> getAllContract(){

        return contractRepository.findAll();
    }

    public Contract getContractById(long cid){

        return contractRepository.findById(cid).orElse(null);
    }

    public String updateContract(ContractRequest contractRequest){

        Contract existingContract = getContractById(contractRequest.getCid());

        try{
            existingContract.setHotel(hotelService.getHotelById(contractRequest.getHid()));
            existingContract.setStartDate(contractRequest.getStartDate());
            existingContract.setEndDate(contractRequest.getEndDate());

            contractRepository.save(existingContract);
            return "Success";
        }

        catch (Exception e){
            System.out.println(e);
            return "Failed";
        }
    }

    public void deleteContract(long cid){
        contractRepository.deleteById(cid);
    }
}
