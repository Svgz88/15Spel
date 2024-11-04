import javax.swing.*;
import java.awt.*;

public class HuvudProgram extends JFrame {
    SpelLogik slogik = new SpelLogik();

    JPanel panel1 = new JPanel();
    JButton[] knappar = new JButton[16];
    int emptyKnapp = 15;

    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();

    JButton blandaKnapp = new JButton("Nytt spel");

    private HuvudProgram() {
        add(panel1);
        panel1.setLayout(new BorderLayout());
        panel1.add(panel2, BorderLayout.NORTH);
        panel1.add(panel3, BorderLayout.CENTER);

        panel2.add(blandaKnapp);

        panel3.setLayout(new GridLayout(4, 4));
        for (int i = 0; i < knappar.length; i++) {
            if (i < 15) {
                //Skriver knappars nummer.
                //Knappar[i] = new JButton(String.valueOf("Knapp "+(i+1)));
                //Funka likadan som raden ovanför.
                knappar[i] = new JButton(String.valueOf((i + 1)));
            } else {
                knappar[i] = new JButton("");
            }
            panel3.add(knappar[i]);

            //Kollar om den tryckta knappen är bredvid den tomma och ?
            int finalI = i;
            knappar[i].addActionListener(l -> {
                if (l.getSource() == knappar[finalI]) {
                    if (slogik.BredvidKnapp(finalI, emptyKnapp)) {
                        knappar[emptyKnapp].setText(knappar[finalI].getText());
                        knappar[finalI].setText("");
                        emptyKnapp = finalI;

                        if(slogik.VinnerSpel(knappar)){
                            JOptionPane.showMessageDialog(null, "Grattis! Du vann!");
                        }

                    }
                }
            });
        }
        //Blanda alla 16 knappar i slumpmässigt ordning.
        blandaKnapp.addActionListener(l -> {
            if (l.getSource() == blandaKnapp) {
                slogik.BlandaAllaKnappar(knappar);
                for (int i = 0; i < knappar.length; i++) {
                    if (knappar[i].getText().isEmpty()) {
                        emptyKnapp = i;
                    }

                }
            }
        });

        this.setTitle("Mitt nya spel 1.1 ");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(600, 350);
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new HuvudProgram();
    }
}
