package pl.autyzmsoft.hanoi;

/**
 * Class to describe the current state of each stack/tower:
 * how many _disks are on the stack and which ones they are.
 * There will be 3 instances of the class,
 * as there are 3 stacks in Hanoi puzzle.
 */
public class Tower {
    //maximum acceptable number of _disks
    private final byte _maxKr = 12;

    //'physical' placement of the Tower:
    private final int _column;

    //How many _disks is currently on the stack:
    private int _ileSztuk = 0;

    //member `_disks[]` - the ids of the disks on the stack.
    //The ids are given just before the game starts.
    //The ids determine _disks's width (later used in drawing).
    //_disks[] is in fact a stack itself, with this._ileSztuk-1 pointing at its top.
    private final Disk[] _disks = new Disk[_maxKr];

    public Tower(int column)
    {
        this._column = column;
    }

    private int GetStackHeight()
    {
        return this._ileSztuk;
    }

    public void PrintTopDisk(char pattern)
        /* Printing disk, that is on the top of the stack */
    {
        int row = Utilities.Wd - this.GetStackHeight() + 1;
        Disk disk = GetTopDisk();
        //Where to place the cursor to start printing:
        Utilities.gotoXY(this._column - (disk.getWidth() / 2), row);
        //
        disk.Print(pattern);
    }

    public void Przenies(Tower destination)
        /*Graphical representation of the move*/
    {
        Console.WriteLine(this.toString() + " -> " + destination.toString());

        Disk disk = GetTopDisk(); //we always move the top disk only
        RemoveTopDisk();
        destination.PutDisk(disk);
    }

    public void PutDisk(Disk disk)
    {
        this._disks[_ileSztuk] = disk; //disk lands on the top of the stack/tower (the table has 0-based idx, so _ileSztuk points "higher" then the current top)
        this._ileSztuk++;
        this.PrintTopDisk(Utilities.pattern);
    }

    private void RemoveTopDisk()
    {
        this.PrintTopDisk(' '); //erasing/clearing top disk (only visually)
        this._ileSztuk--;       //`real` removal
    }

    private Disk GetTopDisk()
    {
        return this._disks[_ileSztuk - 1];
    }

    @Override
    public String toString() {
        switch (this._column) {
            case 15 : return "A";
            case 40 : return "B";
            case 65 :return "C";
            default : return null;
        }
    }

}
