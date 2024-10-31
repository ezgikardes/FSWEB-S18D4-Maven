package com.workintech.s18d1.controller;

import com.workintech.s18d1.dao.BurgerDao;

import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.exceptions.BurgerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/burger")
public class BurgerController {

    BurgerDao burgerDao;


    @Autowired
    public BurgerController(BurgerDao burgerDao) {
        this.burgerDao = burgerDao;
    }

    @GetMapping
    public List<Burger> getAllBurgers(){
        return burgerDao.findAll();
    }

    @GetMapping("/{id}")
    public Burger getBurgerById(@PathVariable Long id){
        Burger burger = burgerDao.findById(id);
        if(burger == null){
            throw new BurgerException("Burger not found with given ID", HttpStatus.BAD_REQUEST);
        }
        return burger;
    }

    @PostMapping
    public Burger addBurger(@RequestBody Burger burger){
        burgerDao.save(burger);
        return burger;
    }

    @PutMapping
    public Burger updateBurger(@RequestBody Burger burger){
        burgerDao.update(burger);
        return burger;
    }

    @DeleteMapping("/{id}")
    public Burger deleteBurger(@PathVariable Long id){
        return burgerDao.remove(id);
    }

    @GetMapping("/price/{price}")
    public List<Burger> getBurgerByPrice(@PathVariable Double price){
        return burgerDao.findByPrice(price);
    }

    @GetMapping("/breadType/{breadType}")
    public List<Burger> getBurgerByBreadType(@PathVariable BreadType breadType){
        return burgerDao.findByBreadType(breadType);
    }

    @GetMapping("/content/{content}")
    public List<Burger> getBurgerByContent(@PathVariable String content){
        return burgerDao.findByContent(content);
    }

}
