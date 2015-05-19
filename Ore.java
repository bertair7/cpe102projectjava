import processing.core.*;
import java.util.List;
import java.util.ArrayList;

public class Ore
   extends Actor
{
   private int rate;

   private int BLOB_ANIMATION_RATE_SCALE = 50;
   private int BLOB_ANIMATION_MIN = 1;
   private int BLOB_ANIMATION_MAX = 3;
 
   public Ore(String name, List<PImage> images, Point position, int rate)
   {
      super(name, images, position);
      this.rate = rate;
   }

   public int get_rate()
   {
      return this.rate;
   }

   public WorldEntity create_blob(WorldModel world, String name, Point pt, 
      int rate, int ticks, List<PImage> i_store)
   {
      Random rand = new Random();
      int min = BLOB_ANIMATION_MIN;
      int max = BLOB_ANIMATION_MAX;
      int randomNum = rand.nextInt((max - min) + 1) + min;
      randomNum *= BLOB_ANIMATION_RATE_SCALE;
      
      WorldEntity blob = new OreBlob(name, pt, rate, ImageStore.get_images(
         i_store, "ore"), randomNum);
      blob.schedule(world, ticks, i_store);
      return blob;
   }

   public void schedule(WorldModel world, int ticks, List<PImage> i_store)
   {
      Actions.schedule_action(world, this, 
         Actions.create_ore_transform_action(world,this, i_store), ticks + 
         this.get_rate());
   }
}

