public class AnimatedActor
   extends Actor
{ 
   protected int rate;

   public AnimatedActor(String name, List<PImage> images, Point position, int 
      rate)
   {
      super(name, images, position);
      this.rate = rate;
   }

   public Point next_position(WorldModel world, Point dest_pt)
   {
      int horiz = sign(dest_pt.getX() - this.get_position().getX());
      Point new_pt = new Point(this.get_position().getX() + horiz, 
                     this.get_position().getY());
      
      if((horiz == 0) || world.is_occupied(new_pt))
      {
         int vert = sign(dest_pt.getY() - this.get_position().getY());
         Point new_pt2 = new Point(this.get_position().getX(), 
                        this.get_position().getY() + vert);
      
         if((vert == 0) || world.is_occupied(new_pt2))
         {
            Point new_pt3 = new Point(this.get_position().getX(), 
                           this.get_position().getY());
            return new_pt3;
         }
         else
         {
            return new_pt2;
         }
      }
      else
      {
         return new_pt;
      }
      
      
   }

   public int get_rate()
   {
      return this.rate;
   }
}
