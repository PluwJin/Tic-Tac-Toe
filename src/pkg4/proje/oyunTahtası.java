
package pkg4.proje;

import java.io.*;

public class oyunTahtası {
    char [][] oyuntahtası;
    String okunanHarf;
    String okunanAd;
    int boyut;
    
   
    
    public oyunTahtası(int boyut){
        this.boyut=boyut;
        oyuntahtası=new char[boyut][boyut];
        
        
            for(int i=0;i<boyut;i++){
                for(int j=0;j<boyut;j++){
                    oyuntahtası[i][j]='_';
                }
            }
            
        
        
        
        
    }
    public oyunTahtası(char[][] tahta, int boyut){/*DOLDUR*/
        this.boyut=boyut;
        oyuntahtası=new char[boyut][boyut];
        
        
            
            for(int i=0; i<boyut; i++){
                    for(int j=0; j<boyut; j++){
                        
                            oyuntahtası[i][j]=tahta[i][j];
                            //System.out.println("("+oyuntahtası[i][j]+")");
                        
                    }
                    
                }
    
    }
    
    char [][] oyunTahtasıAl(){
        return oyuntahtası;
    }
    
    void oyunTahtasınıYazdır(){
        System.out.print("  ");
        for(int i=0;i<boyut;i++){
            System.out.print(" "+i);
    
    }
        System.out.println();
        for(int i=0;i<boyut;i++){
            System.out.print(i+"  ");
            for(int j=0;j<boyut;j++){
                System.out.print(oyuntahtası[i][j]+" ");
            }
              System.out.println();
        }
    }
    
    
    
    void oyunuKaydet(String oyuncuAdi, String oyuncuHarfi,int byt) throws IOException{
        
    
        
        File dosya = new File("oyun.txt");
        if (!dosya.exists()) {
            dosya.createNewFile();
        }

        FileWriter dosyaYazici = new FileWriter(dosya, false);
        try (BufferedWriter tamponYazici = new BufferedWriter(dosyaYazici)) {
            
            tamponYazici.write(Integer.toString(byt));
            
            tamponYazici.newLine();
            tamponYazici.write("9");
            tamponYazici.newLine();
            
            
            
            for (int i = 0; i<boyut; i++) {

                for(int j=0;j<boyut;j++){
                    tamponYazici.write(oyuntahtası[i][j]);
                }
                tamponYazici.newLine();
            }
            
            
            tamponYazici.write("10");
            tamponYazici.newLine();
            tamponYazici.write(oyuncuAdi);
            tamponYazici.newLine();
            
            
            tamponYazici.write("11");
            tamponYazici.newLine();
            tamponYazici.write(oyuncuHarfi);
            tamponYazici.newLine();
            tamponYazici.write("12");
            
            

            
        }
        
  
        
    }
    
    

    
    
    boolean hamleyiYaz(int satir,int sutun,char oyuncu){
        if(oyuntahtası[satir][sutun]!='_'){
            return false;
        }
        else{
            oyuntahtası[satir][sutun]=oyuncu;
            return true;
        }
    }
    
    boolean kazanan(char oyuncu){
        int i,j,k;
        if(boyut==3){
            for(i=0;i<3;i++){
            if(oyuntahtası[i][0]==oyuncu && oyuntahtası[i][1]==oyuncu && oyuntahtası[i][2]==oyuncu)
                return true;
        }
            for(j=0;j<3;j++){
                 if(oyuntahtası[0][j]==oyuncu && oyuntahtası[1][j]==oyuncu && oyuntahtası[2][j]==oyuncu)
                return true;         
        }
            if(oyuntahtası[0][0]==oyuncu && oyuntahtası[1][1]==oyuncu && oyuntahtası[2][2]==oyuncu)
                return true;
            if(oyuntahtası[0][2]==oyuncu && oyuntahtası[1][1]==oyuncu && oyuntahtası[2][0]==oyuncu)
                return true;
        }
        
        else{
            for(i=0;i<boyut;i++){
                for(j=0;j<boyut-2;j++){
                    if(oyuntahtası[i][j]==oyuncu && oyuntahtası[i][j+1]==oyuncu && oyuntahtası[i][j+2]==oyuncu)
                        return true;
                }
            }
            for(j=0;j<boyut;j++){
            for(i=0;i<boyut-2;i++){
                if(oyuntahtası[i][j]==oyuncu && oyuntahtası[i+1][j]==oyuncu && oyuntahtası[i+2][j]==oyuncu)
                    return true;
                }
            
            }
            for(i=0;i<boyut-2;i++){
                for(j=0;j<boyut-2;j++){
                    if(oyuntahtası[i][j]==oyuncu && oyuntahtası[i+1][j+1]==oyuncu && oyuntahtası[i+2][j+2]==oyuncu)
                        return true;
                }
            }
            for(i=0;i<boyut-2;i++){
                for(j=boyut-1;j>=2;j--){
                    if(oyuntahtası[i][j]==oyuncu && oyuntahtası[i+1][j-1]==oyuncu && oyuntahtası[i+2][j-2]==oyuncu)
                        return true;
                    
                }
            }
        }
        return false;
        }
    boolean beraberlikKontrol(){
        int i,j;
        for(i=0;i<boyut;i++){
            for(j=0;j<boyut;j++){
                if(oyuntahtası[i][j]=='_')
                    return false;
            }
        }
        return true;
    }  
    }
    
    
    
    
    
    
    
    

