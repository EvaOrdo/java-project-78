package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestStringSchema {
    @Test
    public void testIsValid() {
        Validator v = new Validator();
        var schema = v.string();
        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid("string"));
        assertFalse(schema.isValid(5));
    }

    @Test
    public void testContains() {
        Validator v = new Validator();
        var schema = v.string();
        schema.contains("good");

        var text = "good good good";

        assertTrue(schema.isValid(text));

        schema.contains("goodbye");
        assertFalse(schema.isValid(text));

    }

    @Test
    public void testRequired() {
        Validator v = new Validator();
        var schema = v.string();
        schema.required();
        assertFalse(schema.isValid(""));
        assertFalse(schema.isValid(null));
    }

    @Test
    public void testMinLength() {
        Validator v = new Validator();
        var schema = v.string();
        schema.minLength(10);

        var text1 = "hello world!";
        assertTrue(schema.isValid(text1));

        var text2 = "hello!";
        assertFalse(schema.isValid(text2));
    }
}