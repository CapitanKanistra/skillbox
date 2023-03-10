import practice.EmailList;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        EmailList emailList = new EmailList();
        String regexAdd = "(?i)(Add)\\s\\w.+";
        String regexList = "(?i)(List)";

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            } else if (input.matches(regexAdd)) {
                String[] data = input.split(" ", 2);
                emailList.add(data[1]);
            } else if (input.matches(regexList)) {
                for (int i = 0; i < emailList.getSortedEmails().size(); i++) {
                    System.out.println(emailList.getSortedEmails().get(i));
                }
            }
        }
    }
}