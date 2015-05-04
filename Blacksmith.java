public class Blacksmith
   extends Actor
{ 
   private int resource_limit;
   private int resource_count;
   private int resource_distance;
   private int rate;
  
   public Blacksmith(String name, Point position, int rate, int resource_limit)
   {
      super(name, position);
      this.resource_limit = resource_limit;
      this.rate = rate;
      this.resource_count = 0;
      this.resource_distance = 1;
   }

   public int get_rate()
   {
      return this.rate;
   }

   public void set_resource_count(int n)
   {
      this.resource_count = n;
   }

   public int get_resource_count()
   {
      return this.resource_count;
   }

   public int get_resource_limit()
   {
      return this.resource_limit;
   }

   public int get_resource_distance()
   {
      return this.resource_distance;
   }

}
