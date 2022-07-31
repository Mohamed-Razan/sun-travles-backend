package com.suntravels.demo.repository;

import com.suntravels.demo.model.Hotel;
import com.suntravels.demo.model.RoomTypeContractKey;
import com.suntravels.demo.model.RoomTypecontract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomTypeContractRepository extends JpaRepository<RoomTypecontract, RoomTypeContractKey> {

}
