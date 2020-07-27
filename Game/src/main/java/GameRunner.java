import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;

import static javafx.application.Application.launch;

public class GameRunner extends Application{

    ArrayList userListAfterGreeding;

    private Image imageback = new Image("file:src/main/resources/Plansza do gry (2).png");

    private FlowPane animals = new FlowPane(Orientation.HORIZONTAL);
    private Label blueDice = new Label();
    private Label orangeDice = new Label();
    private Label blueDiceComputer = new Label();
    private Label orangeDiceComputer = new Label();
    private Label informWinner = new Label();
    private Label qRabbits = new Label();
    private Label qSheeps = new Label();
    private Label qPigs = new Label();
    private Label qCows = new Label();
    private Label qHorses = new Label();



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        orangeDice.setFont(new Font("Arial", 40));
        orangeDice.setTextFill(Color.web("orange"));
        blueDice.setFont(new Font("Arial", 40));
        blueDice.setTextFill(Color.web("blue"));
        orangeDiceComputer.setFont(new Font("Arial", 40));
        orangeDiceComputer.setTextFill(Color.web("orange"));
        blueDiceComputer.setFont(new Font("Arial", 40));
        blueDiceComputer.setTextFill(Color.web("blue"));
        informWinner.setFont(new Font("Arial", 40));
        informWinner.setTextFill(Color.web("red"));
        qRabbits.setFont(new Font("Arial", 30));
        qRabbits.setTextFill(Color.web("green"));
        qSheeps.setFont(new Font("Arial", 30));
        qSheeps.setTextFill(Color.web("green"));
        qPigs.setFont(new Font("Arial", 30));
        qPigs.setTextFill(Color.web("green"));
        qCows.setFont(new Font("Arial", 30));
        qCows.setTextFill(Color.web("green"));
        qHorses.setFont(new Font("Arial", 30));
        qHorses.setTextFill(Color.web("green"));



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
        //PRZYCISKI ---------------------------------------------------------------------------------------------------
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
                userListAfterGreeding = userAnimalList.greedingUser(userList, orange, blue);
                boolean userWinner = userAnimalList.checkAnimalsInCollection(userListAfterGreeding);

            if (userWinner == true) {
                System.out.println("User WON!!!");
                throwDice.setText("GAME OVER");
                informWinner.setText("YOU WON");
            }

                System.out.println("User after greeding has " + userListAfterGreeding.size() + " animals");
                System.out.println("------------------------------------------------------------------------");
                qRabbits.setText("RABBITS: "+ String.valueOf(Collections.frequency(userListAfterGreeding, Animal.RABBIT)));
                qSheeps.setText("SHEEP: "+ String.valueOf(Collections.frequency(userListAfterGreeding, Animal.SHEEP)));
                qPigs.setText("PIGS: "+ String.valueOf(Collections.frequency(userListAfterGreeding, Animal.PIG)));
                qCows.setText("COWS: "+ String.valueOf(Collections.frequency(userListAfterGreeding, Animal.COW)));
                qHorses.setText("HORSES: "+ String.valueOf(Collections.frequency(userListAfterGreeding, Animal.HORSE)));


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

                if (getWinnerComputer.get() == true) {
                    System.out.println("Computer WON!!!");
                    informWinner.setText("Computer WON!!!");

                }
                System.out.println("Computer after greeding has " + computerListAfterGreeding.size() + " animals");
                System.out.println("------------------------------------------------------------------------");

            });
        }

        Button exchangeRabbit = new Button();
        exchangeRabbit.setText("6 RABBIT = 1 SHEEP");
        exchangeRabbit.setOnAction((e) -> {
            if (Collections.frequency(userListAfterGreeding, Animal.RABBIT) > 7){
                userListAfterGreeding.add(Animal.SHEEP);
                userListAfterGreeding.remove(Animal.RABBIT);
                userListAfterGreeding.remove(Animal.RABBIT);
                userListAfterGreeding.remove(Animal.RABBIT);
                userListAfterGreeding.remove(Animal.RABBIT);
                userListAfterGreeding.remove(Animal.RABBIT);
                userListAfterGreeding.remove(Animal.RABBIT);
                System.out.println("Exchanged 6 RABBITS TO 1 SHEEP");
            }
        });

        Button exchangeSheep = new Button();
        exchangeSheep.setText("3 SHEEP = 1 PIG");
        exchangeSheep.setOnAction((e) -> {
            if (Collections.frequency(userListAfterGreeding, Animal.SHEEP) > 4){
                userListAfterGreeding.add(Animal.PIG);
                userListAfterGreeding.remove(Animal.SHEEP);
                userListAfterGreeding.remove(Animal.SHEEP);
                userListAfterGreeding.remove(Animal.SHEEP);

                System.out.println("Exchanged 3 SHEEP TO 1 PIG");
            }
        });

        Button exchangeCow = new Button();
        exchangeCow.setText("2 PIG = 1 COW");
        exchangeCow.setOnAction((e) -> {
            if (Collections.frequency(userListAfterGreeding, Animal.PIG) > 3) {
                userListAfterGreeding.add(Animal.COW);
                userListAfterGreeding.remove(Animal.PIG);
                userListAfterGreeding.remove(Animal.PIG);

                System.out.println("Exchanged 2 PIG TO 1 COW");
            }
        });

        Button exchangeHorse = new Button();
        exchangeHorse.setText("2 COW = 1 HORSE");
        exchangeHorse.setOnAction((e) -> {
            if (Collections.frequency(userListAfterGreeding, Animal.COW) > 3) {
                userListAfterGreeding.add(Animal.HORSE);
                userListAfterGreeding.remove(Animal.COW);
                userListAfterGreeding.remove(Animal.COW);

                System.out.println("Exchanged 2 COW TO 1 HORSE");
            }
        });

        grid.getColumnConstraints().

                add(new ColumnConstraints(80)); // 0
        grid.getColumnConstraints().

                add(new ColumnConstraints(200)); // 1
        grid.getColumnConstraints().

                add(new ColumnConstraints(160)); //2
        grid.getColumnConstraints().

                add(new ColumnConstraints(160)); // 3
        grid.getColumnConstraints().

                add(new ColumnConstraints(160)); // 4
        grid.getColumnConstraints().

                add(new ColumnConstraints(160)); // 5
        grid.getColumnConstraints().

                add(new ColumnConstraints(200)); // 6
        grid.getColumnConstraints().

                add(new ColumnConstraints(160)); // 7
        grid.getColumnConstraints().

                add(new ColumnConstraints(160)); // 8
        grid.getColumnConstraints().

                add(new ColumnConstraints(80)); // column 0 is 100 wide
        grid.getColumnConstraints().

                add(new ColumnConstraints(80)); // column 0 is 100 wide
        grid.getColumnConstraints().

                add(new ColumnConstraints(80)); // column 0 is 100 wide
        grid.getColumnConstraints().


                add(new ColumnConstraints(80)); // column 0 is 100 wide
        grid.getColumnConstraints().

                add(new ColumnConstraints(80)); // column 0 is 100 wide
        grid.getColumnConstraints().

                add(new ColumnConstraints(80)); // column 0 is 100 wide
        grid.getRowConstraints().

                add(new RowConstraints(100)); // column 0 is 100 wide
        grid.getRowConstraints().

                add(new RowConstraints(100)); // column 0
        grid.getRowConstraints().

                add(new RowConstraints(50)); // column 0
        grid.getRowConstraints().

                add(new RowConstraints(50)); // column 0
        grid.getRowConstraints().

                add(new RowConstraints(50)); // column 0
        grid.getRowConstraints().

                add(new RowConstraints(52)); // column 0
        grid.getRowConstraints().

                add(new RowConstraints(50)); // column 0
        grid.getRowConstraints().

                add(new RowConstraints(50)); // column 0



        grid.add(throwDice, 1, 1);
        grid.add(throwComputer, 9, 1);
        grid.add(orangeDice, 2, 1);
        grid.add(blueDice, 3, 1);
        grid.add(orangeDiceComputer, 6, 1);
        grid.add(blueDiceComputer, 7, 1);
        grid.add(informWinner, 6, 5);
        grid.add(exchangeRabbit, 5,20);
        grid.add(exchangeSheep,5,21);
        grid.add(exchangeCow, 5,22);
        grid.add(exchangeHorse, 5,23);

        grid.add(qRabbits,1,5);
        grid.add(qSheeps,1,6);
        grid.add(qPigs,1,7);
        grid.add(qCows,1,8);
        grid.add(qHorses,1,9);


        Scene scene = new Scene(grid, 1600, 900, Color.YELLOW);

        primaryStage.setTitle("SuperFarmer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}


