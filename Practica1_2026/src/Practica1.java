import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Practica1 {

    static public void separa(Set<String> unicos, Set<String> repetidos) {
        Set<String> comunes = new HashSet<>(unicos);
        comunes.retainAll(repetidos);

        Set<String> nuevosUnicos = new HashSet<>(unicos);
        nuevosUnicos.addAll(repetidos);
        nuevosUnicos.removeAll(comunes);

        unicos.clear();
        unicos.addAll(nuevosUnicos);

        repetidos.clear();
        repetidos.addAll(comunes);
    }


    static public Set<Integer> filtra(Iterator<Integer> iter) {
        Set<Integer> all = new HashSet<>();
        Set<Integer> nomult = new HashSet<>();

        while (iter.hasNext()) {
            Integer e = iter.next();
            if (e > 0) {
                if (!all.contains(e)) {
                    nomult.add(e);

                    for (Integer n : all) {
                        if (n % e == 0) {
                            nomult.remove(n);
                        }
                        if (e % n == 0) {
                            nomult.remove(e);
                        }
                    }
                    all.add(e);
                }
            }
        }

        return nomult;
    }


    static public Set<String> repetidos(Collection<Set<String>> col) {
        Set<String> repes = new HashSet<>();
        if (col == null || col.size() < 2) {
            return repes;
        }

        Set<String>[] arraySets = col.toArray(new Set[0]);

        for (int i = 0; i < arraySets.length; i++) {
            for (int j = i + 1; j < arraySets.length; j++) {
                Set<String> aux = new HashSet<>(arraySets[i]);
                aux.retainAll(arraySets[j]);
                repes.addAll(aux);
            }
        }

        return repes;
    }


    public static Set<Integer> interseccionImpares(Collection<Set<Integer>> col) {
        if (col == null || col.isEmpty()) {
            return new HashSet<>();
        }

        Iterator<Set<Integer>> iter = col.iterator();
        Set<Integer> resultado = new HashSet<>(iter.next());

        while (iter.hasNext()) {
            resultado.retainAll(iter.next());
        }
        resultado.removeIf(num -> num % 2 == 0);

        return resultado;
    }
}