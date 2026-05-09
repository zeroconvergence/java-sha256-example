import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SHA256ExTests {
    @Test
    public void testBytesToHex() {
        byte[] data = {(byte) 0xFF, 0x00, 0x0A};
        assertEquals("ff000a", SHA256Ex.bytesToHex(data));
    }

    @Test
    public void testTextToSha256() throws NoSuchAlgorithmException {
        assertEquals(
                "2cf24dba5fb0a30e26e83b2ac5b9e29e1b161e5c1fa7425e73043362938b9824",
                SHA256Ex.textToSha256("hello"));
    }
}