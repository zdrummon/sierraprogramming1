public class Launcher {
    public static void main(String[] args) {
        if (args.length > 0) {
            switch (args[0]) {
                case "hello":
                    HelloWorld.main(new String[0]);
                    break;
                case "game":
                    LauncherTester.main(new String[0]);
                    break;
                default:
                    System.out.println("Unknown program");
            }
        }
    }
}
