package pl.sages.spock

import spock.lang.Specification
import spock.lang.Subject


class PersonSpec extends Specification {

  @Subject
  def person

  def setup() {
    person = new Person()
  }

  def "should exist"() {
    given:
    person = new Person()
    person.age = 10

    when:
    person.surname = 20

    then:
    person
  }
}
