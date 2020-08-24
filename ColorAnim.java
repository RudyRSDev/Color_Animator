import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class ColorAnim {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        
        // List of hex holors (currently a rainbow)
        String[] hexColors = { "#e60000","#e62900","#e65300","#e67c00","#e6a500","#e6cf00","#d3e600","#aae600","#81e600","#57e600","#2ee600","#05e600","#00e625","#00e64e","#00e677","#00e6a1","#00e6ca","#00d8e6","#00aee6","#0085e6","#005ce6","#0032e6","#0009e6","#4900e6","#7300e6","#9c00e6","#c500e6","#e600dc"};
        System.out.println("Number of Hex Colors: " + hexColors.length + "\n");
        
        // Ask for user input
        System.out.print("Please Enter a String: ");
        String inputText = userInput.nextLine();

        try {
            // Create object to write to file
            FileWriter outputFile = new FileWriter(inputText + ".txt");
            // Split each character of input string into an element of an array
            String[] lineSplit = inputText.split("");
            // Save value for current color index
            int currentColorIndex = 0;

            // Loop through hex colors
            for (int colorIndex = 0; colorIndex < hexColors.length; colorIndex++) {
                
                // Initialize frame as empty string
                String frame = "";

                // Add dash and starting quote at beginning of frame
                frame += "- \"";

                // Loop through input text characters
                for (int textIndex = 0; textIndex < lineSplit.length; textIndex++) {
                    // Current color will be current text index + current color index
                    currentColorIndex = textIndex + colorIndex;

                    // If currentColorIndex is >= length of hexColors, mod the value to wrap to beginning
                    if (currentColorIndex >= hexColors.length)
                        currentColorIndex %= hexColors.length;

                    // Concatenate hex color and input text to the frame
                    frame += hexColors[currentColorIndex] + lineSplit[textIndex];
                }

                // Add ending quote at end of the frame
                frame += "\"\n";

                // Print to screen Testing Purposes
                //System.out.print(frame);
                // Write frame to file
                outputFile.write(frame);
                System.out.print("0");

                // If current color index equals length of total hex colors, exit loop
                if (currentColorIndex == hexColors.length)
                    break;

            }
            outputFile.close();
            System.out.println("\nFinished writing all frames to file");
        } 
        catch (Exception error) {
            System.out.println("Error Found: " + error.toString());
        }
    }
}