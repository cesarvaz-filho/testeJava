import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//criação da classe extendendo a classe Pessoa
class Funcionario extends Pessoa {
  // criação dos atributos da classe Funcionario solicitados no item 2
  private BigDecimal salario;
  private String funcao;

  // criação do método construtor recebendo como parametro: nome, data, salario e
  // função. Em seguida são inicializados com o valor passado no parametro.
  public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
    // o método super atribui à classe Funcionario os atributos herdados de Pessoa
    super(nome, dataNascimento);
    this.salario = salario;
    this.funcao = funcao;
  }

  // criação de função para retornar o salario
  public BigDecimal getSalario() {
    return salario;
  }

  // criação de função para setar o salario
  public void setSalario(BigDecimal salario) {
    this.salario = salario;
  }

  // criação de função para retornar a função
  public String getFuncao() {
    return funcao;
  }

  // essa função sobrescreve o comportamento padrão do ToString para exibir a
  // mensagem formatada como solicitada através do objeto DateTimeFormatter.
  @Override
  public String toString() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    return "Nome: " + getNome() + ", Data de Nascimento: " + getDataNascimento().format(formatter) +
        ", Salário: " + String.format("%,.2f", salario) + ", Função: " + funcao;
  }
}