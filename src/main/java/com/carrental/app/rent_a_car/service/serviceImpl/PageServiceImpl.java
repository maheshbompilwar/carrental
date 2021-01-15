package com.carrental.app.rent_a_car.service.serviceImpl;

import com.carrental.app.rent_a_car.entity.PageEntity;
import com.carrental.app.rent_a_car.model.ResponseMessage;
import com.carrental.app.rent_a_car.repository.PageRepository;
import com.carrental.app.rent_a_car.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageServiceImpl implements PageService {

    @Autowired
    PageRepository pageRepository;

    @Override
    public ResponseMessage createPage(PageEntity pageEntity) {
        pageRepository.save(pageEntity);
        return new ResponseMessage("Record Added Successfully...", true);
    }

    @Override
    public List<PageEntity> getPages() {
       return pageRepository.findAll();
    }

    @Override
    public PageEntity getPage(long id) {
      return pageRepository.findPageEntityById(id);
    }

    @Override
    public ResponseMessage updatePage(PageEntity pageEntity) {
        if (pageRepository.findPageEntityById(pageEntity.getId()) == null)
            throw new RuntimeException("Record Not Available...");
       pageRepository.save(pageEntity);
        return new ResponseMessage("Record Updated Successfully...", true);
    }

    @Override
    public ResponseMessage deletePage(long id) {
        if (pageRepository.findPageEntityById(id) == null)
            throw new RuntimeException("Record Not Available...");
        pageRepository.deleteById(id);
        return new ResponseMessage("Record Deleted Successfully...", true);
    }
}
