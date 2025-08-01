package memoire_fin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Memoire_fin extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/memoire_fin/FenetreVente/Fenetre_vente.fxml"));
        
        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
        
        scene.getStylesheets().add(getClass().getResource("/StyleSheets/Style_principale.css").toExternalForm());
    }
     public static void main(String[] args) {
        launch(args);
    }}
