public class ProcessorType {
    private final double frequency;
    private final int coresCount;
    private final String manufactured;
    private final int processorWeight;

    public ProcessorType(double frequency, int coresCount, String manufactured, int processorWeight) {
        this.frequency = frequency;
        this.coresCount = coresCount;
        this.manufactured = manufactured;
        this.processorWeight = processorWeight;
    }
    public int getProcessorWeight() {
        return processorWeight;
    }
    public String toString() {
        return ""
                + "Процессор: " + frequency + "Mhz " + coresCount + " Cores " + "Manufacted:"+ manufactured + " " + processorWeight + "грамм."
                + "";
    }
}