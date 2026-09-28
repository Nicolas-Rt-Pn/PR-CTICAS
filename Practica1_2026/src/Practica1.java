import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Practica1 {

    static public void separa(Set<String> unicos, Set<String> repetidos) {
        Set<String> repes = new HashSet<String>();
        repes.addAll(repetidos);
        repes.retainAll(unicos);

        Set<String> nicos = new HashSet<String>();
        nicos.addAll(unicos);
        nicos.addAll(repes);
        nicos.removeAll(repes);

        unicos.clear();
        unicos.addAll(nicos);
        repetidos.clear();
        repetidos.addAll(repes);
    }


    static public Set <Integer> filtra(Iterator<Integer> iter) {

        Set<Integer> all = new HashSet<Integer>();
        Set<Integer> nomult = new HashSet<Integer>();

        while (iter.hasNext()){
            Integer e = iter.next();

            if(!nomult.contains(e)){
                nomult.add(e);
            }
            for(Integer n : all){
                if(n%e==0) nomult.remove(n);
                if(e%n==0) nomult.remove(e);
            }
            if(!all.contains(e) || e>0){
                all.add(e);
            }
        }

        return nomult;
    }


    static public Set<String> repetidos (Collection<Set<String>> col) {

        return null;
    }


    public static Set<Integer> interseccionImpares (Collection<Set<Integer>> col) {
       return null;
    }


}
