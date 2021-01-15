package com.carrental.app.rent_a_car.controller;


import com.carrental.app.rent_a_car.entity.BrandNameEntity;
import com.carrental.app.rent_a_car.model.ResponseMessage;
import com.carrental.app.rent_a_car.service.BrandNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brandName/")
public class BrandNameController {

    @Autowired
    BrandNameService brandNameService;

    @GetMapping(value = "")
    public String welcome() {
        return "Welcome to BrandName ...";
    }

    @PostMapping(value = "createBrandName")
    public ResponseMessage createBrandName(@RequestBody BrandNameEntity brandNameEntity) {
        return brandNameService.createBrandName(brandNameEntity);
    }

    @GetMapping(value = "getBrandNames")
    public List<BrandNameEntity> getBrandNames() {
        return brandNameService.getBrandNames();
    }

    @GetMapping(value = "getBrandName/{id}")
    public BrandNameEntity getBrandName(@PathVariable long id) {
        return brandNameService.getBrandName(id);
    }

    @PostMapping(value = "updateBrandName")
    public ResponseMessage updateBrandName(@RequestBody BrandNameEntity brandNameEntity) {
        return brandNameService.updateBrandName(brandNameEntity);
    }

    @GetMapping(value = "deleteBrandName/{id}")
    public ResponseMessage deleteBrandName(@PathVariable long id) {
        return brandNameService.deleteBrandName(id);
    }
}