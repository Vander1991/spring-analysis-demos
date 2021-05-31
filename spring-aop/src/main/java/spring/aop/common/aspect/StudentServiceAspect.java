package spring.aop.common.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author : Vander
 * @date :   2021/5/31
 * @description :
 */
@Aspect
public class StudentServiceAspect  {

    @After("execution(public void spring.aop.common.service.StudentService.doSomeSports())")
    public void afterDoSomeSports() {
        System.out.println("spring.aop.common.aspect.StudentServiceAspect.afterDoSomeSports");
    }

}
