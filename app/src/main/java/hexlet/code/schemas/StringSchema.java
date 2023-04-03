package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {
    @Override
    public boolean typeCheck(Object obj) {
        return obj instanceof String;
    }
    public StringSchema required() {
        rules.add(obj -> !((String) obj).isEmpty());
        required = true;
        return this;
    }
    public StringSchema contains(String substring) {
        rules.add(obj -> ((String) obj).contains(substring));
        return this;
    }

    public StringSchema minLength(Integer num) {
        rules.add(obj -> ((String) obj).length() >= num);
        return this;
    }
}

