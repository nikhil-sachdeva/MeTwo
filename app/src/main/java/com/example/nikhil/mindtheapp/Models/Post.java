package com.example.nikhil.mindtheapp.Models;

public class Post {
    String name;
    String body;
    String location;
    public Post(){

    }
public Post(String name,String body,String location){
    this.name=name;
    this.body=body;
    this.location=location;
};
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
