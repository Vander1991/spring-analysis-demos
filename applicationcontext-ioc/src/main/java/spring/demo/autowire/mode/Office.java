package spring.demo.autowire.mode;

import lombok.ToString;

/**
 * @author : Vander
 * @date :   2020/11/18
 * @description :
 */
@ToString
public class Office {

    private Desk desk;

    public void setFieldDesk(Desk desk) {
        System.out.println("autowire byType");
        this.desk = desk;
    }

    public void setDesk(Desk desk) {
        System.out.println("autowire byName");
        this.desk = desk;
    }

}
