package schemas;

import java.time.Duration;

public class Preview {
    private Duration length;

    public Preview(Duration length) {
        this.length = length;

    }

    public Duration getLength() {
        return length;
    }

    public void setLength(Duration length) {
        this.length = length;
    }
}
