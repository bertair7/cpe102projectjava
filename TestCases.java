import java.util.Comparator;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
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
   
   //resource_distance = 1
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
   public void testMinerFull()
   {
      MinerFull willy = new MinerFull("MinerFull", new Point(7, 1), 5, 2, 5);
      MinerFull billy = new MinerFull("MinerFull", new Point(4, 10), 5, 2, 5);
      
      assertEquals(willy.get_resource_count(), 2);
      assertEquals(billy.get_resource_limit(), 2);
      assertEquals(willy.get_position().getX(), 7);
      assertEquals(billy.get_position().getY(), 10);
      assertTrue(willy.get_rate() == billy.get_rate());
      assertTrue(willy.get_animation_rate() == billy.get_animation_rate());
   }

   @Test
   public void testMinerNotFull()
   {
      MinerNotFull milton = new MinerNotFull("MinerNotFull", new Point(5, 5), 
                            5, 2, 5);
      MinerNotFull harris = new MinerNotFull("MinerNotFull", new Point(9, -3),
                            5, 2, 5);
      
      assertEquals(milton.get_resource_count(), 0);
      assertEquals(harris.get_resource_limit(), 2);
      assertEquals(milton.get_position().getX(), 5);
      assertEquals(harris.get_position().getY(), -3);
      assertTrue(milton.get_rate() == harris.get_rate());
      assertTrue(harris.get_animation_rate() == milton.get_animation_rate());
   }

   @Test
   public void testObstacle()
   {
      Obstacle rock = new Obstacle("Obstacle", new Point(10, 10));
      Obstacle pool = new Obstacle("Obstacle", new Point(3, 8));

      assertTrue(rock.get_name() == "Obstacle");
      assertTrue(pool.get_name() == "Obstacle");
      assertEquals(rock.get_position().getY(), 10);
      assertEquals(pool.get_position().getX(), 3);
   }

   @Test
   public void testOreBlob()
   {
      OreBlob ob = new OreBlob("OreBlob", new Point(9, 1), 300, 200);
      OreBlob wan = new OreBlob("OreBlob", new Point(7, 0), 50, 100);

      assertEquals(ob.get_animation_rate(), 200);
      assertEquals(wan.get_animation_rate(), 100);
      assertEquals(ob.get_rate(), 300);
      assertEquals(wan.get_rate(), 50);
   }

   @Test
   public void testOre()
   {
      Ore oreo = new Ore("Ore", new Point(3, 4), 5000);
      Ore milk = new Ore("Ore", new Point(6, 8), 2000);
   
      assertEquals(oreo.get_rate(), 5000);
      assertEquals(milk.get_rate(), 2000);
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
      Quake earth = new Quake("Quake", new Point(6, 6), 12);
      Quake fire = new Quake("Quake", new Point(0, 1), 44);
    
      assertEquals(earth.get_animation_rate(), 12);
      assertEquals(fire.get_animation_rate(), 44);
      assertEquals(earth.get_position().getX(), 6);
      assertEquals(fire.get_position().getY(), 1);
      assertTrue(earth.get_name() == fire.get_name());
   }

   //resource_distance = 1
   @Test
   public void testVein()
   {
      Vein flabby = new Vein("Vein", new Point(3, 5), 10000, 1);
      Vein bird = new Vein("Vein", new Point(6, 7), 101, 1);
      
      assertEquals(flabby.get_rate(), 10000);
      assertEquals(bird.get_rate(), 101);
      assertEquals(flabby.get_position().getX(), 3);
      assertEquals(bird.get_position().getY(), 7);
      assertTrue(bird.get_resource_distance() == 
         flabby.get_resource_distance());
   }

   @Test
   public void testWorldModel()
   { 
      WorldEntity mel = new MinerNotFull("MinerNotFull", new Point(3, 2), 
         5, 2, 5);
      WorldEntity george = new MinerFull("MinerFull", new Point(9, 4), 
         5, 2, 5);
      WorldEntity ob = new OreBlob("OreBlob", new Point(2, 1), 300, 200);
      WorldEntity wan = new OreBlob("OreBlob", new Point(7, 0), 50, 100);
      WorldEntity oreo = new Ore("Ore", new Point(7, 1), 50);
      Point p1 = new Point(3, 1);
      WorldEntity milk = new Ore("Ore", p1, 200);
      WorldEntity rock = new Obstacle("Obstacle", new Point(10, 10));
      WorldEntity pool = new Obstacle("Obstacle", new Point(3, 7));
      WorldEntity flabby = new Vein("Vein", new Point(3, 5), 10000, 1);
      Point p2 = new Point(1, 0);
      WorldEntity aaron = new Blacksmith("Blacksmith", p2, 100, 10);
      WorldEntity earth = new Quake("Quake", new Point(6, 6), 12);
      
      WorldModel world = new WorldModel(15, 15);
      world.add_entity(mel);
      world.add_entity(george);
      world.add_entity(ob);
      world.add_entity(wan);
      world.add_entity(oreo);
      world.add_entity(milk);
      world.add_entity(rock);
      world.add_entity(pool);
      world.add_entity(flabby);
      world.add_entity(aaron);
      world.add_entity(earth);
      
      assertTrue(world.within_bounds(p1));
      assertTrue(world.within_bounds(p2));
      //assertTrue(world.is_occupied(p1));
      //assertTrue(world.is_occupied(p2));

      Point p3 = new Point(0, 0);
      assertEquals(world.get_tile_occupant(p3), null);
      //assertEquals(world.get_tile_occupant(p2), aaron);
      //assertEquals(world.find_nearest(mel.get_position(), milk), milk);
      //assertEquals(world.find_nearest(earth.get_position(), pool), pool);
     
      List<Point> move = new LinkedList<Point>();
      move.add(flabby.get_position());
      Point p4 = new Point(2, 5);
      move.add(p4);
      assertEquals(world.move_entity(flabby, p4), move); 
      List<Point> move2 = new LinkedList<Point>();
      move2.add(george.get_position());
      Point p5 = new Point(8, 4);
      move2.add(p5);
      assertEquals(world.move_entity(george, p5), move2);

      world.remove_entity(pool);
      assertEquals(world.get_tile_occupant(pool.get_position()), null);
      world.remove_entity(wan);
      assertEquals(world.get_tile_occupant(wan.get_position()), null);
   }

}
