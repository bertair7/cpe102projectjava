public class Ore
   extends Actor
{
   private int rate;
 
   public Ore(String name, Point position, int rate = 5000)
   {
      super(name, position);
      this.rate = rate;
   }

   public int get_rate()
   {
      return this.rate;
   }
}

