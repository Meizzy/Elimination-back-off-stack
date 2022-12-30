interface Benchmarkable{
    void startTimer();
    void increaseRelapsedTime();
}

class Benchmark implements Benchmarkable{
   private double start = System.currentTimeMillis();
   double timeElapsed = 0;

   public void startTimer(){
        start = System.currentTimeMillis();
   }
   public void increaseRelapsedTime(){
        timeElapsed = (System.currentTimeMillis() - start - 1000) * 1000;
        System.out.println(timeElapsed);
   }
}