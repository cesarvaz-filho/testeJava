import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pessoa {
  // criação dos atributos da classe Pessoa solicitados no item 1
  private String nome;
  private LocalDate dataNascimento;

  // criação do método construtor recebendo como parametro o nome e data.
  // Em seguida são inicializados com o valor passado no parametro.
  public Pessoa(String nome, LocalDate dataNascimento) {
    this.nome = nome;
    this.dataNascimento = dataNascimento;
  }

  // criação de função para retornar o nome
  public String getNome() {
    return nome;
  }

  // criação de função para retornar a data
  public LocalDate getDataNascimento() {
    return dataNascimento;
  }

  // essa função sobrescreve o comportamento padrão do ToString para exibir a
  // mensagem formatada como solicitada.
  @Override
  public String toString() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    return "Nome: " + nome + ", Data de Nascimento: " + dataNascimento.format(formatter);
  }
}
