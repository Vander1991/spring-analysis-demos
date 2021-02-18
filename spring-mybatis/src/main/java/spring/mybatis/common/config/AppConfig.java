package spring.mybatis.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author : Vander
 * @date :   2021/1/29
 * @description :
 */
@MapperScan("spring.mybatis.common.mapper")
@ComponentScan("spring.mybatis.common")
@Configuration
public class AppConfig {

    /**
     * 此方式仅在2.0以上的mybatis-spring版本中能用
     *
     * @return
     */
    @Bean
    public MapperScannerConfigurer configurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("spring.mybatis.common.mapper");
        return mapperScannerConfigurer;
    }

}
