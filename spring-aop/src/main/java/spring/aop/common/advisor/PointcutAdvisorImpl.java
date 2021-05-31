package spring.aop.common.advisor;

import org.aopalliance.aop.Advice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

import java.lang.reflect.Method;

/**
 * @author : Vander
 * @date :   2021/6/1
 * @description :
 */
public class PointcutAdvisorImpl implements PointcutAdvisor {
    @Override
    public Pointcut getPointcut() {
        NameMatchMethodPointcut methodPointcut = new NameMatchMethodPointcut();
        methodPointcut.addMethodName("doSomeSports");
        return methodPointcut;
    }

    @Override
    public Advice getAdvice() {
        return new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] args, Object target) throws Throwable {
                System.out.println("org.springframework.aop.MethodBeforeAdvice.before : doSomeSports");
            }
        };
    }

    @Override
    public boolean isPerInstance() {
        return false;
    }
}
