package x.y.z;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    public MyTestObj myTGDAO() {
        return new MyTestObj();
    }

}
