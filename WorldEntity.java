import processing.core.*;
import java.util.*;

public class WorldEntity
   extends WorldObject
{
   private Point position;
 
   public WorldEntity(String name, List<PImage> images, Point position)
   {
      super(name, images);
      this.position = position;
   }

   public void set_position(Point p)
   {
      this.position = p;
   }

   public Point get_position()
   {
      return this.position;
   }
}
