class Player{
 String name;
 int health;
 int level;
 int experience;
 int gold;
  
  public Player(String name, int health, int level, int experience, int gold){
   this.name = name;
   this.health = health;
   this.level = level;
   this.experience = experience;
   this.gold = gold;
  }
 

 String getName(){
return name;
 }
   
 

 int getHealth(){
return health;
 }
   
 

 int getLevel(){
return level;
 }
   
 
  int getExp(){
return experience;
  }
   
 

 int getGold(){
 return gold;
 }
  
 void setGold(int newGold){
   gold = newGold;
 }

}

