import java.util.*;

public class Grid
{ 
   private static final int EMPTY = 0;
   private static final int GATHERER = 1;
   private static final int GENERATOR = 2;
   private static final int RESOURCE = 3;

   private int width;
   private int height;
   private List<List<WorldEntity>> cells = new LinkedList<List<WorldEntity>>();

   public Grid(int width, int height, WorldEntity occupancy_value)
   {
      this.width = width;
      this.height = height;
     
      for(int r = 0; r < this.height; r++)
      {
         this.cells.add(new LinkedList<WorldEntity>());
         for(int c = 0; c < this.width; c++)
         {
            this.cells.get(r).add(occupancy_value);
         }
      }
   }

   public void set_cell(Point point, WorldEntity value)
   {
      this.cells.get(point.getY()).set(point.getX(), value);
   }
 
   public WorldEntity get_cell(Point point)
   {
      return this.cells.get(point.getX()).get(point.getY());
   }
}
