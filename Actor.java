import java.util.List;
import java.util.ArrayList;
import processing.core.*;

public class Actor
   extends WorldEntity
{ 
   protected List<Action> pending_actions;

   public Actor(String name, List<PImage> images, Point position)
   {
      super(name, images, position);
      this.pending_actions = new ArrayList<Action>();
   }
   
   public void remove_pending_action(Action action)
   {
      this.pending_actions.remove(action);
   }

   public void add_pending_action(Action action)
   {
      this.pending_actions.add(action);
   }

   public List<Action> get_pending_actions()
   {
      if(!this.pending_actions.isEmpty())
      {
         return this.pending_actions;
      }
      else
      {
         return null;
      }
   }

   public void clear_pending_actions()
   {
      this.pending_actions = null;
   }

   public void next_image()
   {
      this.current_img = (this.current_img + 1) % this.get_images().size();
   }
}
