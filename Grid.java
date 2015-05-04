public class Grid
{ 
   private static final int EMPTY = 0;
   private static final int GATHERER = 1;
   private static final int GENERATOR = 2;
   private static final int RESOURCE = 3;

   private int width;
   private int height;
   private List<List<boolean>> cells = new LinkedList<List<boolean>>();

   public Grid(int width, int height, boolean occupancy_value)
   {
      this.width = width;
      this.height = height;
     
      for(int r = 0; r < this.height; r++)
      {
         this.cells.add(new LinkedList<boolean>());
         for(int c = 0; c < this.width; c++)
         {
            this.cells[r].add(occupancy_value);
         }
      }
   }

   public void set_cell(Point point, boolean value)
   {
      this.cells[point.getX()][point.getY()] = value;
   }
 
   public boolean get_cell(Point point)
   {
      return this.cells[point.getX()][point.getY()];
   }
}
