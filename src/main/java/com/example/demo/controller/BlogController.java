package com.example.demo.controller;


import com.example.demo.data.BlogPost;
import com.example.demo.model.CreateBodyModel;
import com.example.demo.model.UpdateBodyModel;
import com.example.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BlogController {

    @Autowired
    BlogService blogService;

    @RequestMapping(value = "/blogpost", method = RequestMethod.POST)
    public void create(@RequestBody CreateBodyModel createBody) {
        blogService.create(createBody);
    }

    @RequestMapping(value = "/blogpost", method = RequestMethod.GET)
    public BlogPost read(@RequestParam long id) {
        return blogService.read(id);
    }

    /**
     * In order to get the last blog post in the beginning of the page, you should  call this endpoint using
     * descending order with respect to the id.
     * Example: /blogposts?page=0&sort=id,DESC
     * @param pageable
     * @return
     */
    @RequestMapping(value = "/blogposts", method = RequestMethod.GET)
    public Page<BlogPost> readAll(Pageable pageable) {
        return blogService.readAll(pageable);
    }

    @RequestMapping(value = "/blogpost", method = RequestMethod.PUT)
    public void update(@RequestBody UpdateBodyModel updateBodyModel) {
        blogService.update(updateBodyModel);
    }

    @RequestMapping(value = "/blogpost", method = RequestMethod.DELETE)
    public void delete(@RequestParam long id) {
        blogService.delete(id);
    }

}
