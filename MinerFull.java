public class MinerFull
   extends Miner
{
   private int resource_count;
 
   public MinerFull(String name, List<PImage> images, Point position, int rate, 
      int resource_limit, int animation_rate)
   {
      super(name, images, position, rate, resource_limit, animation_rate);
      this.resource_count = resource_limit;
   }

   public int get_resource_count()
   {  
      return this.resource_count;
   }

   public boolean miner_to_smith(WorldModel world, WorldEntity smith)
   {
      Point entity_pt = this.get_position();
      if(!(smith instanceof Blacksmith))
      {
         return false;
      }

      Point smith_pt = smith.get_position();
      if(adjacent(entity_pt, smith_pt)
      {
         smith.set_resource_count(smith.get_resource_count() + 
            this.get_resource_count());
         this.set_resource_count(0);
         return true;
      }
      else
      {
         Point new_pt = this.next_position(world, smith_pt);
         return false;
      }
   }
}
