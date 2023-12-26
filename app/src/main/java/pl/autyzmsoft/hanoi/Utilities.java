package pl.autyzmsoft.hanoi;

public class Utilities {
    public static int kA = 15;
    public static int kB = 40;
    public static int kC = 65;
    public static byte Wd = 20;
    public static byte SzerPdst = 24;
    public static char pattern = 230;

    public Utilities() {
    }

    public static void gotoXY(int x, int y) {
        Console.CursorLeft = x;
        Console.CursorTop = y;
    }
}
