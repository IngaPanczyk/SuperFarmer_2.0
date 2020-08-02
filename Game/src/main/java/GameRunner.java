import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
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


public class GameRunner extends Application {

    ArrayList userListAfterGreeding;
    boolean moveControler = true;
    boolean userWinner = false;
    boolean smallDog = false;
    private boolean bigDog = false;
    int counter = 0; //do liczenia ilości rund do wygranej - ranking

    private Image imageback = new Image("file:src/main/resources/Start.png");
    private Image imageback1 = new Image("file:src/main/resources/Plansza.png");
    private Image youWon = new Image("file:src/main/resources/YouWon.png");
    private Image computerWon = new Image("file:src/main/resources/ComputerWon.png");

    private FlowPane animals = new FlowPane(Orientation.HORIZONTAL);
    private Label blueDice = new Label();
    private Label orangeDice = new Label();
    private Label blueDiceComputer = new Label();
    private Label orangeDiceComputer = new Label();
    private Label comunication = new Label();
    private Label qRabbits = new Label();
    private Label qSheeps = new Label();
    private Label qPigs = new Label();
    private Label qCows = new Label();
    private Label qHorses = new Label();
    private Label qRabbitsCom = new Label();
    private Label qSheepsCom = new Label();
    private Label qPigsCom = new Label();
    private Label qCowsCom = new Label();
    private Label qHorsesCom = new Label();
    private Label smallDogLabel = new Label();
    private Label bigDogLabel = new Label();


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        BackgroundImage backgroundImage1 = new BackgroundImage(imageback1, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        BackgroundImage backgroundYouWon = new BackgroundImage(youWon, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        BackgroundImage backgroundComputerWon = new BackgroundImage(computerWon, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);


        orangeDice.setFont(new Font("Arial", 40));
        orangeDice.setTextFill(Color.web("orange"));
        orangeDice.alignmentProperty();
        blueDice.setFont(new Font("Arial", 40));
        blueDice.setTextFill(Color.web("blue"));
        orangeDiceComputer.setFont(new Font("Arial", 40));
        orangeDiceComputer.setTextFill(Color.web("orange"));
        blueDiceComputer.setFont(new Font("Arial", 40));
        blueDiceComputer.setTextFill(Color.web("blue"));
        comunication.setFont(new Font("Arial", 40));
        comunication.setTextFill(Color.web("red"));
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
        qRabbitsCom.setFont(new Font("Arial", 30));
        qRabbitsCom.setTextFill(Color.web("green"));
        qSheepsCom.setFont(new Font("Arial", 30));
        qSheepsCom.setTextFill(Color.web("green"));
        qPigsCom.setFont(new Font("Arial", 30));
        qPigsCom.setTextFill(Color.web("green"));
        qCowsCom.setFont(new Font("Arial", 30));
        qCowsCom.setTextFill(Color.web("green"));
        qHorsesCom.setFont(new Font("Arial", 30));
        qHorsesCom.setTextFill(Color.web("green"));
        smallDogLabel.setFont(new Font("Arial", 25));
        smallDogLabel.setTextFill(Color.web("brown"));
        bigDogLabel.setFont(new Font("Arial", 25));
        bigDogLabel.setTextFill(Color.web("brown"));

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setPadding(new Insets(18, 12.5, 13.5, 14.5));
        grid.setHgap(5.5);
        grid.setVgap(5.5);
        grid.setBackground(background);

        UserAnimalList userAnimalList = new UserAnimalList();
        ComputerAnimalList computerAnimalLIst = new ComputerAnimalList();
        ArrayList userList = userAnimalList.getlist();
        ArrayList computerList = computerAnimalLIst.getList();

        AtomicBoolean getWinnerComputer = new AtomicBoolean(false);

        Button starGameWithOneRabbit = new Button();
        Button startGameWithNothing = new Button();
        Button throwDice = new Button();
        Button throwComputer = new Button();
        Button exchangeRabbit = new Button();
        Button exchangeSheep = new Button();
        Button exchangePigDown = new Button();
        Button exchangeSheepDown = new Button();
        Button exchangeCow = new Button();
        Button exchangeCowDown = new Button();
        Button exchangeHorse = new Button();
        Button exchangeHorseDown = new Button();
        Button exchangeToSmallDog = new Button();
        Button exchangeToBigDog = new Button();

        starGameWithOneRabbit.setVisible(true);
        startGameWithNothing.setVisible(true);
        exchangeCow.setVisible(false);
        exchangeCowDown.setVisible(false);
        exchangeHorse.setVisible(false);
        exchangeHorseDown.setVisible(false);
        exchangePigDown.setVisible(false);
        exchangeRabbit.setVisible(false);
        exchangeSheep.setVisible(false);
        exchangeSheepDown.setVisible(false);
        throwComputer.setVisible(false);
        throwDice.setVisible(false);
        comunication.setVisible(false);
        exchangeToSmallDog.setVisible(false);
        exchangeToBigDog.setVisible(false);

        starGameWithOneRabbit.setText("START");
        startGameWithNothing.setText("START");
        exchangeRabbit.setText("6 RABBIT = 1 SHEEP");
        throwDice.setText("THROW DICE");
        throwComputer.setText("FINISH YOUR MOVE");
        exchangeRabbit.setText("6 RABBIT = 1 SHEEP");
        exchangeSheep.setText("3 SHEEP = 1 PIG");
        exchangePigDown.setText("1 PIG = 3 SHEEP");
        exchangeSheepDown.setText("1 SHEEP = 6 RABBITS");
        exchangeCow.setText("2 PIG = 1 COW");
        exchangeCowDown.setText("1 COW = 2 PIGS");
        exchangeHorse.setText("2 COW = 1 HORSE");
        exchangeHorseDown.setText("1 HORSE = 2 COW");
        comunication.setText("User Move");
        exchangeToSmallDog.setText("6 RABBITS = 1 SMALL DOG");
        exchangeToBigDog.setText("1 COW = 1 BIG DOG");

        throwDice.setOnAction((e) -> {
            if (moveControler == true && userWinner == false) {

                Dice dice = new Dice();
                Animal orange = dice.orangeDice();
                Animal blue = dice.blueDice();
                orangeDice.setText(String.valueOf(orange));
                blueDice.setText(String.valueOf(blue));
                userListAfterGreeding = userAnimalList.greedingUser(userList, orange, blue,smallDog,bigDog);
                userWinner = userAnimalList.checkAnimalsInCollection(userListAfterGreeding);
                comunication.setText("Computer Move");

                if (userWinner == true) {
                    System.out.println("User WON!!!");
                    Background backgroundYou = new Background(backgroundYouWon);
                    grid.setBackground(backgroundYou);
                    throwDice.setText("GAME OVER");
                    comunication.setText("YOU WON");
                    exchangeCow.setVisible(false);
                    exchangeCowDown.setVisible(false);
                    exchangeHorse.setVisible(false);
                    exchangeHorseDown.setVisible(false);
                    exchangePigDown.setVisible(false);
                    exchangeRabbit.setVisible(false);
                    exchangeSheep.setVisible(false);
                    exchangeSheepDown.setVisible(false);
                    throwComputer.setVisible(false);
                    throwDice.setVisible(false);
                    comunication.setVisible(false);
                    comunication.setVisible(false);
                    blueDice.setVisible(false);
                    orangeDice.setVisible(false);
                    orangeDiceComputer.setVisible(false);
                    blueDiceComputer.setVisible(false);
                    qCowsCom.setVisible(false);
                    qCows.setVisible(false);
                    qPigsCom.setVisible(false);
                    qPigs.setVisible(false);
                    qSheepsCom.setVisible(false);
                    qSheeps.setVisible(false);
                    qRabbitsCom.setVisible(false);
                    qRabbits.setVisible(false);
                    qHorses.setVisible(false);
                    qHorsesCom.setVisible(false);
                }

                System.out.println("User after greeding has " + userListAfterGreeding.size() + " animals");
                System.out.println("------------------------------------------------------------------------");
                qRabbits.setText("RABBITS: " + String.valueOf(Collections.frequency(userListAfterGreeding, Animal.RABBIT)));
                qSheeps.setText("SHEEP: " + String.valueOf(Collections.frequency(userListAfterGreeding, Animal.SHEEP)));
                qPigs.setText("PIGS: " + String.valueOf(Collections.frequency(userListAfterGreeding, Animal.PIG)));
                qCows.setText("COWS: " + String.valueOf(Collections.frequency(userListAfterGreeding, Animal.COW)));
                qHorses.setText("HORSES: " + String.valueOf(Collections.frequency(userListAfterGreeding, Animal.HORSE)));
                moveControler = false;
                System.out.println("Movecontroler:" + moveControler);
                throwComputer.setVisible(true);
                throwDice.setVisible(false);
            } else {
                throwDice.setText("GAME OVER");
                comunication.setText("YOU WON");
            }
        });
        throwComputer.setOnAction((e) -> {
            if (!moveControler && getWinnerComputer.get() == false) {
                comunication.setText("User move");
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
                    comunication.setText("Computer WON!!!");
                    Background backgroundComputer = new Background(backgroundComputerWon);
                    grid.setBackground(backgroundComputer);
                    exchangeCow.setVisible(false);
                    exchangeCowDown.setVisible(false);
                    exchangeHorse.setVisible(false);
                    exchangeHorseDown.setVisible(false);
                    exchangePigDown.setVisible(false);
                    exchangeRabbit.setVisible(false);
                    exchangeSheep.setVisible(false);
                    exchangeSheepDown.setVisible(false);
                    throwComputer.setVisible(false);
                    throwDice.setVisible(false);
                    throwDice.setVisible(false);
                    comunication.setVisible(false);
                    blueDice.setVisible(false);
                    orangeDice.setVisible(false);
                    orangeDiceComputer.setVisible(false);
                    blueDiceComputer.setVisible(false);
                    qCowsCom.setVisible(false);
                    qCows.setVisible(false);
                    qPigsCom.setVisible(false);
                    qPigs.setVisible(false);
                    qSheepsCom.setVisible(false);
                    qSheeps.setVisible(false);
                    qRabbitsCom.setVisible(false);
                    qRabbits.setVisible(false);
                    qHorses.setVisible(false);
                    qHorsesCom.setVisible(false);

                }
                System.out.println("Computer after greeding has " + computerListAfterGreeding.size() + " animals");

                qRabbitsCom.setText("RABBITS: " + String.valueOf(Collections.frequency(computerListAfterGreeding, Animal.RABBIT)));
                qSheepsCom.setText("SHEEP: " + String.valueOf(Collections.frequency(computerListAfterGreeding, Animal.SHEEP)));
                qPigsCom.setText("PIGS: " + String.valueOf(Collections.frequency(computerListAfterGreeding, Animal.PIG)));
                qCowsCom.setText("COWS: " + String.valueOf(Collections.frequency(computerListAfterGreeding, Animal.COW)));
                qHorsesCom.setText("HORSES: " + String.valueOf(Collections.frequency(computerListAfterGreeding, Animal.HORSE)));
                System.out.println("------------------------------------------------------------------------");
                moveControler = true;
                System.out.println("Movecontroler:" + moveControler);
                throwComputer.setVisible(false);
                throwDice.setVisible(true);
            } else {
                throwDice.setText("GAME OVER");
                comunication.setText("COMPUTER WON");
            }
        });
        exchangeRabbit.setOnAction((e) -> {
            try {
                if (Collections.frequency(userListAfterGreeding, Animal.RABBIT) > 6) {
                    userListAfterGreeding.add(Animal.SHEEP);
                    for (int n = 0; n < 6; n++) {
                        userListAfterGreeding.remove(Animal.RABBIT);
                    }
                    System.out.println("Exchanged 6 RABBITS TO 1 SHEEP");
                    qSheeps.setText("SHEEP: " + String.valueOf(Collections.frequency(userListAfterGreeding, Animal.SHEEP)));
                    qRabbits.setText("RABBITS: " + String.valueOf(Collections.frequency(userListAfterGreeding, Animal.RABBIT)));
                }
            }catch (Exception e1){
                System.out.println("You don't have enough animals");
            }
        });
        exchangeSheep.setOnAction((e) -> {
            try {
                if (Collections.frequency(userListAfterGreeding, Animal.SHEEP) > 3) {
                    userListAfterGreeding.add(Animal.PIG);
                    userListAfterGreeding.remove(Animal.SHEEP);
                    userListAfterGreeding.remove(Animal.SHEEP);
                    userListAfterGreeding.remove(Animal.SHEEP);
                    qSheeps.setText("SHEEP: " + String.valueOf(Collections.frequency(userListAfterGreeding, Animal.SHEEP)));
                    qPigs.setText("PIGS: " + String.valueOf(Collections.frequency(userListAfterGreeding, Animal.PIG)));
                    System.out.println("Exchanged 3 SHEEP TO 1 PIG");
                }
            } catch (Exception e1){
                System.out.println("You don't have enough animals");
            }
        });
        exchangePigDown.setOnAction((e) -> {
            try {
                if (Collections.frequency(userListAfterGreeding, Animal.PIG) > 1) {
                    userListAfterGreeding.remove(Animal.PIG);
                    userListAfterGreeding.add(Animal.SHEEP);
                    userListAfterGreeding.add(Animal.SHEEP);
                    userListAfterGreeding.add(Animal.SHEEP);
                    qSheeps.setText("SHEEP: " + String.valueOf(Collections.frequency(userListAfterGreeding, Animal.SHEEP)));
                    qPigs.setText("PIGS: " + String.valueOf(Collections.frequency(userListAfterGreeding, Animal.PIG)));
                    System.out.println("Exchanged 1 PIG TO 3 SHEEP");
                }
            }catch (Exception e1){
                System.out.println("You don't have enough animals");
            }
        });
        exchangeSheepDown.setOnAction((e) -> {
            try {
                if (Collections.frequency(userListAfterGreeding, Animal.SHEEP) > 1) {
                    userListAfterGreeding.remove(Animal.SHEEP);
                    userListAfterGreeding.add(Animal.RABBIT);
                    userListAfterGreeding.add(Animal.RABBIT);
                    userListAfterGreeding.add(Animal.RABBIT);
                    userListAfterGreeding.add(Animal.RABBIT);
                    userListAfterGreeding.add(Animal.RABBIT);
                    userListAfterGreeding.add(Animal.RABBIT);

                    System.out.println("Exchanged 1 SHEEP TO 6 RABBITS");
                    qSheeps.setText("SHEEP: " + String.valueOf(Collections.frequency(userListAfterGreeding, Animal.SHEEP)));
                    qRabbits.setText("RABBITS: " + String.valueOf(Collections.frequency(userListAfterGreeding, Animal.RABBIT)));
                }
            }catch (Exception e1){
                System.out.println("You don't have enough animals");
            }
        });
        exchangeCow.setOnAction((e) -> {
            if (Collections.frequency(userListAfterGreeding, Animal.PIG) > 2) {
                userListAfterGreeding.add(Animal.COW);
                userListAfterGreeding.remove(Animal.PIG);
                userListAfterGreeding.remove(Animal.PIG);
                System.out.println("Exchanged 2 PIG TO 1 COW");
                qPigs.setText("PIGS: " + String.valueOf(Collections.frequency(userListAfterGreeding, Animal.PIG)));
                qCows.setText("COWS: " + String.valueOf(Collections.frequency(userListAfterGreeding, Animal.COW)));

            }
        });
        exchangeCowDown.setOnAction((e) -> {
            if (Collections.frequency(userListAfterGreeding, Animal.COW) > 1) {
                userListAfterGreeding.remove(Animal.COW);
                userListAfterGreeding.add(Animal.PIG);
                userListAfterGreeding.add(Animal.PIG);
                System.out.println("Exchanged 2 COW TO 2 PIGS");
                qPigs.setText("PIGS: " + String.valueOf(Collections.frequency(userListAfterGreeding, Animal.PIG)));
                qCows.setText("COWS: " + String.valueOf(Collections.frequency(userListAfterGreeding, Animal.COW)));

            }
        });
        exchangeHorse.setOnAction((e) -> {
            if (Collections.frequency(userListAfterGreeding, Animal.COW) > 2) {
                userListAfterGreeding.add(Animal.HORSE);
                userListAfterGreeding.remove(Animal.COW);
                userListAfterGreeding.remove(Animal.COW);
                System.out.println("Exchanged 2 COW TO 1 HORSE");
                qCows.setText("COWS: " + String.valueOf(Collections.frequency(userListAfterGreeding, Animal.COW)));
                qHorses.setText("HORSES: " + String.valueOf(Collections.frequency(userListAfterGreeding, Animal.HORSE)));

            }

        });
        exchangeHorseDown.setOnAction((e) -> {
            if (Collections.frequency(userListAfterGreeding, Animal.HORSE) > 1) {
                userListAfterGreeding.remove(Animal.HORSE);
                userListAfterGreeding.add(Animal.COW);
                userListAfterGreeding.add(Animal.COW);
                System.out.println("Exchanged 1 HORSE TO 2 COWS");
                qCows.setText("COWS: " + String.valueOf(Collections.frequency(userListAfterGreeding, Animal.COW)));
                qHorses.setText("HORSES: " + String.valueOf(Collections.frequency(userListAfterGreeding, Animal.HORSE)));

            }
        });
        starGameWithOneRabbit.setOnAction((e) -> {
            Menu menu = new Menu();
            menu.startWithRabbit(userList);
            menu.startWithRabbit(computerList);
            starGameWithOneRabbit.setVisible(false);
            startGameWithNothing.setVisible(false);
            exchangeCow.setVisible(true);
            exchangeCowDown.setVisible(true);
            exchangeHorse.setVisible(true);
            exchangeHorseDown.setVisible(true);
            exchangePigDown.setVisible(true);
            exchangeRabbit.setVisible(true);
            exchangeSheep.setVisible(true);
            exchangeSheepDown.setVisible(true);
            throwComputer.setVisible(false);
            throwDice.setVisible(true);
            comunication.setVisible(true);
            exchangeToSmallDog.setVisible(true);
            Background background1 = new Background(backgroundImage1);
            grid.setBackground(background1);

        });
        startGameWithNothing.setOnAction((e) -> {
            startGameWithNothing.setVisible(false);
            starGameWithOneRabbit.setVisible(false);
            exchangeCow.setVisible(true);
            exchangeCowDown.setVisible(true);
            exchangeHorse.setVisible(true);
            exchangeHorseDown.setVisible(true);
            exchangePigDown.setVisible(true);
            exchangeRabbit.setVisible(true);
            exchangeSheep.setVisible(true);
            exchangeSheepDown.setVisible(true);
            throwComputer.setVisible(true);
            throwDice.setVisible(true);
            comunication.setVisible(true);
            exchangeToSmallDog.setVisible(true);
            Background background1 = new Background(backgroundImage1);
            grid.setBackground(background1);
        });
        exchangeToSmallDog.setOnAction((e)->{
            try {
                if (Collections.frequency(userListAfterGreeding, Animal.RABBIT) >= 6) {
                    userListAfterGreeding.remove(Animal.RABBIT);
                    userListAfterGreeding.remove(Animal.RABBIT);
                    userListAfterGreeding.remove(Animal.RABBIT);
                    userListAfterGreeding.remove(Animal.RABBIT);
                    userListAfterGreeding.remove(Animal.RABBIT);
                    userListAfterGreeding.remove(Animal.RABBIT);
                    smallDog = true;
                    smallDogLabel.setText("SMALL DOG");
                    qRabbits.setText("RABBITS: " + String.valueOf(Collections.frequency(userListAfterGreeding, Animal.RABBIT)));

                }
            }catch (Exception e1){
                System.out.println("You do not have 6 RABBITS to exchange");
            }
        });
        exchangeToBigDog.setOnAction((e)->{
            try {
                if (Collections.frequency(userListAfterGreeding, Animal.COW) >= 2) {
                    userListAfterGreeding.remove(Animal.COW);
                    userListAfterGreeding.remove(Animal.COW);
                    bigDog = true;
                }
            }catch (Exception e1){
                System.out.println("You do not have 2 COWS to exchange");
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

                add(new ColumnConstraints(250)); // 4
        grid.getColumnConstraints().

                add(new ColumnConstraints(200)); // 5
        grid.getColumnConstraints().

                add(new ColumnConstraints(200)); // 6
        grid.getColumnConstraints().

                add(new ColumnConstraints(200)); // 7
        grid.getColumnConstraints().

                add(new ColumnConstraints(200)); // 8
        grid.getColumnConstraints().

                add(new ColumnConstraints(80)); // 9
        grid.getColumnConstraints().

                add(new ColumnConstraints(80)); // 10
        grid.getColumnConstraints().

                add(new ColumnConstraints(80)); // 11
        grid.getColumnConstraints().

                add(new ColumnConstraints(80)); // 12
        grid.getColumnConstraints().

                add(new ColumnConstraints(80)); // 13
        grid.getColumnConstraints().

                add(new ColumnConstraints(80)); // 14
        grid.getRowConstraints().

                add(new RowConstraints(100)); // 1
        grid.getRowConstraints().

                add(new RowConstraints(100)); //2
        grid.getRowConstraints().

                add(new RowConstraints(50)); // 3
        grid.getRowConstraints().

                add(new RowConstraints(50)); //4
        grid.getRowConstraints().

                add(new RowConstraints(50)); // 4
        grid.getRowConstraints().

                add(new RowConstraints(52)); // 5
        grid.getRowConstraints().

                add(new RowConstraints(50)); // 6
        grid.getRowConstraints().

                add(new RowConstraints(50)); // 7


        grid.add(throwDice, 0, 1);
        grid.add(throwComputer, 0, 2);
        grid.add(orangeDice, 2, 1);
        grid.add(blueDice, 3, 1);
        grid.add(orangeDiceComputer, 5, 1);
        grid.add(blueDiceComputer, 6, 1);
        grid.add(comunication, 4, 5, 3, 1);
        grid.add(exchangeRabbit, 5, 12);
        grid.add(exchangeCow, 5, 11);
        grid.add(exchangeHorse, 5, 10);
        grid.add(exchangePigDown, 5, 9);
        grid.add(exchangeSheep, 5, 13);
        grid.add(exchangeCowDown, 5, 14);
        grid.add(exchangeHorseDown, 5, 15);
        grid.add(exchangeSheepDown, 5, 8);
        grid.add(exchangeToSmallDog, 5,16);
        grid.add(qRabbits, 1, 5);
        grid.add(qSheeps, 1, 6);
        grid.add(qPigs, 1, 7);
        grid.add(qCows, 1, 8);
        grid.add(qHorses, 1, 9);
        grid.add(qRabbitsCom, 7, 5);
        grid.add(qSheepsCom, 7, 6);
        grid.add(qPigsCom, 7, 7);
        grid.add(qCowsCom, 7, 8);
        grid.add(qHorsesCom, 7, 9);
        grid.add(starGameWithOneRabbit, 2, 7);
        grid.add(startGameWithNothing, 7, 7);
        grid.add(smallDogLabel, 1,3);
        grid.add(bigDogLabel, 1,4);


        Scene scene = new Scene(grid, 1600, 900, Color.YELLOW);

        primaryStage.setTitle("SuperFarmer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}


