package com.manipal.controller;

import com.manipal.bean.ToDoBean;
import com.manipal.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ToDOController {
@Autowired
ToDoService ToDoService;

    @GetMapping("/{username}")
    public ArrayList<ToDoBean> homePage(@PathVariable String  name){

        return ToDoService.toDos(name);
    }
}

