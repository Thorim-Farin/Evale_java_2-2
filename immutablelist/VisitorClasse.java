package immutablelist;

import functionalInterface.cartographie.Ville;

public class VisitorClasse implements VisiteurInterface {
   @Override
   public Integer length_visitor (Cons c) {
      if( c.isEmpty() ) {
         return Integer.valueOf(0);
      }
      return 1 + length_visitor((Cons) c.tail());
   }

   @Override
   public Integer length_visitor(Nil n) {
      if( n.isEmpty() ) {
         return Integer.valueOf(0);
      }
      return 1 + length_visitor((Nil) n.tail());
   }
}


