import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Main {
    private static Logger logger;


    private static final String ADD_COMMAND = "add Василий Петров " +
            "vasily.petrov@gmail.com +79215637722";
    private static final String COMMAND_EXAMPLES = "\t" + ADD_COMMAND + "\n" +
            "\tlist\n\tcount\n\tremove Василий Петров";
    private static final String COMMAND_ERROR = "Wrong command! Available command examples: \n" +
            COMMAND_EXAMPLES;
    private static final String HELP_TEXT = "Command examples:\n" + COMMAND_EXAMPLES;

    public static void main(String[] args) {
        logger = LogManager.getLogger(Main.class);

        logger.info("We've just greeted the user!");

        logger.error("We've just greeted the user!");



        Scanner scanner = new Scanner(System.in);
        CustomerStorage executor = new CustomerStorage();


        while (true) {
            try {
                String command = scanner.nextLine();
                String[] tokens = command.split("\\s+", 2);

                if (tokens[0].equals("add")) {
                    logger.info("Ввод");
                    executor.addCustomer(tokens[1]);

                } else if (tokens[0].equals("list")) {
                    logger.info("Лист");
                    executor.listCustomers();
                } else if (tokens[0].equals("remove")) {
                    logger.info("Удалить");
                    executor.removeCustomer(tokens[1]);
                } else if (tokens[0].equals("count")) {
                    logger.info("Колл-во");
                    System.out.println("There are " + executor.getCount() + " customers");
                } else if (tokens[0].equals("help")) {
                    logger.info("Вывод помощи");
                    System.out.println(HELP_TEXT);
                } else {
                    logger.info("ОШИБКА");
                    System.out.println(COMMAND_ERROR);
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
