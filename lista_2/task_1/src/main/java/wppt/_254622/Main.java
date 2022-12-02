package wppt._254622;

import java.util.Scanner;

import static java.lang.System.exit;

public final class Main {

    /**
     * Invoice.
     */
    private final Invoice invoice;
    /**
     * Scanner.
     */
    private final Scanner scanner = new Scanner(System.in);

    /**
     * @param args
     */
    public static void main(final String[] args) {
        Main app = new Main();
        showHelp();

        while (true) {
            System.out.print(">> ");
            app.chooseOption(app.scanner.nextLine());

        }
    }

    /**
     * @param input
     */
    private void chooseOption(final String input) {
        switch (input.toUpperCase()) {
            case "ADD":
                invoice.addItem(scanner);
                break;
            case "SHOW":
                invoice.show();
                break;
            case "EXIT":
                exit(0);
                break;
            case "HELP":
            default:
                showHelp();
                break;
        }
    }

    private static void showHelp() {
        System.out.printf("%6s - %s%n", "ADD", "add new invoice element");
        System.out.printf("%6s - %s%n", "SHOW", "show this invoice");
        System.out.printf("%6s - %s%n", "EXIT", "exit program");
        System.out.printf("%6s - %s%n", "HELP", "show this submenu");
    }

    private Main() {
        invoice = new Invoice();
    }
}
