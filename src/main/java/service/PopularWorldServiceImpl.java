package service;

import org.apache.spark.api.java.JavaRDD;
import org.springframework.stereotype.Service;
import scala.Tuple2;

import java.util.List;

/**
 * Created by dmygaenko on 22/09/2016.
 */
@Service
public class PopularWorldServiceImpl implements PopularWorldService {

    @Override
    public List<String> topX(JavaRDD<String> lines, int x) {
        return lines.map(String::toLowerCase)
              /*  .flatMap((line) -> line.split(" "))*/
                .mapToPair((word) -> new Tuple2<>(word, 1))
                .reduceByKey(Integer::sum)
                .mapToPair(Tuple2::swap)
                .sortByKey(false)
                .map(Tuple2::_2)
                .take(x);
    }
}
