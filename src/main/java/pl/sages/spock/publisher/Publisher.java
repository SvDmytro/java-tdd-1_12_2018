package pl.sages.spock.publisher;

import io.vavr.control.Try;

import java.util.ArrayList;
import java.util.List;

public class Publisher {

  private List<Subscriber> subscribers = new ArrayList<>();

    public Publisher() {
    }

    public void send(final String event) {
    subscribers.forEach(sc -> Try.run(() -> sc.receive(event)).toEither());
  }

    public List<Subscriber> getSubscribers() {
        return this.subscribers;
    }

    public void setSubscribers(List<Subscriber> subscribers) {
        this.subscribers = subscribers;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Publisher)) return false;
        final Publisher other = (Publisher) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$subscribers = this.getSubscribers();
        final Object other$subscribers = other.getSubscribers();
        if (this$subscribers == null ? other$subscribers != null : !this$subscribers.equals(other$subscribers))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Publisher;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $subscribers = this.getSubscribers();
        result = result * PRIME + ($subscribers == null ? 43 : $subscribers.hashCode());
        return result;
    }

    public String toString() {
        return "Publisher(subscribers=" + this.getSubscribers() + ")";
    }
}
