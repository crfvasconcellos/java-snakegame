import javax.swing.*;
import java.awt.*;

public class InterfaceDoGame extends JPanel {
    // Pegador e paralisia
    boolean pegador1 = true;   // Verde começa como pegador
    boolean pegador2 = false;
    boolean paralisada1 = false;
    boolean paralisada2 = false;
    long tempoParalisa1 = 0;
    long tempoParalisa2 = 0;

    // Cooldown para troca de pegador
    long cooldownPegador1 = 0;
    long cooldownPegador2 = 0;

    int tamanho = 25;

    // Cobra verde
    int[] x1 = {100, 75, 50, 25};
    int[] y1 = {100, 100, 100, 100};
    char direcao1 = 'D';

    // Cobra azul
    int[] x2 = {100, 75, 50, 25};
    int[] y2 = {200, 200, 200, 200};
    char direcao2 = 'D';

    public void moverCobras() {
        long agora = System.currentTimeMillis();

        // Pega-pega com cooldown de 3s
        if (pegador1 && !paralisada2 && agora - cooldownPegador1 >= 3000 && colidiuComOutra(x1, y1, x2, y2)) {
            paralisada2 = true;        // azul paralisada
            tempoParalisa2 = agora;
            pegador1 = false;          // passa pegador
            pegador2 = true;
            cooldownPegador2 = agora;  // inicia cooldown
        }

        if (pegador2 && !paralisada1 && agora - cooldownPegador2 >= 3000 && colidiuComOutra(x2, y2, x1, y1)) {
            paralisada1 = true;
            tempoParalisa1 = agora;
            pegador2 = false;
            pegador1 = true;
            cooldownPegador1 = agora;
        }

        // Atualiza paralisia
        if (paralisada1 && agora - tempoParalisa1 >= 3000) paralisada1 = false;
        if (paralisada2 && agora - tempoParalisa2 >= 3000) paralisada2 = false;

        // Move cobra verde
        if (!paralisada1) {
            for (int i = x1.length - 1; i > 0; i--) {
                x1[i] = x1[i - 1];
                y1[i] = y1[i - 1];
            }
            switch (direcao1) {
                case 'W': if (y1[0] > 0) y1[0] -= tamanho; break;
                case 'S': if (y1[0] < getHeight() - tamanho) y1[0] += tamanho; break;
                case 'A': if (x1[0] > 0) x1[0] -= tamanho; break;
                case 'D': if (x1[0] < getWidth() - tamanho) x1[0] += tamanho; break;
            }
        }

        // Move cobra azul
        if (!paralisada2) {
            for (int i = x2.length - 1; i > 0; i--) {
                x2[i] = x2[i - 1];
                y2[i] = y2[i - 1];
            }
            switch (direcao2) {
                case 'U': if (y2[0] > 0) y2[0] -= tamanho; break;
                case 'D': if (y2[0] < getHeight() - tamanho) y2[0] += tamanho; break;
                case 'L': if (x2[0] > 0) x2[0] -= tamanho; break;
                case 'R': if (x2[0] < getWidth() - tamanho) x2[0] += tamanho; break;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Cobra verde
        g.setColor(Color.GREEN.darker());
        g.fillRect(x1[0], y1[0], tamanho, tamanho);
        g.setColor(Color.GREEN);
        for (int i = 1; i < x1.length; i++) g.fillRect(x1[i], y1[i], tamanho, tamanho);
        if (pegador1) {
            g.setColor(Color.RED);
            g.drawRect(x1[0], y1[0], tamanho, tamanho); // borda vermelha permanente
        }

        // Cobra azul
        g.setColor(Color.BLUE.darker());
        g.fillRect(x2[0], y2[0], tamanho, tamanho);
        g.setColor(Color.BLUE);
        for (int i = 1; i < x2.length; i++) g.fillRect(x2[i], y2[i], tamanho, tamanho);
        if (pegador2) {
            g.setColor(Color.RED);
            g.drawRect(x2[0], y2[0], tamanho, tamanho); // borda vermelha permanente
        }
    }

    public boolean colidiuComOutra(int[] xCobra, int[] yCobra, int[] xOutra, int[] yOutra) {
        for (int i = 0; i < xOutra.length; i++) {
            if (xCobra[0] == xOutra[i] && yCobra[0] == yOutra[i]) return true;
        }
        return false;
    }
}
