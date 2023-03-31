package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {
    @Override
    protected boolean typeCheck(Object obj) {
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

    public void shape(Map<String, BaseSchema> schemas) {
        Predicate<Object> shape = object -> {
            var map = (Map) object;
            for (var pair : schemas.entrySet()) {
                var key = pair.getKey();
                var value = pair.getValue();
                if (!value.isValid(map.get(key))) {
                    return false;
                }
            }
            return true;
        };

        rules.add(shape);
    }

}
