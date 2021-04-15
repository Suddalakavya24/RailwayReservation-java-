class Tracks implements Runnable {
    Thread track;
    String trackname;
    Trains t1,t2;
    Tracks() {
        
    }

    Tracks(String trackname) {
        this.trackname = trackname;
        track = new Thread(this, trackname);
        track.start();
    }

    void runTrains() {
    	//if(trackname.contentEquals("one")||trackname.contentEquals("two"))
        new Trains(trackname+"-1");
    	//else if(trackname.contentEquals("One")||trackname.contentEquals("Two"))
        //new Trains(trackname+"-2");
    }

    void displayTrack() {
        System.out.println("On track : " + track.getName());
    }

   synchronized public void run() {
       
            try {
                displayTrack();
                track.sleep(1000);
                runTrains();
            } catch (InterruptedException e) {
                System.out.println("Something happend to track " + track.getName());
            }
          
        
        System.out.println("Exiting " + track.getName());
       for(int i=0;i<10;i++) {
        try {
			track.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        new Trains(trackname+"-"+(i+2));
       /* try {
			track.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        new Trains(trackname+"-3");
        }*/}}
    


class Trains extends Tracks implements Runnable {
    Thread train;

     Trains(String trainname) {
        train = new Thread(this, trainname);
        trackname = train.getName().substring(0, train.getName().length() - 2);
        train.start();
    }

    void arrive() {
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Train " + train.getName() + " on track " + trackname + " arrived");
       // alt();
    }

    void alt() {
        System.out.println("Train " + train.getName() + " on track " + trackname + " halted");
       // depart();
    }

    void depart() {
        System.out.println("Train " + train.getName()+ " on track " + trackname + " departed");
    }

   synchronized public void run() {
        try {
            arrive();
           train.sleep(2000);
            alt();
           train.sleep(2000);
            depart();
        } catch (InterruptedException e) {
            System.out.println("Something happend to train " + train.getName());
        }
        System.out.println("Exiting " + train.getName());
    }
}
}

public class RailwayThreads {
    public static void main(String args[]) {
        new Tracks("one");
        new Tracks("two");
        // new Tracks("three");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Main Thread Interrupted");
        }
       // new Tracks("One");
       // new Tracks("Two");
        System.out.println("Main Thread Exiting");
    }
}
