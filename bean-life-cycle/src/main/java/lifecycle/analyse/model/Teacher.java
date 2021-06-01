package lifecycle.analyse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author : Vander
 * @date :   2021/5/26
 * @description :
 */
@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Teacher {

    private String teaNo;

    private String teaName;

}
