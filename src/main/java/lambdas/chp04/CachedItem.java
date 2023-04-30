package lambdas.chp04;

import java.time.Duration;
import java.util.Objects;

public class CachedItem {

    private String stock;
    private Duration duration;

    public CachedItem(String stock, Duration duration) {
        this.stock = stock;
        this.duration = duration;
    }

    public String getStock() {
        return stock;
    }

    public Duration getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "CachedItem{ stock='" + stock + ", duration=" + duration.getSeconds() + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CachedItem that = (CachedItem) o;
        return Objects.equals(stock, that.stock);
    }


}
