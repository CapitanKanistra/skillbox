import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Loader {

    public static PrintWriter writer;


    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(8);
        long start = System.currentTimeMillis();
        //+

        writer = new PrintWriter("D:\\CarNumberGenerator\\res\\numbers.txt");


        char letters[] = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};
        int regionCode = 199;


        service.submit(new NumberGenerator(regionCode));

        service.shutdown();


        System.out.println("Время выполнения несколькими потоками1 - " + (System.currentTimeMillis() - start) + " ms");
    }
}


/*        start = System.currentTimeMillis();


        StringBuilder builder = new StringBuilder();


            for (int number = 1; number < 1000; number++) {


                for (char firstLetter : letters) {
                    for (char secondLetter : letters) {
                        for (char thirdLetter : letters) {
                            builder.append(firstLetter);
                            builder.append(padNumber(number, 3));
                            builder.append(secondLetter);
                            builder.append(thirdLetter);
                            builder.append(padNumber(regionCode, 2));
                            builder.append("\n");
                        *//*String carNumber = firstLetter + padNumber(number, 3) +
                            secondLetter + thirdLetter + padNumber(regionCode, 2);*//*
 *//*                       writer.write(carNumber.getBytes());
                        writer.write('\n');*//*

                        }
                    }
                }
                writer.write(builder.toString().getBytes());



            }



            writer.flush();
            writer.close();
        System.out.println("Время выполнения одним потоком - " + (System.currentTimeMillis() - start) + " ms");


        }
        private static String padNumber( int number, int numberLength){
            String numberStr = Integer.toString(number);
            int padSize = numberLength - numberStr.length();
            for (int i = 0; i < padSize; i++) {
                numberStr = '0' + numberStr;
            }
            return numberStr;
        }

        private static StringBuilder padNumber1 ( int number, int numberLength){
            String numberStr = Integer.toString(number);
            int padSize = numberLength - numberStr.length();
            StringBuilder padNumbers = new StringBuilder();
            for (int i = 0; i < padSize; i++) {
                padNumbers.append("0");
            }
            padNumbers.append(numberStr);

            return padNumbers;
        }

    }*/



