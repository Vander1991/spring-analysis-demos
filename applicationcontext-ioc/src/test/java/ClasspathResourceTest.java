import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.net.URL;

/**
 * @author : Vander
 * @date :   2020/7/25
 * @description :
 */
public class ClasspathResourceTest {

    @Test
    public void test() throws IOException {
        Resource classPathResource = new ClassPathResource("beandefinition-alias.xml");
        System.out.println(((ClassPathResource) classPathResource).getFile().getAbsolutePath());
    }

    @Test
    public void testUrl() {
        URL resource = this.getClass().getClassLoader().getResource("beandefinition-alias.xml");
        System.out.println(resource.getFile());
    }

}
