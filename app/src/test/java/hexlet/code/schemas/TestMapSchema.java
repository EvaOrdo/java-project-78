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
    @Test
    public void testShape() {

        Map<String, BaseSchema> schemas = new HashMap<>();
        StringSchema stringSchema = new StringSchema();
        NumberSchema numberSchema = new NumberSchema();

        schemas.put("name", stringSchema.required());
        schemas.put("age", numberSchema.positive());

        schema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", 100);
        assertTrue(schema.isValid(human1));

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);
        assertTrue(schema.isValid(human2));

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);
        assertFalse(schema.isValid(human3));

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", -5);
        assertFalse(schema.isValid(human4));
    }
}
