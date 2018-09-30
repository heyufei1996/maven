import org.json.JSONObject;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File(Main.class.getClassLoader().getResource("json.config").getFile()));
        JSONObject jsonObject =new JSONObject(scanner.nextLine());
        System.out.println(jsonObject.get("age"));
    }
}
