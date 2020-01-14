class Weapon{
  int minAtk;
  int maxAtk;
  String description;
  int price;

  public Weapon(int minAtk, int maxAtk, String description, int price)
  {
    this.minAtk = minAtk;
    this.maxAtk = maxAtk;
    this.description = description;
    this.price = price;
  }
  
  public String toString(){
    return description + ", ATK:" 
    + ((maxAtk+minAtk)/2) +"\t$" + price;
  }

  public int getMinAtk(){
    return minAtk;
  }

 public int getMaxAtk(){
    return maxAtk;
  }

 public String getDescription(){
    return description;
  }

 public int getPrice(){
    return price;
  }

  public void weaponSetter(int minimum, int maximum, String desc, int cost){
    minAtk = minimum;
    maxAtk = maximum;
    description = desc;
    price = cost;
  }

}