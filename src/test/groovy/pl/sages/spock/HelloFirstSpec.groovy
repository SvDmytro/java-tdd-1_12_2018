package pl.sages.spock

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class HelloFirstSpec extends Specification {


  def "should has proper size"() {
    expect:
    text.size() == length

    where:
    text     | length
    "Spock"  | 5
    "Kirk"   | 4
    "Scotty" | 6
  }
}