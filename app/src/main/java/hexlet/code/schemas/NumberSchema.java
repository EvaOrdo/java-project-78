package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {
    @Override
    public boolean typeCheck(Object obj) {
        return obj instanceof Integer;
    }

    public NumberSchema required() {
        required = true;
        return this;
    }

    public NumberSchema positive() {
        rules.add(obj -> (Integer) obj > 0);
        return this;
    }

    public NumberSchema range(Integer min, Integer max) {
        rules.add(obj -> (Integer) obj >= min && (Integer) obj <= max);
        return this;
    }
}
