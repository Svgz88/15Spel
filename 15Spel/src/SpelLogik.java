import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class SpelLogik {
    //numero 1
    public void initieraKnappar(JButton[] lista,JPanel panel){
        for(int i = 0; i < lista.length; i++){
            if(i < 15){
                lista[i] = new JButton(String.valueOf(i+1));
            }else{
                lista[15] = new JButton("");

            }panel.add(lista[i]);
        }
    }
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

            }else{
                lista[i].setText(String.valueOf(blandaKnappar.get(i)));
                System.out.println(lista[i].getText());
            }
        }
    }
    //Numero 2
    public boolean BredvidKnapp(int index1, int index2){
        return ((index1/4 == index2/4) &&  Math.abs(index1 - index2) == 1) ||
                (index1 % 4 == index2 % 4 && Math.abs(index1 - index2)== 4);
    }

    public boolean VinnerSpel(JButton[] lista){
        for(int i = 0; i < 15; i++){
            if(!lista[i].getText().equals(String.valueOf(i+1))){
                return false;
            }
        }return lista[15].getText().isEmpty();

    }
}
