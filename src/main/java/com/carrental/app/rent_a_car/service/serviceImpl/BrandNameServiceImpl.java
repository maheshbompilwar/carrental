package com.carrental.app.rent_a_car.service.serviceImpl;

import com.carrental.app.rent_a_car.entity.BrandNameEntity;
import com.carrental.app.rent_a_car.model.ResponseMessage;
import com.carrental.app.rent_a_car.repository.BrandNameRepository;
import com.carrental.app.rent_a_car.service.BrandNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandNameServiceImpl implements BrandNameService {

    @Autowired
    BrandNameRepository brandNameRepository;

    @Override
    public ResponseMessage createBrandName(BrandNameEntity brandNameEntity) {
        brandNameRepository.save(brandNameEntity);
        return new ResponseMessage("Record Added Successfully...", true);
    }

    @Override
    public List<BrandNameEntity> getBrandNames() {
       return brandNameRepository.findAll();
    }

    @Override
    public BrandNameEntity getBrandName(long id) {
       return brandNameRepository.findBrandNameEntityById(id);
    }

    @Override
    public ResponseMessage updateBrandName(BrandNameEntity brandNameEntity) {
        if (brandNameRepository.findBrandNameEntityById(brandNameEntity.getId()) == null)
            throw new RuntimeException("Record Not Available...");
       brandNameRepository.save(brandNameEntity);
        return new ResponseMessage("Record Updated Successfully...", true);
    }

    @Override
    public ResponseMessage deleteBrandName(long id) {
        if (brandNameRepository.findBrandNameEntityById(id) == null)
            throw new RuntimeException("Record Not Available...");
        brandNameRepository.deleteById(id);
        return new ResponseMessage("Record Deleted Successfully...", true);
    }
}