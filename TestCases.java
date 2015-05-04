import java.util.Comparator;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.junit.Before;

public class TestCases
{
   @Test
   public void testBackground()
   {
      Background bgnd = new Background("Background");
      assertEquals(bgnd.get_name(), "Background");
   }
   
   @Test
   public void testBlacksmith()
   {
      Point p1 = new Point(4, 4);
      Blacksmith walter = new Blacksmith("Blacksmith", p1, 100, 10);
      Point p2 = new Point(6, 1);
      Blacksmith aaron = new Blacksmith("Blacksmith", p2, 100, 10);

      assertEquals(walter.get_resource_limit(), 10);
      assertEquals(walter.get_position(), p1);
      assertTrue(aaron.get_rate() == 100);
      assertTrue(aaron.get_resource_distance() == 1);
      assertEquals(walter.get_rate(), aaron.get_rate());
   }

   @Test
   public void testGrid()
   {
      //List<List<WorldEntity>> cells = new LinkedList<List<WorldEntity>>
   }
   
   @Test
   public void testMinerFull()
   {
      //MinerFull mf = new MinerFull(
   }

   @Test
   public void testMinerNotFull()
   {
      //MinerNotFull mnf = new MinerNotFull(
   }

   @Test
   public void testObstacle()
   {
      //Obstacle obs = new Obstacle(
   }

   @Test
   public void testOreBlob()
   {
      //OreBlob ob = new OreBlob(
   }

   @Test
   public void testOre()
   {
      //Ore ore = new Ore(
   }

   @Test
   public void testPoint()
   {
      Point pt1 = new Point(2, 3);
      Point pt2 = new Point(1, -6);

      assertEquals(pt1.getX(), 2);
      assertEquals(pt1.getY(), 3);
      assertEquals(pt2.getX(), 1);
      assertEquals(pt2.getY(), -6);
   }

   @Test
   public void testQuake()
   {
      //Quake q = new Quake(
   }

   @Test
   public void testVein()
   {
      //Vein v = new Vein(
   }

   @Test
   public void testWorldModel()
   {
      //WorldModel world = new WorldModel(
   }

}
