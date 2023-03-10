package practice.string;

public class SequentialWordsNumbers {
    public static void main(String[] args) {
        String text = "Это просто текст, для примера работы программы";
        System.out.println(sequentialWordsNumbers(text));
    }

    public static String sequentialWordsNumbers(String text) {
        StringBuilder stringBuilder = new StringBuilder();
        int num = 0;
        String word = "";
        String newText = text + " ";
        if (text == "") {
            word = "";
        } else {
            for (int i = 0; i < newText.length(); i++) {
                if (newText.charAt(i) != ' ') {
                    word = word + newText.charAt(i);
                } else {
                    num++;
                    stringBuilder.append(" (" + num + ") " + word);
                    word = "";
                }
            }
        }
            return stringBuilder.toString().trim();
        }
}


