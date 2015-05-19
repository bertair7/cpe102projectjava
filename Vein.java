import java.lang.Math;

public class Vein
   extends AnimatedActor
{
   private int resource_distance;
   private int ORE_CORRUPT_MIN = 20000;
   private int ORE_CORRUPT_MAX = 30000;
 
   public Vein(String name, List<PImage> images, Point position, int rate, int 
      resource_dist)
   {
      super(name, images, position, rate);
      this.resource_distance = resource_dist;
   }

   public int get_resource_distance()
   {
      return this.resource_distance;
   }

   public WorldEntity _create_ore(WorldModel world, String name, Point pt, 
      int ticks, List<PImage> i_store)
   {
      Random rand = new Random();
      int randomNum = rand.nextInt((ORE_CORRUPT_MAX - ORE_CORRUPT_MIN) + 1) +
         ORE_CORRUPT_MIN;
      
      WorldEntity ore = new Ore(name, pt, i_store.get_images(i_store, "ore"), 
         randomNum);
      ore._schedule(world, ticks, i_store);
      return ore;
   }

   public void _schedule(WorldModel world, int ticks, List<PImage> i_store)
   {
      Actions.schedule_action(world, this, Actions.create_vein_action(world, 
         this, i_store), ticks + this.get_rate());
   }
}
