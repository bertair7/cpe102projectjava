import java.util.Comparator;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static.org.junit.Assert.fail;
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
      Blacksmith walter = new Blacksmith("Blacksmith", p1, 100, 10, 1);
      Point p2 = new Point(6, 1);
      Blacksmith aaron = new Blacksmith("Blacksmith", p2, 100, 10, 1);

      assertEquals(walter.get_resource_limit(), 10);
      assertEquals(walter.get_position(), p1);
      assertTrue(aaron.get_rate() == 100);
      assertTrue(aaron.get_resource_distance() == 1);
      assertEquals(walter.get_rate(), aaron.get_rate());
   }

   @Test
   public void testGrid()
   {
   
   }
   
   @Test
   public void testMinerFull()
   {
   
   }

   @Test
   public void testMinerNotFull()
   {
   
   }

   @Test
   public void testObstacle()
   {
   
   }

   @Test
   public void testOreBlob()
   {
   
   }

   @Test
   public void testOre()
   {
   
   }

   @Test
   public void testPoint()
   {
   
   }

   @Test
   public void testQuake()
   {
   
   }

   @Test
   public void testVein()
   {
   
   }

   @Test
   public void testWorldModel()
   {
   
   }

}
