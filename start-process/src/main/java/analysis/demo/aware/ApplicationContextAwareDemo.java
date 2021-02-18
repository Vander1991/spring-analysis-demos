package analysis.demo.aware;

import analysis.demo.common.model.Fan;
import lombok.Getter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author : Vander
 * @date :   2021/1/23
 * @description :
 */
@Getter
@Component
public class ApplicationContextAwareDemo implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    private Fan fan;

    @Override
    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext has been invoke!!!");
        this.applicationContext = applicationContext;
    }

    @Autowired
    public void setFan(Fan fan) {
        System.out.println("setFan has been invoke!!!");
        this.fan = fan;
    }

}
