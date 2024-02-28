import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose an option:");
        System.out.println("1. Encrypt Text");
        System.out.println("2. Decrypt Text");
        System.out.println("3. Auto Decrypt Text");
        int option = scanner.nextInt();

        if (option == 1 || option == 2) {
            System.out.println("Enter the text:");
            String text = scanner.next();
            System.out.println("Enter the shift:");
            String shift = scanner.next();
            scanner.nextLine();

            operateCipher(text, shift, option);
        } else if (option == 3) {
            System.out.println("Enter the text:");
            String text = scanner.next();
            operateCipher(text, "0", option);
        } else {
            System.out.println("Invalid option. Exiting...");
        }
    }

    private static void operateCipher(String text, String shift, int number) {
        Cipher cesarCipher = new CesarCipher();
        String result = "";

        switch (number) {
            case 1:
                result = cesarCipher.encrypt(text, shift);
                System.out.println("Encrypted text: " + result);
                break;
            case 2:
                result = cesarCipher.decrypt(text, shift);
                System.out.println("Decrypted text: " + result);
                break;
            case 3:
                result = CaesarCipherDecryptor.autoDecrypt(text, cesarCipher);
                if (result != null) {
                    System.out.println("Valid word found:\n" + result);
                } else {
                    System.out.println("No valid word found.");
                }
                break;
            default:
                System.out.println("Invalid number.");
        }
    }
}
