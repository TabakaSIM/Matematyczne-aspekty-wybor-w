package MAW;

import java.util.ArrayList;

public class Indexes {
    int limit;
    ArrayList<Wyborca> listaWyborcow;


    public Indexes(int limit, int ... tab) {
        this.limit = limit;
        this.listaWyborcow = new ArrayList<Wyborca>();
        for(int i=0;i<tab.length;i++){
            listaWyborcow.add(new Wyborca(tab[i],i+1));
        }
    }

    public Indexes(int limit, ArrayList<Wyborca> listaKandydatow, int i) {
        this.limit = limit;
        this.listaWyborcow = new ArrayList<Wyborca>(listaKandydatow);
        this.listaWyborcow.remove(i);
    }

    public void calculate(){
        int points = 0;

        for(int i = 0; i<this.listaWyborcow.size(); i++){
            points += this.listaWyborcow.get(i).value;
        }

        System.out.println("Points for group with " + this.listaWyborcow.size() + "= " + points);

        for(int i = 0; i<this.listaWyborcow.size(); i++){
            if(points - this.listaWyborcow.get(i).value >= limit){
                new Indexes(limit, this.listaWyborcow, i).calculate();
            } else {
                this.listaWyborcow.get(i).addIndexSS(this.listaWyborcow.size()-1);
                System.out.println("Przyznano punkty wyborcy nr: " + this.listaWyborcow.get(i).nr + " w ilosci " + (this.listaWyborcow.size()-1) + "!");
            }
        }

    }

    public void printIndexSS(){
        for(int i = 0; i<this.listaWyborcow.size(); i++){
            System.out.println("Kandydat " + this.listaWyborcow.get(i).nr + ": " + this.listaWyborcow.get(i).indexSS);
        }
    }

}
