import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

class Conversation implements Chatbot {
  // Attributes 
  private int rounds;
  private String transcript;

  //open scanner
  Scanner scanner = new Scanner(System.in);
  //create mirror list
  Map<String, String> mirrorWords = new HashMap<>();

  /**
   * Constructor 
   * @param rounds how many rounds the chatbot will interact with the user given by user
   * @param transcript adds the input and output to the transcript
   */
  Conversation() {
    this.rounds = 0;
    this.transcript = "";
  }

  //getters
  public int getRounds(int rounds){
    return this.rounds;
  }

  /**
   * Starts and runs the conversation with the user
   */
  public void chat() {
    //create mirror mappings
    mirrorWords.put("I", " you");
    mirrorWords.put("me", "you");
    mirrorWords.put("am", "are");
    mirrorWords.put("you", "I");
    mirrorWords.put("my", "your");
    mirrorWords.put("your", "my");
    mirrorWords.put("are", "am");

    //number of rounds
    System.out.println("How many rounds?: ");
    this.rounds = scanner.nextInt();
    scanner.nextLine();
    System.out.println("Hello! What's on your mind?");

    for (int i = 0; i < rounds; i++) {
      String text = scanner.nextLine();
      String response = respond(text);
      System.out.println(response);
      transcript += "User: " + text + "\n";
      transcript += "Chatbot: " + response + "\n";
    }
    System.out.println("Ok! bye");
    scanner.close();
  }

  /**
   * Prints transcript of conversation
   */
  public void printTranscript() {
    System.out.println("\n-----------");
    System.out.println("TRANSCRIPT");
    System.out.println("-----------");
    System.out.println(transcript);
    System.out.println("Ok! bye");
  }

  /**
   * Gives appropriate response (mirrored or canned) to user input
   * @param inputString the users last line of input
   * @return mirrored or canned response to user input  
   */
  public String respond(String inpuString) {
    String[] words = inpuString.split(" ");
    String response = "";

    //check if any mirrorWord is in the input
    boolean containsMirror = false;
    for (String word : words) {
        if (mirrorWords.containsKey(word)){
            containsMirror = true;
            break;
        }
    }

    if (containsMirror){
      for (String word : words) {
        String replacement = mirrorWords.getOrDefault(word, word);
        if (replacement.equals("i")) {
            replacement = "I"; // Capitalize when needed
        }
        response += replacement + " ";
      }
      return response.trim();
    } else {
      System.out.println("mmm ok.");
    }
    return inpuString;
  }

  public static void main(String[] arguments) {
    Conversation myConversation = new Conversation();
    myConversation.chat();
    myConversation.printTranscript();
  }
}
