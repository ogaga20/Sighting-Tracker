import java.io.*;
import java.util.ArrayList;

public class RecordContainer {
    private ArrayList<UFOSighting> recordContainer;

    public RecordContainer(){
        this.recordContainer = new ArrayList<UFOSighting>();
    }

    public void addRecord(UFOSighting sighting){
        this.recordContainer.add(sighting);
    }

    //the method that saves the records to a file
    public void saveRecords() throws IOException {
        File recordsFile = new File("records");
        recordsFile.createNewFile();

        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(recordsFile)));
        for (int i = 0; i < recordContainer.size(); i++){
            out.writeUTF(recordContainer.get(i).getDate().toString());
            out.writeUTF(recordContainer.get(i).getTime().toString());
            out.writeUTF(recordContainer.get(i).getLocation().toString());
            out.writeUTF(recordContainer.get(i).getDescription());
            out.writeBoolean(recordContainer.get(i).isCorroborated());
        }
        out.close();
    }

    //the method that loads the records from a file
    public void loadRecords() throws IOException {

        String fileWithRecords = "records";

        File file = new File(fileWithRecords);

        if (file.exists()) {

            DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(fileWithRecords)));

            String date;
            String time;
            String location;
            String description;
            boolean isCorroborated;


            try {
                while (true) {
                    date = in.readUTF();
                    time = in.readUTF();
                    location = in.readUTF();
                    description = in.readUTF();
                    isCorroborated = in.readBoolean();
                    UFOSighting sighting = new UFOSighting(date, time, location, description, isCorroborated);
                    recordContainer.add(sighting);
                }
            } catch (EOFException e) {

            } catch (IOException e) {
                e.printStackTrace();
            }
            in.close();
        } else {
            return;
        }
    }

    public ArrayList<UFOSighting> getRecordContainer(){
        return this.recordContainer;
    }
}
