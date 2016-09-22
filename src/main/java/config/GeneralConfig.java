package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by dmygaenko on 22/09/2016.
 */
@Configuration
@Import({SparkConfig.class, BeanConfig.class})
public class GeneralConfig {
}
