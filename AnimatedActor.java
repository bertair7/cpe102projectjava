public class AnimatedActor
   extends Actor
{
   private int rate;

   public AnimatedActor(String name, Point position, int rate)
   {
      super(name, position);
      this.rate = rate;
   }

   public Point next_position(WorldModel world, Point dest_pt)
   {
      int horiz = sign(dest_pt.getX() = this.position.getX());
      Point new_pt = Point(this.position.getX() + horiz, this.position.getY());
      
      if((horiz == 0) || world.is_occupied(new_pt))
      {
         int vert = sign(dest_pt.getY() - this.position.getY());
         new_pt = Point(this.position.getX(), this.position.getY() + vert);
      
         if((vert == 0) || world.is_occupied(new_pt))
         {
            new_pt = Point(this.position.getX(), this.position.getY());
         }
      }
      
      return new_pt;
   }

   public int get_rate()
   {
      return this.rate;
   }
}
