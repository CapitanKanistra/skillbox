import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        System.out.println(findPlanesLeavingInTheNextTwoHours(airport));




    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        final int TWO_HOURS = 7_200_000;
        return airport.getTerminals().stream()
                .map(Terminal::getFlights).peek(x -> System.out.println("Все рейсы: " + x + " ++ Все терминалы ++"))
                .flatMap(List::stream).peek(x -> System.out.println("Меняем формат: " + x))
                .filter(flight -> flight.getType() == Flight.Type.DEPARTURE
                        && flight.getDate().getTime() > System.currentTimeMillis()
                        && flight.getDate().getTime() < System.currentTimeMillis() + TWO_HOURS)
                .collect(Collectors.toList());
        //TODO Метод должден вернуть список рейсов вылетающих в ближайшие два часа.
    }

}