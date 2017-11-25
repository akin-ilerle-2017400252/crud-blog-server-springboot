package com.example.demo.data;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BlogPostRepository extends CrudRepository<BlogPost, Long>, PagingAndSortingRepository<BlogPost, Long> {

    BlogPost findById(long id);
}
