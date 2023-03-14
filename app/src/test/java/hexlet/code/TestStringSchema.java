package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestStringSchema {
    private StringSchema schema;
    @BeforeEach
    public final void beforeEach() {
        Validator v = new Validator();
        schema = v.string();
    }
    @Test
    public void testIsValid() {
        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid("string"));
        assertFalse(schema.isValid(5));
    }

    @Test
    public void testContains() {
        schema.contains("good");

        var text = "good good good";

        assertTrue(schema.isValid(text));

        schema.contains("goodbye");
        assertFalse(schema.isValid(text));

    }

    @Test
    public void testRequired() {
        schema.required();
        assertFalse(schema.isValid(""));
        assertFalse(schema.isValid(null));
    }

    @Test
    public void testMinLength() {
        schema.minLength(10);

        var text1 = "hello world!";
        assertTrue(schema.isValid(text1));

        var text2 = "hello!";
        assertFalse(schema.isValid(text2));
    }
}
