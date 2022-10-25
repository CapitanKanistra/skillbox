package Encapsulation2;

public class Curier {
    private final Dimensions dimensions;
    private final int mass;
    private final String address;
    private final boolean turnOver;
    private final String registeredNumber;
    private final boolean isFragile;



    public Curier(Dimensions dimensions, int mass, String address, boolean turnOver, String registeredNumber, boolean isFragile) {
        this.dimensions = dimensions ;
        this.mass = mass;
        this.address = address;
        this.turnOver = turnOver;
        this.registeredNumber = registeredNumber;
        this.isFragile = isFragile;
    }
    public Curier setAddress(String address) {
        return new Curier(dimensions,  mass, address, turnOver, registeredNumber, isFragile);
    }
    public Curier setDimensions(Dimensions dimensions) {
        return new Curier(dimensions, mass, address, turnOver, registeredNumber, isFragile);
    }
    public Curier setMass(int mass) {
        return new Curier(dimensions, mass, address, turnOver, registeredNumber, isFragile);
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public String getAddress() {
        return address;
    }

    public int getMass() {
        return mass;
    }
}


