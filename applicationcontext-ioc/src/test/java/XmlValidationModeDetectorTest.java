import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.xml.XmlValidationModeDetector;

import java.io.IOException;

/**
 * @author : Vander
 * @date :   2020/7/20
 * @description :
 */
public class XmlValidationModeDetectorTest {

    @Test
    public void test() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("beandefinition-context.xml");
        XmlValidationModeDetector xmlValidationModeDetector = new XmlValidationModeDetector();
        int mode = xmlValidationModeDetector.detectValidationMode(classPathResource.getInputStream());
        switch(mode) {
            case XmlValidationModeDetector.VALIDATION_NONE: {
                System.out.println("VALIDATION_NONE");
                break;
            }
            case XmlValidationModeDetector.VALIDATION_AUTO:{
                System.out.println("VALIDATION_AUTO");
                break;
            }
            case XmlValidationModeDetector.VALIDATION_DTD:{
                System.out.println("VALIDATION_DTD");
                break;
            }
            case XmlValidationModeDetector.VALIDATION_XSD:{
                System.out.println("VALIDATION_XSD");
                break;
            }
        }

    }

}
