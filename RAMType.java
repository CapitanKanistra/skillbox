public class RAMType {
    private final RAMTypeEnum type;
    private final int ramVolume;
    private final int ramWeight;

    public RAMType(RAMTypeEnum type, int ramVolume, int ramWeight) {
        this.type = type;
        this.ramVolume = ramVolume;
        this.ramWeight = ramWeight;
    }


    public int getRamWeight() {
        return ramWeight;
    }

    public String toString() {
        return ""
                + "ОЗУ: " + type + " " + ramVolume + "Gb " + ramWeight + "грамм."
                + "";


    }
}
