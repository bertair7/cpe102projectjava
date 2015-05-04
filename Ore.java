public class Ore
   extends Actor
{
   private int rate;
 
   public Ore(String name, Point position, int rate)
   {
      super(name, position);
      this.rate = rate;
   }

   public int get_rate()
   {
      return this.rate;
   }
}

