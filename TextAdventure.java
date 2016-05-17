import java.util.Scanner;
import java.util.Random;
import java.io.*;
public class TextAdventure{
   public static Scanner in = new Scanner(System.in);
   public static Random r = new Random();
   public static Player player = new Player();
   public static boolean fight = true;
   public static Enemy enemy = new Enemy();
   public static Store store = new Store();
   public static int game = 0;
      

   public static void main(String[] args)throws IOException{
      boolean finish = false;
      int answer = 0;
   
      do{
         System.out.println("||-----------------WELCOME---------------||");
         System.out.println("||-------------------------------------------------||");
         System.out.println("|| 1: New Game                            ||");
         System.out.println("|| 2: Load Game                           ||");
         System.out.println("||-------------------------------------------------||");
         answer = in.nextInt();
         switch(answer){
            case 1:
               player.characterCreate();
               player.getCharacter();
               break;
            case 2:
               loadGame();
               player.getCharacter();
               break;
         }
      } while(answer != 1 && answer != 2);
      startUp();
   }
   public static void startUp() throws IOException{
      boolean finish = false;
      String answer = "";
      while(game == 0){
         player.setHp();
         newBattle();
      }
      while(game == 3){
         while(fight == false){
            boolean shopping = false;
            boolean choose = false;
            
            System.out.println("Would you like to save?");
            answer = in.nextLine();
            if(answer.toUpperCase().equals("YES")){
               saveGame();
            }
            else if(answer.toUpperCase().equals("NO") && shopping == false){
               shopping = true;
               System.out.println("You find a vendor out in the wilderness");
               store.Store(player.getMoney());
               if(store.getPurchase() == true){
                  finish = false;
                  while(finish == false){
                     System.out.println("Would you like to replace your "+player.getWepName1()+" or your "+player.getWepName2()+"?");
                     answer = in.nextLine();
                     if(answer.toUpperCase().equals(player.getWepName1().toUpperCase())){
                        player.setWeapon1(store.getCode(), store.getName(), store.getDmg(), store.getArmour(), store.getMagic(), store.getFire(), store.getIce(), store.getElectric());
                        finish = true;
                     }
                     else if(answer.toUpperCase().equals(player.getWepName2().toUpperCase())){
                        player.setWeapon2(store.getCode(), store.getName(), store.getDmg(), store.getArmour(), store.getMagic(), store.getFire(), store.getIce(), store.getElectric());
                        finish = true;
                     }
                  }
               }
            }
         }
         System.out.println("Are you ready to go back to the fight?");
         answer = in.nextLine();
         if(answer.toUpperCase().equals("YES")){
            fight = true;
         }
         else {
            System.out.println("Would you like to quit?");
            answer = in.nextLine();
            if(answer.toUpperCase().equals("YES")){
               game = 3;
            }
               
         }
      }
      while(game ==4){
         System.out.println("Would you like to Save?");
         if(in.nextLine().toUpperCase().equals("YES")){
            saveGame();
         }
      }
   }
               
   public static void newBattle() throws IOException{
      enemy = new Enemy(player.getLvl()+r.nextInt(6));
      System.out.println("||=======================================||");
      System.out.println("|| A wild "+enemy.getName()+" appears! ||");
      System.out.println("||=======================================||");
      System.out.println();
          
      enemy.setDmg(player.playerAttack(), player.getArmour());
      if(enemy.getMiss() == false){
         System.out.println(player.getName()+" used "+player.getAttack()+"!\n"+enemy.getName()+" took "+enemy.getDmg()+"!");
      }
      else if(enemy.getMiss() == true){
         System.out.println(player.getName()+" used "+player.getAttack()+" but the enemy "+enemy.getName()+" dodged!");
      }
      while(enemy.getHp() > 0 ){
         player.setDamage(enemy.enemyAttack(), enemy.getArmour());
         if(player.getMiss() == false){
            System.out.println(enemy.getName() + " used "+enemy.getAttack()+"!\n"+player.getName()+" took "+player.getDmg()+"!");
         }
         else if(player.getMiss() == true){
            System.out.println(enemy.getName()+" used "+enemy.getAttack()+" but "+player.getName()+" dodged!");
         }
         if(player.getHp() < 0){
            gameOver();
         }
         enemy.setDmg(player.playerAttack(), player.getArmour());
         if(enemy.getMiss() == false){
            System.out.println(player.getName()+" used "+player.getAttack()+"!\n"+enemy.getName()+" took "+enemy.getDmg()+"!");
         }
         else if(enemy.getMiss() == true){
            System.out.println("The "+enemy.getName()+" used "+enemy.getAttack()+", but "+player.getName()+" dodged!");
         }
      }
      if(enemy.getHp() <= 0){
         System.out.println(enemy.getName()+" was defeated!");
         enemy.setXp();
         player.setXp(enemy.getXp());
         System.out.println(player.getName()+" got "+enemy.getXp()+" XP!");
         player.setMoney(enemy.getMoney());
         System.out.println(player.getName()+" got "+enemy.getMoney()+" gold!");
         System.out.println("would you like to look for another enemy?");
         boolean finish = false;
         while(finish == false){
            String answer = in.nextLine();
            if(answer.toUpperCase().equals("NO")){
               fight = false;
               finish = true;
            }
            else if(answer.toUpperCase().equals("YES")){
               fight = true;
               finish = true;
            }
         }
      }
     
   }
   public static void gameOver(){
      System.out.println(player.getName()+" died valiantly to an enemy "+enemy.getName()+"'s "+enemy.getAttack()+".\nRIP");
      fight = false;
      System.exit(0);
   }
   public static void loadGame() throws IOException{
      File[] infile = new File[3];
      infile[0] = new File("SaveGame1");
      infile[1] = new File("SaveGames2");
      infile[2] = new File("SaveGames3");
      System.out.println("Load file 1, 2 or 3?");
      int answer = in.nextInt();
      in.nextLine();
      Scanner en = new Scanner(infile[answer-1]);
                     
      String name = en.nextLine();
      String raceS = en.nextLine();
      int race = Integer.valueOf(en.nextLine());
      int lvl = Integer.valueOf(en.nextLine());
      int str = Integer.valueOf(en.nextLine());
      int dtx = Integer.valueOf(en.nextLine());
      int intel = Integer.valueOf(en.nextLine());
      double maxhp = Double.valueOf(en.nextLine());
      double xpmult = Double.valueOf(en.nextLine());
      double dmgred = Double.valueOf(en.nextLine());
      double dodge = Double.valueOf(en.nextLine());
      int money = Integer.valueOf(en.nextLine());
      double xp = Double.valueOf(en.nextLine());
      String wepcode1 = en.nextLine();
      String wepcode2 = en.nextLine();
      player = new Player(name, raceS, race, lvl, str, dtx, intel, maxhp, xpmult, dmgred, dodge, money, xp, wepcode1, wepcode2);
   }
   public static void saveGame() throws IOException{
      File infile[] = new File[3];
      infile[0] = new File("SaveGame1");
      infile[1] = new File("SaveGames2");
      infile[2] = new File("SaveGames3");
      System.out.println("Do you want to save to file 1, 2 or 3?");
      int answer = in.nextInt();
      in.nextLine();
      PrintStream write = new PrintStream(infile[answer-1]);
      Scanner en = new Scanner(infile[answer-1]);
   
      write.println(player.getName());
      write.println(player.getRaceS());
      write.println(player.getRace());
      write.println(player.getLvl());
      write.println(player.getStr());
      write.println(player.getDtx());
      write.println(player.getIntel());
      write.println(player.getMaxHp());
      write.println(player.getXpMult());
      write.println(player.getDmgRed());
      write.println(player.getDodge());
      write.println(player.getMoney());
      write.println(player.getXp());
      write.println(player.getWepcode1());
      write.println(player.getWepcode2());
   }
   public int getGame(){
      return game;
   }
}
