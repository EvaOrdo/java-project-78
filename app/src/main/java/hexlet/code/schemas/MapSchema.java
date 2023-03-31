package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {
    @Override
    public boolean typeCheck(Object obj) {
        return obj instanceof Map<?, ?>;
    }
    public final MapSchema required() {
        required = true;
        return this;
    }

    public final MapSchema sizeof(Integer size) {
        Predicate<Object> isRightSize = obj -> {
            Map<?, ?> map = (Map<?, ?>) obj;
            return map.size() == size;
        };
        rules.add(isRightSize);
        return this;
    }

}
