import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class SpelLogik {
    //Numero 1
    public void BlandaAllaKnappar(JButton[] lista){
        ArrayList<Integer> blandaKnappar = new ArrayList<>();
        for(int i = 1; i < 16; i++){
            blandaKnappar.add(i);
        }
        blandaKnappar.add(0);
        // 1- 2 - 3 - 4-
        // 5 - 6 - 7 -8-
        // 9- 10- 11- 12-
        // 13- 14- 15- 0-
        Collections.shuffle(blandaKnappar);

        for(int i = 0; i < lista.length; i++){
            if(blandaKnappar.get(i) == 0){
                lista[i].setText("");
                System.out.println("Tom "+lista[i].getText());
                System.out.println("Index "+i);
            }else{
                lista[i].setText(String.valueOf(blandaKnappar.get(i)));
                System.out.println("Knapp "+lista[i].getText());
                System.out.println("Index "+i);
            }
        }
    }
    //Numero 2
    //Returnera true om knappen är intill varandra up/ner vänster/höger.
    public boolean BredvidKnapp(int siffraKnapp, int tomKnapp){
        //Al dividir x/4 == y/4 = true significa que x e y estan en la misma fila.
        //Valor absoluto de x - y == 1 significa que estan uno al lado del otro en la misma fila.

        //x % 4 == a y % 4 = true significa que los indices estan en la misma columna.
        //Valor absoluto de x - y == 4 significa que estan uno arriba del otro en la misma columna.
        return ((siffraKnapp/4 == tomKnapp/4) &&  Math.abs(siffraKnapp - tomKnapp) == 1) ||
                (siffraKnapp % 4 == tomKnapp % 4 && Math.abs(siffraKnapp - tomKnapp)== 4);
    }
    //Numero 3
    public boolean VinnerSpel(JButton[] lista){
        for(int i = 0; i < 15; i++){
            if(!lista[i].getText().equals(String.valueOf(i+1))){
                return false;
            }
        }return lista[15].getText().isEmpty();
    }
}
