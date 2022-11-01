public class KeyboardType {
    private final KeyboardTypeEnum type;
    private final boolean backLight;
    private final int keyboardWeight;

    public KeyboardType(KeyboardTypeEnum type, boolean backLight, int keyboardWeight) {
        this.type = type;
        this.backLight = backLight;
        this.keyboardWeight = keyboardWeight;
    }

    public int getKeyboardWeight() {
        return keyboardWeight;
    }

    public String toString() {
        return ""
                + "Клавиатура: " + type + " Подсветка:" + backLight + " " + keyboardWeight + "грамм."
                + "";
    }
}
