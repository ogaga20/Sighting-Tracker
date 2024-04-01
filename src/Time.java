public class Time {
    private int min;
    private int hour;

    //A constructor that inputs 2 ints, hour and minute in that order.
    public Time(int min, int hour) {
        this.min = min;
        this.hour = hour;
    }

    public Time(){
        min = 0;
        hour = 0;
    }

    //This is in the form of xx:xx which is hour:min in military time
    public Time(String format){
        format.trim();
        String[] splitTime = format.split(":");
        hour = Integer.parseInt(splitTime[0]);
        min = Integer.parseInt(splitTime[1]);
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    @Override
    //Returns a string in the format hour:min
    public String toString() {
        return hour + ":" + min;
    }
}