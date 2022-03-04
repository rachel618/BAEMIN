package com.example.demo.src.category;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.store.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/categories")
public class CategoryController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private final CategoryProvider categoryProvider;
    @Autowired

    public CategoryController(CategoryProvider categoryProvider) {
        this.categoryProvider = categoryProvider;
    }



}
