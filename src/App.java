import java.util.Random;
import java.util.Scanner;

import java.awt.datatransfer.*;
import java.awt.Toolkit;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        String str = scan.nextLine();

        while(str != "stop") {

            String[] tab = str.split(" ");
            String result = "";

            for (int i = 0; i < tab.length; i++) {
                result = result + gogole(tab[i]) +" ";
            }

            System.out.println(result);

            StringSelection stringSelection = new StringSelection(result);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);

            str = scan.nextLine();
            if(str=="stop") break;
        }

        scan.close();
    }

    private static String gogole(String s){

        if(s.length()==1) return s;
        
        int length = s.length();

        int toExchange = new Random().nextInt(length-1);

        StringBuilder sb = new StringBuilder(s);

        char temp = sb.charAt(toExchange);
        sb.setCharAt(toExchange, sb.charAt(toExchange+1));
        sb.setCharAt(toExchange+1, temp);
        
        return sb.toString();
    }
}
