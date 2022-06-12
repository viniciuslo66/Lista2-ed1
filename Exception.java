public class Exception extends RuntimeException {

  private static final long serialVersionUID = 4652958143051993454L;

  private String descricao = "";

  public Exception(String descricao) {
    super(descricao);

    this.descricao = descricao;
  }

  public String getdescricao() {
    return descricao;
  }

}
