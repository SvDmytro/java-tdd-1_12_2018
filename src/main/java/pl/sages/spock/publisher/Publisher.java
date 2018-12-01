package pl.sages.spock.publisher;

import java.util.ArrayList;
import java.util.List;

import io.vavr.API;
import io.vavr.control.Try;
import lombok.Data;
import lombok.SneakyThrows;

@Data
public class Publisher {

  List<Subscriber> subscribers = new ArrayList<>();

  public void send(final String event) {
    subscribers.forEach(sc -> Try.run(() -> sc.receive(event)).toEither());
  }
}
