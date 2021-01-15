package com.carrental.app.rent_a_car.service;

import com.carrental.app.rent_a_car.entity.PageEntity;
import com.carrental.app.rent_a_car.model.ResponseMessage;

import java.util.List;

public interface PageService {
    ResponseMessage createPage(PageEntity pageEntity);

    List<PageEntity> getPages();

    PageEntity getPage(long id);

    ResponseMessage updatePage(PageEntity adminEntity);

    ResponseMessage deletePage(long id);
}
