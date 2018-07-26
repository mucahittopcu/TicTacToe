package tictactoe;

import java.util.Random;
import java.util.Scanner;

class Oyuncu 
{
    char harf;
    boolean insanMi;
    String nick;
    String hamle;
    
    public Oyuncu()
    {
        this.insanMi =true;
        this.harf='X';
    }
    public Oyuncu(boolean insanmiKontrolu)
    {
        this.insanMi=insanmiKontrolu;
        if(this.insanMi=true)
        {
            this.harf='X';
        }
        else
        {
            this.harf='O';
        }
    }
    Oyuncu(boolean insanmiKontrolu, char kr)
    {
        this.insanMi=insanmiKontrolu;
        this.harf=kr;
    }
    void oyuncuismidegistir(String isim)
    {
        this.nick=isim;
    }
    String oyuncuisimAl()
    {
        return this.nick;
    }
    void karakterdegistir(char character){
        this.harf=character;
    }
    char karakteriAl()
    {
        return harf;
    }
    boolean  oyuncuTurunuAl()
    {
        return insanMi;
    }
    String oyuncununHamlesiniAl()
    {
        return hamle;
    }
    String  insanOyuncuHamlesiniKotrol() 
    {   
        Scanner key=new Scanner(System.in);
        System.out.print("Sıra Sizde: ");
        hamle = key.next();
        return hamle;
    }
    String  bilgisayarHamlesiUret(int boy)
    {
        int a,b;
        Random rnd = new Random();
        a = rnd.nextInt(boy-1);
        b = rnd.nextInt(boy-1);
        String a1=Integer.toString(a+1);
        String b1=Integer.toString(b+1);
        hamle= a1 + b1;
        return hamle;
    }
}