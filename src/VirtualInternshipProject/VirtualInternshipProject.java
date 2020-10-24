/*
 * Team 3 - Duy Vo - Zhihan Lin - Dante Barton
 * In this project, we create some feature for our platform we working on
 * login system, resources website, badges earned display
 */
package VirtualInternshipProject;

import java.io.*;
import javafx.application.Application;
import static javafx.application.Application.STYLESHEET_CASPIAN;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 *
 * @author zhihanlin
 * @author Duy Vo
 * @author Dante barton
 */
public class VirtualInternshipProject extends Application {

    // create the link urls
    final static String urls = "https://info.credly.com/resources";

    // create WebView and WebEngine to link it to the urls
    final WebView browser = new WebView();
    final WebEngine webEngine = browser.getEngine();

    /**
     * nodes for login and register
     */
    Label lblUserName;
    Label lblPassWord;
    Label lblPrompt;
    TextField tfUserName;
    TextField tfPassWord;
    Button btnLogIn;
    Button btnReg;
    boolean ifLogin = false;

    private Image badgeImage = new Image(
            "demo_badge.png");

    private Image teamBadge = new Image("teamwork_badge.png");

    private Image ResourseImage = new Image("resourse.jpg");

    private String DescriptionBadge1 = " Badge Name: Project Participant Demo Badge \n"
            + "Issued by: Acclaim\n"
            + "Type: Experience \n"
            + "Level: Foundational \n"
            + "The earner of this badge is working with an industry sponsor to follow a project brief and\n"
            + "create a product in Java in line with the project scope and requirements. \n"
            + "The earner can accept a digital credential and engage with the earner experience.\n\n"
            + "Skills: \n"
            + "- Collaboration\n"
            + "- Experiential Learning\n"
            + "- Java\n"
            + "- Teamwork";

    private String DescriptionBadge2 = " Badge Name: Collaboration and Teamwork: Knowledge Level 1 \n"
            + "Issued by: Pearson College and Career Readiness Programs \n"
            + "Type: Learning \n"
            + "Level: foundational \n"
            + "The badge earner has demonstrated basic competency in several key areas: \n"
            + "an understanding of how listening is a key part of collaboration; how groups \n"
            + "and teams compare and develop; how to form and participate on teams; how to work collaboratively \n"
            + "to set common goals, promote open communnication, and generate strong results; and how to handle common types of team conflict. \n"
            + "Skills: \n"
            + "- Collaboration \n"
            + "- Communication \n"
            + "- Conflict Resolution \n"
            + "- Delegation \n"
            + "- Flexibility \n"
            + "- Forming Teams \n"
            + "- Generating Results \n"
            + "- Goal Setting \n"
            + "- Listening \n"
            + "- Negotiation \n"
            + "- Shared Leadership \n"
            + "- Teamwork";

    /**
     * nodes for TabPane
     */
    Tab tabLogIn = new Tab(" ");
    Tab tabDesc = new Tab(" ");
    Tab tabRes = new Tab(" ");

    @Override
    public void start(Stage primaryStage) throws IOException {

        //  left part
        VBox content = new VBox();
        HBox contentButton = new HBox();
        HBox contentBadge = new HBox();
        VBox contentInsideBadge1 = new VBox();
        VBox contentInsideBadge2 = new VBox();
        //content.setOrientation(Orientation.VERTICAL);

        Button buttonBagde1 = new Button("Project Participation\n Demo Badge");
        buttonBagde1.setFont(Font.font("Time New Roman", FontWeight.BLACK, FontPosture.REGULAR, 20));
        Button buttonBagde2 = new Button("Collaboration and Teamwork: \n Knowledge Level 1");
        buttonBagde2.setFont(Font.font("Time New Roman", FontWeight.BLACK, FontPosture.REGULAR, 20));

        ImageView imageView1 = new ImageView(badgeImage);
        ImageView imageView2 = new ImageView(teamBadge);

        imageView1.setFitHeight(70);
        imageView1.setFitWidth(70);
        imageView1.setX(10);
        imageView1.setY(10);

        imageView2.setFitHeight(70);
        imageView2.setFitWidth(70);
        imageView2.setX(10);
        imageView2.setY(10);

        //HBox hBox = new HBox();
        //hBox.getChildren().add(imageView1);
        Pane imagePane1 = new Pane();
        Pane imagePane2 = new Pane();

        imagePane1.getChildren().add(imageView1); // badgeImage
        TextArea taDesc1 = new TextArea();
        taDesc1.setText(DescriptionBadge1);
        ScrollPane taDescScrollPane1 = new ScrollPane(taDesc1);

        imagePane2.getChildren().add(imageView2); // badgeImage
        TextArea taDesc2 = new TextArea();
        taDesc2.setText(DescriptionBadge2);
        ScrollPane taDescScrollPane2 = new ScrollPane(taDesc2);

        contentInsideBadge1.getChildren().addAll(imagePane1, taDescScrollPane1);
        contentInsideBadge2.getChildren().addAll(imagePane2, taDescScrollPane2);

        contentButton.getChildren().addAll(buttonBagde1, buttonBagde2);
        content.getChildren().addAll(contentButton, contentBadge);

        buttonBagde1.setOnAction(e -> {
            contentBadge.getChildren().clear();
            contentBadge.getChildren().add(contentInsideBadge1);
        });
        buttonBagde2.setOnAction(e -> {
            contentBadge.getChildren().clear();
            contentBadge.getChildren().add(contentInsideBadge2);
        });

        //* * * * * * * * * * * * * * * *//    
        //           Resourse            //
        //* * * * * * * * * * * * * * * *//
        SplitPane contentRes = new SplitPane();
        contentRes.setOrientation(Orientation.VERTICAL);

        ImageView imageViewResourse = new ImageView(ResourseImage);
        imageViewResourse.setFitHeight(40);
        imageViewResourse.setFitWidth(40);

        HBox hBoxResourseImage = new HBox();
        hBoxResourseImage.getChildren().add(imageViewResourse);
        Pane resourseImagePane = new Pane();

        resourseImagePane.getChildren().add(imageViewResourse);

        // create the HyperLink for resourse button
        Hyperlink hyperlink = new Hyperlink("Resourse");
        hyperlink.setFont(Font.font("Time New Roman", FontWeight.BOLD, FontPosture.REGULAR, 20));

        // action event 
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                webEngine.load(urls);
            }
        };

        // when hyperlink is pressed, the program will go direct to the link urls
        hyperlink.setOnAction(event);

        // create a HBox 
        HBox hbox = new HBox();
        hbox.getChildren().addAll(resourseImagePane, hyperlink, browser);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(hbox, browser);
        VBox.setVgrow(browser, Priority.ALWAYS);

        contentRes.getItems().addAll(vBox);

        //* * * * * * * * * * * * * * * *//    
        //        LOGIN & REGISTER       //
        //* * * * * * * * * * * * * * * *//
        lblUserName = new Label("Username: ");
        lblUserName.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.LIGHT, FontPosture.REGULAR, 15));
        lblPassWord = new Label("Password: ");
        lblPassWord.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.LIGHT, FontPosture.REGULAR, 15));
        lblPrompt = new Label();
        tfUserName = new TextField();
        tfPassWord = new TextField();
        btnLogIn = new Button();
        btnLogIn.setStyle("-fx-font-size: 13");
        btnReg = new Button();

        btnLogIn.setText("Log In");
        btnLogIn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String userName = tfUserName.getText();
                String passWord = tfPassWord.getText();
                ifLogin = verifyingLogin(userName, passWord);
                if (ifLogin) {
                    lblPrompt.setText("LogIn successfully");
                    ifLogin = true;
                } else {
                    lblPrompt.setText("Username and password does not match");
                }
                if (ifLogin) {
                    tabDesc.setContent(content);
                    tabRes.setContent(contentRes);
                }
            }
        });

        btnReg.setText("Register");
        btnReg.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String userName = tfUserName.getText();
                String passWord = tfPassWord.getText();

                if (resigsteration(userName, passWord)) {
                    lblPrompt.setText("Thank you for registeration!");
                }
            }
        });

        /*
            username    [      ]
            password    [      ]
            login       register
         */
        GridPane center = new GridPane();
        center.setAlignment(Pos.CENTER);
        center.setHgap(10);
        center.setVgap(5.5);

        center.add(lblUserName, 1, 0);
        center.add(tfUserName, 2, 0);
        center.add(lblPassWord, 1, 1);
        center.add(tfPassWord, 2, 1);
        center.add(btnLogIn, 2, 2);
        center.add(btnReg, 2, 2);
        center.add(lblPrompt, 2, 3);
        GridPane.setHalignment(btnLogIn, HPos.LEFT);
        GridPane.setHalignment(btnReg, HPos.RIGHT);

        BorderPane logIn = new BorderPane();
        logIn.setCenter(center);

        //* * * * * * * * * * * * * * * *//    
        //          TABS on LEFT         //
        //* * * * * * * * * * * * * * * *//
        TabPane tabPane = new TabPane();

        Label lblLogIn = new Label("LogIn");
        Label lblDesc = new Label("Badges \nEarned");
        Label lblRes = new Label("Resourse");

        tabLogIn.setGraphic(lblLogIn);
        tabDesc.setGraphic(lblDesc);
        tabRes.setGraphic(lblRes);

        tabLogIn.setContent(logIn);
        tabPane.setSide(Side.LEFT);
        tabPane.setTabMinHeight(70);
        tabPane.setTabMaxHeight(70);
        tabPane.setTabMinWidth(60);
        tabPane.setTabMaxWidth(60);

        tabPane.getTabs().addAll(tabLogIn, tabDesc, tabRes);

        //  right part
        SplitPane sp = new SplitPane();
        sp.getItems().addAll(tabPane);

        Scene scene = new Scene(sp, 650, 450);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public boolean verifyingLogin(String userName, String passWord) {
        boolean status = false;
        String tempUser = "";
        String tempPswd = "";
        try {
            DataInputStream dataIn = new DataInputStream(new FileInputStream("user_pswd.dat"));

            while (true) {
                tempUser = dataIn.readUTF();
                tempPswd = dataIn.readUTF();

                if (tempPswd.equals(passWord) && tempUser.equals(userName)) {
                    status = true;
                }
            }
        } catch (EOFException e) {
            System.out.println("Reading is finished");
        } catch (FileNotFoundException e) {
            System.out.println("The file was not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean resigsteration(String userName, String passWord) {
        boolean status = false;
        if (validationInput(userName, passWord)) {
            try {
                DataOutputStream dataOut = new DataOutputStream(new FileOutputStream("user_pswd.dat"));
                dataOut.writeUTF(userName);
                dataOut.writeUTF(passWord);
                status = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return status;
    }

    public boolean validationInput(String tempN, String tempP) {
        boolean status = false;
        if (tempN.length() > 8 || tempP.length() > 8) {
            lblPrompt.setText("Both username and password can't\nbe longer than 8 characters");
        } else {
            status = true;
        }
        return status;
    }

}
