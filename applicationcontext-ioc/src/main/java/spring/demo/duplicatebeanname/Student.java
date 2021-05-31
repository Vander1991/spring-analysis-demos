package spring.demo.duplicatebeanname;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author : Vander
 * @date :   2021-05-28
 * @description :
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
@Component("Jason")
public class Student {

    private String stuNo;

    private String stuName;

}
