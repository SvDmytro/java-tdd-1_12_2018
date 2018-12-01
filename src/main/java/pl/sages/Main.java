package pl.sages;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    for(int i = 0; i < 100; i++){
      System.out.println("Hello");
      Thread.sleep(2000);
    }
  }

  public boolean method() {
    System.out.println("aaaa");
    return true;
  }
}
