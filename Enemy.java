import java.util.Random;
import java.io.*;
import java.util.Scanner;
public class Enemy extends Character{

   private String name = "";
   private int lvl = 0;
   private double hp = 0;
   private double dmgred = 0;
   private int race = 0;
   private String raceS = "";
   private Random r = new Random();
   private double atkdmg = 0;
   private String atkname = "";
   private double xpgain = 0;
   private double dmgtkn = 0;
   private double armour = 0;
   private int money = 0;
   private int rando1;
   private int rando2;
   private double dodge;

 
   
   public Enemy(){
        super();
   }
      
   public Enemy(int dif) throws IOException{
      rando1 = (((int)(Math.random()*21)*10)+11);
      if(rando1 >= 211){
         rando1 = 201;
      }
      if(rando2 >= 211){
         rando2 = 201;
      }
            
      rando2 = (((int)(Math.random()*21)*10)+11);
      this.lvl = r.nextInt(dif);
      this.race = r.nextInt(4)+1;
      if(race == 1){
         this.raceS = "Human";
         this.hp = 9 + lvl*5;
         this.dmgred = 0-(r.nextInt(dif)/100);
         this.dodge = 10;
      }
      else if(race == 2){
         this.raceS = "Orc";
         this.hp = 15 + lvl*7;
         this.dmgred = (.75 - (r.nextInt(dif)/100));
         this.dodge = 0;
      }
      else if(race == 3){
         this.raceS = "Elf";
         this.hp = 8 + lvl*4;
         this.dmgred = -.5 + (r.nextInt(dif)/100);
         this.dodge = 33;
      }
      else if(race == 4){
         this.raceS = "Dwarf";
         this.hp = 10 + lvl*6;
         this.dmgred = .9 - (r.nextInt(dif)/100);
         this.dodge = 20;
      }
      if(dmgred >= .9){
         dmgred = dmgred - .1;
      }
      int rand = r.nextInt(5)+1;
      if(rand == 1){
         this.name = raceS+" Bandit";
      }
      if(rand == 2){
         this.name = raceS+" Brigand";
      }
      if(rand == 3){
         this.name = raceS+" Thief";
      }
      if(rand == 4){
         this.name = raceS+" Deserter";
      }
      if(rand == 5){
         this.name = raceS+" Liberal";
      }
               
      
   }
   public double enemyAttack() throws IOException{
      Weapon[] w = new Weapon[2];
      w[0] = new Weapon(this.rando1);
      w[1] = new Weapon(this.rando2);
      int choice = r.nextInt(2);
      atkname = w[choice].getName();
      atkdmg = w[choice].getDmg();
      armour = w[choice].getArmour();
      return atkdmg;
   }
   
   private static boolean miss = false;
   public void setDmg(double dmg, double armour){
      double hit = Math.random()*100;
      if(hit > dodge){
         double pen;
         if(race != 3){
            pen = dmgred - armour;
            if(pen <= 0){
               pen = 0;
            }
         }
         else{
            pen = dmgred;
         }
      
         hp = hp - dmg*(1.0-pen);
         this.dmgtkn = dmg*(1.0-pen);
         miss = false;
      }
      else{
         this.dmgtkn = 0;
         this.armour =  0;
         miss = true;
      }
   }
   public boolean getMiss(){
      return miss;
   }
   public double getHp(){
      return hp;
   }
   public int getRace(){
      return race;
   }
   public int getLvl(){
      return lvl;
   }
   public String getName(){
      return name;
   }
   public double getDmg(){
      return dmgtkn;
   }
   public String getAttack(){
      return atkname;
   }
   public void setXp(){
      xpgain = this.lvl+r.nextInt(6);
      money = r.nextInt(this.lvl)+10;
   }
   public double getXp(){
      return xpgain;
   }
   public double getArmour(){
      return armour;
   }
   public int getMoney(){
      return money;
   }
}