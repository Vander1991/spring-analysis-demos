package spring.aop.common.advice;

import org.aopalliance.aop.Advice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

import java.lang.reflect.Method;

/**
 * @author : Vander
 * @date :   2021-05-31
 * @description :
 */
public class PointcutAdvisorImpl implements PointcutAdvisor {

    /**
     * 切点，表示Advice切的位置
     *
     * @return
     */
    @Override
    public Pointcut getPointcut() {
        NameMatchMethodPointcut methodPointcut = new NameMatchMethodPointcut();
        methodPointcut.addMethodName("doSomeSports");
        return methodPointcut;
    }

    /**
     * 增强逻辑
     *
     * @return
     */
    @Override
    public Advice getAdvice() {
        return new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] args, Object target) throws Throwable {
                System.out.println("org.springframework.aop.MethodBeforeAdvice.before : before doSomeSports");
            }
        };
    }

    @Override
    public boolean isPerInstance() {
        return false;
    }
}
