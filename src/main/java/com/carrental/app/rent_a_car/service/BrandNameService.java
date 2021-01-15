package com.carrental.app.rent_a_car.service;

import com.carrental.app.rent_a_car.entity.BrandNameEntity;
import com.carrental.app.rent_a_car.model.ResponseMessage;

import java.util.List;

public interface BrandNameService {
    ResponseMessage createBrandName(BrandNameEntity brandNameEntity);

    List<BrandNameEntity> getBrandNames();

    BrandNameEntity getBrandName(long id);

    ResponseMessage updateBrandName(BrandNameEntity brandNameEntity);

    ResponseMessage deleteBrandName(long id);
}