
package pkg4.proje;
import java.util.*;

public class oyuncu {
    Scanner scan=new Scanner(System.in);
    Random r=new Random();
    char hangiharf;
    boolean insanmı;
    String kullanıcıadı;
    int hamle;
    
    public oyuncu(){
        insanmı=true;
        hangiharf='X';
    }
    public oyuncu(boolean insanmıKontrol){
        insanmı=insanmıKontrol;
        if(insanmı==true){
            hangiharf='X';
        }
        else
            hangiharf='O';
    }
    public oyuncu(boolean insanmıKontrol,char kr){
        insanmı=insanmıKontrol;
        hangiharf=kr;
    }
    
    char karakteriAl(){
        return hangiharf;
    }
    boolean oyuncuTurunuAl(){
        return insanmı;
    }
    int insanOyuncuHamlesiniKontrol(int boyut){
        
            while(true){
             System.out.println("Sizin Sıranız Lütfen Koordinat Girin:");
            this.hamle=scan.nextInt();
            if(hamle/10<boyut && hamle%10<boyut && hamle/10>=0 && hamle%10>=0 && hamle <=77 || hamle==-1){
                break;
            }
        }
        
        return this.hamle;
    }
    int bilgisayarHamlesiUret(int boyut){
        int satir=r.nextInt(boyut);
        int sutun=r.nextInt(boyut);
        int hamle=satir*10+sutun;
 
        return hamle;
    }

}
