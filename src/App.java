import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//mantive o nome padrão da classe principal quando se cria um novo projeto Java sem framework - item 3
public class App {
    public static void main(String[] args) throws Exception {
        // criação de um array para adicionar as pessoas, conforme 3.1.
        List<Funcionario> funcionarios = new ArrayList<>(Arrays.asList(
                // Cada chamada da do construtor Funcionario insere uma pessoa passando nos
                // parametros as info que constam na tabela do desafio.
                new Funcionario("Maria", LocalDate.of(2000, Month.OCTOBER, 18), new BigDecimal("2009.44"), "Operador"),
                new Funcionario("João", LocalDate.of(1990, Month.MAY, 12), new BigDecimal("2284.38"), "Operador"),
                new Funcionario("Caio", LocalDate.of(1961, Month.MAY, 2), new BigDecimal("9836.14"), "Coordenador"),
                new Funcionario("Miguel", LocalDate.of(1988, Month.OCTOBER, 14), new BigDecimal("19119.88"), "Diretor"),
                new Funcionario("Alice", LocalDate.of(1995, Month.JANUARY, 5), new BigDecimal("2234.68"),
                        "Recepcionista"),
                new Funcionario("Heitor", LocalDate.of(1999, Month.NOVEMBER, 19), new BigDecimal("1582.72"),
                        "Operador"),
                new Funcionario("Arthur", LocalDate.of(1993, Month.MARCH, 31), new BigDecimal("4071.84"), "Contador"),
                new Funcionario("Laura", LocalDate.of(1994, Month.JULY, 8), new BigDecimal("3017.45"), "Gerente"),
                new Funcionario("Heloísa", LocalDate.of(2003, Month.MAY, 24), new BigDecimal("1606.85"), "Eletricista"),
                new Funcionario("Helena", LocalDate.of(1996, Month.SEPTEMBER, 2), new BigDecimal("2799.93"),
                        "Gerente")));

        // Remove o funcionário “João” da lista usando expressão lambda para encontrar o
        // João. Conforme item 3.2
        funcionarios.removeIf(func -> func.getNome().equals("João"));

        // Imprime todos os funcionários com todas suas informações conforme item 3.3
        System.out.println("Todos os Funcionários:");
        funcionarios.forEach(System.out::println);

        // Atualiza a lista de funcionários com 10% de aumento conforme item 3.4
        // o forEach percorre toda a lista e aplica 10% de aumento no salario ja
        // existente usando função lambda
        funcionarios.forEach(func -> func.setSalario(func.getSalario().multiply(new BigDecimal("1.1"))));

        // Agrupa os funcionários por função em um MAP conforme 3.5

        // Imprime os funcionários, agrupados por função conforme 3.6
        System.out.println("\nFuncionários Agrupados por Função:");

        // Imprime os funcionários que fazem aniversário no mês 10 e 12 conforme 3.8
        System.out.println("\nFuncionários com aniversário em outubro e dezembro:");
        // cria um fluxo a partir de funcionarios. Em seguida filtro cada elemento e
        // aplica uma função que verifica se o mês é dezembro ou outubro e imprime cada
        // elemento.
        funcionarios.stream()
                .filter(func -> func.getDataNascimento().getMonth() == Month.OCTOBER
                        || func.getDataNascimento().getMonth() == Month.DECEMBER)
                .forEach(System.out::println);

        // Imprime o funcionário com a maior idade conforme 3.9
        // captura o maio elemento da lista de funcionários
        Funcionario maisVelho = Collections.max(funcionarios, Comparator.comparing(Funcionario::getDataNascimento));
        // calcula a idade baseado na idade atual - nascimento da pessoa
        int idade = LocalDate.now().getYear() - maisVelho.getDataNascimento().getYear();
        // imprime o resultado da maior idade
        System.out.println("\nFuncionário com a maior idade: " + maisVelho.getNome() + " - Idade: " + idade);

        // Imprime a lista de funcionários em ordem alfabética conforme 3.10
        System.out.println("\nFuncionários em ordem alfabética:");
        // faz ordenação da lista de funcionarios com a função sort e percorre a lista
        // para imprimir uma linha para cada elemento
        funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .forEach(System.out::println);

        // Imprime o total dos salários dos funcionários conforme 3.11
        // cria fluxo sequencial com a lista de funcionarios
        BigDecimal totalSalarios = funcionarios.stream()
                .map(Funcionario::getSalario)
                // metodo de acumulação de salario. O salario é somada cada vez que a função ler
                // um novo elemento
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("\nTotal dos salários dos funcionários: " + String.format("%,.2f", totalSalarios));

        // Imprime quantos salários mínimos ganha cada funcionário conforme 3.12
        // cria variavel para guardar o salario sugerido de R$1212.
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        System.out.println("\nSalários em relação ao salário mínimo:");
        // percorre cada elemento da lista funcionarios
        funcionarios.forEach(func -> {
            // captura o valor de salario de cada elemento da lista e imprime
            BigDecimal salariosMinimos = func.getSalario().divide(salarioMinimo, 2);
            System.out.println(func.getNome() + " ganha " + salariosMinimos + " salários mínimos.");
        });
    }
}
