package spring.demo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.demo.model.Microwave;
import spring.demo.model.Refrigerator;

/**
 * @author : Vander
 * @date :   2020/5/11
 * @description :
 */
public class Main {

    private static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args){
        ClassPathXmlApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("beandefinition-context.xml");
        Microwave microwave = (Microwave) applicationContext.getBean("microwave");
        log.info(microwave.toString());
        Refrigerator refrigerator = (Refrigerator) applicationContext.getBean("refrigerator0");
        log.info(refrigerator.toString());
    }

}
