package practice;


import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailList {
    private static final String EMAIL_REGEX = "^(.+)[@](.+)\\W{1}(\\D+)$";
    private final TreeSet<String> emailList = new TreeSet<>();
    private static final Pattern CONSTANT = Pattern.compile(EMAIL_REGEX);
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";

    public static boolean isValid(final String email) {
        Matcher matcher = CONSTANT.matcher(email);
        return matcher.matches();
    }

    public void add(String email) {
        if (isValid(email)) {
            String register = email.toLowerCase();
            emailList.add(register);
        } else {
            System.out.println(WRONG_EMAIL_ANSWER);
        }
    }

    public List<String> getSortedEmails() {
        return (List) new ArrayList(emailList);
    }

}