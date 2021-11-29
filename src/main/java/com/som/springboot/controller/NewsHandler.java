package com.som.springboot.controller;

import com.som.springboot.entity.News;
import com.som.springboot.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/news")
public class NewsHandler {
    @Autowired
    private NewsRepository newsRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<News> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Pageable pageable= PageRequest.of(page-1,size);
        return newsRepository.findAll(pageable);
    }

    @PostMapping("/save")
    public String save(@RequestBody News news){
        News result = newsRepository.save(news);
        if(result != null){
            return "success";
        }else{
            return "error";
        }
    }

    @GetMapping("/findById/{id}")                                //通过id调取信息
    public News findById(@PathVariable("id") Integer id) {
        return newsRepository.findById(id).get();                    //从仓库中通过id调取信息
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        newsRepository.deleteById(id);
    }
}
