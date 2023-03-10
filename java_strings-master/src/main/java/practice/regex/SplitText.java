package practice.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SplitText {

  public static void main(String[] args) {
    String text = "Это просто текст, для примера работы программы";
    System.out.println(splitTextIntoWords(text));


  }

  public static String splitTextIntoWords(String text) {
    String regex = "[а-яa-zА-ЯA-Z]+";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(text);
      List<String> list = new ArrayList<>();
    while (matcher.find()) {
      list.add(matcher.group());
      }
    //TODO реализуйте метод
    return list.stream().collect(Collectors.joining("\n"));
  }
}

