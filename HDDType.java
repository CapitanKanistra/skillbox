public class HDDType {
    private final HDDTypeEnum type;
    private final int hddVolume;
    private final int hddWeight;

    public HDDType(HDDTypeEnum type,int hddVolume,int hddWeight) {
        this.type = type;
        this.hddVolume = hddVolume;
        this.hddWeight = hddWeight;
    }
    public HDDTypeEnum getType() {
        return type;
    }


    public int getHddWeight() {
        return hddWeight;
    }
    public String toString() {
        return ""
                + "ПЗУ: " + type + " " + hddVolume + "Gb " + hddWeight + "грамм."
                + "";
    }




}
