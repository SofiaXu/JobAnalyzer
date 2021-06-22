package site.aoba.jobanalyzer.analyers.impl

import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.kafka010.KafkaUtils
import org.apache.spark.streaming.kafka010.ConsumerStrategies.Subscribe
import org.apache.spark.streaming.kafka010.LocationStrategies.PreferConsistent
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.support.serializer.JsonDeserializer
import org.springframework.scheduling.annotation.{Async, Scheduled}
import org.springframework.stereotype.Component
import site.aoba.jobanalyzer.analyers.Analyzer
import site.aoba.jobanalyzer.models.ViewHistory

@Component
@Autowired
class JobViewHistoryAnalyzer(sparkContext: SparkContext,
                             sparkSession: SparkSession,
                             streamingContext: StreamingContext) extends Analyzer{
  private val sc: SparkContext = sparkContext;
  private val spark: SparkSession = sparkSession;
  private val ssc: StreamingContext = streamingContext;
  private val logger: Logger = LoggerFactory.getLogger(getClass);
  private val stream = KafkaUtils.createDirectStream(ssc,
    PreferConsistent,
    Subscribe[String, ViewHistory](Array("JobViewHistory"), Map[String, Object](
      "bootstrap.servers" -> "localhost:2181",
      "key.deserializer" -> classOf[StringDeserializer],
      "value.deserializer" -> classOf[JsonDeserializer[ViewHistory]],
      "auto.offset.reset" -> "latest",
      "enable.auto.commit" -> (false: java.lang.Boolean)
    )))
  private var isRunning: Boolean = false;

  @Async
  @Scheduled(fixedRate = Long.MaxValue)
  override def startAnalyzer(): Unit = {
    if (isRunning) {
      return
    }
    isRunning = true
    logger.info("Start reading from kafka.")
    stream.foreachRDD(x => {
      
    })
  }

  override def stopAnalyzer(): Unit = {
    throw new UnsupportedOperationException("Unsupported");
  }

  override def close(): Unit = {

  }
}
