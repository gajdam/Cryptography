import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CesarCipherTest {
    // Test encrypt method of CaesarCipher class
    @Test
    public void testEncrypt() {
        CesarCipher cipher = new CesarCipher();
        String plaintext = "maciek";
        String key = "3";
        String expected = "pdflhn";
        String encrypted = cipher.encrypt(plaintext, key);
        assertEquals(expected, encrypted);
    }

    // Test decrypt method of CaesarCipher class
    @Test
    public void testDecrypt() {
        CesarCipher cipher = new CesarCipher();
        String ciphertext = "pdflhn";
        String key = "3";
        String expected = "maciek";
        String decrypted = cipher.decrypt(ciphertext, key);
        assertEquals(expected, decrypted);
    }

    // Test autoDecrypt method of CaesarCipherDecryptor class with valid word
    // expected answer: Valid word found: horse
    @Test
    public void testAutoDecryptWithValidWord() {
        String ciphertext = "cotjuc";
        Cipher testCipher = new CesarCipher();

        String result = CaesarCipherDecryptor.autoDecrypt(ciphertext, testCipher);

        assertEquals("widnow", result);
    }

    // Test autoDecrypt method of CaesarCipherDecryptor class with empty ciphertext
    // expected answer: no valid word found
    @Test
    public void testAutoDecryptWithEmptyCiphertext() {
        String ciphertext = "";
        Cipher testCipher = new CesarCipher();

        String result = CaesarCipherDecryptor.autoDecrypt(ciphertext, testCipher);

        assertEquals(null, result);
    }
}