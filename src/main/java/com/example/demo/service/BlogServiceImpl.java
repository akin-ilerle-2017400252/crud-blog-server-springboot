package com.example.demo.service;

import com.example.demo.data.BlogPost;
import com.example.demo.data.BlogPostRepository;
import com.example.demo.model.BlogException;
import com.example.demo.model.CreateBodyModel;
import com.example.demo.model.UpdateBodyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogPostRepository blogPostRepository;

    @Override
    public void create(CreateBodyModel createBody) {
        BlogPost blogPost = new BlogPost();

        blogPost.setDate(new Date());
        blogPost.setHeader(createBody.getHeader());
        blogPost.setPost(createBody.getPost());

        blogPostRepository.save(blogPost);
    }

    @Override
    public BlogPost read(long id) {
        BlogPost blogPost = blogPostRepository.findById(id);

        nullBlogPostCheck(blogPost);

        return blogPost;

    }

    @Override
    public Page<BlogPost> readAll(Pageable pageable) {

        return blogPostRepository.findAll(pageable);

    }

    @Override
    public void update(UpdateBodyModel updateBodyModel) {

        BlogPost blogPost = blogPostRepository.findById(updateBodyModel.getId());

        nullBlogPostCheck(blogPost);

        if (updateBodyModel.getHeader() != null) {
            blogPost.setHeader(updateBodyModel.getHeader());
        }
        if (updateBodyModel.getPost() != null) {
            blogPost.setPost(updateBodyModel.getPost());
        }
        blogPostRepository.save(blogPost);
    }

    @Override
    public void delete(long id) {
        try {
            blogPostRepository.delete(id);
        }
        catch (EmptyResultDataAccessException e){
            throw new BlogException("Blog post not found", HttpStatus.NOT_FOUND);
        }
    }

    private void nullBlogPostCheck(BlogPost blogPost){
        if (blogPost == null) {
            throw new BlogException("Blog post not found", HttpStatus.NOT_FOUND);
        }
    }



}
