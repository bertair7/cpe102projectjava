public class Utility
{
   public static WorldObject nearest_entity(List[WorldObject][int] entity_dists)
   {
      WorldObject nearest;
      if(entity_dists.length > 0)
      {
         WorldObject pair = entity_dists.get(0);
         for(int other : entity_dists[0])
         {
            if(other[1] < pair[1])
            {
               pair = other;
            }
         }
         nearest = pair[0];
      }
      else
      {
         return Null;
      }
      
      return nearest;
   }

   public static int distance_sq(Point p1, Point p2)
   {
      int dX = (p1.getX() - p2.getX()) * (p1.getX() - p2.getX());
      int dY = (p1.getY() - p2.getY()) * (p1.getY() - p2.getY());
      return dX + dY;
   }
}
