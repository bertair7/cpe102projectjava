public class WorldObject
{
   private String name;
   //private int current_img;
   //private String[] imgs;

   public WorldObject(String name)
   {
      this.name = name;
      //this.imgs = imgs;
      //this.current_img = 0;
   }

/*   public String[] get_images()
   {
      return this.imgs;
   }

   public String get_image()
   {
      return this.imgs[this.current_img];
   }
*/
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
      return ((pt1.getX() == pt2.getX() && Math.abs(pt1.getY() - pt2.getY()) == 1) or 
             (pt1.getY() == pt2.getY() and Math.abs(pt1.getX() - pt2.getX()) == 1));
   }

   //public img get_image(entity)
}
