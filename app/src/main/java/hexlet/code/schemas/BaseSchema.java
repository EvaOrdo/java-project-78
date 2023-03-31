package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema {
    protected List<Predicate<Object>> rules = new ArrayList<>();
    protected boolean required = false;

    /**
     * @param obj should be checked for a type
     * @return Boolean
     */
    protected boolean typeCheck(Object obj) {
        return true;
    }

    public final boolean isValid(Object obj) {
        if (obj == null) {
            return !required;
        }

        if (!typeCheck(obj)) {
            return false;
        }

        for (var rule: rules) {
            if (!rule.test(obj)) {
                return false;
            }
        }
        return true;
    }
}
