package pl.sages.spock.publisher;

public interface Subscriber {

  void receive(String event) throws Exception;

  int getNumber();
}
