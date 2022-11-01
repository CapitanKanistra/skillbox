public class MonitorType {
    private final int diagonale;
    private final MonitorTypeEnum type;
    private final int monitorWeight;

    MonitorType(int diagonale, MonitorTypeEnum type, int monitorWeight) {
        this.diagonale = diagonale;
        this.type = type;
        this.monitorWeight = monitorWeight;
    }

    public int getMonitorWeight() {
        return monitorWeight;
    }

    public String toString() {
        return ""
                +"Монитор: " + diagonale + "inch " + type + " " + monitorWeight + "грамм."
                + "";


    }
}
