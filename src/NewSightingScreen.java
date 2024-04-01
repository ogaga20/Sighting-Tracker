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

    public NewSightingScreen(ApplicationFrame f, RecordContainer rc){
        frame = f;
        recordContainer = rc;
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(800, 600));


        screenTitle = new JLabel("Report a New Sighting", SwingConstants.CENTER);
            screenTitle.setPreferredSize(new Dimension(800, 45));

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
            submitButton.setPreferredSize(new Dimension(800, 45));
            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String dateFieldText = dateField.getText();
                    String timeFieldText = timeField.getText();
                    String cityFieldText = cityField.getText();
                    String stateFieldText = stateField.getText();
                    String latFieldText = latField.getText();
                    String lonFieldText = lonField.getText();
                    String descriptionAreaText = descriptionArea.getText();

                    //to get in the format the UFOSighting constructor expects
                    String locationText = latFieldText + " " + lonFieldText + " " + stateFieldText + " " + cityFieldText;

                    UFOSighting sighting = new UFOSighting(dateFieldText, timeFieldText, locationText, descriptionAreaText);
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

                    frame.getSearchScreen().update(recordContainer.getRecordContainer().size());

                    dateField.setText("");
                    timeField.setText("");
                    cityField.setText("");
                    stateField.setText("");
                    latField.setText("");
                    lonField.setText("");
                    descriptionArea.setText("");
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
}
