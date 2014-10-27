package client;

public class graphicLessInteract {
    native void writetotty();
    
    public static void main(String[] args) {
      new graphicLessInteract().writetotty();  // invoke the native method
   } 
    
}
