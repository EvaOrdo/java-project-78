package hexlet.code.schemas;

public class StringSchema {
    private String substring = "";
    private int minLength = 0;

    public void required() {
        this.minLength = 1;
    }

    public void contains(String substr) {
        this.substring = substr;
    }

    public void minLength(int length) {
        this.minLength = length;
    }

    public boolean isValid(Object obj) {
        if (!(obj instanceof String) && obj != null) {
            return false;
        }

        var text = (String) obj;

        if (text == null) {
           return minLength > 0 ? false : true;
        }

        if (text.length() < minLength || !text.contains(substring)) {
            return false;
        }
        return true;
    }
}

