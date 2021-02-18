import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.Arrays;

/**
 * @author : Vander
 * @date :   2020/7/25
 * @description :
 */
public class StringUtilsTest {

    @Test
    public void testTokenize() {
        String nameAttr = "a,; b,; c";
        // 分割
        String[] nameArr = StringUtils.tokenizeToStringArray(nameAttr, ",; ");
        System.out.println(Arrays.asList(nameArr));
    }

}
