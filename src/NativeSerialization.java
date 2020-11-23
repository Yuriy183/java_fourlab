import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class NativeSerialization {

    private static String fileName = "Figure" + new Date() + ".txt";


    public static void saveFile(Square sq, SquarePrism sp)
    {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName, true)))
        {
            oos.writeObject(sq);
            oos.writeObject(sp);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static IFigure[] loadFile(String fileName)
    {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName)))
        {
            IFigure[] figure = new IFigure[2];
            figure[0] = (Square)ois.readObject();
            figure[1] = (SquarePrism)ois.readObject();
            return figure;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return new IFigure[1];
    }
}