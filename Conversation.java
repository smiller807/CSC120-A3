import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
class Conversation implements Chatbot {
  // Attributes 
  private int rounds;
  private String text;
  private String response;

  /**
   * Constructor 
   * @param rounds how many rounds the chatbot will interact with the user given by user
   * @param text text from the user
   * @param response chatbot response
   * @param words words being replaced
   */
  Conversation() {
    this.rounds = 0;
    this.text = text;
    this.response = response;
  }

  //getters
  public int getRounds(int rounds){
    return this.rounds;
  }
  public String getText(String text){
    return this.text;
  }
  public String getResponse(String response){
    return this.response;
  }

  /**
   * Starts and runs the conversation with the user
   */
  public void chat() {
    //open scanner
    Scanner scanner = new Scanner(System.in);
    //create mirror list
    Map<String, String> mirrorWords = new HashMap<>();

    //create mirror mappings
    mirrorWords.put("I", " you");
    mirrorWords.put("me ", "you");
    mirrorWords.put("am ", "are");
    mirrorWords.put("you", "I");
    mirrorWords.put("my", "your");
    mirrorWords.put("your", "my");

    //number of rounds
    System.out.println("How many rounds?: ");
    this.rounds = scanner.nextInt();
    scanner.nextLine();
    System.out.println("Hello! What's on your mind?");

    for (int i = 0; i <= rounds; i++) {
        String text = scanner.nextLine();
        String[] words = text.split(" ");
        String response = "";

        for (String word : words) {
            String replacement = mirrorWords.getOrDefault(word, word);
            if (replacement.equals("i")) {
                replacement = "I"; // Capitalize when needed
            }
            response += replacement + " ";
        }
        System.out.println(response.trim());
    }
    System.out.println("Ok! bye");
    scanner.close();
  }

  /**
   * Prints transcript of conversation
   */
  public void printTranscript() {

  }

  /**
   * Gives appropriate response (mirrored or canned) to user input
   * @param inputString the users last line of input
   * @return mirrored or canned response to user input  
   */
  public String respond(String inputString) {
    String returnString = ""; 
    return returnString; 
  }

  public static void main(String[] arguments) {
    Conversation myConversation = new Conversation();
    myConversation.chat();
    myConversation.printTranscript();
  }
}
