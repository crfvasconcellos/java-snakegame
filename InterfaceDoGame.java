import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceDoGame extends JPanel implements ActionListener {

    int[] x = {100, 75, 50, 25}; // posições horizontais
    int[] y = {100, 100, 100, 100}; // posições verticais
    int tamanho = 25; // tamanho de cada quadrado




    @Override
    public void actionPerformed(ActionEvent e) {




    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // limpa o painel antes de desenhar

        // desenha a cabeça
        g.setColor(Color.GREEN.darker());
        g.fillRect(x[0], y[0], tamanho, tamanho);

        // desenha o corpo
        g.setColor(Color.GREEN);
        for (int i = 1; i < x.length; i++) {
            g.fillRect(x[i], y[i], tamanho, tamanho);
        }
    }



}
