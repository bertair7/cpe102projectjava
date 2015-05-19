public class Quake
   extends Actor
{
   private int animation_rate;

   private int QUAKE_STEPS = 10;
   private int QUAKE_DURATION = 1100;
 
   public Quake(String name, List<PImage> images, Point position, int 
      animation_rate)
   {
      super(name, images, position);
      this.animation_rate = animation_rate;
   }

   public int get_animation_rate()
   {
      return this.animation_rate;
   }

   public void _schedule(WorldModel world, int ticks)
   {
      Actions.schedule_animation(world, this, QUAKE_STEPS);
      Actions.schedule_action(world, this, 
         Actions.create_entity_death_action(world, this), ticks + 
         QUAKE_DURATION);
   }
}
