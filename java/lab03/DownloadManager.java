class DownloadTask extends Thread
{
    String file; int size;

    DownloadTask(String file, int size)
    {
        this.file = file;
        this.size = size;
    }   

    public void run()
    {
        int i = 0, step = 10;
        while(true)
        {
            System.out.println("Downloading file " + file + ": " + i + "% complete");
            if(i == 100) break;
            i += step;
            if(i > 100) {i = 100; continue;}

            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException e)
            {
                System.out.println("Thread was interrupted");
            }
        }
    }
}

class DownloadManager
{
    public static void main(String []args)
    {
        DownloadTask th1 = new DownloadTask("Happy Farm", 120);
        DownloadTask th2 = new DownloadTask("The Grokking Algorithms", 100);
        DownloadTask th3 = new DownloadTask("My Diggy Dog", 80);
        
        th1.start();
        th2.start();
        th3.start();
    }
}