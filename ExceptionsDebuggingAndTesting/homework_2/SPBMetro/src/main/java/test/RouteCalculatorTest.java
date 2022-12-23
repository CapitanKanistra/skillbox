import core.Line;
import core.Station;
import junit.framework.TestCase;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RouteCalculatorTest extends TestCase
{
    List<Station> lineDirect;
    List<Station> lineWithOneChange;
    List<Station> lineWithTwoChange;
    StationIndex stationIndex;
    RouteCalculator calculator;

    Station per;
    Station vtor;
    Station tre;
    Station chet;

    @Override
    public void setUp() throws Exception
    {
        stationIndex = new StationIndex();

        Line line1 = new Line(1, "Красная");
        Line line2 = new Line(2, "Желтая");
        Line line3 = new Line(3, "Зеленая");

        per = new Station("Первая", line1);
        vtor = new Station("Вторая", line1);//2.5
        Station zvetnoiBulvar = new Station("Цветной бульвар", line2);//3.5
        tre = new Station("Третья", line2);//2.5
        Station sretenskiiBulvar= new Station("Сретенский бульвар", line2);//3.5
        chet= new Station("Четвертая", line3);//2.5 14.5


        Stream.of(line1, line2, line3).forEach(stationIndex::addLine);
        Stream.of(per, vtor,zvetnoiBulvar,tre, sretenskiiBulvar, chet)
                .peek(s -> s.getLine().addStation(s)).forEach(stationIndex :: addStation);
        stationIndex.addConnection(Stream.of(zvetnoiBulvar, sretenskiiBulvar).collect(Collectors.toList()));
        stationIndex.getConnectedStations(zvetnoiBulvar);
        stationIndex.getConnectedStations(sretenskiiBulvar);

        calculator = new RouteCalculator(stationIndex);

        lineDirect = Stream.of(per, vtor).collect(Collectors.toList());
        lineWithOneChange = Stream.of(per,vtor,zvetnoiBulvar,tre).collect(Collectors.toList());
        lineWithTwoChange= Stream.of(per,vtor,zvetnoiBulvar,tre,sretenskiiBulvar,chet).collect(Collectors.toList());

    }

    public void testCalculateDuration()
    {
        double actual = RouteCalculator.calculateDuration(lineWithTwoChange);
        double expected = 14.5;
        assertEquals(expected, actual);
    }

    public void testGetShortestRoute() {

        List<Station> actualLineDirect = calculator.getShortestRoute(per,vtor);
        List<Station> actualLineWithOneChange = calculator.getShortestRoute(per,tre);
        List<Station> actualLineWithTwoChange = calculator.getShortestRoute(per,chet);

        List<Station> expectedLineDirect = lineDirect;
        List<Station> expectedLineWithOneChange = lineWithOneChange;
        List<Station> expectedLineWithTwoChange = lineWithTwoChange;

        assertEquals(actualLineDirect, expectedLineDirect);
        assertEquals(actualLineWithOneChange, expectedLineWithOneChange);
        assertEquals(actualLineWithTwoChange, expectedLineWithTwoChange);
    }

    @Override
    public void tearDown() throws Exception
    {
        super.tearDown();
    }
}