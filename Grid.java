public class Grid
{ 
   private final int EMPTY = 0;
   private final int GATHERER = 1;
   private final int GENERATOR = 2;
   private final int RESOURCE = 3;

   private int width;
   private int height;
   private List<List<boolean>> cells = new LinkedList<List<boolean>>();

   public Grid(int width, int height, boolean occupancy_value)
   {
      this.width = width;
      this.height = height;
      this.cells.add(new LinkedList<boolean>());
     
      for(int r = 0; r < this.height; r++)
      {
         this.cells.add([])
         for(int c = 0; c < this.width; c++)
         {
            this.cells[r].add(occupancy_value);
         }
      }
   }

   public void set_cell(Point point, int value)
   {
      this.cells[point.getX()][point.getY()] = value;
   }
 
   public int get_cell(Point point)
   {
      return this.cells[point.getX()][point.getY()];
   }
}
