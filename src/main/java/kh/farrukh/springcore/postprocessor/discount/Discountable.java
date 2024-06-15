package kh.farrukh.springcore.postprocessor.discount;

public abstract class Discountable {

  protected int discount;

  public abstract String getQualifier();

  public int getDiscount() {
    return this.discount;
  }

  public void setDiscount(int discount) {
    this.discount = discount;
  }

}
