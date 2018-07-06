package com.david.SL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// 注解设置自动扫描组件，并设置组件名称
@Component("bookBean")
public class Book {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 注解设置属性值
//    @Value("Computer Networking")
//    public String name;

    @Value("#{'Computer Networking'.toUpperCase()}")
    public String name;

    public String getFullName(String prefix){
        return prefix+this.name;
    }

}
