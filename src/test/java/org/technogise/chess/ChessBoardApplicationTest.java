package org.technogise.chess;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class ChessBoardApplicationTest {

    @Test
    public void validateInput_returnsFalseIfInvalidOrder() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method validateInputMethod = ChessBoardApplication.class.getDeclaredMethod("validateInput", String.class);
        validateInputMethod.setAccessible(true);

        boolean result = (Boolean) validateInputMethod.invoke(null, "2 KING 2");
        assertFalse(result);
    }

    @Test
    public void validateInput_returnsFalseIfInvalidPosition() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method validateInputMethod = ChessBoardApplication.class.getDeclaredMethod("validateInput", String.class);
        validateInputMethod.setAccessible(true);

        boolean result = (Boolean) validateInputMethod.invoke(null, "KING KING 2");
        assertFalse(result);
    }

    @Test
    public void validateInput_returnsFalseIfEmptyInput() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method validateInputMethod = ChessBoardApplication.class.getDeclaredMethod("validateInput", String.class);
        validateInputMethod.setAccessible(true);

        boolean result = (Boolean) validateInputMethod.invoke(null, "");
        assertFalse(result);
    }

    @Test
    public void validateInput_returnsFalseIfArgumentsMismatch() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method validateInputMethod = ChessBoardApplication.class.getDeclaredMethod("validateInput", String.class);
        validateInputMethod.setAccessible(true);

        boolean result = (Boolean) validateInputMethod.invoke(null, "KING 2");
        assertFalse(result);
    }

    @Test
    public void validateInput_returnsTrueIfValidInput() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method validateInputMethod = ChessBoardApplication.class.getDeclaredMethod("validateInput", String.class);
        validateInputMethod.setAccessible(true);

        boolean result = (Boolean) validateInputMethod.invoke(null, "KING 2 2");
        assertTrue(result);
    }
}
