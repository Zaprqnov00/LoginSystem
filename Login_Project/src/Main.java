import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> mapWithInformationPerUser = new LinkedHashMap<>();
        int countUsers = 0;

        while (countUsers < 2){
            System.out.println("Username:");
            String username = scanner.nextLine();

            checkUsernameLength(username);

            checkUsernameForDigitsAndSymbols(username);

            System.out.println("Password:");
            String password = scanner.nextLine();

            checkPasswordLength(password);

            checkPasswordSymbolsAndDigits(password);

            System.out.printf("Welcome %s, you have successfully registered on our platform.\n",username);
            System.out.println();

            countUsers++;
            mapWithInformationPerUser.put(username, password);
        }

        printInformationPerUser(mapWithInformationPerUser, countUsers);
    }

    private static void printInformationPerUser(Map<String, String> mapWithInformationPerUser, int countUsers) {
        System.out.println("System information for all users:");
        System.out.println("----------------------");

        for (Map.Entry<String, String> entry : mapWithInformationPerUser.entrySet()) {
            System.out.println("  Username: " + entry.getKey());
            System.out.println("  Password: " + entry.getValue());
            System.out.println("----------------------");
        }

        System.out.println("Count users in system: " + countUsers);
    }

    private static void checkPasswordSymbolsAndDigits(String password) {
        int countDigits = 0;
        int countLetters = 0;
        for (int i = 0; i < password.length(); i++) {
            char currentSymbol = password.charAt(i);

            if (Character.isDigit(currentSymbol)) {
                countDigits++;
            }

            if (Character.isLetter(currentSymbol)) {
                countLetters++;
            }

            if (currentSymbol == '@' || currentSymbol == '!' || currentSymbol == '#' || currentSymbol == '$') {
                throw new IllegalArgumentException("Password shouldn't contains this symbols!!!");
            }
        }

        if (countLetters < 5) {
            throw new IllegalArgumentException("Password need contains least 5 letters!!!");
        }
        if (countDigits < 3) {
            throw new IllegalArgumentException("Password contains need least 3 digits!!!");
        }
    }

    private static void checkPasswordLength(String password) {
        if (password.length() < 3 || password.length() > 20) {
            throw new IllegalArgumentException("Password need length 3 to 20 symbols!!!");
        }
    }

    private static void checkUsernameLength(String username) {
        if (username.length() < 4 || username.length() > 10) {
            throw new IllegalArgumentException("Username length need 0 to between 10 letters!!!");
        }
    }

    private static void checkUsernameForDigitsAndSymbols(String username) {
        for (int i = 0; i < username.length(); i++) {
            char currentSymbol = username.charAt(i);
            if (Character.isDigit(currentSymbol)) {
                throw new IllegalArgumentException("Username contains only letters!!!");
            }
            if (currentSymbol == '@' || currentSymbol == '!' || currentSymbol == '#' || currentSymbol == '$'
            || currentSymbol == '/' || currentSymbol == '&') {
                throw new IllegalArgumentException("Username shouldn't contains this symbols!!!");
            }
        }
    }
}
