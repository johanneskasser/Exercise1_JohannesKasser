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
        boolean actual = Password.checkPassword("hello");
        assertFalse(actual);
    }

    @Test
    public void passwordCheck_length2(){
        boolean actual = Password.checkPassword("hello1234mynameisjohanneskasser");
        assertFalse(actual);
    }

    @Test
    public void passwordCheck_length3(){
        boolean actual = Password.checkPassword("hellowhatsup");
        assertTrue(actual);
    }

    @Test
    public void passwordCheck_capitals(){
        boolean actual = Password.checkPassword("HelLo");
        assertTrue(actual);
    }

    @Test
    public void passwordCheck_capitals2(){
        boolean actual = Password.checkPassword("hello");
        assertFalse(actual);
    }

    @Test
    public void passwordCheck_capitals3(){
        boolean actual = Password.checkPassword("HELLO");
        assertFalse(actual);
    }

    @Test
    public void passwordCheck_numbers(){
        boolean actual = Password.checkPassword("supersecure132");
        assertTrue(actual);
    }

    @Test
    public void passwordCheck_numbers2(){
        boolean actual = Password.checkPassword("supersecure");
        assertFalse(actual);
    }

    @Test
    public void passwordCheck_special(){
        boolean actual = Password.checkPassword("supersecure132A1!");
        assertTrue(actual);
    }

    @Test
    public void passwordCheck_special2(){
        boolean actual = Password.checkPassword("supersecure");
        assertFalse(actual);
    }

    @Test
    public void passwordCheck_ongoingnumbers(){
        boolean actual = Password.checkPassword("supersecure132");
        assertTrue(actual);
    }

    @Test
    public void passwordCheck_ongoingnumbers2(){
        boolean actual = Password.checkPassword("supersecure123");
        assertFalse(actual);
    }

    @Test
    public void passwordCheck_threetimes(){
        boolean actual = Password.checkPassword("supersecure132");
        assertTrue(actual);
    }

    @Test
    public void passwordCheck_threetimes2(){
        boolean actual = Password.checkPassword("supersecure99999999");
        assertFalse(actual);
    }
}