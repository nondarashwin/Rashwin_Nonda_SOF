package com.manipal.service;

import com.manipal.bean.ToDoBean;

import java.util.ArrayList;

public class ToDoService {
    public static ArrayList<ToDoBean> toDos(String name){
    ArrayList<ToDoBean> toDoList=new ArrayList<>();
    toDoList.add(new ToDoBean("Rashw","create"));
        toDoList.add(new ToDoBean("Rashw","read"));
        toDoList.add(new ToDoBean("Rashw","update"));
        ArrayList<ToDoBean> output=new ArrayList<>();
        for(ToDoBean todo:toDoList){
            if(todo.name.equals(name)){
                output.add(todo);
            }
    System.out.println(todo.name);
        }
        return output;
    }
}
