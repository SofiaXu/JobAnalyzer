package site.aoba.jobanalyzer.di

import org.apache.spark.sql.SparkSession
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext}
import org.springframework.context.annotation.{Bean, Configuration}

@Configuration
class SparkConfiguration {
  private val conf = new SparkConf().setMaster("local[4]").setAppName("JobAnalyzer").set("spark.ui.enabled", "false")

  @Bean
  def getSparkSession: SparkSession = {
    SparkSession
      .builder()
      .config(conf)
      .getOrCreate();
  }

  @Bean
  def getSparkContext(spark: SparkSession): SparkContext = {
    spark.sparkContext
  }

  @Bean
  def getSparkStreamingContext(sc: SparkContext): StreamingContext = {
    new StreamingContext(sc, Seconds(1));
  }
}
