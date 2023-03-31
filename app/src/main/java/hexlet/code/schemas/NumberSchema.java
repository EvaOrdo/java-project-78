package hexlet.code.schemas;

import java.util.function.Predicate;

public class NumberSchema extends BaseSchema {
    @Override
    public boolean typeCheck(Object obj) {
        return obj instanceof Integer;
    }

    public final NumberSchema required() {
        required = true;
        return this;
    }

    public final NumberSchema positive() {
        Predicate<Object> isPositive = obj -> {
            Integer num = (Integer) obj;
            return num > 0;
        };
        rules.add(isPositive);
        return this;
    }

    public final NumberSchema range(Integer min, Integer max) {
        Predicate<Object> isInRange = obj -> {
            Integer num = (Integer) obj;
            return  num >= min && num <= max;
        };
        rules.add(isInRange);
        return this;
    }
}
