
package pkg4.proje;
import java.util.*;
import java.io.*;
 class Proje {
     File dosya = new File("oyun.txt");

    
    int boyut=0;
    int kayit=0;
    String okunanAd;
    String okunanHarf;
    char [][] t3=new char[3][3];
    char [][] t5=new char[5][5];
    char [][] t7=new char[7][7];
    
     
     public Proje() throws IOException{
         
        
        
        if (!dosya.exists()) {
            //System.out.println("\n(Main)Kayitli Oyun Yok!\n");
            this.kayit=-1;
        }
        
        else{
            //System.out.println("Dosya okundu.");
            this.kayit=1;
            
            FileReader dosyaokuyucu = new FileReader(dosya);
            String line;
            int i=0, j=0;

            try (BufferedReader tamponOkuyucu = new BufferedReader(dosyaokuyucu)) {
                
                
                  while ((line = tamponOkuyucu.readLine()) != "9") {
                    
                    if("9".equals(line))
                        break;
                    
                    this.boyut=Integer.parseInt(line);
                    //System.out.println("\n|"+this.boyut+"|");
                    
                    
                    
                }
                
                char [][] kayitlitahta=new char[boyut][boyut];
                
                
                while ((line = tamponOkuyucu.readLine()) !="10") {
                   
                    if("10".equals(line))
                        break;
                    
                    //System.out.println(line);
                    for(j=0; j<line.length();j++){
                       // System.out.println("\nGirildi ("+i+","+j+")");
                        kayitlitahta[i][j]=line.charAt(j);
                        //System.out.println("|"+kayitlitahta[i][j]+"|");
                       // System.out.println("\ncikildi("+i+","+j+")");
                    }
                    i++;
                    
                    
                    
                }
                
                if(boyut==3)
                    this.t3=kayitlitahta.clone();
                
                else if(boyut==5)
                    this.t5=kayitlitahta.clone();
                
                else if(boyut==7)
                    this.t7=kayitlitahta.clone();
                
                    
                
                
                while ((line = tamponOkuyucu.readLine()) != "11") {
                    
                    if("11".equals(line))
                        break;
                    
                    this.okunanAd=line;
                    //System.out.println("\n|"+this.okunanAd+"|");
                    
                    
                    
                }
                
                
                while ((line = tamponOkuyucu.readLine()) != "12") {
                    
                    if("12".equals(line))
                        break;
                    
                    this.okunanHarf=line;
                    //System.out.println("\n|"+this.okunanHarf+"|");
                    
                    
                    
                }
                
                
                
              
                

            }            
            
        }     
        
        
    }
     

   
    public static void main(String[] args) throws IOException {
        Scanner scan=new Scanner(System.in);
        Proje yeni = new Proje();
        
       
        
        int tahtaboyutu=1;
               
        String kullanıcıAdı="yeniOyuncu";
        String hangiharf="X";
        int secim=-1;
        int yenimi=-1;
        int kaydedilsinmi=-1;
        char[] hangiharf1;
        char hangiharfchar='X';
        char [][] k7=new char[7][7];
        
        
        if(yeni.kayit==1){
            System.out.println("Kayıtlı oyuna devam etmek için 1, yeni oyun için 2 giriniz: ");
            yenimi=scan.nextInt();
        }
            
        else if(yeni.kayit==-1){
            System.out.println("Kayıtlı oyun bulunamadı. Yeni oyun başlatılıyor...");
            System.out.println("(Oyundan çıkmak için -1 yazınız)\n");
            yenimi=2;
        }
        
        if(yenimi==1){
            System.out.println("Kayıtlı oyun açıldı. Oyuncu: "+yeni.okunanAd+" - Harf: "+yeni.okunanHarf);
            System.out.println("(Oyundan çıkmak için -1 yazınız)\n");
        }
        
        else if(yeni.kayit==1 && yenimi==2){
            System.out.println("Yeni oyun başlatılıyor...");
            System.out.println("(Oyundan çıkmak için -1 yazınız)\n");
        }
            
        
        
        
        //oyunTahtası oyun1=new oyunTahtası(tahtaboyutu,yenimi);
        
        if(yenimi==1 && yeni.kayit!=-1){
            
                //oyunTahtası oyun1=new oyunTahtası(tahtaboyutu,yenimi);
               
                kullanıcıAdı=yeni.okunanAd;
                hangiharf=yeni.okunanHarf;
                
                
                tahtaboyutu=yeni.boyut;
                //System.out.println("\n!!"+yeni.boyut);
                
                hangiharf1=hangiharf.toCharArray();
                hangiharfchar=hangiharf1[0];
                
                secim=1;
                
                for(int i=0; i<tahtaboyutu; i++){
                    for(int j=0; j<tahtaboyutu; j++){
                        if(tahtaboyutu==3)
                            k7[i][j]=yeni.t3[i][j];
                        
                        else if(tahtaboyutu==5)
                            k7[i][j]=yeni.t5[i][j];
                        
                        else if(tahtaboyutu==7)
                            k7[i][j]=yeni.t7[i][j];
                        //System.out.println("["+k7[i][j]+"]");
                    }
                    
                }
                
                
                
                
                
                
                //oyunTahtası oyun1=new oyunTahtası(k7,tahtaboyutu);
                
                
                /*
                if(tahtaboyutu==3)
                     oyunTahtası oyun2=new oyunTahtası(yeni.t3,tahtaboyutu);
                
                else if(tahtaboyutu==5)
                        
                else if(tahtaboyutu==7)
                
                */
            
        }
        
        else if(yenimi==2){
            
            System.out.println("Oyun Tahtasının Boyutunu Giriniz(Yalnızca 3,5 veya 7):");
            //KULLANICIDAN TAHTANIN BUYUKLUGUNU ALIR--------------------------------------------------------------
            while(true){
            tahtaboyutu=scan.nextInt();
            if(tahtaboyutu==3 || tahtaboyutu==5 || tahtaboyutu==7)
                break;
            else
                    System.out.println("Yanlış Giriş Yaptınız Yalnızca 3,5 veya 7 !!!");
            }
            //KULLANICNIN İSMİNİ ALIR-------------------------------------------------------------------
            System.out.println("Kullanıcı İsmi Giriniz:");
            kullanıcıAdı=scan.next();

            //HANGİ HARFİ KULLANACAĞINI ALIR-------------------------------------------------------------
            System.out.println("Kullanılacak Harfi Seçmek İster misiniz? (Evet ise 1 Hayır ise 0):");
            secim=scan.nextInt();
            if(secim==1){
            System.out.println("Hangi Harfi Kullanacaksınız(Yalnızca X veya O):");
            while(true){
                hangiharf=scan.next();
                hangiharf=hangiharf.toUpperCase();
                hangiharf1=hangiharf.toCharArray();
                hangiharfchar=hangiharf1[0];

                if(hangiharfchar=='X' || hangiharfchar=='O')
                    break;
                else
                    System.out.println("Yanlış Harf Girdiniz Yalnızca X veya O !!!!");
            }
            }
            
            //oyunTahtası oyun1=new oyunTahtası(tahtaboyutu,yenimi);
            
            
        }
        
        
        
        
         oyunTahtası oyun1=new oyunTahtası(tahtaboyutu);
         oyunTahtası oyun2=new oyunTahtası(k7,tahtaboyutu);
         
         if(yenimi==1)
             oyun1.oyuntahtası=oyun2.oyuntahtası;
         
         
         //-----------------------------------------------------------------------------------------------------------------------
         //KULLANICI HARF SEÇMEDİYSE BU KISIM ÇALIŞIR ----------------------------------------------------------------------------
         //-----------------------------------------------------------------------------------------------------------------------
         if(secim==0)
         System.out.println("\nHarf secilmedi.");
         
         while(secim==0){
        oyuncu insan=new oyuncu();
        oyuncu bilgisayar=new oyuncu(false);
             
         oyun1.oyunTahtasınıYazdır();
         oyun1.oyunuKaydet(kullanıcıAdı,hangiharf,tahtaboyutu);
         
        while(true){
            System.out.println("----------------------------------------------------------");
        int donen=insan.insanOyuncuHamlesiniKontrol(tahtaboyutu);
        
        if(donen==-1){
            System.out.println("Oyundan cikilacak. Kaydedilsin mi? (1:Evet - 0:Hayır)");
            while(true){
                kaydedilsinmi=scan.nextInt();
                if(kaydedilsinmi==1 || kaydedilsinmi==0)
                    break;
                else
                    System.out.println("Yenlış giriş, tekrar girin: ");
            }
            
            if(kaydedilsinmi==1)
                oyun1.oyunuKaydet(kullanıcıAdı,hangiharf,tahtaboyutu);
                
            System.exit(0);
        }
        
        while(oyun1.hamleyiYaz(donen/10,donen%10,insan.karakteriAl())==false){
            donen=insan.insanOyuncuHamlesiniKontrol(tahtaboyutu);
                if(donen==-1){
                System.out.println("Oyundan cikilacak. Kaydedilsin mi? (1:Evet - 0:Hayır)");
                while(true){
                    kaydedilsinmi=scan.nextInt();
                    if(kaydedilsinmi==1 || kaydedilsinmi==0)
                        break;
                    else
                        System.out.println("Yenlış giriş, tekrar girin: ");
                }

                if(kaydedilsinmi==1)
                    oyun1.oyunuKaydet(kullanıcıAdı,hangiharf,tahtaboyutu);

                System.exit(0);
            }
        }
            System.out.println("Kullanıcı "+kullanıcıAdı+" Hamle Yaptı:"+donen/10+" "+donen%10);
            
        oyun1.oyunTahtasınıYazdır();
        //oyun1.oyunuKaydet(kullanıcıAdı,hangiharf,tahtaboyutu);
        
        if(oyun1.kazanan(insan.hangiharf)){
                System.out.println("Kazanan:"+insan.karakteriAl());
                yeni.dosya.delete();
        break;
        }
        if(oyun1.beraberlikKontrol()){
            System.out.println("Berabere !!!");
            yeni.dosya.delete();
        break;
        }
            
        int donen2=bilgisayar.bilgisayarHamlesiUret(tahtaboyutu);  
       while(oyun1.hamleyiYaz(donen2/10,donen2%10,bilgisayar.karakteriAl())==false){
            donen2=bilgisayar.bilgisayarHamlesiUret(tahtaboyutu);
       }
           System.out.println();
        System.out.println("Bilgisayar Oynadı,Hamle:"+donen2/10+" "+donen2%10);
        
        oyun1.oyunTahtasınıYazdır();
        //oyun1.oyunuKaydet(kullanıcıAdı,hangiharf,tahtaboyutu);
        
        if(oyun1.kazanan(bilgisayar.hangiharf)){
                System.out.println("Kazanan:"+bilgisayar.karakteriAl());
                yeni.dosya.delete();
        break;
        }
        if(oyun1.beraberlikKontrol()){
            System.out.println("Berabere !!!");
            yeni.dosya.delete();
        break;
        }
        }
        System.exit(0);
         }
         
         //--------------------------------------------------------------------------------------------------------------------
         //KULLANICI HARF OALRAK X SEÇTİYSE BU KISIM ÇALIŞIR ------------------------------------------------------------------
         //--------------------------------------------------------------------------------------------------------------------
         
          while(secim==1 && hangiharfchar=='X'){
        oyuncu insan=new oyuncu();
        oyuncu bilgisayar=new oyuncu(false,'O');
       
         oyun1.oyunTahtasınıYazdır();
         //oyun1.oyunuKaydet(kullanıcıAdı,hangiharf,tahtaboyutu);
         
        while(true){
            System.out.println("----------------------------------------------------------");
        int donen=insan.insanOyuncuHamlesiniKontrol(tahtaboyutu);
           // System.out.println("|"+donen+"|");
        if(donen==-1){
            System.out.println("Oyundan cikilacak. Kaydedilsin mi? (1:Evet - 0:Hayır)");
            while(true){
                kaydedilsinmi=scan.nextInt();
                if(kaydedilsinmi==1 || kaydedilsinmi==0)
                    break;
                else
                    System.out.println("Yenlış giriş, tekrar girin: ");
            }
            
            if(kaydedilsinmi==1)
                oyun1.oyunuKaydet(kullanıcıAdı,hangiharf,tahtaboyutu);
                
            System.exit(0);
        }
        
       
        while(oyun1.hamleyiYaz(donen/10,donen%10,insan.karakteriAl())==false){
            donen=insan.insanOyuncuHamlesiniKontrol(tahtaboyutu); 
                if(donen==-1){
                System.out.println("Oyundan cikilacak. Kaydedilsin mi? (1:Evet - 0:Hayır)");
                while(true){
                    kaydedilsinmi=scan.nextInt();
                    if(kaydedilsinmi==1 || kaydedilsinmi==0)
                        break;
                    else
                        System.out.println("Yenlış giriş, tekrar girin: ");
                }

                if(kaydedilsinmi==1)
                    oyun1.oyunuKaydet(kullanıcıAdı,hangiharf,tahtaboyutu);

                System.exit(0);
            }
        }
            System.out.println("Kullanıcı "+kullanıcıAdı+" Hamle Yaptı:"+donen/10+" "+donen%10);
            
        oyun1.oyunTahtasınıYazdır();
        
        
        if(oyun1.kazanan(insan.hangiharf)){
                System.out.println("Kazanan:"+insan.karakteriAl());
                yeni.dosya.delete();
        break;
        }
        if(oyun1.beraberlikKontrol()){
            System.out.println("Berabere !!!");
            yeni.dosya.delete();
        break;
        }
            
        int donen2=bilgisayar.bilgisayarHamlesiUret(tahtaboyutu);  
        while(oyun1.hamleyiYaz(donen2/10,donen2%10,bilgisayar.karakteriAl())==false){
            donen2=bilgisayar.bilgisayarHamlesiUret(tahtaboyutu);
        }
           System.out.println();
        System.out.println("Bilgisayar Oynadı,Hamle:"+donen2/10+" "+donen2%10);
        
        oyun1.oyunTahtasınıYazdır();
        //oyun1.oyunuKaydet(kullanıcıAdı,hangiharf,tahtaboyutu);
        
        if(oyun1.kazanan(bilgisayar.hangiharf)){
                System.out.println("Kazanan:"+bilgisayar.karakteriAl());
                yeni.dosya.delete();
        break;
        }
        if(oyun1.beraberlikKontrol()){
            System.out.println("Berabere !!!");
            yeni.dosya.delete();
        break;
        }
        }
        System.exit(0);
         }
          //---------------------------------------------------------------------------------------------------------------
          //KULLANICI HARF OLARAK O SEÇTİYSE BU KISIM ÇALIŞIR--------------------------------------------------------------
          //---------------------------------------------------------------------------------------------------------------
          while(secim==1 && hangiharfchar=='O'){
        oyuncu insan=new oyuncu(true,'O');
        oyuncu bilgisayar=new oyuncu(false,'X');
       
         oyun1.oyunTahtasınıYazdır();
         //oyun1.oyunuKaydet(kullanıcıAdı,hangiharf,tahtaboyutu);
         
        while(true){
            System.out.println("----------------------------------------------------------");
        int donen=insan.insanOyuncuHamlesiniKontrol(tahtaboyutu);
        if(donen==-1){
            System.out.println("Oyundan cikilacak. Kaydedilsin mi? (1:Evet - 0:Hayır)");
            while(true){
                kaydedilsinmi=scan.nextInt();
                if(kaydedilsinmi==1 || kaydedilsinmi==0)
                    break;
                else
                    System.out.println("Yenlış giriş, tekrar girin: ");
            }
            
            if(kaydedilsinmi==1)
                oyun1.oyunuKaydet(kullanıcıAdı,hangiharf,tahtaboyutu);
                
            System.exit(0);
        }
        while(oyun1.hamleyiYaz(donen/10,donen%10,insan.karakteriAl())==false){
            donen=insan.insanOyuncuHamlesiniKontrol(tahtaboyutu);
                if(donen==-1){
                System.out.println("Oyundan cikilacak. Kaydedilsin mi? (1:Evet - 0:Hayır)");
                while(true){
                    kaydedilsinmi=scan.nextInt();
                    if(kaydedilsinmi==1 || kaydedilsinmi==0)
                        break;
                    else
                        System.out.println("Yenlış giriş, tekrar girin: ");
                }

                if(kaydedilsinmi==1)
                    oyun1.oyunuKaydet(kullanıcıAdı,hangiharf,tahtaboyutu);

                System.exit(0);
            }
        }
            System.out.println("Kullanıcı "+kullanıcıAdı+" Hamle Yaptı:"+donen/10+" "+donen%10);
            
        oyun1.oyunTahtasınıYazdır();
        //oyun1.oyunuKaydet(kullanıcıAdı,hangiharf,tahtaboyutu);
        
        if(oyun1.kazanan(insan.hangiharf)){
                System.out.println("Kazanan:"+insan.karakteriAl());
                yeni.dosya.delete();
        break;
        }
        if(oyun1.beraberlikKontrol()){
            System.out.println("Berabere !!!");
            yeni.dosya.delete();
        break;
        }
            
        int donen2=bilgisayar.bilgisayarHamlesiUret(tahtaboyutu);  
        while(oyun1.hamleyiYaz(donen2/10,donen2%10,bilgisayar.karakteriAl())==false){
             donen2=bilgisayar.bilgisayarHamlesiUret(tahtaboyutu);
        }
           System.out.println();
        System.out.println("Bilgisayar Oynadı,Hamle:"+donen2/10+" "+donen2%10);
        
        oyun1.oyunTahtasınıYazdır();
        //oyun1.oyunuKaydet(kullanıcıAdı,hangiharf,tahtaboyutu);
        
        if(oyun1.kazanan(bilgisayar.hangiharf)){
                System.out.println("Kazanan:"+bilgisayar.karakteriAl());
                yeni.dosya.delete();
        break;
        }
        if(oyun1.beraberlikKontrol()){
            System.out.println("Berabere !!!");
            yeni.dosya.delete();
        break;
        }
        }
        System.exit(0);
         }
 

    }
    
}
