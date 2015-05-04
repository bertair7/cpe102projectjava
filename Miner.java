public class Miner
   extends AnimatedActor
{ 
   private int resource_limit;
   private int animation_rate;
   private int resource_count;

   public Miner(String name, Point position, int rate, int resource_limit, 
      int animation_rate)
   {
      super(name, position, rate);
      this.resource_limit = resource_limit;
      this.animation_rate = animation_rate;
   }

   public void set_resource_count(int n)
   {
      this.resource_count = n;
   }

   public int get_resource_limit()
   {
      return this.resource_limit;
   }

   public int get_animation_rate()
   {
      return this.animation_rate;
   }

}
