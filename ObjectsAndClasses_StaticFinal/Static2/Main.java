public class Main {
    public static void main(String[] args) {
        ProcessorType processorType = new ProcessorType(3.5, 2, "China", 15);
        RAMType ramType = new RAMType(RAMTypeEnum.DDR,16,20);
        HDDType hddType = new HDDType(HDDTypeEnum.HDD,200,500);
        MonitorType monitorType = new MonitorType(23,MonitorTypeEnum.IPS,5000);
        KeyboardType keyboardType = new KeyboardType(KeyboardTypeEnum.MECHANICAL,false,1000);
        Computer computer = new Computer("Intel","A", processorType, ramType, hddType, monitorType, keyboardType);
        computer.setProcessor(new ProcessorType(2.5,2,"China",20));
        computer.setRam(new RAMType(RAMTypeEnum.SDR,16,15));
        computer.setHdd(new HDDType(HDDTypeEnum.SSD,500,800));
        computer.setMonitor(new MonitorType(23,MonitorTypeEnum.IPS,6000));
        computer.setKeyboard(new KeyboardType(KeyboardTypeEnum.MEMBRAN,true,1500));


        ProcessorType processorType1 = new ProcessorType(2.5,2,"Malasia",20);
        RAMType ramType1 = new RAMType(RAMTypeEnum.SDR,16,20);
        HDDType hddType1 = new HDDType(HDDTypeEnum.SSD,500,600);
        MonitorType monitorType1 = new MonitorType(25,MonitorTypeEnum.VA,6000);
        KeyboardType keyboardType1 = new KeyboardType(KeyboardTypeEnum.MEMBRAN,true,900);

        Computer computer1 = new Computer("AMD","B",processorType1 , ramType1 , hddType1, monitorType1,keyboardType1);
        System.out.println(computer);
        System.out.println(computer1);
        System.out.println("\nОбщий вес: " + (computer.getTotalWeight() + computer1.getTotalWeight()) );

    }
}
