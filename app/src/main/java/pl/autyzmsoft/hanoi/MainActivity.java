package pl.autyzmsoft.hanoi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    static int movesToEnd; //remaining number of moves
    static boolean czySpowalniac;
    static int waitTime;

    static Tower towerC;
    static Tower towerA;
    static Tower towerB;

    static int TotalMoves(int n) {
        if (n == 1)
            return 1;
        else
        {
            int wyn = TotalMoves(n - 1);
            wyn = 2 * wyn + 1;
            return wyn;
        }
    }
    static void Poczekaj(int waitTime) {
        if (czySpowalniac) {
            try {
                Thread.sleep(waitTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    static void Hanoi(int n, Tower Src, Tower Dst, Tower Aux)
    //Parameters:
    //n -  number of _disks
    //Src - Skad / Source
    //Dst - Dokad / Destination
    //Aux - Pozycja Srodkowa / Position in the Middle (Auxiliary Position)
    {
        if (n > 0)
        {
            Hanoi(n - 1, Src, Aux, Dst);  //now Aux is (temporary) Destination, Dst is auxiliary

            Poczekaj(waitTime);

            Src.Przenies(Dst);

            movesToEnd--;

            Utilities.gotoXY(0, 1);
//            Console.Write("Pozostalo:           " + movesToEnd + "   ");
            Utilities.gotoXY(0, 1);

            Hanoi(n - 1, Aux, Dst, Src);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Console.Clear();
        Console.CursorVisible = false;

        //Number of disks:
        int n = 5  ;
        //
        movesToEnd = TotalMoves(n);
        Console.Write("Do wykonania ruchow: " + movesToEnd);
        Utilities.gotoXY(0, 1);
        Console.Write("Pozostalo:           " + movesToEnd);
        czySpowalniac = true;
        waitTime = 2000;
        //
        towerA = new Tower(Utilities.kA);
        towerB = new Tower(Utilities.kB);
        towerC = new Tower(Utilities.kC);
        //Putting _disks on 1st stack and initial drawing of the 1st stack;
        //the idx `i' of the for loop will be the disk's ID:
        for (int i = 0; i < n; i++)
        {
            towerA.PutDisk(new Disk(i));
        }
        //
        Utilities.gotoXY(Utilities.kA, Utilities.Wd + 1); Console.Write('A');
        Utilities.gotoXY(Utilities.kB, Utilities.Wd + 1); Console.Write('B');
        Utilities.gotoXY(Utilities.kC, Utilities.Wd + 1); Console.Write('C');
        //
        Utilities.gotoXY(0, Utilities.Wd + 3);
        Console.WriteLine("Towers of Hanoi");
        Console.WriteLine("press any key...");
        Console.ReadKey();
        Utilities.gotoXY(0, Utilities.Wd + 4);
        Console.WriteLine("                                        ");
        //
        Hanoi(n, towerA, towerC, towerB);
        //
        //odstep pod rysunkiem:
        Utilities.gotoXY(Utilities.kA, Utilities.Wd + 5);
        Console.WriteLine();
        Console.WriteLine();
    }
}