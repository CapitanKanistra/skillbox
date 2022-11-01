public class Computer {
    public ProcessorType processorType;
    public RAMType ramType;
    public HDDType hddType;
    public MonitorType monitorType;
    public KeyboardType keyboardType;
    public String vendor;
    public final String name;

    public Computer(String vendor, String name, ProcessorType processorType, RAMType ramType, HDDType hddType, MonitorType monitorType, KeyboardType keyboardType) {
        this.vendor = vendor;
        this.name = name;
        this.processorType = processorType;
        this.ramType = ramType;
        this.hddType = hddType;
        this.monitorType = monitorType;
        this.keyboardType = keyboardType;
    }

    public int getTotalWeight() {
        return processorType.getProcessorWeight() + ramType.getRamWeight() + hddType.getHddWeight() +
                monitorType.getMonitorWeight() + keyboardType.getKeyboardWeight();
    }


    public String getVendor() {
        return vendor;
    }

    public String getName() {
        return name;
    }


    public String toString() {
        return ""
                + "Данные о компьютере" + "\n"
                + "Модель компьютера: " + getName() + "\n"
                + "Продавец: " + getVendor() + "\n"
                + processorType + "\n" + ramType + "\n" + hddType + "\n"
                + monitorType + "\n" + keyboardType + "\n"
                + "Общий вес компьютера: " + getTotalWeight();

    }
}