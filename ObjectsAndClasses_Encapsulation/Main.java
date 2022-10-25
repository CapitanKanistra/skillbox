public class Main {
    public static void main(String[] args) {
        Curier curier = new Curier(new Dimensions(100,50,20),5,"sportivnaya 26",false,"A105",true);
        Curier curier1 = curier.setAddress("Lesnaya 50");
        System.out.println(curier.getAddress());
        System.out.println(curier1.getAddress());
        Curier curier2 = curier.setDimensions(new Dimensions(50,20,5));
        System.out.println(curier.getDimensions().getVolume());
        System.out.println(curier2.getDimensions().getVolume());
        Curier curier3 = curier.setMass(2);
        System.out.println(curier.getMass());
        System.out.println(curier3.getMass());

    }
}
