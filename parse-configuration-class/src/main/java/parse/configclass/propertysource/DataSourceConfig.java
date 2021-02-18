package parse.configclass.propertysource;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author : Vander
 * @date :   2021/1/25
 * @description :
 */
@Component
@PropertySource(name = "dataSourceConfig", value = "classpath:datasource.properties", encoding = "UTF-8")
public class DataSourceConfig {
}
