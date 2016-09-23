package service;

import config.GeneralConfig;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scala.tools.nsc.typechecker.StructuredTypeStrings;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by dmygaenko on 22/09/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = GeneralConfig.class)
public class PopularWorldServiceTest {

    @Autowired
    private JavaSparkContext sc;

    @Autowired
    private PopularWorldService service;

    @Test
    public void topX() throws Exception {
        JavaRDD<String> rdd = sc.parallelize(Arrays.asList("java java scala scala groovy java"));
        List<String> strings = service.topX(rdd, 2);

        assertTrue(strings.containsAll(Arrays.asList("java", "scala")));
    }

    @Test
    public void test() throws Exception {
        JavaRDD<String> rdd = sc.parallelize(Arrays.asList("java java scala groovy java"));
        SQLContext sqlContext = new SQLContext(sc);
        Dataset<Row> dataFrame = sqlContext.createDataFrame(rdd, StructuredTypeStrings.class);
    }

}