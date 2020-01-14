import java.util.Scanner;
import java.util.Random;

class Main {
 public static void main(String[] args) {
   Scanner scan = new Scanner(System.in);
  
  //Sets the stage... Showtime!
   text("\n\nWelcome to RPGMan Java Edition\nWhat is your name?");
   Player player = new Player(scan.nextLine(), 25, 1, 0, 25);
   Monster monster = new Monster(5,1,3, "Swag", 2, "DefaultName");
   Weapon weapon = new Weapon(1,3,"A short rusty sword" , 3);
   Town town = new Town("Swaggart", 50);
   clearScreen();

   //Flavor text pt1
   text("Welcome to the world of Yelich, " + player.name + ".\nWith your trusty yet rusty sword in hand,\n you find yourself in the midst of battle.\n Use your wits to slay the enemy!\n");
   Display(player);
   Battle(player,monster, weapon);
   town.townLoop(town);
   
   Scanner choice = new Scanner(System.in);


    //Core Loop
    while(true){
        text("1.Look for a store\n2.Travel to another area\n3.Go to the outskirts to battle\n");

        switch(choice.nextInt())
        {
          case 1:
          {
            text("You search for a store\nand stumble upon a general store!\nThe ShopKeeper looks at you.\n\"What'll it be?\"\n");
            text("You are currently wielding a: " + weapon.toString()+"\n");
            weapon = town.shopkeeper(weapon, player);
                  
            break;
          }
          case 2:
          {
            clearScreen();
            town.townLoop(town);
            break;
          }
          case 3:
          {
            Battle(player, monster, weapon);
            System.out.println("\nExiting Battle...\n");
            break;
          }
          case 4:{
            endGame();
            break;
          }
        }
    }   
 }


  static void Display(Player player){
   System.out.println("Name: " + player.name + "\tHP: " + player.health+"\nLevel: " + player.level + "\tGold: " + player.gold);
  }
 
  static void clearScreen() {
    //This is NOT CLS.
   System.out.print("\033[H\033[2J");
   System.out.flush();
 }

  //Battle phase
  static void Battle(Player player, Monster monster, Weapon weapon){
   boolean hasPlayerAttacked = false;
   boolean escape = false;
  Scanner scan = new Scanner(System.in);
  
  if(player.level < 3){
    monster = new Monster(10,1,3,monster.getDescription(), 2, "Goblin");
  }
  else if(player.level >=3 && player.level < 5)
  {
    monster = new Monster(20, 5, 10, monster.getDescription(), 4, "Skeleton");
  }
  else{
    monster = new Monster(50, 15, 30, monster.getDescription(), 20, "Dragon");
  }
  
    //int health, int minAtk, int maxAtk, String description, int level

    text(monster.getDescription());
    
    while(player.health> 0 && monster.health >0){
    text("1.Attack\n2.Drink Health Potion\n3.Flee");
      switch(scan.nextInt())
      {
        case 1:{
          //attackRoll(player, weapon, monster);
          clearScreen();
          Display(player);
          monster.health -=attackRoll(player, weapon, monster, hasPlayerAttacked);
          System.out.println("Monster HP: " + monster.health + "\n");
          hasPlayerAttacked = true;
          break;
        }
        case 2:{
          clearScreen();
          Display(player);
          player.health+=15;
          hasPlayerAttacked = true;
          break;
        }
        case 3:{
          clearScreen();
          if(monster.health > 10){
            text("You cannot escape!");
            hasPlayerAttacked = true;
          }
          else{
          text("You make a run for it and escape!");
          escape = true;
          }
          
          break;
        }
        default: text("\033[31mERROR\u001B[0m");
      }

      if(escape == true)
      break;

      StatsCheck(player, monster);
      if(monster.health>0){
      text("The enemy swoops in for an attack!");
      player.health-=attackRoll(player, weapon, monster, hasPlayerAttacked);
      StatsCheck(player, monster);
      hasPlayerAttacked = false;
      }
        
    }
    hasPlayerAttacked=false;
   
 }

 public static int attackRoll(Player player, Weapon weapon, Monster monster,boolean hasPlayerAttacked)
 {
   int attack = -1;
   if(!hasPlayerAttacked){
    attack = (int)(Math.random()*weapon.maxAtk + weapon.minAtk);
    hasPlayerAttacked = true;
    text(player.name + " dealt " + attack + " to " + monster.name);
    
   }
   else{
     hasPlayerAttacked=false;
     attack = (int)(Math.random()*monster.maxAtk + monster.minAtk);
     text(monster.name + " dealt " + attack + " to " + player.name);
   }
    
   return attack;
 }

 public static void StatsCheck(Player player, Monster monster){
   if(player.health<1)
   {
     text("\033[31mYou have died.");
     endGame();
   }
   if(monster.health<1)
   {
     text("Congrats! You won! Earn 5 exp and 5 gold!");
     player.experience+=5;
     player.gold+=5;
   }

  if(player.experience >= player.level*5)
  {
    text("You've leveled up!\n");
    player.level++;
    player.experience = 0;
  }

 }
 

  static void endGame(){
    System.exit(0);
  }

  static void text(String text){
    System.out.println(text);
  }

}
