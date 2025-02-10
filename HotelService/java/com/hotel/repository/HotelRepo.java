package com.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.entity.Hotel;

@Repository
public interface HotelRepo extends JpaRepository<Hotel, String> {

}
