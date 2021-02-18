package test.parse.configclass.util;

import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.Arrays;

/**
 * @author : Vander
 * @date :   2021/1/25
 * @description :
 */
public class StringUtilsTest {

    @Test
    public void testTokenizeToStringArray() {
        String namesStr = "jason,john,panda\t\nvendor susan";
        String[] names = StringUtils.tokenizeToStringArray(namesStr, ",; \t\n");
        System.out.println(Arrays.asList(names));
    }

}
