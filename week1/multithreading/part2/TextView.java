package multithreading.part2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/*
De twee klassen in deze package vormen het antwoord op de opgave 30.1 uit Liang en de pdf opgave op Blackboard. In de
uitwerkingen die verschaft zijn, wordt er gebruik gemaakt van één klasse, maar het is natuurlijk beter om dat in twee
verschillende klassen te doen: één voor de data en één voor het weergeven van die data. Op deze manier demonstreren
we ook hoe je met twee klassen en meerdere Threads kunt samenwerken.

Deze klasse is de GUI van de applicatie. Met JavaFX worden twee knoppen boven een textArea gezet. Met de eerste knop
kun je deze textArea leegmaken, met de tweede knop run je de TaskThreadDemo, waarbij de output van de verschillende
Runnables niet in de console wordt gelogd maar in de textArea te voorschijn komt. De uitdaging die we daarbij onder-
vinden is hoe die Runnables kennis hebben van die textArea. Daarvoor worden hieronder verschillende opties besproken.

Er zijn twee klassen die met deze GUI samenwerken: TaskThreadDemo1 en TaskThreadDemo2. De eerste maakt gebruik van een
static public TextArea in deze klasse, bij de tweede wordt deze TextArea bij het aanmaken meegegeven. Check de
beschrijving in beide klassen voor details.

De GUI zelf is niet zo heel belangrijk: bestudeer de code even om een gevoel te krijgen van hoe je zoiets opbouwt, maar
let vooral op de becommentarieerde regels hieronder.
*/


public class TextView extends Application {
    /*
    Eén methode om de Runnables kennis te laten hebben van de textArea is om deze als static public te definiëren. In
    dat geval kunnen we de variabele eenvoudig op de klasse aanspreken (als Textview.textArea). Van een dergelijke
    klasse-variabele kan er binnen elke JVM maar één zijn (of je moet heel ingewikkelde systemen gaan toepassen).
     */
	static public TextArea textArea;
	
	@Override
	public void start(Stage primaryStage) {
		BorderPane mainPane = new BorderPane();
		HBox hbox = addHBox();
		mainPane.setTop(hbox);
		mainPane.setCenter(addVBox());
		
		Scene scene = new Scene(mainPane, 500, 300);
		primaryStage.setTitle("Awesome thread output");
		primaryStage.setScene(scene);
		primaryStage.show();
		textArea.requestFocus();
	}
	
	protected void update(char txt) {
		textArea.appendText(Character.toString(txt));		
	}
	
	private VBox addVBox() {
	    VBox vbox = new VBox();
	    vbox.setPadding(new Insets(10));
	    vbox.setSpacing(8);

	    textArea = new TextArea(this.getText());
	    textArea.setMaxWidth(500);
	    textArea.setWrapText(true);
	    textArea.setEditable(false);
	    textArea.setFont(Font.font("Arial", FontWeight.BOLD, 14));
	    vbox.getChildren().add(textArea);
	
	    return vbox;
	}
	
	private HBox addHBox() {
		HBox hbox = new HBox();hbox.setPadding(new Insets(15, 12, 15, 12));
	    hbox.setSpacing(10);
	    hbox.setStyle("-fx-background-color: #336699;");

	    Button buttonStart = new Button("Start");
	    buttonStart.setPrefSize(100, 20);
	    // stap 1a
        // Verander hier de klasse TastThreadDemo1 in TaskThreadDemo2 om het principe van Dependency Injection
        // te laten werken.
//        buttonStart.setOnAction(e -> new TaskThreadDemo1() );
	    buttonStart.setOnAction(e -> new TaskThreadDemo2(textArea) );

	    Button buttonClear = new Button("Clear");
	    buttonClear.setPrefSize(100, 20);
	    // stap 1b
	    buttonClear.setOnAction( e -> textArea.clear() );
	    
	    hbox.getChildren().addAll(buttonStart, buttonClear);

	    return hbox;
	}
	
	private String getText() {
		return "In deze textArea moeten de dingen komen te staan "
				+ "die door de verschillende Threads (in TaskThreadDemo) "
				+ "worden aangemaakt. Voeg eerst lambda's toe aan de "
				+ "knoppen om ze te laten werken.";
	}

	
	public static void main(String[] args) {
		launch(args);	
	}
	
}
