package MoscowUndergroundParser;


public class Line {
    private String number;
    private String line;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public Line(String number, String line){
        this.number = number;
        this.line = line;
    }

    @Override
    public String toString() {
        return number + " : " + line;
    }
}