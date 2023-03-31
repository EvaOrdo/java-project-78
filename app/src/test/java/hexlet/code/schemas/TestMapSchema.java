package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestMapSchema {
    private final Validator v = new Validator();
    private MapSchema schema;

    @BeforeEach
    public final void beforeEach() {
        schema = v.map();
    }

    @Test
    public void testIsValid() {
        assertTrue(schema.isValid(null));
    }

    @Test
    public void testRequired() {
        schema.required();
        assertFalse(schema.isValid(null));
        Map<String, String> data = new HashMap<>();
        assertTrue(schema.isValid(data));
        data.put("key1", "value1");
        assertTrue(schema.isValid(data));
    }

    @Test
    public void testSizeof() {
        schema.sizeof(2);
        Map<String, String> data = new HashMap<>();
        assertFalse(schema.isValid(data));
        data.put("key1", "value1");
        assertFalse(schema.isValid(data));
        data.put("key2", "value2");
        assertTrue(schema.isValid(data));
    }

}
