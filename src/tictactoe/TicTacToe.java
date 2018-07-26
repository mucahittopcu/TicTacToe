package tictactoe;

import java.io.*;
import java.util.*;

public class TicTacToe 
{
    public static void main(String[] args) throws IOException  
    {   
        Scanner key=new Scanner(System.in);
        int boyut;
        char [][] oyunTahtasi = null;
        
        Oyuncu computer =new Oyuncu(false);
        Oyuncu oyunc=new Oyuncu(true);
       
        File savegame=new File("savegame.txt");
        File savegame1=new File("savegame1.txt");
        //oyun kaydı kontrolü
        if(savegame.exists() && savegame1.exists())
        {   
            System.out.println("Kayıtlı Oyun Bulundu...");
            System.out.println("Kayıtlı Oyundan Devam Etmek İster Misiniz?..(EVET=1 // HAYIR=2)");
            int a1;
            a1=key.nextInt();
            //Oyuncu kayıtlı oyundan devam etmek isterse..
            if(a1==1)
            {
                try
                {
                    File f = new File("savegame1.txt");
                    FileReader fr;
                    fr = new FileReader(f);
                    BufferedReader br = new BufferedReader(fr);
                    String satir;
                    String[] dizi1=new String[3];
                    int j = 0,k=0;
                    //Oyuncu ismi, harfi ve tahta boyutu dosyadan çekiliyor
                    try
                    {
                        File file = new File("savegame.txt");
                        BufferedReader reader = null;
                        reader = new BufferedReader(new FileReader(file));
                        String satir1 = reader.readLine();
                        int i=0;
                        while (satir1!=null)
                        {
                            dizi1[i]=satir1;
                            i++;
                            satir1 = reader.readLine();
                        }
 
                    }catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                    int boyut1=Integer.parseInt(dizi1[2]);
                    char[][] x = new char[boyut1][boyut1];
                    //Kayıtlı oyun tahtası dosyadan çekiliyor
                    try
                    {
                        // bos satır olana kadar dosyayı oku
                        while ((satir = br.readLine()) != null) 
                        {
                            System.out.println(satir);
                            // satirlari bosluklara gore bol
                            StringTokenizer st = new StringTokenizer(satir);
                        
                            while (st.hasMoreElements()) 
                            {
                                // dosyadan her satırı okuyup bır dızıye ata
                                for(int i=0;i<boyut1;i++)
                                {
                                    char[] dizi=(st.nextElement().toString()).toCharArray();
                                    x[k][i]=dizi[0];
                                
                                }
                                k++;
                                j++;
                            }
                        }
                        //Oyun tahtası, isim ve harf oyuna aktarılıyor..
                        oyunTahtasi=x;
                        char[] harf1=dizi1[1].toCharArray();
                        oyunc.karakterdegistir(harf1[0]);
                        oyunc.oyuncuismidegistir(dizi1[0]);
                        if(oyunc.karakteriAl()=='X')
                        {
                            computer.karakterdegistir('O');
                        }
                        else
                        {
                            computer.karakterdegistir('X');
                        }
                    
                    }catch(IOException e)
                    {
                        e.printStackTrace();
                    }
                    
                }
                catch(FileNotFoundException e)
                {
                    e.printStackTrace();
                }
            
            }
            else
            {
                //Kayıt var ama kayıttan çekmek istemezse...
                System.out.print("Oyun Tahtasının Boyutunu Giriniz( 3, 5 veya 7 ): ");
                boyut=key.nextInt();
                boyut++;
                oyunTahtasi=new char[boyut][boyut];
                
                for(int i=0;i<oyunTahtasi.length;i++)
                {
                    for(int j=0;j<oyunTahtasi.length;j++)
                    {   
                        if(i==0){
                            String a=Integer.toString(j);
                            char[] kenar1=a.toCharArray();
                            oyunTahtasi[i][j]=kenar1[0];
                            
                        }else if(j==0){
                            String a12=Integer.toString(i);
                            char[] kenar2=a12.toCharArray();
                            oyunTahtasi[i][j]=kenar2[0];
                            
                        }else{
                            oyunTahtasi[i][j]='-';
                        }
                        
                    }
                }
                
                char girDeger;
                System.out.println("X ve O seçicek misiniz?(Evet=1 // Hayır=2)");
                int a=key.nextInt();
                //X-O seçimi
                if(a==1)
                {
                    System.out.println("Seçiniz...");
                    girDeger=key.next().charAt(1);
                    oyunc.karakterdegistir(girDeger);
            
                    System.out.print("İsminizi Giriniz: ");
                    oyunc.oyuncuismidegistir(key.next());
            
                    if(oyunc.karakteriAl()=='X'){
                        computer.karakterdegistir('O');
                    }
                    else
                    {
                        computer.karakterdegistir('X');
                    }
                }
                //Otomatik X-O seçimi
                else if(a==2)
                {
                    System.out.print("İsminizi Giriniz: ");
                    oyunc.oyuncuismidegistir(key.next());
                    
                }
                
            }
            
        }
        else
        {
            //Kayıt Yoksa..  
            System.out.print("Oyun Tahtasının Boyutunu Giriniz( 3, 5 veya 7 ): ");
            boyut=key.nextInt();
            boyut++;
            oyunTahtasi=new char[boyut][boyut];
            for(int i=0;i<oyunTahtasi.length;i++)
            {
                for(int j=0;j<oyunTahtasi.length;j++)
                {
                    if(i==0)
                    {
                        String a=Integer.toString(j);
                        char[] kenar1=a.toCharArray();
                        oyunTahtasi[i][j]=kenar1[0];
                        
                    }else if(j==0)
                    {
                        String a12=Integer.toString(i);
                        char[] kenar2=a12.toCharArray();
                        oyunTahtasi[i][j]=kenar2[0];
                        
                    }else
                    {
                        oyunTahtasi[i][j]='-';
                    }
                }
            }
            char girDeger;
            System.out.println("X ve O seçicek misiniz?(Evet=1 // Hayır=2)");
            int a=key.nextInt();
            //X-O seçimi
            if(a==1)
            {
                System.out.println("Seçiniz...");
                girDeger=key.next().charAt(0);
                oyunc.karakterdegistir(girDeger);
                System.out.print("İsminizi Giriniz: ");
                oyunc.oyuncuismidegistir(key.next());
                if(oyunc.karakteriAl()=='X')
                {
                    computer.karakterdegistir('O');
                }
                else
                {
                    computer.karakterdegistir('X');
                }
            }
            //Otomatik X-O seçimi
            else if(a==2)
            {
                System.out.print("İsminizi Giriniz: ");
                oyunc.oyuncuismidegistir(key.next());
                computer.karakterdegistir('O');
            }    
        }
        
        OyunTahtasi tahta=new OyunTahtasi(oyunTahtasi);
        System.out.println("Lütfen Çıkış Yapmak İstediğinizde E 'ye basınız...");
        System.out.println("\n"+oyunc.oyuncuisimAl()+" 'in Seçtiği: "+oyunc.karakteriAl()+" // Bilgisayarın Seçtiği: "+ computer.karakteriAl());
        tahta.oyunTahtasiniYazdir();
        
        //Oyunun gerçeklendiği kısım
        for(int i=0;i<((oyunTahtasi.length-1)*(oyunTahtasi.length-1));i++)
        {   
            //Oyuncu hareketleri
            if(i%2==0)
            {
                oyunc.insanOyuncuHamlesiniKotrol();
                //Eğer hamle yaparken çıkmak isterse
                if(oyunc.oyuncununHamlesiniAl().equals("E"))
                {
                    System.out.println("Kaydetmek İster Misiniz? (E veya H) ");
                    String kaydet=key.next();
                    if(kaydet.equals("E"))
                    {
                        //Kayıt etmek istediğindeki dosya işlemleri
                        //Oyuncu ismi, harfi ve tahta boyutu savagame.txt dosyasına yazılır
                        try
                        {
                            FileWriter fileWriter = new FileWriter("savegame.txt");
                            PrintWriter dosyayaz=new PrintWriter(fileWriter);
                             
                            dosyayaz.println(oyunc.oyuncuisimAl());
                            dosyayaz.println(oyunc.karakteriAl());
                            dosyayaz.println(oyunTahtasi.length);
                            
                            dosyayaz.close();
                        
                        }catch(IOException e)
                        {  
                            System.out.println("Hata!");    
                        }
                        //Oyun tahtası da savegame1.txt dosyasına yazılır
                        try
                        {
                            FileWriter fileWriter = new FileWriter("savegame1.txt");
                            PrintWriter dosyayaz=new PrintWriter(fileWriter);
                            
                            char [][] matris=new char[tahta.oyunTahtasiniAl().length][tahta.oyunTahtasiniAl().length];
                            matris = tahta.oyunTahtasiniAl();
                            for(int k=0;k<tahta.oyunTahtasiniAl().length;k++)
                            {
                                for(int j=0;j<tahta.oyunTahtasiniAl().length;j++)
                                {
                                    dosyayaz.print(matris[k][j]+ " ");
                                }
                                dosyayaz.println();
                            }
                           
                            System.out.println("Oyun Kaydedildi.");
                            dosyayaz.close();
                        }
                        catch(IOException e)
                        {   
                            System.out.println("Hata!");
                        }
                        System.exit(0);
                    }
                    //Çıkarken kayıt etmek istemezse
                    else if(kaydet.equals("H"))
                    {
                        System.out.println("Oyun Kaydedilmeden Çıkıldı!");
                        System.exit(0);
                    }
                }
                //Girilen koordinatın dolu olup olmaığı kontrolü
                while(tahta.hamleyiYaz(oyunc.oyuncununHamlesiniAl(), oyunc.karakteriAl())==false )
                {
                    System.out.println("Girilen Koordinat Dolu!");
                    System.out.println("Lütfen Tekrar Deneyiniz...");
                    oyunc.insanOyuncuHamlesiniKotrol(); 
                }
                tahta.oyunTahtasiniYazdir();
                System.out.println("<<<<<<<<<<<>>>>>>>>>>>");
                if(tahta.kazanan(oyunc.karakteriAl())==true)
                {
                    System.out.println("Tebrikler "+oyunc.oyuncuisimAl());
                    System.out.println("Siz Kazandınız :)");
                    break;
                }
                if(tahta.berabere()==true && tahta.kazanan(oyunc.karakteriAl())==false)
                {
                    System.out.println("Berabere Kaldınız.");
                    break;
                }
                
            }
            //Bilgisayarın hareketleri
            else
            {
                computer.bilgisayarHamlesiUret(tahta.oyunTahtasiniAl().length);
                System.out.println("Bilgisayar Oynuyor...");
                while(tahta.hamleyiYaz(computer.oyuncununHamlesiniAl(), computer.karakteriAl())==false)
                {
                    computer.bilgisayarHamlesiUret(tahta.oyunTahtasiniAl().length);
                }
                tahta.oyunTahtasiniYazdir();
                System.out.println("<<<<<<<<<<<>>>>>>>>>>>");
                if(tahta.kazanan(computer.karakteriAl())==true)
                {
                    System.out.println("Üzgünüz Kaybettiniz :( ");
                    break;
                }
                if(tahta.berabere()==true && tahta.kazanan(computer.karakteriAl())==false )
                {
                    System.out.println("Berabere Kaldınız.");
                    break;
                }
            }
        }
    } 
}