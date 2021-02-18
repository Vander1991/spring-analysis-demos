package test.parse.configclass.util;

import org.junit.Test;
import parse.configclass.lookup.model.Desk;

import java.lang.annotation.Annotation;
import java.util.Arrays;

/**
 * @author : Vander
 * @date :   2021/1/26
 * @description :
 */
public class ClassReaderTest {

    @Test
    public void readClassAnnotations() {
        Annotation[] annotations = Desk.class.getAnnotations();
        System.out.println(Arrays.asList(annotations));
    }

}
