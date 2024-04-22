package model;

public class Local {
  private int id;
  private String setor;

  public Local(int id, String setor) {
    this.id = id;
    this.setor = setor;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getSetor() {
    return setor;
  }

  public void setSetor(String setor) {
    this.setor = setor;
  }

  
  @Override
  public String toString() {
    return "Local [id=" + id + ", setor=" + setor + "]";
  }

}
