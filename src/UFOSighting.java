public class UFOSighting {
        Date date;
        Time time;
        Location location;
        String description;

        //4 strings, date in xx/xx/xxxx, Time in xx:xx, Location in "Latitude Longitude State City"
        public UFOSighting(String date, String time, String location, String description) {
            this.date = new Date(date);
            this.time = new Time(time);
            String[] temp = location.split(" ");
            this.location = new Location(temp[0], temp[1], temp[2], temp[3]);
            this.description = description;
        }

        public UFOSighting(Date date, Time time, Location location, String description){
            this.date = date;
            this.time = time;
            this.location = location;
            this.description = description;
        }

        public UFOSighting(){
            date = null;
            time = null;
            location = null;
            description = null;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public Time getTime() {
            return time;
        }

        public void setTime(Time time) {
            this.time = time;
        }

        public Location getLocation() {
            return location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return date + " " + time + " " + location + " " + description;
        }
    }

