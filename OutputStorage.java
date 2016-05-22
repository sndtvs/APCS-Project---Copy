public class OutputStorage implements Output{
   public static void optionMenu(String[] options){
   
      int listAmount = options.length;
      int maxLength = options[0].length;
      for(int i = 0; i < options.length; i++){
         if(options[i].length > maxLength){
            maxLength = options[i];
         }
      }
      maxLength = maxLength + 2;
      System.out.print(" __| |");//Start top of border
      for(int i = 0; i < maxLength; i++){
         System.out.print("_");
      }
      System.out.println("| |__");//End top of border
      System.out.print("(__   ");
      for(int i = 0; i < maxLength; i++){
         System.out.print("_");
      }
      System.out.println("   __)");
      
      for(int j = 0; j < listAmount; j++){
         System.out.print("   | |");//Start of body
         for(int i = 0; i < maxLength; i++){
            System.out.print(" ");
         }
      
         System.out.println("| |");
      
         System.out.println("   | | "+options[j]+" | |"); //Main Text
      
         System.out.print(" __| |");//
         for(int i = 0; i < maxLength; i++){
            System.out.print("_");
         }
         System.out.println("| |__");
      }
      System.out.print("(__   ");//   __)");
      for(int i = 0; i < maxLength; i++){
         System.out.print("_");
      }
      System.out.println("   __)");
      System.out.print("   | |");//
      for(int i = 0; i < maxLength; i++){
         System.out.print(" ");
      }
      System.out.println("| |");
   }
   
   public static void openingScreen(){
      System.out.println("                            ,--.");
      System.out.println("                           {    }");
      System.out.println("                           K,   }");
      System.out.println("                          /  ~Y`");
      System.out.println("                     ,   /   /");
      System.out.println("                    {_'-K.__/");
      System.out.println("                      `/-.__L._");
      System.out.println("                      /  ' /`\\_}");
      System.out.println("                     /  ' /");
      System.out.println("             ____   /  ' /");
      System.out.println("      ,-'~~~~    ~~/  ' /_");
      System.out.println("    ,'             ``~~~  ',");
      System.out.println("   (                        Y");
      System.out.println("  {                         I");
      System.out.println(" {      -                    `,");
      System.out.println(" |       ',                   )");
      System.out.println(" |        |   ,..__      __. Y");
      System.out.println(" |    .,_./  Y ' / ^Y   J   )|");
      System.out.println(" \\           |' /   |   |   ||");
      System.out.println("  \\          L_/    . _ (_,.'(");
      System.out.println("   \\,   ,      ^^\"\"' / |      )");
      System.out.println("     \\_  \\          /,L]     /");
      System.out.println("       '-_~-,       ` `   ./`");
      System.out.println("          `'{_            )");
      System.out.println("              ^^\\..___,.--`");
      System.out.println();
      System.out.println("    .....                                       s            ..                 ..          _                                       s");
      System.out.println(" .H8888888h.  ~-.                              :8         :**888H: `: .xH\"\"   dF           u                                       :8");
      System.out.println(" 888888888888x  `>               uL   ..      .88        X   `8888k XX888    '88bu.       88Nu.   u.                u.    u.      .88       x.    .        .u    .");
      System.out.println("X~     `?888888hx~      .u     .@88b  @88R   :888ooo    '8hx  48888 ?8888    '*88888bu   '88888.o888c      .u     x@88k u@88c.   :888ooo  .@88k  z88u    .d88B :@8c       .u");
      System.out.println("'      x8.^\"*88*\"    ud8888.  '\"Y888k/\"*P  -*8888888    '8888 '8888 `8888      ^\"*8888N   ^8888  8888   ud8888.  ^\"8888\"\"8888\" -*8888888 ~\"8888 ^8888   =\"8888f8888r   ud8888.");
      System.out.println(" `-:- X8888x       :888'8888.    Y888L       8888        %888>'8888  8888     beWE \"888L   8888  8888 :888'8888.   8888  888R    8888      8888  888R     4888>'88\"  :888'8888.");
      System.out.println("      488888>      d888 '88%\"     8888       8888          \"8 '888\"  8888     888E  888E   8888  8888 d888 '88%\"   8888  888R    8888      8888  888R     4888> '    d888 '88%\"");
      System.out.println("    .. `\"88*       8888.+\"        `888N      8888         .-` X*\"    8888     888E  888E   8888  8888 8888.+\"      8888  888R    8888      8888  888R     4888>      8888.+\"");
      System.out.println("  x88888nX\"      . 8888L       .u./\"888&    .8888Lu=        .xhx.    8888     888E  888F  .8888b.888P 8888L        8888  888R   .8888Lu=   8888 ,888B .  .d888L .+   8888L");
      System.out.println(" !\"*8888888n..  :  '8888c. .+ d888\" Y888*\"  ^%888*        .H88888h.~`8888.>  .888N..888    ^Y8888*\"\"  '8888c. .+  \"*88*\" 8888\"  ^%888*    \"8888Y 8888\"   ^\"8888*\"    '8888c. .+");
      System.out.println("'    \"*88888888*    \"88888%   ` \"Y   Y\"       'Y\"        .~  `%88!` '888*~    `\"888*\"\"       `Y\"       \"88888%      \"\"   'Y\"      'Y\"      `Y\"   'YP        \"Y\"       \"88888%");
      System.out.println("        ^\"***\"`       \"YP'                                     `\"     \"\"         \"\"                      \"YP'");
   }
   
   public static void transitionBreak(){
      System.out.println();
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println();
   }
   
   public static void normalText(String attacking, String defending, int damage){
      String phrase = defending+" took "+damage+" damage from "+attacking+"!";
      int phraseLength = phrase.length + 2;
      
      System.out.print(" __| |");//Start top of border
      for(int i = 0; i < phraseLength; i++){
         System.out.print("_");
      }
      System.out.println("| |__");//End top of border
      System.out.print("(__   ");
      for(int i = 0; i < phraseLength; i++){
         System.out.print("_");
      }
      System.out.println("   __)");
      
      System.out.print("   | |");//Start of body
      for(int i = 0; i < phraseLength; i++){
         System.out.print(" ");
      }
      
      System.out.println("| |");
      
      System.out.println("   | | "+phrase+" | |"); //Main Text
      
      System.out.print(" __| |");//
      for(int i = 0; i < phraseLength; i++){
         System.out.print("_");
      }
      System.out.println("| |__");
      
      System.out.print("(__   ");//   __)");
      for(int i = 0; i < phraseLength; i++){
         System.out.print("_");
      }
      System.out.println("   __)");
      System.out.print("   | |");//
      for(int i = 0; i < phraseLength; i++){
         System.out.print(" ");
      }
      System.out.println("| |");
      
   }
}