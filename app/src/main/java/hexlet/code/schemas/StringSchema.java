package hexlet.code.schemas;

import java.util.function.Predicate;

public final class StringSchema extends BaseSchema {
    @Override
    public boolean typeCheck(Object obj) {
        return obj instanceof String;
    }
    public StringSchema required() {
        Predicate<Object> isRequired = obj -> {
            String str = (String) obj;
            return !str.isEmpty();
        };
        rules.add(isRequired);
        required = true;
        return this;
    }
    public StringSchema contains(String substring) {
        Predicate<Object> isContains = obj -> {
            String str = (String) obj;
            return str.contains(substring);
        };
        rules.add(isContains);
        return this;
    }

    public StringSchema minLength(Integer num) {
        Predicate<Object> minLength = obj -> {
            String str = (String) obj;
            return str.length() >= num;
        };
        rules.add(minLength);
        return this;
    }
}

