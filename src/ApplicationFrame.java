import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ApplicationFrame extends JFrame {
    private MainMenuScreen mainMenuScreen;
    private NewSightingScreen newSightingScreen;
    private BrowseScreen browseScreen;
    private SearchScreen searchScreen;
    private RecordContainer recordContainer;


    //this constructor makes the records data structure, loads it (if it's there to load) and makes all the screens
    ApplicationFrame() throws IOException {
        recordContainer = new RecordContainer();
        recordContainer.loadRecords();
        newSightingScreen = new NewSightingScreen(this, recordContainer);
        browseScreen = new BrowseScreen(this);
        searchScreen = new SearchScreen(this, recordContainer, browseScreen);
        mainMenuScreen = new MainMenuScreen(this, newSightingScreen, browseScreen, searchScreen, recordContainer);


        this.setTitle("Sighting Tracker");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(mainMenuScreen);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public MainMenuScreen getMainMenuScreen(){
        return mainMenuScreen;
    }
    public BrowseScreen getBrowseScreen() {return browseScreen;}

}
