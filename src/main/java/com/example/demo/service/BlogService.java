package com.example.demo.service;


import com.example.demo.data.BlogPost;
import com.example.demo.model.CreateBodyModel;
import com.example.demo.model.UpdateBodyModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService {

    void create(CreateBodyModel createBodyModel);

    BlogPost read(long id);

    Page<BlogPost> readAll(Pageable pageable);

    void update(UpdateBodyModel updateBodyModel);

    void delete(long id);
}
