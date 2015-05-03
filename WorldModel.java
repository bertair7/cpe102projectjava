public class WorldModel
{
   private int num_rows;
   private int num_cols;
   private String[] entities;
   private Grid occupancy;
   private Grid background;
  
   public WorldModel(int num_rows, int num_cols, Grid background)
   {
      this.background = Occ_Grid(num_cols, num_rows, background);
      this.num_rows = num_rows;
      this.num_cols = num_cols;
      this.entities = [];
      this.occupancy = Occ_Grid(num_cols, num_rows, Null);
   }

   public boolean within_bounds(Point pt)
   {
      return (pt.getX() >= 0 && pt.getX() < this.num_cols && pt.getY() >= 0 && 
         pt.getY() < this.num_rows)
   }

   public boolean is_occupied(Point pt)
   {
      return (this.within_bounds(pt) && this.occupancy.get_cell(pt) != None);
   }

   public Background get_background(Point pt)
   {
      if(this.within_bounds(pt))
      {
         return this.background.get_cell(pt);
      }
   }

   public Background set_background(Point pt, Background bgnd)
   {
      if(this.within_bounds(pt))
      {
         this.background.set_cell(pt, bgnd);
      }
   }

   public Background get_tile_occupant(Point pt)
   {
      if(this.within_bounds(pt))
      {
         return this.occupancy.get_cell(pt);
      }
   }
   
   public String[] get_entities()
   {
      return this.entities;
   }

   public Type
}
