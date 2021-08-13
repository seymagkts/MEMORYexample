import java.sql.SQLOutput;
import java.util.Scanner;
public class main {
    private static kart[][] kartlar=new kart[2][2];

    public static void main(String[] args) {
        kartlar[0][0]=new kart('O');
        kartlar[0][1]=new kart('Ş');
        kartlar[1][0]=new kart('Ş');
        kartlar[1][1]=new kart('O');

        while(bittiMi()==false){
            oyunTahtasi();
            tahminEt();
        }

    }
  
    public static void tahminEt(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Birinci tahmin");
        int i1=scanner.nextInt();
        int j1=scanner.nextInt();

        kartlar[i1][j1].setTahmin(true);
        oyunTahtasi();

        System.out.println("İkinci tahmin");
        int i2=scanner.nextInt();
        int j2=scanner.nextInt();

        if(kartlar[i1][j1].getDeger()==kartlar[i2][j2].getDeger()){
            kartlar[i2][j2].setTahmin(true);
            oyunTahtasi();
        }else{
            kartlar[i1][j1].setTahmin(false);
        }
     
    }
  
    public static boolean bittiMi(){
        for (int i = 0 ; i<2 ; i++){
            for(int j = 0 ; j <2;j++){
                if(kartlar[i][j].isTahmin()==false){
                    return false;
                }
            }
        } return true;
      
    }
    public static void oyunTahtasi(){
        for(int i =0 ; i < 2 ; i++){
            for(int j = 0 ; j < 2 ; j++){
                if(kartlar[i][j].isTahmin()){
                    System.out.print("| "+kartlar[i][j].getDeger()+" | ");
                }else{
                    System.out.print("|  |");
                }
            }
            System.out.println("");
        }
    }
}
