package spring.mybatis.simulate;

import lombok.Setter;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import spring.mybatis.simulate.model.Student;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @author : Vander
 * @date :   2021/1/30
 * @description :
 */
@Setter
public class MapperFactoryBean implements FactoryBean {

    private Class<?> mapper;

    public MapperFactoryBean(Class<?> mapper) {
        this.mapper = mapper;
    }

    @Autowired
    private Map<Integer, Student> studentsContent;

    @Override
    public Object getObject() throws Exception {
        return Proxy.newProxyInstance(
                this.getClass().getClassLoader(),
                new Class[]{mapper},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if(method.getName().equals("selectById")) {
                            return studentsContent.get(args[0]);
                        }
                        return null;
                    }
                });
    }

    @Override
    public Class<?> getObjectType() {
        return mapper;
    }

}
