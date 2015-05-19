import java.util.*;
import java.lang.Math;

public class Utility
{
   public static WorldEntity nearest_entity(List<WorldEntity> 
      entity, List<Integer> entity_dists)
   {
      if(entity_dists.size() > 0)
      {
         WorldEntity min = entity.get(0);
         int pair = entity_dists.get(0);
         for(int i = 1; i < entity_dists.size(); i++)
         {
            if(entity_dists.get(i) < pair)
            {
               min = entity.get(i);
            }
         }
         return min;
      }
      else
      {
         return null;
      }
    
   }

   public static int distance_sq(Point p1, Point p2)
   {
      int dX = (p1.getX() - p2.getX()) * (p1.getX() - p2.getX());
      int dY = (p1.getY() - p2.getY()) * (p1.getY() - p2.getY());
      return dX + dY;
   }

   public static PImage get_image(WorldEntity entity)
   { 
      return entity.imgs.get(entity.current_img);
   }
}
