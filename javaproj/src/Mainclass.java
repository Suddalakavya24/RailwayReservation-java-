class Mainclass{
    public static void main(String[] args) {
        Track track1=new Track("PlatformOne",ThreadColor.ANSI_GREEN);
        Thread train11=new Thread(new Train("TrainOne",track1));
        // naming convention for trains: Train#trackNumber#trainNumber
        Thread train12=new Thread(new Train("TrainTwo",track1));
        train11.start();
        train12.start();
        Track track2=new Track("PlatformTwo",ThreadColor.ANSI_RED);
        Thread train21=new Thread(new Train("TrainOne",track2));
        Thread train22=new Thread(new Train("TrainTwo",track2));
        train21.start();
        train22.start();
    }
} class Track {
    private String color;
    private String trackName;
    private boolean vacant=true;
    public Track(String trackName,String color){
        this.trackName=trackName;
        this.color=color;
    }
    public synchronized void arrive(String trainName){
        while(!vacant){
            try{
                wait();
            }catch(InterruptedException e){
                System.out.println(color+"On "+trackName+" problem occurred");
            }
        }
        vacant=false;
        System.out.println(color+"On "+trackName+" "+trainName+" arrived");
        //notifyAll();
    }
    public synchronized void halt(String trainName){
        System.out.println(color+"On "+trackName+" "+trainName+" halted");
    }
    public synchronized void depart(String trainName){
        while(vacant){
            try{
                wait();
            }catch (InterruptedException e){
                System.out.println(color+"On "+trackName+" problem occurred");
            }
        }
        vacant=true;
        System.out.println(color+"On "+trackName+" "+trainName+" departed");
        notify();
    }
}

class Train implements Runnable{
    private String trainName;
    private Track track;
    Train(String trainName, Track track){
        this.trainName=trainName;
        this.track=track;
    }
    public void run(){
        track.arrive(trainName);
        track.halt(trainName);
        track.depart(trainName);
    }
}

class ThreadColor {
    public static final String ANSI_RESET="\u001B[0m";
    public static final String ANSI_BLACK="\u001B[30m";
    public static final String ANSI_RED="\u001B[31m";
    public static final String ANSI_GREEN="\u001B[32m";
    public static final String ANSI_LIGHT_YELLOW = "\u001B[93m";
    public static final String ANSI_YELLOW = "\u001b[33m";
    public static final String ANSI_BLUE="\u001B[34m";
    public static final String ANSI_PURPLE="\u001B[35m";
    public static final String ANSI_CYAN="\u001B[36m";
    public static final String ANSI_WHITE="\u001B[37m";
}
