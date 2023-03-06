public class Test {
        public static int number_of_readers = 6;
        public static int number_of_writers = 5;
        public static void main(String args[]){
               ReadWriteLock r = new ReadWriteLock();
               Thread[] readerArray = new Thread[number_of_readers];
               Thread[] writerArray = new Thread[number_of_writers];
               for (int i = 1; i < number_of_readers; i++) {
                      readerArray[i] = new Thread(new Reader(i, r));
                      readerArray[i].start();
               }
               for (int i = 1; i < number_of_writers; i++) {
                      writerArray[i] = new Thread(new Writer(i, r));
                      writerArray[i].start();
               }
         }
}