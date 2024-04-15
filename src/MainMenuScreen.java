import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuScreen extends JPanel {
    private ApplicationFrame frame;
    private NewSightingScreen newSightingScreen;
    private BrowseScreen browseScreen;
    private SearchScreen searchScreen;
    private RecordContainer recordContainer;

    //components this screen will have
    private JLabel mainMenuTitle;
    private GridBagConstraints mainMenuTitleConstraints;

    private JButton newSighting;
    private GridBagConstraints newSightingButtonConstraints;

    private JButton corroborateSighting;
    private GridBagConstraints corroborateSightingButtonConstraints;

    private JButton browseSighting;
    private GridBagConstraints browseSightingButtonConstraints;

    private JButton searchSighting;
    private GridBagConstraints searchSightingButtonConstraints;

    //fields for managing the size of the screen and the components
    private Dimension preferredScreenSize;
    private Dimension preferredComponentSize;
    private int rightBorder;
    private int leftBorder;
    private int bottomBorder;
    private int internalPaddingX;
    private int internalPaddingY;

    MainMenuScreen(ApplicationFrame f, NewSightingScreen nss, BrowseScreen bs, SearchScreen ss, RecordContainer rc){
        frame = f;
        newSightingScreen = nss;
        browseScreen = bs;
        searchScreen = ss;
        recordContainer = rc;

        //total size of the panel
        preferredScreenSize = new Dimension(800, 600);

        //the sizes of the borders around the edge of the display panel
        rightBorder = 100;
        leftBorder = 100;
        bottomBorder = 100;

        //this "internal padding" essentially makes the component smaller in a GridBagLayout
        internalPaddingX = 200;
        internalPaddingY = 20;
        this.setBorder(BorderFactory.createEmptyBorder(0, leftBorder, bottomBorder, rightBorder));
        this.setPreferredSize(preferredScreenSize);
        this.setLayout(new GridBagLayout());
        this.setOpaque(true);

        preferredComponentSize = new Dimension((preferredScreenSize.width - rightBorder - leftBorder - internalPaddingX * 2),
                (preferredScreenSize.height - bottomBorder) / 4 - internalPaddingY * 2);

        //main menu title - just displays the title of the screen at the top
        mainMenuTitle = new JLabel("Main Menu", JLabel.CENTER);
            mainMenuTitle.setFont(mainMenuTitle.getFont().deriveFont(24.0F));
            mainMenuTitle.setPreferredSize(preferredComponentSize);
            mainMenuTitleConstraints = new GridBagConstraints();
            mainMenuTitleConstraints.gridx = 0;
            mainMenuTitleConstraints.gridy = 0;
            mainMenuTitleConstraints.weightx = 1.0;
            mainMenuTitleConstraints.weighty = 1.0;
            mainMenuTitleConstraints.ipadx = internalPaddingX;
            mainMenuTitleConstraints.ipady = internalPaddingY;


        //button to take user to new sighting screen
        newSighting = new JButton("Report a New Sighting");
            newSighting.setAlignmentX(Component.CENTER_ALIGNMENT);
            newSighting.setPreferredSize(preferredComponentSize);
            newSightingButtonConstraints = new GridBagConstraints();
            newSightingButtonConstraints.gridx = 0;
            newSightingButtonConstraints.gridy = 1;
            newSightingButtonConstraints.weightx = 1.0;
            newSightingButtonConstraints.weighty = 1.0;
            newSightingButtonConstraints.ipadx = internalPaddingX;
            newSightingButtonConstraints.ipady = internalPaddingY;
            newSightingButtonConstraints.fill = GridBagConstraints.HORIZONTAL;

            newSighting.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setScreen(newSightingScreen);
                }
            });

        //button to take user to corroborate sighting screen (currently inactive)
        corroborateSighting = new JButton("Corroborate a Previous Sighting");
            corroborateSighting.setAlignmentX(Component.CENTER_ALIGNMENT);
            corroborateSighting.setPreferredSize(preferredComponentSize);
            corroborateSightingButtonConstraints = new GridBagConstraints();
            corroborateSightingButtonConstraints.gridx = 0;
            corroborateSightingButtonConstraints.gridy = 2;
            corroborateSightingButtonConstraints.weightx = 1.0;
            corroborateSightingButtonConstraints.weighty = 1.0;
            corroborateSightingButtonConstraints.ipadx = internalPaddingX;
            corroborateSightingButtonConstraints.ipady = internalPaddingY;
            corroborateSightingButtonConstraints.fill = GridBagConstraints.HORIZONTAL;

        //button to take user to search sighting screen
        browseSighting = new JButton("Browse All Sightings");
            browseSighting.setAlignmentX(Component.CENTER_ALIGNMENT);
            browseSighting.setPreferredSize(preferredComponentSize);
            browseSightingButtonConstraints = new GridBagConstraints();
            browseSightingButtonConstraints.gridx = 0;
            browseSightingButtonConstraints.gridy = 3;
            browseSightingButtonConstraints.weightx = 1.0;
            browseSightingButtonConstraints.weighty = 1.0;
            browseSightingButtonConstraints.ipadx = internalPaddingX;
            browseSightingButtonConstraints.ipady = internalPaddingY;
            browseSightingButtonConstraints.fill = GridBagConstraints.HORIZONTAL;

            browseSighting.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    browseScreen.setRecordContainer(recordContainer);
                    browseScreen.initialize_all_records();
                    setScreen(browseScreen);
                }
            });

        searchSighting = new JButton("Search Sightings");
            searchSighting.setAlignmentX(Component.CENTER_ALIGNMENT);
            searchSighting.setPreferredSize(preferredComponentSize);
            searchSightingButtonConstraints = new GridBagConstraints();
            searchSightingButtonConstraints.gridx = 0;
            searchSightingButtonConstraints.gridy = 4;
            searchSightingButtonConstraints.weightx = 1.0;
            searchSightingButtonConstraints.weighty = 1.0;
            searchSightingButtonConstraints.ipadx = internalPaddingX;
            searchSightingButtonConstraints.ipady = internalPaddingY;
            searchSightingButtonConstraints.fill = GridBagConstraints.HORIZONTAL;

            searchSighting.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setScreen(searchScreen);
                }
            });

        /*
        //button to save sightings (THIS MUST BE PRESSED BEFORE CLOSING THE PROGRAM IF NEW ENTRIES HAVE BEEN ADDED)
        saveSightings = new JButton("Save Sightings");
        saveSightings.setPreferredSize(new Dimension(400, 100));
        saveSightings.setAlignmentX(Component.CENTER_ALIGNMENT);
        saveSightings.setFont(new Font("Serif", Font.PLAIN, 16));
        saveSightings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

                searchScreen.update(recordContainer.getRecordContainer().size());
            }
        });

*/
        this.add(mainMenuTitle, mainMenuTitleConstraints);
        this.add(newSighting, newSightingButtonConstraints);
        //this.add(corroborateSighting, corroborateSightingButtonConstraints);
        this.add(browseSighting, browseSightingButtonConstraints);
        this.add(searchSighting, searchSightingButtonConstraints);


        //this.add(saveSightings);
    }

    private void setScreen(JPanel screen){
        frame.getContentPane().removeAll();
        frame.getContentPane().add(screen);
        frame.pack();
        frame.revalidate();
        frame.repaint();
    }
}
