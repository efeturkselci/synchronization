public class Writer implements Runnable {
       private ReadWriteLock R;
       private int writer_number;
       public Writer(int wn, ReadWriteLock rwl) {
            writer_number = wn;
            R =rwl ;
       }
       public void run() {
            while (true){
                  Sleep.nap();
                  System.out.println("Writer " + writer_number + " wants to write");
                  R.writeLock(writer_number);
                  R.writeUnLock(writer_number);
             }
       }
}