import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchScreen extends JPanel {
    private ApplicationFrame frame;
    private RecordContainer recordContainer;
    private JTabbedPane tabbedPane;
    private JPanel browsingPanel;
    private JPanel searchPanel;

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

    private JTextField onWhichRecord;
    private JTextField outOfRecord;
    private JTextField dateField;
    private JTextField timeField;
    private JTextField cityField;
    private JTextField stateField;
    private JTextField latField;
    private JTextField lonField;
    private JTextArea descriptionArea;

    private JButton backButton;
    private JButton nextButton;
    private JButton returnButton;

    private int onWhichRecordNum;
    private int totalRecordNum;

    public SearchScreen(ApplicationFrame f, RecordContainer rc){
        totalRecordNum = 0;
        onWhichRecordNum = 0;
        frame = f;
        recordContainer = rc;
        this.setPreferredSize(new Dimension(800, 600));
        this.setLayout(new GridLayout(1, 1));
        browsingPanel = new JPanel();
        searchPanel = new JPanel();

        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Browse Sightings", browsingPanel);
        tabbedPane.addTab("Search Sightings", searchPanel);
        tabbedPane.setTabPlacement(SwingConstants.TOP);

        this.add(tabbedPane);

        browsingPanel.setLayout(new FlowLayout());

        screenTitle = new JLabel("Browse Sightings", SwingConstants.CENTER);
        screenTitle.setPreferredSize(new Dimension(800, 20));

        recordLabel = new JLabel("Record #: ", SwingConstants.LEFT);
            recordLabel.setPreferredSize(new Dimension(400, 10));
        onWhichRecord = new JTextField(5);
            onWhichRecord.setEditable(false);
        recordSlashLabel = new JLabel("/");
        outOfRecord = new JTextField(5);
            outOfRecord.setEditable(false);
            outOfRecord.setText(Integer.toString(totalRecordNum));
        dateLabel = new JLabel ("Date: ");
            dateLabel.setPreferredSize(new Dimension(400, 40));
        timeLabel = new JLabel ("Time: ");
            timeLabel.setPreferredSize(new Dimension(400, 40));
        cityLabel = new JLabel("City: ");
            cityLabel.setPreferredSize(new Dimension(400, 40));
        stateLabel = new JLabel("State: ");
            stateLabel.setPreferredSize(new Dimension(400, 40));
        latLabel = new JLabel("Latitude: ");
            latLabel.setPreferredSize(new Dimension(400, 40));
        lonLabel = new JLabel("Longitude: ");
            lonLabel.setPreferredSize(new Dimension(400, 40));
        descriptionLabel = new JLabel ("Description:");
            descriptionLabel.setPreferredSize(new Dimension(400, 40));

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

        browsingPanel.add(screenTitle);
        browsingPanel.add(recordLabel);
        browsingPanel.add(onWhichRecord);
        browsingPanel.add(recordSlashLabel);
        browsingPanel.add(outOfRecord);
        browsingPanel.add(dateLabel);
        browsingPanel.add(dateField);
        browsingPanel.add(timeLabel);
        browsingPanel.add(timeField);
        browsingPanel.add(cityLabel);
        browsingPanel.add(cityField);
        browsingPanel.add(stateLabel);
        browsingPanel.add(stateField);
        browsingPanel.add(latLabel);
        browsingPanel.add(latField);
        browsingPanel.add(lonLabel);
        browsingPanel.add(lonField);
        browsingPanel.add(descriptionLabel);
        browsingPanel.add(descriptionArea);
        browsingPanel.add(backButton);
        browsingPanel.add(nextButton);
        browsingPanel.add(returnButton);

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
        } else {
            outOfRecord.setText(Integer.toString(0));
        }
    }

    public void update(int newSize) {
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
    }
}
