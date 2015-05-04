public class MinerNotFull
   extends Miner
{ 
   private int resource_count;
  
   public MinerNotFull(String name, Point position, int rate, 
      int resource_limit, int animation_rate)
   {
      super(name, position, rate, resource_limit, animation_rate);
      this.resource_count = 0;
   }

   public int get_resource_count()
   {  
      return this.resource_count;
   }

   //public miner_to_ore(WorldModel world, Ore ore)
}
