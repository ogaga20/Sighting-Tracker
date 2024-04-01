public class Record {
    private String date;
    private String time;
    private String location;
    private String description;

    public Record(String d, String t, String l, String des){
        date = d;
        time = t;
        location = l;
        description = des;
    }

    public String getDate(){
        return this.date;
    }

    public String getTime(){
        return this.time;
    }

    public String getLocation(){
        return this.location;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDate(String s){
        this.date = s;
    }

    public void setTime(String s){
        this.time = s;
    }

    public void setLocation(String s){
        this.location = s;
    }

    public void setDescription(String s){
        this.description = s;
    }
}
