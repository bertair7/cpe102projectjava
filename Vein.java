public class Vein
   extends AnimatedActor
{
   private int resource_distance;
 
   public Vein(String name, Point position, int rate, int resource_dist)
   {
      super(name, position, rate);
      this.resource_distance = resource_dist;
   }

   public int get_resource_distance()
   {
      return this.resource_distance;
   }
}
