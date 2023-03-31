package hexlet.code.schemas;

import java.util.function.Predicate;

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
        Predicate<Object> isPositive = obj -> {
            Integer num = (Integer) obj;
            return num > 0;
        };
        rules.add(isPositive);
        return this;
    }

    public NumberSchema range(Integer min, Integer max) {
        Predicate<Object> isInRange = obj -> {
            Integer num = (Integer) obj;
            return  num >= min && num <= max;
        };
        rules.add(isInRange);
        return this;
    }
}
