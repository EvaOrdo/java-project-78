package hexlet.code.schemas;

public final class NumberSchema {
    private boolean positive = false;
    private boolean required = false;
    private boolean range = false;
    private int start;
    private int end;

    public Boolean isValid(Object obj) {
        if (!(obj instanceof Integer) && obj != null) {
            return false;
        }
        var number = (Integer) obj;

        if (required) {
            return number != null;
        }

        if (positive) {
            return number > 0;
        }

        if (range) {
            return (number >= start && number <= end);
        }
        return true;
    }

    public void positive() {
        this.positive = true;
    }

    public void required() {
        this.required = true;
    }

    public void range(int s, int f) {
        this.start = s;
        this.end = f;
        this.range = true;
    }
}
