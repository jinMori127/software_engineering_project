package il.cshaifasweng.OCSFMediatorExample.client;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.event.ActionEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;

public class MasterPageCotroller {

    @FXML
    private StackPane content_area;

    @FXML
    private Menu catalog_menu;

    @Subscribe
    public void change_content(ContentChangeEvent event)
    {
        Platform.runLater(()->{
            setContent(event.getPage()+".fxml");
        });
    }

    @FXML
    public void initialize() {
        System.out.println("Initializing MasterPageCotroller");
        EventBus.getDefault().register(this);
        System.out.println("Registered MasterPageCotroller");
        // Initialize common UI components and behavior here
        // catalog_menu.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> setContent("Movie_editing_details.fxml"));

        setContent("HomePage.fxml");


    }

    public void setContent(String file) {
        FXMLLoader new_content = null;
        try {
             new_content = new FXMLLoader(getClass().getResource(file));
             System.out.println("we are here");

        } catch (Exception e) {

            e.printStackTrace();
            return;
        }

        content_area.getChildren().clear();
        try {
            content_area.getChildren().setAll((Node) new_content.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void handle_action(ActionEvent event) {
        MenuItem source = (MenuItem) event.getSource();
        String menuItemText = source.getText();
        if (menuItemText.equals("Home page")) {
            setContent("HomePage.fxml");
        }
        else if(menuItemText.equals("id")){
            setContent("UserLoginWithID.fxml");
        }
        else if (menuItemText.equals("worker"))
        {
            setContent("WorkerLogIn.fxml");
        } else if (menuItemText.equals("Purchases")) {
            setContent("UserPurchases.fxml");
        }
        else if(menuItemText.equals("Complains"))
        {
            setContent("UserComplains.fxml");
        }
        else if (menuItemText.equals("Sing out")) {
            setContent("MultiEntryTicket.fxml");
        }
        else if (menuItemText.equals("Purchase Multi Entry Ticket")) {
            setContent("MultiEntryTicket.fxml");
        }




    }



}
