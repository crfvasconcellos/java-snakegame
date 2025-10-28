import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame("Snake Game");
        InterfaceDoGame panel = new InterfaceDoGame();

        window.setSize(1080, 720);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(panel);
        window.setVisible(true);

        // Timer para atualizar o jogo
        Timer timer = new Timer(200, e -> {
            panel.moverCobras();
            panel.repaint();
        });
        timer.start();

        // KeyListener
        window.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent e) {
                int code = e.getKeyCode();

                // Cobra verde - WASD
                if (code == java.awt.event.KeyEvent.VK_W) panel.direcao1 = 'W';
                if (code == java.awt.event.KeyEvent.VK_S) panel.direcao1 = 'S';
                if (code == java.awt.event.KeyEvent.VK_A) panel.direcao1 = 'A';
                if (code == java.awt.event.KeyEvent.VK_D) panel.direcao1 = 'D';

                // Cobra azul - Numpad
                if (code == java.awt.event.KeyEvent.VK_NUMPAD8) panel.direcao2 = 'U';
                if (code == java.awt.event.KeyEvent.VK_NUMPAD5) panel.direcao2 = 'D';
                if (code == java.awt.event.KeyEvent.VK_NUMPAD4) panel.direcao2 = 'L';
                if (code == java.awt.event.KeyEvent.VK_NUMPAD6) panel.direcao2 = 'R';
            }
        });

        // Foco
        window.setFocusable(true);
        window.requestFocusInWindow();
    }
}
