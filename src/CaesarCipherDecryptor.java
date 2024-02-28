public class CaesarCipherDecryptor {
    public static String autoDecrypt(String ciphertext, Cipher cipher) { // if word exists, returns it
        // does not take the '0' transition into account, then the encrypted word is also decrypted
        for (int shift = 1; shift < 26; shift++) {
            String decrypted = cipher.decrypt(ciphertext, String.valueOf(shift));
            System.out.println("Attempted decryption with shift " + shift + ": " + decrypted);
            if (WordChecker.checkWord(decrypted)) {
                return decrypted;
            }
        }

        return null;
    }
}
