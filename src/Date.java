public class Date {
    private int month;
    private int day;
    private int year;

    public Date(){
        month = 0;
        day = 0;
        year = 0;
    }

    //Format is in the form xx/xx/xxxx ,which is month/day/year
    public Date(String format){
        format.trim();
        String[] splitDate = format.split("/");
        month = Integer.parseInt(splitDate[0]);
        day = Integer.parseInt(splitDate[1]);
        year = Integer.parseInt(splitDate[2]);
    }

    //A constructor that inputs 3 ints, month, day, and year in that order.
    public Date (int month, int day, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    //Returns a string of the more month/day/year
    public String toString(){
        return month + "/" + day + "/" + year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}