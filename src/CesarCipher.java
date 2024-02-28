public class CesarCipher implements Cipher {

    @Override
    public String encrypt(String plaintext, String shiftStr) {
        int shift = parseShift(shiftStr);
        StringBuilder encrypted = new StringBuilder();

        for (char c : plaintext.toCharArray()) {
            if (Character.isLetter(c)) {
                char shifted = (char) (((c - 'a' + shift) % 26) + 'a');
                encrypted.append(shifted);
            } else {
                encrypted.append(c);
            }
        }

        return encrypted.toString();
    }

    @Override
    public String decrypt(String ciphertext, String shiftStr) {
        int shift = parseShift(shiftStr);
        return encrypt(ciphertext, String.valueOf(26 - shift));
    }

    private int parseShift(String shiftStr) {
        try {
            return Integer.parseInt(shiftStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Shift must be an integer.");
        }
    }
}
