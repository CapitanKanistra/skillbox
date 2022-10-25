public class Dimensions {
    private final int lengths;
    private final int width;
    private final int height;

    public Dimensions(int lengths, int width, int height) {
        this.lengths = lengths;
        this.width = width;
        this.height = height;
    }

    public int getVolume() {
        return lengths * width * height;
    }

}
