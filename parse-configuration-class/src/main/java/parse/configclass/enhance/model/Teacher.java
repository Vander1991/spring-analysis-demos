package parse.configclass.enhance.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author : Vander
 * @date :   2021/1/27
 * @description :
 */
@AllArgsConstructor
@NoArgsConstructor
@Component
@Data
public class Teacher {
    private Student student;
}
