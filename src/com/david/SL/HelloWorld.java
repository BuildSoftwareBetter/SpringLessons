package com.david.SL;

import java.util.Date;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * 创建一个普通的类
 */

public class HelloWorld  implements InitializingBean, DisposableBean{
    private String name;

    /*属性注入*/
    public void setName(String name) {
        this.name = name;
    }

    public HelloWorld(){}

    /*构造函数注入*/
    public HelloWorld(String name) {
        this.name = name;
    }

    public void printHello() {
        System.out.println("Spring :Hello " + name);
    }


    private Date createTime;

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void destroy() throws Exception {

        System.out.println(this.name+"destory");

    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}

