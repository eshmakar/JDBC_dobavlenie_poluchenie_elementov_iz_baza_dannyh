public class Main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        GettingCars.showCars();
        long stop = System.currentTimeMillis();
        System.out.println((stop-start)/1000.);
    }


}
