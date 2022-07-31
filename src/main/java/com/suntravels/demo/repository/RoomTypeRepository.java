package com.suntravels.demo.repository;

import com.suntravels.demo.model.Hotel;
import com.suntravels.demo.model.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {

    List<RoomType> findByHotel(Hotel hotel);
}
