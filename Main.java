import javax.swing.*;

public class Main {
    public static void main(String[] args) {


    InterfaceDoGame game = new InterfaceDoGame();


        JFrame window = new JFrame("Snake Game");
        InterfaceDoGame panel = new InterfaceDoGame();

        window.add(panel);
        window.setSize(400, 400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);



    }
}
