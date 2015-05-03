public class WorldEntity
   extends WorldObject
{
   private Point position;
 
   public WorldEntity(String name, Point position)
   {
      super(name);
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
