import processing.core.*;
import java.util.List;
import java.util.ArrayList;

public class Miner
   extends AnimatedActor
{ 
   private int resource_limit;
   private int animation_rate;
   private int resource_count;

   public Miner(String name, List<PImage> images, Point position, int rate, int 
      resource_limit, int animation_rate)
   {
      super(name, images, position, rate);
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

   public void schedule(WorldModel world, int ticks, List<PImage> i_store)
   {
      Actions.schedule_action(world, WorldEntity this, 
         Actions.create_miner_action(world, this, i_store), ticks + 
         this.get_rate());
      Actions.schedule_animation(world, WorldEntity this);
   }
}
