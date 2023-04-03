package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema {
    @Override
    public boolean typeCheck(Object obj) {
        return obj instanceof Map<?, ?>;
    }
    public MapSchema required() {
        required = true;
        return this;
    }

    public MapSchema sizeof(Integer size) {
        rules.add(obj -> ((Map<?, ?>) obj).size() == size);
        return this;
    }

    public void shape(Map<String, BaseSchema> schemas) {
        rules.add(object -> {
            var map = (Map<?, ?>) object;
            for (var pair : schemas.entrySet()) {
                var key = pair.getKey();
                var value = pair.getValue();
                if (!value.isValid(map.get(key))) {
                    return false;
                }
            }
            return true;
        });
    }

}
