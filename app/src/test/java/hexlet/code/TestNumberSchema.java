package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestNumberSchema {
    private NumberSchema schema;

    @BeforeEach
    public final void beforeEach() {
        Validator v = new Validator();
        schema = v.number();
    }
    @Test
    public void testIsValid() {
        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(10));
        assertTrue(schema.isValid(-10));
        assertFalse(schema.isValid("5"));
    }

    @Test
    public void testRequired() {
        schema.required();
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(0));
        assertTrue(schema.isValid(-10));
    }

    @Test
    public void testPositive() {
        schema.positive();
        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(10));
        assertFalse(schema.isValid(0));
        assertFalse(schema.isValid(-2));
    }

    @Test
    public void testRange() {
        schema.range(2, 6);
        assertTrue(schema.isValid(2));
        assertTrue(schema.isValid(6));
        assertFalse(schema.isValid(1));
        assertFalse(schema.isValid(7));
    }
}
