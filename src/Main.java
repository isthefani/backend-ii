import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        Integer numero = numeros.stream().reduce(0, (a,b) -> a+b);
        System.out.println(numero);
    }
}