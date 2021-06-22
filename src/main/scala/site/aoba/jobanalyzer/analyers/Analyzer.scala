package site.aoba.jobanalyzer.analyers

trait Analyzer extends AutoCloseable {
  def startAnalyzer(): Unit;
  def stopAnalyzer(): Unit;
}
