package service;

import org.apache.spark.api.java.JavaRDD;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dmygaenko on 22/09/2016.
 */
public interface PopularWorldService extends Serializable {

    List<String> topX(JavaRDD<String> lines, int x);

}
