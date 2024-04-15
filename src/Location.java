import java.text.DecimalFormat;
import java.text.NumberFormat;

    public class Location {
        private double latitude;
        private double longitude;
        private String state;
        private String city;

        public Location(double latitude, double longitude, String state, String city) {
            this.latitude = latitude;
            this.longitude = longitude;
            this.state = state;
            this.city = city;
        }

        public Location(){
            latitude = 0;
            longitude = 0;
            state = null;
            city = null;
        }

        public Location(String latitude, String longitude, String state, String city) {
            this.latitude = Double.parseDouble(latitude);
            this.longitude = Double.parseDouble(longitude);
            this.state = state;
            this.city = city;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public double getDoubleLong(){
            return longitude;
        }

        //Returns a String of Longitude
        public String getLongitude() {
            NumberFormat formatter = new DecimalFormat("##0.######");
            String lon = formatter.format(longitude);
            return lon;
        }

        public double getDoubleLat(){
            return latitude;
        }

        //Returns a String of Latitude
        public String getLatitude() {
            NumberFormat formatter = new DecimalFormat("#0.######");
            String lat = formatter.format(latitude);
            return lat;
        }

        //Returns a string in the format of "Latitude Longitude State City"
        @Override
        public String toString() {
            NumberFormat formatter = new DecimalFormat("#0.######");
            String lat = formatter.format(latitude);
            formatter = new DecimalFormat("##0.######");
            String lon = formatter.format(longitude);

            return lat + " " + lon + " " + state + " " + city;
        }

        public double compareLatitude(double lat) {

            if(this.latitude == lat)
            {
                return 0;
            }

            double result = this.latitude - lat;
            return result;
        }

        public double compareLongitude(double lon){

            if(this.longitude == lon)
            {
                return 0;
            }

            double result = this.longitude - lon;
            return result;
        }
    }
