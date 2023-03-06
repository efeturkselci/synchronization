public class Reader implements Runnable {
      private ReadWriteLock rwl; 
      private int reader_number;
      public Reader(int reader_num, ReadWriteLock rwl) {
           this.reader_number = reader_num;
           this.rwl = rwl;
      }
      public void run() {
           while (true) {
                 Sleep.nap();
                 System.out.println("Reader " + reader_number + " wants to read");
                 rwl.readLock(reader_number);
                 Sleep.nap();
                 rwl.readUnLock(reader_number);
                 
           }
      }
}