package com.david.SL;

import com.david.SL.AutoScan.CustomerService;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {

    public static void main(String[] args) {

//        ELbyAnnotation();

        ELbyXML();
    }

    // 基于注解的EL
    public static void ELbyAnnotation(){

        ApplicationContext context = new ClassPathXmlApplicationContext("AutoScanConfig.xml");
        BookDetail bd = (BookDetail)context.getBean("bookDetail");
        System.out.println(bd.toString());

    }

    // 基于xml的EL
    public static void ELbyXML(){

        ApplicationContext context = new ClassPathXmlApplicationContext("BookELConfig.xml");
        BookDetail bd = (BookDetail)context.getBean("bookDetail");
        System.out.println(bd.toString());

    }

    public static void Autowire(){

        ApplicationContext context = new ClassPathXmlApplicationContext("AutoWireConfig.xml");

        // no
//        User UserAdminDefault = (User) context.getBean("UserAdminDefault");
//        System.out.println(UserAdminDefault.toString());


        // byType
//        User UserAdminByType = (User) context.getBean("UserAdminByType");
//        System.out.println(UserAdminByType.toString());

        // byName
//        User UserAdminByName = (User) context.getBean("UserAdminByName");
//        System.out.println(UserAdminByName.toString());

        // constructor
        User UserAdminByConstructor = (User) context.getBean("UserAdminByConstructor");
        System.out.println(UserAdminByConstructor.toString());

    }

    // 自动扫描组件
    public static void AutoScan() {
        ApplicationContext context = new ClassPathXmlApplicationContext("AutoScanConfig.xml");

        CustomerService cs= (CustomerService) context.getBean("customerService");

        System.out.println(cs.toString());
    }

    // 多个参数的构造函数测试
    public static void MutiParaConstruct() {

        ApplicationContext context = new ClassPathXmlApplicationContext("CustomerConfig.xml");

        Customer c = (Customer) context.getBean("Customer1");

        System.out.println(c.toString());

    }


    public static void PostConstructPreDestroy() {
        ApplicationContext context = new ClassPathXmlApplicationContext("CustomerConfig.xml");

        Customer c = (Customer) context.getBean("xiaoming");

        System.out.println(c.getName());
        //Scope();

        ((ClassPathXmlApplicationContext) context).close();
    }

    // 测试properties资源文件
    public static void PropertyPlaceholderTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        HelloWorld single = (HelloWorld) context.getBean("HelloWorldPlaceholder");
        single.printHello();
    }

    // 日期注入
    public static void DateInject() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        HelloWorld HelloWorldFactoryBeanCreateTime = (HelloWorld) context.getBean("HelloWorldFactoryBeanCreateTime");
        System.out.println(HelloWorldFactoryBeanCreateTime.getCreateTime());

//        HelloWorld HelloWorldCustomDateEditorCreateTime = (HelloWorld) context.getBean("HelloWorldCustomDateEditorCreateTime");
//        System.out.println(HelloWorldCustomDateEditorCreateTime.getCreateTime());
    }

    /*bean作用域（生命周期）*/
    public static void Scope() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        HelloWorld single = (HelloWorld) context.getBean("helloBeanSig");
        single.printHello();
        single.setName("single2");

        HelloWorld single2 = (HelloWorld) context.getBean("helloBeanSig");
        single2.printHello();

        HelloWorld proto = (HelloWorld) context.getBean("helloBeanPro");
        proto.printHello();
        proto.setName("proto2");

        HelloWorld proto2 = (HelloWorld) context.getBean("helloBeanPro");
        proto2.printHello();
    }

    /*通过Import加载多个xml文件*/
    public static void LoadImportXmlFile() {
        ApplicationContext context = new ClassPathXmlApplicationContext("SystemAuthority.xml");

        User user = (User) context.getBean("UserAdmin");
        System.out.println(user.toString());
    }

    public static void LoadMutilXmlFile() {
        // 加载多个xml配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"SystemRole.xml", "SystemUser.xml"});

        User user = (User) context.getBean("UserAdmin");

        System.out.println(user.toString());
    }

    public static void HelloWorld() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        HelloWorld obj = (HelloWorld) context.getBean("helloBeanSetter");
        obj.printHello();

        HelloWorld obj2 = (HelloWorld) context.getBean("helloBeanCons");
        obj2.printHello();

        obj2.setName("second");

        obj2 = (HelloWorld) context.getBean("helloBeanCons");
        obj2.printHello();
    }
}