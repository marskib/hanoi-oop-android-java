package pl.autyzmsoft.hanoi;

import android.util.Log;

public class Console {
    public static boolean CursorVisible;
    public static int CursorLeft;
    public static int CursorTop;

    public Console() {
    }

    public static void Write(String str) {
//        System.out.println(str);
        Log.i("Hanoi****", str);

    }

    public static void Write(Character chr) {
    }

    public static void WriteLine(String str) {
//        System.out.println(str);
        Log.i("Hanoi****", str);
    }

    public static void WriteLine() {
    }

    public static void Clear() {
    }

    public static void ReadKey() {
    }
}
