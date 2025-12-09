package com.Hotels.HotelMicroservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Hotels.HotelMicroservice.Entites.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String >{

}
