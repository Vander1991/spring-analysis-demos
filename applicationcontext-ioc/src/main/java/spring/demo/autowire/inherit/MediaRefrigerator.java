package spring.demo.autowire.inherit;

import org.springframework.stereotype.Component;

/**
 * @author : Vander
 * @date :   2020/11/19
 * @description : 父类不注入到容器，但是用了@Autowired的注解，这样能不能注入成功？
 *              答案是可以的
 */
@Component
public class MediaRefrigerator extends Refrigerator {
}
