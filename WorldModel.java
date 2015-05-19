import java.util.*;
import processing.core.*;

public class WorldModel
{
   private int num_rows;
   private int num_cols;
   private List<WorldEntity> entities;
   private Grid occupancy;
   private OrderedList action_queue;
   private Grid background;
   
   public WorldModel(int num_rows, int num_cols, WorldObject bgnd)
   {
      this.num_rows = num_rows;
      this.num_cols = num_cols;
      this.entities = new LinkedList<WorldEntity>();
      this.occupancy = new Grid(num_cols, num_rows, null);
      this.action_queue = new OrderedList();

      for(int y = 0; y < num_rows; y++)
      {
         for(int x = 0; x < num_cols; x++)
         {
            this.background[x][y] = bgnd;
         }
      }
   }

   public boolean within_bounds(Point pt)
   {
      return (pt.getX() >= 0 && pt.getX() < this.num_cols && pt.getY() >= 0 && 
         pt.getY() < this.num_rows);
   }

   public boolean is_occupied(Point pt)
   {
      return (within_bounds(pt) && (this.occupancy.get_cell(pt) != null));
   }

   public PImage get_background(Point pt)
   {
      if(within_bounds(pt))
      {
         return this.background[pt.getX()][pt.getY()];
      }
      return null;
   }

   public void set_background(Point pt, WorldObject bgnd)
   {
      if(within_bounds(pt))
      {
         this.background[pt.getX()][pt.getY()] = bgnd;
      }
      return null;
   }
   
   public List<WorldEntity> get_entities()
   {
      return this.entities;
   }

   public WorldEntity find_nearest(Point pt, WorldEntity type)
   {
      List<Integer> entity_dists = new ArrayList<Integer>();
      List<WorldEntity> entity = new ArrayList<WorldEntity>();
      for(WorldEntity e : this.entities)
      {
         if(e.getClass().equals(type.getClass()))
         {
            entity_dists.add(Utility.distance_sq(pt, e.get_position()));
            entity.add(e);
         }
      }
      return Utility.nearest_entity(entity, entity_dists);
   }

   public void add_entity(WorldEntity entity)
   {
      Point pt = entity.get_position();
      if(within_bounds(pt))
      {
         WorldEntity old_entity = this.occupancy.get_cell(pt);
         if(old_entity != null)
         {
            old_entity.clear_pending_actions();
         }
         this.occupancy.set_cell(pt, entity);
         this.entities.add(entity);
      }
   }

   public List<Point> move_entity(WorldEntity entity, Point pt)
   {
      List<Point> tiles = new LinkedList<Point>();
      if(within_bounds(pt))
      {
         Point old_pt = entity.get_position();
         this.occupancy.set_cell(old_pt, null);
         tiles.add(old_pt);
         this.occupancy.set_cell(pt, entity);
         tiles.add(pt);
         entity.set_position(pt);
      }
      return tiles;
   }

   public WorldEntity get_tile_occupant(Point pt)
   {
      if(within_bounds(pt))
      {
         return this.occupancy.get_cell(pt);
      }
      else
      {
         return null;
      }
   }

   public void remove_entity(WorldEntity entity)
   {
      remove_entity_at(entity.get_position());
   }

   public void remove_entity_at(Point pt)
   {
      if(within_bounds(pt) && this.occupancy.get_cell(pt) != null)
      {
         WorldEntity entity = this.occupancy.get_cell(pt);
         entity.set_position(new Point(-1, -1));
         this.entities.remove(entity);
         this.occupancy.set_cell(pt, null);
      }
   }

   public void schedule_action(Action action, long time)
   {  
      this.action_queue.insert(action, time);
   }

   public void unschedule_action(Action action, long time)
   {
      this.action_queue.remove(action);
   }

   public void update_on_time(int ticks)
   {  
      //tiles = [];    
      ListItem next = this.action_queue.head();
      while((next != null) && next.ord < ticks)
      {
         this.action_queue.pop();
         //tiles.extend(next.run(ticks));
         next = this.action_queue.head();
      }
   }
}
