import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.IOException;

public class Weapon{

   private  Random r = new Random();
   private  String itemcode = "";
   private  String name = "";
   private  double dmg = 0;
   private  double armour = 0;
   private  boolean magic = false;
   private  boolean fire = false;
   private  boolean ice = false;
   private  boolean electric = false;
   private  int price = 0;
       
      
   public Weapon(int rando)throws IOException{
      File infile = new File("Melee.txt");
      Scanner s = new Scanner(infile);
      for(int i = 1; i < rando; i++){
         s.nextLine();
      }
      this.itemcode = s.nextLine();
      this.name = s.nextLine();
      this.dmg = Double.valueOf(s.nextLine());
      this.armour = Double.valueOf(s.nextLine());
      this.magic = Boolean.valueOf(s.nextLine());
      this.fire = Boolean.valueOf(s.nextLine());
      this.ice = Boolean.valueOf(s.nextLine());
      this.electric = Boolean.valueOf(s.nextLine());
      s.nextLine();
      this.price = Integer.valueOf(s.nextLine());
   }
   
   public Weapon(String code, boolean thisisherefor0reason) throws IOException{
      File infile = new File("Melee.txt");
      Scanner s = new Scanner(infile);
      boolean finish = false;
      int i = 0;
      String next = "";
      while(finish == false){
         next = s.nextLine();
         if(next.equals(code)){
            this.itemcode = next;
            this.name = s.nextLine();
            this.dmg = Double.valueOf(s.nextLine());
            this.armour = Double.valueOf(s.nextLine());
            this.magic = Boolean.valueOf(s.nextLine());
            this.fire = Boolean.valueOf(s.nextLine());
            this.ice = Boolean.valueOf(s.nextLine());
            this.electric = Boolean.valueOf(s.nextLine());
            s.nextLine();
            this.price = Integer.valueOf(s.nextLine());
            finish = true;
         }
         i++;
      }
   }

   public String getCode(){
      return itemcode;
   }
   public String getName(){
      return name;
   }
   public double getDmg(){
      return dmg;
   }
   public double getArmour(){
      return armour;
   }
   public boolean getMagic(){
      return magic;
   }
   public boolean getFire(){
      return fire;
   }
   public boolean getIce(){
      return ice;
   }
   public boolean getElectric(){
      return electric;
   }
   public int getPrice(){
      return price;
   }
         
}