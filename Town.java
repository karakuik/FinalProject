import java.util.Random;
import java.util.Scanner;
class Town{
  String name;
  int population;

  public Town(String name, int population)
  {
    this.name = name;
    this.population = population;
  }

  String getDescription(){
    if(population<100)
    {
      return "a small village with a stable and a small general store.";
    }
    else if(population>99 && population<350)
    {
      return "a mid-sized town with a stable, a blacksmith and a decently sized general store.";
    }
    else if(population>350)
    {
      return "a large bustling city with a castle towards the back. Business is booming here!";
    }
    else
    return "YOUVE STUMBLED INTO THE ERROR-REALM. YOU SHOULD NOT BE HERE";

  }

  int setPopulation(){
    population = (int)(Math.random()*500)+25;
    return population;
  }

 static int numberGenerator(int min, int max){
    int result = (int)(Math.random()*max) + min;
    return result;
  }

  void townLoop(Town town){
    town.population = town.setPopulation();
    System.out.println("You've come to a town with a population of " + town.population + ",\nit is " + town.getDescription() + 
    "\n\nWhat would you like to do?");

  }
  static String weaponDescriptionGenerator(){
    String result = "";
    int random = numberGenerator(1, 3);

    switch(random)
    {
      case 1:{
        result+="A short ";
        break;
      }
      case 2:{
        result+= "A mid-sized ";
        break;
      }
      case 3:{
        result+= "A long ";
        break;
      }
      default:{
        result += "An error ridden... ";
        break;
      }
    }
    random = numberGenerator(1, 3);

    switch(random)
    {
      case 1:{
        result+="Sword";
        break;
      }
      case 2:{
        result+= "Axe";
        break;
      }
      case 3:{
        result+= "Dagger";
        break;
      }
      default:{
        result += "DIGI-SWORD OF ERROR";
        break;
      }
    }
    
    return result;
  }

  Weapon shopkeeper(Weapon Original, Player player){
     Scanner choice = new Scanner(System.in);
       Weapon weapon = new Weapon(numberGenerator(0, 5), numberGenerator(10, 15), weaponDescriptionGenerator(), numberGenerator(20, 25));
       //Weapon Original = new Weapon(getMinAtk(), getMaxAtk(), getDescription(),getPrice());
       System.out.println("The shopkeeper rummages in the back, he returns with " + weapon.toString());
        if(player.gold > weapon.price)
        {
          System.out.println("Would you like to buy it?\n1.Yes\n2.No");
            if(choice.nextInt() == 1)
            {
              System.out.println("\n***Bought!***\n");
              player.setGold(player.gold-weapon.price);
              return weapon;
            }
            else
            {
              return Original; 
            }
        }
        else{
          System.out.println("You seem light on coin, go get some!\n");
          return Original; 
        }
            
  }
  

}