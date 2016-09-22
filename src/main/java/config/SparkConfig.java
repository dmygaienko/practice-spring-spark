package config;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by dmygaenko on 22/09/2016.
 */
@Configuration
public class SparkConfig {

    @Bean
    public JavaSparkContext sc() {
        SparkConf conf = new SparkConf();
        conf.setAppName("my spark application");
        conf.setMaster("local[2]");
        return new JavaSparkContext(conf);
    }

}
