package com.shoes.dao;

import java.util.List;

import com.shoes.model.Shoe;

public interface ShoeDAO {

    boolean addShoe(Shoe shoe);

    boolean updateShoe(Shoe shoe);

    boolean deleteShoe(int id);

    Shoe getShoeById(int id);

    List<Shoe> getAllShoes();

    List<Shoe> getShoesByCategory(String category);

    List<Shoe> searchShoes(String keyword);
}