package validation;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit test class for {@link ExpressionValidator.class}.
 */
public class ExpressionValidatorTest {

    @Test
    public void validSymbolTest() {
        assertTrue(new ExpressionValidator().isValid("( A | B ) & ( C  > D )"));
    }

    @Test
    public void validSymbolTest2() {
        assertTrue(new ExpressionValidator().isValid("( 0 1 !&  asd | < > >>>   ^  A B C a b c not asdawfa )"));
    }

    @Test
    public void invalidSymbolTest() {
        assertFalse(new ExpressionValidator().isValid("( 0 1 !&  asd | < >  ^  A B C a b c -.-)"));
    }

    @Test
    public void invalidSymbolTest2() {
        assertFalse(new ExpressionValidator().isValid("(A | B) & (@C & D)"));
    }

    @Test
    public void validParenthesesTest() {
        assertTrue(new ExpressionValidator().isValid("(A | B) & (C & D)"));
    }

    @Test
    public void validParenthesesTest2() {
        assertTrue(new ExpressionValidator().isValid("((A | B)) & ((C & D))"));
    }

    @Test
    public void badParenthesesTest() {
        assertFalse(new ExpressionValidator().isValid("(A | B) & (C & D"));
    }

    @Test
    public void badParenthesesTest2() {
        assertFalse(new ExpressionValidator().isValid("(A | B)) & (C & D"));
    }

    @Test
    public void badParenthesesTest3() {
        assertFalse(new ExpressionValidator().isValid("(A | B) & (C & D))"));
    }

}
