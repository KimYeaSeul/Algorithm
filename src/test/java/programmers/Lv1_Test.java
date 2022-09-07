package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Lv1_Test {

    private Lv1_1 lv1 = new Lv1_1();

    @Test
    void _짝수와_홀수() {
        assertEquals("Even", lv1._짝수와_홀수(4));
        assertEquals("Odd", lv1._짝수와_홀수(3));
    }
}
