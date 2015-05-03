public class MinerFull
   extends Miner
{
   private int resource_count;
 
   public MinerFull(String name, Point position, int rate, int resource_limit, 
      int animation_rate)
   {
      super(name, position, rate, resource_limit, animation_rate);
      this.resource_count = resource_limit;
   }
}
