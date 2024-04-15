import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchScreen extends JPanel {
    private ApplicationFrame frame;
    private RecordContainer container;
    private BrowseScreen browseScreen;

    private JLabel screenTitle;
    private GridBagConstraints screenTitleConstraints;

    private JLabel fromDateLabel;
    private GridBagConstraints fromDateLabelConstraints;
    private JTextField fromDateField;
    private GridBagConstraints fromDateFieldConstraints;

    private JLabel toDateLabel;
    private GridBagConstraints toDateLabelConstraints;
    private JTextField toDateField;
    private GridBagConstraints toDateFieldConstraints;

    private JLabel fromLatLabel;
    private GridBagConstraints fromLatLabelConstraints;
    private JTextField fromLatField;
    private GridBagConstraints fromLatFieldConstraints;
    private JLabel toLatLabel;
    private GridBagConstraints toLatLabelConstraints;
    private JTextField toLatField;
    private GridBagConstraints toLatFieldConstraints;

    private JLabel fromLonLabel;
    private GridBagConstraints fromLonLabelConstraints;
    private JTextField fromLonField;
    private GridBagConstraints fromLonFieldConstraints;
    private JLabel toLonLabel;
    private GridBagConstraints toLonLabelConstraints;
    private JTextField toLonField;
    private GridBagConstraints toLonFieldConstraints;

    private JButton searchButton;
    private GridBagConstraints searchButtonConstraints;

    private JButton returnButton;
    private GridBagConstraints returnButtonConstraints;

    private Dimension preferredScreenSize;
    private Dimension preferredComponentSize;
    private int rightBorder;
    private int leftBorder;
    private int bottomBorder;
    private int internalPaddingX;
    private int internalPaddingY;

    public SearchScreen(ApplicationFrame f, RecordContainer c, BrowseScreen bs){
        frame = f;
        container = c;
        browseScreen = bs;

        //total size of the panel
        preferredScreenSize = new Dimension(800, 600);

        //the sizes of the borders around the edge of the display panel
        rightBorder = 50;
        leftBorder = 50;
        bottomBorder = 50;

        //this "internal padding" essentially makes the component smaller in a GridBagLayout
        internalPaddingX = 100;
        internalPaddingY = 20;
        this.setBorder(BorderFactory.createEmptyBorder(0, leftBorder, bottomBorder, rightBorder));
        this.setPreferredSize(preferredScreenSize);
        this.setLayout(new GridBagLayout());
        this.setOpaque(true);

        preferredComponentSize = new Dimension(((preferredScreenSize.width - rightBorder - leftBorder) /4 - internalPaddingX * 2),
                (preferredScreenSize.height - bottomBorder) / 4 - internalPaddingY * 2);

        //screen title - just displays the title of the screen at the top
        screenTitle = new JLabel("Search for Sightings");
        screenTitle.setFont(screenTitle.getFont().deriveFont(24.0F));
        screenTitle.setHorizontalAlignment(SwingConstants.CENTER);
        screenTitle.setPreferredSize(preferredComponentSize);
        screenTitleConstraints= new GridBagConstraints();
        screenTitleConstraints.gridwidth = 4; //allows the component to span multiple cells
        screenTitleConstraints.gridx = 0;
        screenTitleConstraints.gridy = 0;
        screenTitleConstraints.weightx = 1.0;
        screenTitleConstraints.weighty = 1.0;
        screenTitleConstraints.ipadx = internalPaddingX;
        screenTitleConstraints.ipady = internalPaddingY;
        screenTitle.setHorizontalAlignment(SwingConstants.CENTER);


        fromDateLabel = new JLabel("Date - From: (xx/xx/xxxx)");
        fromDateLabel.setPreferredSize(preferredComponentSize);
        fromDateLabelConstraints = new GridBagConstraints();
        fromDateLabelConstraints.gridx = 0;
        fromDateLabelConstraints.gridy = 1;
        fromDateLabelConstraints.weightx = 1.0;
        fromDateLabelConstraints.weighty = 1.0;
        fromDateLabelConstraints.ipadx = internalPaddingX;
        fromDateLabelConstraints.ipady = internalPaddingY;
        fromDateLabelConstraints.anchor = GridBagConstraints.WEST;

        fromDateField = new JTextField(20);
        fromDateField.setPreferredSize(preferredComponentSize);
        fromDateFieldConstraints = new GridBagConstraints();
        fromDateFieldConstraints.gridx = 1;
        fromDateFieldConstraints.gridy = 1;
        fromDateFieldConstraints.weightx = 1.0;
        fromDateFieldConstraints.weighty = 1.0;
        fromDateFieldConstraints.ipadx = internalPaddingX;
        fromDateFieldConstraints.ipady = internalPaddingY;

        toDateLabel = new JLabel("To: ");
        toDateLabel.setPreferredSize(preferredComponentSize);
        toDateLabelConstraints = new GridBagConstraints();
        toDateLabelConstraints.gridx = 2;
        toDateLabelConstraints.gridy = 1;
        toDateLabelConstraints.weightx = 1.0;
        toDateLabelConstraints.weighty = 1.0;
        toDateLabelConstraints.ipadx = internalPaddingX;
        toDateLabelConstraints.ipady = internalPaddingY;

        toDateField = new JTextField(20);
        toDateField.setPreferredSize(preferredComponentSize);
        toDateFieldConstraints = new GridBagConstraints();
        toDateFieldConstraints.gridx = 3;
        toDateFieldConstraints.gridy = 1;
        toDateFieldConstraints.weightx = 1.0;
        toDateFieldConstraints.weighty = 1.0;
        toDateFieldConstraints.ipadx = internalPaddingX;
        toDateFieldConstraints.ipady = internalPaddingY;

        fromLatLabel = new JLabel("Latitude - From: (##.#####)");
        fromLatLabel.setPreferredSize(preferredComponentSize);
        fromLatLabelConstraints = new GridBagConstraints();
        fromLatLabelConstraints.gridx = 0;
        fromLatLabelConstraints.gridy = 2;
        fromLatLabelConstraints.weightx = 1.0;
        fromLatLabelConstraints.weighty = 1.0;
        fromLatLabelConstraints.ipadx = internalPaddingX;
        fromLatLabelConstraints.ipady = internalPaddingY;
        fromLatLabelConstraints.anchor = GridBagConstraints.WEST;

        fromLatField = new JTextField(20);
        fromLatField.setPreferredSize(preferredComponentSize);
        fromLatFieldConstraints = new GridBagConstraints();
        fromLatFieldConstraints.gridx = 1;
        fromLatFieldConstraints.gridy = 2;
        fromLatFieldConstraints.weightx = 1.0;
        fromLatFieldConstraints.weighty = 1.0;
        fromLatFieldConstraints.ipadx = internalPaddingX;
        fromLatFieldConstraints.ipady = internalPaddingY;

        toLatLabel = new JLabel("To: ");
        toLatLabel.setPreferredSize(preferredComponentSize);
        toLatLabelConstraints = new GridBagConstraints();
        toLatLabelConstraints.gridx = 2;
        toLatLabelConstraints.gridy = 2;
        toLatLabelConstraints.weightx = 1.0;
        toLatLabelConstraints.weighty = 1.0;
        toLatLabelConstraints.ipadx = internalPaddingX;
        toLatLabelConstraints.ipady = internalPaddingY;

        toLatField = new JTextField(20);
        toLatField.setPreferredSize(preferredComponentSize);
        toLatFieldConstraints = new GridBagConstraints();
        toLatFieldConstraints.gridx = 3;
        toLatFieldConstraints.gridy = 2;
        toLatFieldConstraints.weightx = 1.0;
        toLatFieldConstraints.weighty = 1.0;
        toLatFieldConstraints.ipadx = internalPaddingX;
        toLatFieldConstraints.ipady = internalPaddingY;

        fromLonLabel = new JLabel("Longitude - From: (##.#####)");
        fromLonLabel.setPreferredSize(preferredComponentSize);
        fromLonLabelConstraints = new GridBagConstraints();
        fromLonLabelConstraints.gridx = 0;
        fromLonLabelConstraints.gridy = 3;
        fromLonLabelConstraints.weightx = 1.0;
        fromLonLabelConstraints.weighty = 1.0;
        fromLonLabelConstraints.ipadx = internalPaddingX;
        fromLonLabelConstraints.ipady = internalPaddingY;
        fromLonLabelConstraints.anchor = GridBagConstraints.WEST;

        fromLonField = new JTextField(20);
        fromLonField.setPreferredSize(preferredComponentSize);
        fromLonFieldConstraints = new GridBagConstraints();
        fromLonFieldConstraints.gridx = 1;
        fromLonFieldConstraints.gridy = 3;
        fromLonFieldConstraints.weightx = 1.0;
        fromLonFieldConstraints.weighty = 1.0;
        fromLonFieldConstraints.ipadx = internalPaddingX;
        fromLonFieldConstraints.ipady = internalPaddingY;

        toLonLabel = new JLabel("To: ");
        toLonLabel.setPreferredSize(preferredComponentSize);
        toLonLabelConstraints = new GridBagConstraints();
        toLonLabelConstraints.gridx = 2;
        toLonLabelConstraints.gridy = 3;
        toLonLabelConstraints.weightx = 1.0;
        toLonLabelConstraints.weighty = 1.0;
        toLonLabelConstraints.ipadx = internalPaddingX;
        toLonLabelConstraints.ipady = internalPaddingY;

        toLonField = new JTextField(20);
        toLonField.setPreferredSize(preferredComponentSize);
        toLonFieldConstraints = new GridBagConstraints();
        toLonFieldConstraints.gridx = 3;
        toLonFieldConstraints.gridy = 3;
        toLonFieldConstraints.weightx = 1.0;
        toLonFieldConstraints.weighty = 1.0;
        toLonFieldConstraints.ipadx = internalPaddingX;
        toLonFieldConstraints.ipady = internalPaddingY;

        searchButton = new JButton("Search");
        searchButton.setPreferredSize(preferredComponentSize);
        searchButton.setBackground(Color.GREEN);
        searchButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        searchButtonConstraints= new GridBagConstraints();
        searchButtonConstraints.gridwidth = 4; //allows the component to span multiple cells
        searchButtonConstraints.gridx = 0;
        searchButtonConstraints.gridy = 4;
        searchButtonConstraints.weightx = 1.0;
        searchButtonConstraints.weighty = 1.0;
        searchButtonConstraints.ipadx = internalPaddingX;
        searchButtonConstraints.ipady = internalPaddingY;
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date startDate;
                if (fromDateField.getText().equals("")){
                    startDate = new Date("00/00/0000");
                } else {
                    startDate = new Date(fromDateField.getText());
                }

                Date endDate;
                if (toDateField.getText().equals("")){
                    endDate = new Date("99/99/9999");
                } else {
                    endDate = new Date(toDateField.getText());
                }

                double startLat;

                if (fromLatField.getText().equals("")){
                    startLat = 0;
                } else {
                    startLat = Double.parseDouble(fromLatField.getText());
                }

                double endLat;

                if (toLatField.getText().equals("")){
                    endLat = 100000;
                } else {
                    endLat = Double.parseDouble(toLatField.getText());
                }

                double startLon;

                if (fromLonField.getText().equals("")){
                    startLon = 0;
                } else {
                    startLon = Double.parseDouble(fromLonField.getText());
                }

                double endLon;

                if (toLonField.getText().equals("")){
                    endLon = 100000;
                } else {
                    endLon = Double.parseDouble(toLonField.getText());
                }

                RecordContainer searchResults = searchContainer(startDate, endDate, startLat, endLat, startLon, endLon);
                browseScreen.setRecordContainer(searchResults);
                browseScreen.initialize_all_records();

                frame.getContentPane().removeAll();
                frame.getContentPane().add(browseScreen);
                frame.pack();
                frame.revalidate();
                frame.repaint();
            }
        });

        returnButton = new JButton("Return to Main Menu");
        returnButton.setPreferredSize(preferredComponentSize);
        returnButtonConstraints= new GridBagConstraints();
        returnButtonConstraints.gridwidth = 4; //allows the component to span multiple cells
        returnButtonConstraints.gridx = 0;
        returnButtonConstraints.gridy = 5;
        returnButtonConstraints.weightx = 1.0;
        returnButtonConstraints.weighty = 1.0;
        returnButtonConstraints.ipadx = internalPaddingX;
        returnButtonConstraints.ipady = internalPaddingY;
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

        this.add(screenTitle, screenTitleConstraints);
        this.add(fromDateLabel, fromDateLabelConstraints);
        this.add(fromDateField, fromDateFieldConstraints);
        this.add(toDateLabel, toDateLabelConstraints);
        this.add(toDateField, toDateFieldConstraints);
        this.add(fromLatLabel, fromLatLabelConstraints);
        this.add(fromLatField, fromLatFieldConstraints);
        this.add(toLatLabel, toLatLabelConstraints);
        this.add(toLatField, toLatFieldConstraints);
        this.add(fromLonLabel, fromLonLabelConstraints);
        this.add(fromLonField, fromLonFieldConstraints);
        this.add(toLonLabel, toLonLabelConstraints);
        this.add(toLonField, toLonFieldConstraints);
        this.add(searchButton, searchButtonConstraints);
        this.add(returnButton, returnButtonConstraints);
    }

    private RecordContainer searchContainer(Date dateStart, Date dateEnd, double latStart, double latEnd, double lonStart, double lonEnd){
        RecordContainer rc = new RecordContainer();

        for (int i = 0; i < container.getRecordContainer().size(); i++){
            if (((isDateInRange(container.getRecordContainer().get(i).getDate(), dateStart, dateEnd)) &&
            (isCoordInRange(container.getRecordContainer().get(i).getLocation().getDoubleLat(), latStart, latEnd))) &&
            (isCoordInRange(container.getRecordContainer().get(i).getLocation().getDoubleLong(), lonStart, lonEnd))){
                rc.addRecord(container.getRecordContainer().get(i));
            }
        }
        return rc;
    }

    private boolean isDateInRange(Date date, Date dateStart, Date dateEnd){
        boolean answer;
        int resultStart = date.compareTo(dateStart);
        int resultEnd = date.compareTo(dateEnd);
        if ((resultStart >= 0) && (resultEnd <= 0)){
            answer = true;
        } else {
            answer = false;
        }
        return answer;
    }

    private boolean isCoordInRange(double coord, double coordStart, double coordEnd){
        boolean answer;
        if ((coord >= coordStart) && (coord <= coordEnd)){
            answer = true;
        } else {
            answer = false;
        }
        return answer;
    }
}
