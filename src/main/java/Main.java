import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;

/**
 * http://spark.apache.org/docs/latest/
 * http://spark.apache.org/docs/latest/programming-guide.html
 *
 * Created by dmygaenko on 22/09/2016.
 */
public class Main {

    public static void main(String[] args) {
        SparkConf conf = new SparkConf();
        conf.setAppName("my spark application");
        conf.setMaster("local[*]");
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> logData = sc.textFile("data/someFile.txt").cache();

        long numAs = logData.filter(new Function<String, Boolean>() {
            public Boolean call(String s) { return s.contains("a"); }
        }).count();


        System.out.println(numAs);
    }
}
