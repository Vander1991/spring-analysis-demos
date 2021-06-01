package circulate.dependency.common.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author : Vander
 * @date :   2021/2/1
 * @description :
 */
@Aspect
@Component
public class HusbandAspect {

    @Before("execution(public void circulate.dependency.common.model.Husband.makeMoney())")
    public void enhanceMethod() {
        System.out.println("before husband makeMoney : enhanceMethod!");
    }

}
