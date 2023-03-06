public class Sleep {
       public static void nap() {
             nap(NAP_DURATION);
       }
       public static void nap(int duration) {
             int sleeptime = (int) (NAP_DURATION * Math.random() );
             try { 
            	 Thread.sleep(sleeptime*1000); 
             } catch (InterruptedException e) {}
       }
       private static int NAP_DURATION = 5;
}
