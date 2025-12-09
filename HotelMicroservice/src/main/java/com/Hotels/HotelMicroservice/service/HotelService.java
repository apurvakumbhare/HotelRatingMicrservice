package com.Hotels.HotelMicroservice.service;

import java.util.List;

import com.Hotels.HotelMicroservice.Entites.Hotel;

public interface HotelService {
  public Hotel createHotel(Hotel hotel);
  public Hotel getHotelByHotelId(String id);
  public List<Hotel> getHotels();
}
