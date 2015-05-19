public class MinerNotFull
   extends Miner
{ 
   private int resource_count;
  
   public MinerNotFull(String name, List<PImage> images, Point position, int 
      rate, int resource_limit, int animation_rate)
   {
      super(name, position, rate, resource_limit, animation_rate);
      this.resource_count = 0;
   }

   public int get_resource_count()
   {  
      return this.resource_count;
   }

   public boolean miner_to_ore(WorldModel world, WorldEntity ore)
   {
      Point entity_pt = this.get_position();
      if(!(ore instanceof Ore))
      {
         return false;
      }

      Point ore_pt = ore.get_position();
      if(adjacent(entity_pt, ore_pt)
      {
         this.set_resource_count(this.get_resource_count()+ 1);
         actions.remove_entity(world, ore);
         return true;
      }
      else
      {
         Point new_pt = this.next_position(world, ore_pt);
         return false;
      }
   }
}
