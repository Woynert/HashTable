
import edu.*;
import java.util.Random;
import java.lang.Math;


public class main{

  //terminal colors
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_RED   = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";

  public static void main(String[] args) {

    //create hash table
    Hash myHash = new Hash( (int) Math.pow(2, 10) ); //N Elements -> potencia de dos (1024)

    //vars
    Employe myEmploye;
    int posInserted;

    //insert one thousand values automatically
    for(int i = 0; i < 1000; i++){

      //new employee
      myEmploye = new Employe(generateName(), generateName(), randomIntRange(1000, 9999), randomIntRange(18, 50));

      posInserted = myHash.insert(myEmploye);

      //check
      if (posInserted >= 0){
        System.out.println(ANSI_GREEN + "Inserted in " + String.valueOf(posInserted) + " " + ANSI_RESET + myEmploye.toString());
      }
      else{
        System.out.println(ANSI_RED + "Not inserted " + String.valueOf(myHash.getSize()) + "/" + String.valueOf(myHash.getLength()) + " " + ANSI_RESET +  myEmploye.toString());
      }

    }

    //manual insertion
    System.out.println( "\nMANUAL INSERTION" );
    myEmploye = new Employe("Woynert", "Red", 8888, 20);
    posInserted = myHash.insert(myEmploye);

    //show flag
    if (posInserted >= 0){
      System.out.println(ANSI_GREEN + "Inserted in " + String.valueOf(posInserted) + " " + ANSI_RESET + myEmploye.toString());
    }

    //manual recovery
    System.out.println( "\nMANUAL RECOVERY" );
    Employe myEmployeBack = (Employe) myHash.getObject("Woynert", 8888);

    //show flag
    if (myEmployeBack != null){
      System.out.println(ANSI_GREEN + "Recovered: " + myEmployeBack.toString() + ANSI_RESET);
    }

    //Stadistics
    System.out.println( "\nCOLLISION AT INSERT RATE" );
    System.out.println( String.valueOf( myHash.getInsertedByCollision() ) + "/" + String.valueOf( myHash.getSize() ));
  }

  //generate a name
  private static String generateName(){

    String name   = "";
    int[] vocals  = {97, 101, 105, 111, 117};

    //lengt in range
    int length = randomIntRange(3, 8);

    //generate first (UPPERCASE)
    name += (char) randomIntRange(65, 90);

    //generate rest (LOWERCASE)
    for (int i = 0; i < length-1; i++){

      //vocal
      if (i % 2 == 0)
      name += (char) vocals[randomIntRange(0, 4)];

      //consonant
      else
      name += (char) randomIntRange(97, 122);

    }

    return name;
  }

  //get random number in range
  private static int randomIntRange(int min, int max){
    Random random = new Random();
    return (min + random.nextInt(max - min +1));
  }


}
