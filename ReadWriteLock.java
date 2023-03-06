import java.util.concurrent.Semaphore;
 class ReadWriteLock {
	
	private Semaphore S = new Semaphore (1);
	private Semaphore mutex = new Semaphore(1);
	private int readerCount = 0;
	
	
	
    public void readLock(int readerNumber) { 
        try{
             mutex.acquire();
        }
        catch (InterruptedException e) {}
        ++readerCount;
        if (readerCount == 1){
              try{
                   S.acquire();
              }
              catch (InterruptedException e) {}
         }
        System.out.println("Reader " + readerNumber + " is reading. Reader count is " + readerCount);
        mutex.release();
    }
     public void writeLock(int writer_number) {
         try{
              S.acquire();
         }
         catch (InterruptedException e) {}
         System.out.println("Writer " + writer_number + " is currently writing");
    }

     public void readUnLock(int reader_number) {
           try{
                mutex.acquire();
           }
           catch (InterruptedException e) {}
          --readerCount;
           if (readerCount == 0){
                S.release();
           }
           System.out.println("Reader " + reader_number + " finished reading. Reader count is " + readerCount);
           mutex.release();
      } 
   
     public void writeUnLock(int writerNumber) {
    	 System.out.println("Writer " + writerNumber + " finished writing");
         S.release();
    	 
    }
	
	
}