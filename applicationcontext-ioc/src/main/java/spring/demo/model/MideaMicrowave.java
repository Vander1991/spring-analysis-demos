package spring.demo.model;

import lombok.NoArgsConstructor;

/**
 * @author : Vander
 * @date :   2020/3/3
 * @description :
 */
@NoArgsConstructor
public class MideaMicrowave extends Microwave {

    private boolean hasWheel;

    public MideaMicrowave(boolean hasWheel) {
        super();
        this.hasWheel = hasWheel;
    }

}
