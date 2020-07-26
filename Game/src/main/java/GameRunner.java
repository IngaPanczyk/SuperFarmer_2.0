import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;

import static javafx.application.Application.launch;

public class GameRunner extends Application {
    private Image imageback = new Image("file:src/main/resources/Plansza do gry (2).png");

    private FlowPane animals = new FlowPane(Orientation.HORIZONTAL);
    private Label blueDice = new Label();
    private Label orangeDice = new Label();
    private Label blueDiceComputer = new Label();
    private Label orangeDiceComputer = new Label();
    private Label informWinner = new Label();


    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        orangeDice.setFont(new Font("Arial", 50));
        orangeDice.setTextFill(Color.web("orange"));
        blueDice.setFont(new Font("Arial", 50));
        blueDice.setTextFill(Color.web("blue"));


        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setPadding(new Insets(18, 12.5, 13.5, 14.5));
        grid.setHgap(5.5);
        grid.setVgap(5.5);
        grid.setBackground(background);

        //MECHANIKA GRY ----------------------------------------------------------------------------------------------

        UserAnimalList userAnimalList = new UserAnimalList();
        ComputerAnimalList computerAnimalLIst = new ComputerAnimalList();

        ArrayList userList = userAnimalList.getlist();
        ArrayList computerList = computerAnimalLIst.getList();
        boolean getWinnerUser = false;
        AtomicBoolean getWinnerComputer = new AtomicBoolean(false);

        boolean moveControler = true;
            Button throwDice = new Button();
            throwDice.setText("THROW DICE");
            while (moveControler == true) {
                moveControler = false;
                throwDice.setOnAction((e) -> {
                    Dice dice = new Dice();
                    Animal orange = dice.orangeDice();
                    Animal blue = dice.blueDice();
                    orangeDice.setText(String.valueOf(orange));
                    blueDice.setText(String.valueOf(blue));
                    ArrayList userListAfterGreeding = userAnimalList.greedingUser(userList, orange, blue);
                });

            }

            Button throwComputer = new Button();
            throwComputer.setText("FINISH YOUR MOVE");
            while (moveControler == false) {
                moveControler = true;
                throwComputer.setOnAction((e) -> {
                    Dice dice = new Dice();
                    Animal orange = dice.orangeDice();
                    Animal blue = dice.blueDice();
                    orangeDiceComputer.setText(String.valueOf(orange));
                    blueDiceComputer.setText(String.valueOf(blue));
                    ArrayList computerListAfterGreeding = computerAnimalLIst.greedingComputer(computerList, orange, blue);

                    if (Collections.frequency(computerListAfterGreeding, Animal.RABBIT) > 7) {
                        computerAnimalLIst.exRabbitToScheep(computerListAfterGreeding);
                        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                    }
                    if (Collections.frequency(computerListAfterGreeding, Animal.SHEEP) > 4) {
                        computerAnimalLIst.exSheepToPig(computerListAfterGreeding);
                        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                    }
                    if (Collections.frequency(computerListAfterGreeding, Animal.PIG) > 2) {
                        computerAnimalLIst.exPigToCow(computerListAfterGreeding);
                        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                    }
                    if (Collections.frequency(computerListAfterGreeding, Animal.COW) > 2) {
                        computerAnimalLIst.exCowToHorse(computerListAfterGreeding);
                        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                    }

                    getWinnerComputer.set(computerAnimalLIst.checkAnimalsInCollection(computerListAfterGreeding));

                    System.out.println("Computer after greeding has " + computerListAfterGreeding.size()+ " animals");
                    System.out.println("------------------------------------------------------------------------");

                    if (getWinnerComputer.get() == true) {
                        System.out.println("Computer WON!!!");
                        throwComputer.setText("GAME OVER");

                        informWinner.setText("Computer WON!!!");



                    } else if (getWinnerUser == true) {
                        System.out.println("User WON!!!");
                        throwDice.setText("GAME OVER");
                        informWinner.setText("YOU WON");


                    }

                });
            }

        Button exchangePig = new Button();
        exchangePig.setText("PIG");
        exchangePig.setOnAction((e) -> {

        });

        Button exchangeRabbit = new Button();
        exchangeRabbit.setText("RABBIT");
        exchangeRabbit.setOnAction((e) -> {

        });

        Button exchangeSheep = new Button();
        exchangeSheep.setText("SHEEP");
        exchangeSheep.setOnAction((e) -> {

        });

        grid.add(throwDice, 1 ,1 );
        grid.add(throwComputer, 12,1);
        grid.add(orangeDice, 2 ,1);
        grid.add(blueDice, 3, 1);
        grid.add(orangeDiceComputer, 4 ,1);
        grid.add(blueDiceComputer, 6, 1);
        grid.add(informWinner,6,5);


        Scene scene = new Scene(grid, 1600, 900, Color.YELLOW);

        primaryStage.setTitle("SuperFarmer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}


