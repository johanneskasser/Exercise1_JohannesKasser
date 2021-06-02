package at.ac.fhcampuswien;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordTest {

    @BeforeAll
    public static void init(){
        System.out.println("Testing started...");
    }

    @AfterAll
    public static void finished(){
        System.out.println("Finished testing!");
    }

    @Test
    public void passwordCheck_length(){
        boolean actual = Password.checkLength("hello");
        assertFalse(actual);
    }


    //
    @Test
    public void passwordCheck_length2(){
        boolean actual = Password.checkLength("hello1234mynameisjohanneskasser");
        assertFalse(actual);
    }

    @Test
    public void passwordCheck_length3(){
        boolean actual = Password.checkLength("helloWhatsup1!");
        assertTrue(actual);
    }

    @Test
    public void passwordCheck_capitals(){
        boolean actual = Password.checkCapitals("Hello");
        assertTrue(actual);
    }

    @Test
    public void passwordCheck_capitals2(){
        boolean actual = Password.checkCapitals("hello");
        assertFalse(actual);
    }

    @Test
    public void passwordCheck_capitals3(){
        boolean actual = Password.checkCapitals("HELLO");
        assertFalse(actual);
    }

    @Test
    public void passwordCheck_numbers(){
        boolean actual = Password.checkDigits("superSecure132!");
        assertTrue(actual);
    }

    @Test
    public void passwordCheck_numbers2(){
        boolean actual = Password.checkDigits("supersecure");
        assertFalse(actual);
    }

    @Test
    public void passwordCheck_special(){
        boolean actual = Password.checkSpecialCharacters("supersecure132A1!");
        assertTrue(actual);
    }

    @Test
    public void passwordCheck_special2(){
        boolean actual = Password.checkSpecialCharacters("supersecure");
        assertFalse(actual);
    }

    @Test
    public void passwordCheck_ongoingnumbers(){
        boolean actual = Password.checkIncrease("supersecure132");
        assertTrue(actual);
    }

    @Test
    public void passwordCheck_ongoingnumbers2(){
        boolean actual = Password.checkIncrease("supersecure123");
        assertFalse(actual);
    }

    @Test
    public void passwordCheck_threetimes(){
        boolean actual = Password.checkContinuous("supersecure132");
        assertTrue(actual);
    }

    @Test
    public void passwordCheck_threetimes2(){
        boolean actual = Password.checkContinuous("supersecure99999999");
        assertFalse(actual);
    }

    @Test
    public void passwordCheck_ValidPW(){
        boolean actual = Password.checkPassword("suPerSecure931!");
        assertTrue(actual);
    }

    @Test
    public void passwordCheck_InvalidPW(){
        boolean actual = Password.checkPassword("wackPassword");
        assertFalse(actual);
    }
}