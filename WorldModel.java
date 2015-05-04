public class WorldModel
{
   private int num_rows;
   private int num_cols;
   private String[] entities;
   private Grid occupancy;
   
   public WorldModel(int num_rows, int num_cols)
   {
      this.num_rows = num_rows;
      this.num_cols = num_cols;
      this.entities = [];
      this.occupancy = new Grid(num_cols, num_rows, Null);
   }

   public boolean within_bounds(Point pt)
   {
      return (pt.getX() >= 0 && pt.getX() < this.num_cols && pt.getY() >= 0 && 
         pt.getY() < this.num_rows);
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

   public WorldObject find_nearest(Point pt, WorldObject type)
   {
      List[WorldObject][int] oftype = new List[WorldObject][int]();
      for(WorldObject e : this.entities)
      {
         if(e instanceof type)
         {
            oftype.add([e][Utility.distance_sq(pt, e.get_position())];
         }
      }
      return nearest_entity(oftype);
   }

   public List<Point> move_entity(WorldEntity entity, Point pt)
   {
      List<Point> tiles = new List<Point>();
      if(this.within_bounds(pt))
      {
         Point old_pt = entity.get_position();
         this.occupancy.set_cell(old_pt, None);
         tiles.add(old_pt);
         this.occupancy.set_cell(pt, entity);
         tiles.add(pt);
         entity.set_position(pt);
      }
      return tiles;
   }

   public void remove_entity(WorldEntity entity)
   {
      this.remove_entity_at(entity.get_position());
   }

   public void remove_entity_at(Point pt)
   {
      if(this.within_bounds(pt) && this.occupancy.get_cell(pt) != Null)
      {
         WorldEntity entity = this.occupancy.get_cell(pt);
         entity.set_position(new Point(-1, -1));
         this.entities.remove(entity);
         this.occupancy.set_cell(pt, Null);
      }
   }
}
