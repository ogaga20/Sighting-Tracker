import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class NewSightingScreen extends JPanel {
    private ApplicationFrame frame;
    private RecordContainer recordContainer;

    private JLabel screenTitle;
    private JLabel dateLabel;
    private JLabel timeLabel;
    private JLabel cityLabel;
    private JLabel stateLabel;
    private JLabel latLabel;
    private JLabel lonLabel;
    private JLabel descriptionLabel;

    private JTextField dateField;
    private JTextField timeField;
    private JTextField cityField;
    private JTextField stateField;
    private JTextField latField;
    private JTextField lonField;
    private JTextArea descriptionArea;

    private JButton submitButton;
    private JButton returnButton;

    private boolean isDateGood;
    private boolean isTimeGood;
    private boolean isLatGood;
    private boolean isLonGood;

    public NewSightingScreen(ApplicationFrame f, RecordContainer rc){
        isDateGood = false;
        isTimeGood = false;
        isLatGood = false;
        isLonGood = false;

        frame = f;
        recordContainer = rc;
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(800, 600));


        screenTitle = new JLabel("Report a New Sighting", SwingConstants.CENTER);
            screenTitle.setPreferredSize(new Dimension(800, 30));
            screenTitle.setFont(getFont().deriveFont(24.0F));

        dateLabel = new JLabel ("Date (xx/xx/xxxx): ");
            dateLabel.setPreferredSize(new Dimension(400, 45));
        timeLabel = new JLabel ("Time (xx:xx): ");
            timeLabel.setPreferredSize(new Dimension(400, 45));
        cityLabel = new JLabel("City: ");
            cityLabel.setPreferredSize(new Dimension(400, 45));
        stateLabel = new JLabel("State: ");
            stateLabel.setPreferredSize(new Dimension(400, 45));
        latLabel = new JLabel("Latitude (##.#####): ");
            latLabel.setPreferredSize(new Dimension(400, 45));
        lonLabel = new JLabel("Longitude (##.#####): ");
            lonLabel.setPreferredSize(new Dimension(400, 45));
        descriptionLabel = new JLabel ("Description:");
            descriptionLabel.setPreferredSize(new Dimension(400, 45));

        dateField = new JTextField(20);
        timeField = new JTextField(20);
        cityField = new JTextField(20);
        stateField = new JTextField(20);
        latField = new JTextField(20);
        lonField = new JTextField(20);
        descriptionArea = new JTextArea(10, 20);

        submitButton = new JButton("Submit");
            submitButton.setPreferredSize(new Dimension(400, 45));
            submitButton.setBackground(Color.GREEN);
            submitButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String dateFieldText = dateField.getText();
                    String timeFieldText = timeField.getText();
                    String latFieldText = latField.getText();
                    String lonFieldText = lonField.getText();

                    if (confirmSubmission(dateFieldText, timeFieldText, latFieldText, lonFieldText)) {
                        String cityFieldText = cityField.getText();
                        String stateFieldText = stateField.getText();
                        String descriptionAreaText = descriptionArea.getText();

                        //to get in the format the UFOSighting constructor expects
                        String locationText = latFieldText + " " + lonFieldText + " " + stateFieldText + " " + cityFieldText;

                        boolean isCorroborated = false;
                        UFOSighting sighting = new UFOSighting(dateFieldText, timeFieldText, locationText, descriptionAreaText, isCorroborated);
                        recordContainer.addRecord(sighting);

                        try {
                            recordContainer.saveRecords();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }

                        try {
                            recordContainer.getRecordContainer().clear();
                            recordContainer.loadRecords();
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }

                        dateField.setText("");
                        timeField.setText("");
                        cityField.setText("");
                        stateField.setText("");
                        latField.setText("");
                        lonField.setText("");
                        descriptionArea.setText("");
                    }
                }
            });

            returnButton = new JButton("Return to Main Menu");
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
        this.add(submitButton);
        this.add(returnButton);



    }

    /*private void resetFieldCheck() {
        isDateGood = false;
        isTimeGood = false;
        isLatGood = false;
        isLonGood = false;
    }*/

    private boolean checkDate(String date) {
        boolean answer = true;

        char c[] = new char[date.length()];
        if (date.length() != 10) {
            answer = false;
        } else {
            for (int i = 0; i < date.length(); i++) {
                c[i] = date.charAt(i);
            }
            if (!Character.isDigit(c[0]) || !Character.isDigit(c[1]) ||
                    !Character.isDigit(c[3]) || !Character.isDigit(c[4]) ||
                    !Character.isDigit(c[6]) || !Character.isDigit(c[7]) ||
                    !Character.isDigit(c[8]) || !Character.isDigit(c[9])) {
                answer = false;
            }

            if (c[2] != '/' || c[5] != '/') {
                answer = false;
            }
        }
        return answer;
    }

    private boolean checkTime(String time) {
        boolean answer = true;

        char c[] = new char[time.length()];
        if (time.length() != 5) {
            answer = false;
        } else {
            for (int i = 0; i < time.length(); i++) {
                c[i] = time.charAt(i);
            }
            if (!Character.isDigit(c[0]) || !Character.isDigit(c[1]) ||
                    !Character.isDigit(c[3]) || !Character.isDigit(c[4])) {
                answer = false;
            }

            if (c[2] != ':') {
                answer = false;
            }
        }
        return answer;
    }

    private boolean checkCoord(String coord){
        boolean answer = true;

        char c[] = new char[coord.length()];
        if (coord.length() != 8) {
            answer = false;
        } else {
            for (int i = 0; i < coord.length(); i++) {
                c[i] = coord.charAt(i);
            }
            if (!Character.isDigit(c[0]) || !Character.isDigit(c[1]) ||
                    !Character.isDigit(c[3]) || !Character.isDigit(c[4]) ||
                    !Character.isDigit(c[5]) || !Character.isDigit(c[6]) ||
                    !Character.isDigit(c[7])) {
                answer = false;
            }

            if (c[2] != '.') {
                answer = false;
            }
        }
        return answer;
    }

    private boolean confirmSubmission(String date, String time, String lat, String lon){
        boolean answer = true;

        isDateGood = checkDate(date);
        isTimeGood = checkTime(time);
        isLatGood = checkCoord(lat);
        isLonGood = checkCoord(lon);

        if (!isDateGood){
            this.dateField.setText("CHECK FORMAT");
            answer = false;
        }
        if (!isTimeGood){
            this.timeField.setText("CHECK FORMAT");
            answer = false;
        }
        if (!isLatGood){
            this.latField.setText("CHECK FORMAT");
            answer = false;
        }
        if (!isLonGood){
            this.lonField.setText("CHECK FORMAT");
            answer = false;
        }
        return answer;
    }
}
