public class OreBlob
   extends AnimatedActor
{
   private int animation_rate;
    
   public OreBlob(String name, Point position, int rate, int animation_rate)
   {
      super(name, position, rate);
      this.animation_rate = animation_rate;
   }

   public int get_animation_rate()
   {
      return this.get_animation_rate;
   }
}
