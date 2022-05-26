package tests.base;


import com.petroandrushchak.configs.ClientConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Slf4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ClientConfig.class)
public class TestBaseApi {

    @BeforeEach
    public void beforeEach(TestInfo testInfo) {
        log.info("Before Each test method");
    }
}
