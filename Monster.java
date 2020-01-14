class Monster{
int health;
int minAtk;
int maxAtk;
String description;
int level;
String name;

  public Monster(int health, int minAtk, int maxAtk, String description, int level, String name){
    this.health = health;
    this.minAtk = minAtk;
    this.maxAtk = maxAtk;
    this.description = getDescription();
    this.level = level;
    this.name = name;
  }

  String getDescription(){
    if(level>1 && level <3)
    {
      name = "goblin";
      return "A small goblin approaches you!";
    }
    else if (level >2 && level <5)
    {
      name = "skeleton";
      return "A Skeleton approaches you!";
    }
    else
    return "A dragon approaches you!";

  }
}