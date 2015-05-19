import java.util.List;
import java.util.ArrayList;
import processing.core.*;

public class WorldObject
{
   private String name;
   protected int current_img;
   protected List<PImage> imgs;

   public WorldObject(String name, List<PImage> imgs)
   {
      this.name = name;
      this.imgs = imgs;
      this.current_img = 0;
   }

   public List<PImage> get_images()
   {
      return this.imgs;
   }

   public PImage get_image()
   {
      return this.imgs.get(this.current_img);
   }

   public String get_name()
   {
      return this.name;
   }

   public static int sign(int x)
   {
      if(x < 0)
      {
         return -1;
      }
      else if(x > 0)
      {
         return 1;
      }
      else
      {
         return 0;
      }
   }

   public static boolean adjacent(Point pt1, Point pt2)
   {
      return ((pt1.getX() == pt2.getX() && 
             Math.abs(pt1.getY() - pt2.getY()) == 1) ||
             (pt1.getY() == pt2.getY() && 
             Math.abs(pt1.getX() - pt2.getX()) == 1));
   }
}
