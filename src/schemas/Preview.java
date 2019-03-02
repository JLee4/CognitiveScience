package schemas;

import java.time.Duration;

public class Preview {

    private Duration length;
    private Appeal appeal;

    public Preview(Duration length, Appeal appeal) {
        this.length = length;
        this.appeal = appeal;
    }

    public Appeal getAppeal() {
        return appeal;
    }

    public void setAppeal(Appeal appeal) {
        this.appeal = appeal;
    }

    public Duration getLength() {
        return length;
    }

    public void setLength(Duration length) {
        this.length = length;
    }
}
