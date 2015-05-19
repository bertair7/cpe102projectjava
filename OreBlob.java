import processing.core.*;
import java.util.List;
import java.util.ArrayList;

public class OreBlob
   extends AnimatedActor
{
   private int animation_rate;
   private int QUAKE_ANIMATION_RATE = 100;
    
   public OreBlob(String name, List<PImage> images, Point position, int rate, 
      int animation_rate)
   {
      super(name, images, position, rate);
      this.animation_rate = animation_rate;
   }

   public int get_animation_rate()
   {
      return this.animation_rate;
   }

   public WorldEntity _create_quake(WorldModel world, Point pt, int ticks, 
      List<PImage> i_store)
   {
      WorldEntity quake = new Quake("quake", pt, ImageStore.get_images
         (i_store, "quake"), QUAKE_ANIMATION_RATE);
      quake.schedule(world, ticks);
      return quake;
   }

   public void schedule(WorldModel world, int ticks, List<PImage> i_store)
   {
      Actions.schedule_action(world, this, Actions.create_ore_blob_action
         (world, this, i_store), ticks + this.get_rate());
      Actions.schedule_animation(world, this);
   }

   public boolean blob_to_vein(WorldModel world, WorldEntity vein)
   {
      Point entity_pt = this.get_position();
      if(!(vein instanceof Vein))
      {
         return false;
      }
      
      Point vein_pt = vein.get_position();
      if(adjacent(entity_pt, vein_pt))
      {
      	 Actions.remove_entity(world, vein);
         return true;
      }
      else
      {
         Point new_pt = this.next_position(world, vein_pt);
     	 WorldEntity old_entity = world.get_tile_occupant(new_pt);

         if(old_entity instanceof Ore)
         {
	    Actions.remove_entity(world, old_entity);
	 }
         return false;
      }
   }
}
