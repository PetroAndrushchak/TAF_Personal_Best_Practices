package tests.spring;

import com.petroandrushchak.spring.configuration.WebClientSpringConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@SpringJUnitConfig
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = WebClientSpringConfiguration.class)
@ComponentScan(basePackages = {"com.petroandrushchak.spring"})
public class BaseTest {


}
