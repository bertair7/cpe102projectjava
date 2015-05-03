public class WorldObject
{
   private String name;
   //private int current_img;
   //private String[] imgs;

   public Entity(String name)
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

   public int sign(x)
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

   //public boolean adjacent(Point pt1, Point pt2)

   //public img get_image(entity)
}
