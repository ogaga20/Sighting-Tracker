import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class BrowseScreen extends JPanel {
    private ApplicationFrame frame;
    private RecordContainer recordContainer;

    private JLabel screenTitle;
    private JLabel recordLabel;
    private JLabel recordSlashLabel;
    private JLabel dateLabel;
    private JLabel timeLabel;
    private JLabel cityLabel;
    private JLabel stateLabel;
    private JLabel latLabel;
    private JLabel lonLabel;
    private JLabel descriptionLabel;
    private JLabel corroborateLabel;

    private JTextField onWhichRecord;
    private JTextField outOfRecord;
    private JTextField dateField;
    private JTextField timeField;
    private JTextField cityField;
    private JTextField stateField;
    private JTextField latField;
    private JTextField lonField;
    private JTextArea descriptionArea;
    private JTextField corroborateField;

    private JButton backButton;
    private JButton nextButton;
    private JButton corroborateButton;
    private JButton returnButton;

    private int onWhichRecordNum;
    private int totalRecordNum;

    public BrowseScreen(ApplicationFrame f){
        totalRecordNum = 0;
        onWhichRecordNum = 0;
        frame = f;
        recordContainer = null;
        this.setPreferredSize(new Dimension(800, 600));
        this.setLayout(new FlowLayout());

        screenTitle = new JLabel("Search Results", SwingConstants.CENTER);
        screenTitle.setPreferredSize(new Dimension(800, 30));
        screenTitle.setFont(screenTitle.getFont().deriveFont(24.0F));

        recordLabel = new JLabel("Record: ", SwingConstants.LEFT);
            recordLabel.setPreferredSize(new Dimension(400, 10));
        onWhichRecord = new JTextField(5);
            onWhichRecord.setEditable(false);
        recordSlashLabel = new JLabel("/");
        outOfRecord = new JTextField(5);
            outOfRecord.setEditable(false);
            outOfRecord.setText(Integer.toString(totalRecordNum));
        dateLabel = new JLabel ("Date: ");
            dateLabel.setPreferredSize(new Dimension(400, 35));
        timeLabel = new JLabel ("Time: ");
            timeLabel.setPreferredSize(new Dimension(400, 35));
        cityLabel = new JLabel("City: ");
            cityLabel.setPreferredSize(new Dimension(400, 35));
        stateLabel = new JLabel("State: ");
            stateLabel.setPreferredSize(new Dimension(400, 35));
        latLabel = new JLabel("Latitude: ");
            latLabel.setPreferredSize(new Dimension(400, 35));
        lonLabel = new JLabel("Longitude: ");
            lonLabel.setPreferredSize(new Dimension(400, 35));
        descriptionLabel = new JLabel ("Description:");
            descriptionLabel.setPreferredSize(new Dimension(400, 35));
        corroborateLabel = new JLabel("Corroborated?");
            corroborateLabel.setPreferredSize(new Dimension(400, 35));

        dateField = new JTextField(20);
            dateField.setEditable(false);
        timeField = new JTextField(20);
            timeField.setEditable(false);
        cityField = new JTextField(20);
            cityField.setEditable(false);
        stateField = new JTextField(20);
            stateField.setEditable(false);
        latField = new JTextField(20);
            latField.setEditable(false);
        lonField = new JTextField(20);
            lonField.setEditable(false);
        descriptionArea = new JTextArea(10, 20);
            descriptionArea.setEditable(false);
        corroborateField = new JTextField(20);
            corroborateField.setEditable(false);

        backButton = new JButton("Previous Record");
            backButton.setPreferredSize(new Dimension(350, 40));
            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (onWhichRecordNum > 1){
                        onWhichRecord.setText(Integer.toString(--onWhichRecordNum));
                        dateField.setText(recordContainer.getRecordContainer().get(onWhichRecordNum - 1).getDate().toString());
                        timeField.setText(recordContainer.getRecordContainer().get(onWhichRecordNum - 1).getTime().toString());
                        cityField.setText(recordContainer.getRecordContainer().get(onWhichRecordNum - 1).getLocation().getCity());
                        stateField.setText(recordContainer.getRecordContainer().get(onWhichRecordNum - 1).getLocation().getState());
                        latField.setText(recordContainer.getRecordContainer().get(onWhichRecordNum - 1).getLocation().getLatitude());
                        lonField.setText(recordContainer.getRecordContainer().get(onWhichRecordNum - 1).getLocation().getLongitude());
                        descriptionArea.setText(recordContainer.getRecordContainer().get(onWhichRecordNum - 1).getDescription());
                        corroborateField.setText(String.valueOf(recordContainer.getRecordContainer().get(onWhichRecordNum - 1).isCorroborated()));
                    }
                }
            });
        nextButton = new JButton("Next Record");
            nextButton.setPreferredSize(new Dimension(350, 40));
            nextButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (onWhichRecordNum < totalRecordNum) {
                        onWhichRecord.setText(Integer.toString(++onWhichRecordNum));
                        dateField.setText(recordContainer.getRecordContainer().get(onWhichRecordNum - 1).getDate().toString());
                        timeField.setText(recordContainer.getRecordContainer().get(onWhichRecordNum - 1).getTime().toString());
                        cityField.setText(recordContainer.getRecordContainer().get(onWhichRecordNum - 1).getLocation().getCity());
                        stateField.setText(recordContainer.getRecordContainer().get(onWhichRecordNum - 1).getLocation().getState());
                        latField.setText(recordContainer.getRecordContainer().get(onWhichRecordNum - 1).getLocation().getLatitude());
                        lonField.setText(recordContainer.getRecordContainer().get(onWhichRecordNum - 1).getLocation().getLongitude());
                        descriptionArea.setText(recordContainer.getRecordContainer().get(onWhichRecordNum - 1).getDescription());
                        corroborateField.setText(String.valueOf(recordContainer.getRecordContainer().get(onWhichRecordNum - 1).isCorroborated()));
                    }
                }
            });

        corroborateButton = new JButton("Corroborate Sighting");
        corroborateButton.setPreferredSize(new Dimension(350, 40));
        corroborateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                corroborateField.setText(String.valueOf(true));
                recordContainer.getRecordContainer().get(onWhichRecordNum - 1).corroborate();
                try {
                    recordContainer.saveRecords();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        returnButton = new JButton("Return to Main Menu");
        returnButton.setPreferredSize(new Dimension(350, 40));
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame.getContentPane().removeAll();
                frame.getContentPane().add(frame.getMainMenuScreen());
                frame.pack();
                frame.revalidate();
                frame.repaint();
            }
        });

        this.add(screenTitle);
        this.add(recordLabel);
        this.add(onWhichRecord);
        this.add(recordSlashLabel);
        this.add(outOfRecord);
        this.add(dateLabel);
        this.add(dateField);
        this.add(timeLabel);
        this.add(timeField);
        this.add(cityLabel);
        this.add(cityField);
        this.add(stateLabel);
        this.add(stateField);
        this.add(latLabel);
        this.add(latField);
        this.add(lonLabel);
        this.add(lonField);
        this.add(descriptionLabel);
        this.add(descriptionArea);
        this.add(corroborateLabel);
        this.add(corroborateField);
        this.add(backButton);
        this.add(nextButton);
        this.add(corroborateButton);
        this.add(returnButton);

    }

    public void initialize_all_records(){
        if (recordContainer.getRecordContainer().size() > 0){
            totalRecordNum = recordContainer.getRecordContainer().size();
            onWhichRecordNum = 1;
            outOfRecord.setText(Integer.toString(totalRecordNum));
            onWhichRecord.setText(Integer.toString(onWhichRecordNum));
            dateField.setText(recordContainer.getRecordContainer().get(0).getDate().toString());
            timeField.setText(recordContainer.getRecordContainer().get(0).getTime().toString());
            cityField.setText(recordContainer.getRecordContainer().get(0).getLocation().getCity());
            stateField.setText(recordContainer.getRecordContainer().get(0).getLocation().getState());
            latField.setText(recordContainer.getRecordContainer().get(0).getLocation().getLatitude());
            lonField.setText(recordContainer.getRecordContainer().get(0).getLocation().getLongitude());
            descriptionArea.setText(recordContainer.getRecordContainer().get(0).getDescription());
            corroborateField.setText(String.valueOf(recordContainer.getRecordContainer().get(0).isCorroborated()));
        } else {
            outOfRecord.setText(Integer.toString(0));
            onWhichRecord.setText(Integer.toString(0));
            dateField.setText("");
            timeField.setText("");
            cityField.setText("");
            stateField.setText("");
            latField.setText("");
            lonField.setText("");
            descriptionArea.setText("");
            corroborateField.setText("");
        }
    }

    /*public void update(int newSize) {
        totalRecordNum = newSize;
        outOfRecord.setText(Integer.toString(totalRecordNum));
        if (onWhichRecordNum == 0) {
            onWhichRecordNum = 1;
            onWhichRecord.setText(Integer.toString(onWhichRecordNum));
            dateField.setText(recordContainer.getRecordContainer().get(0).getDate().toString());
            timeField.setText(recordContainer.getRecordContainer().get(0).getTime().toString());
            cityField.setText(recordContainer.getRecordContainer().get(0).getLocation().getCity());
            stateField.setText(recordContainer.getRecordContainer().get(0).getLocation().getState());
            latField.setText(recordContainer.getRecordContainer().get(0).getLocation().getLatitude());
            lonField.setText(recordContainer.getRecordContainer().get(0).getLocation().getLongitude());
            descriptionArea.setText(recordContainer.getRecordContainer().get(0).getDescription());
        }
    }*/

    public void setRecordContainer(RecordContainer container){
        this.recordContainer = container;
    }


}
