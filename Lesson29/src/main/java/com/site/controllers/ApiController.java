package com.site.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


@RestController
@RequestMapping("/api")
public class ApiController {
    ArrayList<Integer> arrayList;

    public ApiController(){
        arrayList = new ArrayList<>();
        arrayList.add(0);
        arrayList.add(1);
    }

    @PostMapping("/add")
    public void add() {
        arrayList.add(arrayList.getLast()+arrayList.get(arrayList.size()-2));
    }

    @GetMapping("/read")
    public String read(){
        String a = "";
        for (int i = 0; i < arrayList.size(); i++) {
            a += STR." \{arrayList.get(i)}";
        }
        return a;
    }


    public ArrayList<Integer> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<Integer> arrayList) {
        this.arrayList = arrayList;
    }
}
