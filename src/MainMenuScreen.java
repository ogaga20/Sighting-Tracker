import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainMenuScreen extends JPanel {
    private ApplicationFrame frame;
    private NewSightingScreen newSightingScreen;
    private SearchScreen searchScreen;
    private RecordContainer recordContainer;
    private JLabel mainMenuTitle;
    private JButton newSighting;
    private JButton corroborateSighting;
    private JButton searchSighting;
    private JButton saveSightings;

    MainMenuScreen(ApplicationFrame f, NewSightingScreen nss, SearchScreen ss, RecordContainer rc){
        frame = f;
        newSightingScreen = nss;
        searchScreen = ss;
        recordContainer = rc;
        this.setPreferredSize(new Dimension(800, 600));
        this.setLayout(new GridLayout(0, 1, 0, 75));
        this.setBorder(new EmptyBorder(50, 50, 50, 50));
        this.setOpaque(true);

        mainMenuTitle = new JLabel("Main Menu", JLabel.CENTER);
        mainMenuTitle.setPreferredSize(new Dimension(400, 0));
        mainMenuTitle.setFont(new Font("Serif", Font.PLAIN, 32));

        //button to take user to new sighting screen
        newSighting = new JButton("Create a New Sighting");
        newSighting.setPreferredSize(new Dimension(400, 100));
        newSighting.setAlignmentX(Component.CENTER_ALIGNMENT);
        newSighting.setFont(new Font("Serif", Font.PLAIN, 16));
        newSighting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(newSightingScreen);
                frame.pack();
                frame.revalidate();
                frame.repaint();
            }
        });

        //button to take user to corroborate sighting screen
        corroborateSighting = new JButton("Corroborate a Previous Sighting");
        corroborateSighting.setPreferredSize(new Dimension(400, 100));
        corroborateSighting.setAlignmentX(Component.CENTER_ALIGNMENT);
        corroborateSighting.setFont(new Font("Serif", Font.PLAIN, 16));

        //button to take user to search sighting screen
        searchSighting = new JButton("Search for Sightings");
        searchSighting.setPreferredSize(new Dimension(400, 100));
        searchSighting.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchSighting.setFont(new Font("Serif", Font.PLAIN, 16));
        searchSighting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(searchScreen);
                frame.pack();
                frame.revalidate();
                frame.repaint();
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
        this.add(mainMenuTitle);
        this.add(newSighting);
        this.add(corroborateSighting);
        this.add(searchSighting);
        //this.add(saveSightings);
    }
}
