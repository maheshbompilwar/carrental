package com.carrental.app.rent_a_car.controller;

import com.carrental.app.rent_a_car.entity.PageEntity;
import com.carrental.app.rent_a_car.model.ResponseMessage;
import com.carrental.app.rent_a_car.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/page/")
public class PageController {

    @Autowired
    PageService pageService;

    @GetMapping(value = "")
    public String welcome() {
        return "Welcome to admin ...";
    }

    @PostMapping(value = "createPage")
    public ResponseMessage createPage(@RequestBody PageEntity pageEntity) {
        return pageService.createPage(pageEntity);
    }

    @GetMapping(value = "getPages")
    public List<PageEntity> getPages() {
        return pageService.getPages();
    }

    @GetMapping(value = "getPage/{id}")
    public PageEntity getPage(@PathVariable long id) {
        return pageService.getPage(id);
    }

    @PostMapping(value = "updatePage")
    public ResponseMessage updatePage(@RequestBody PageEntity adminEntity) {
        return pageService.updatePage(adminEntity);
    }

    @GetMapping(value = "deletePage/{id}")
    public ResponseMessage deletePage(@PathVariable long id) {
        return pageService.deletePage(id);
    }
}
