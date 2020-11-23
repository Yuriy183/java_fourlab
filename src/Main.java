import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Square> Squares = new ArrayList<>();
        ArrayList<SquarePrism> Prisms = new ArrayList<>();

        double maxDiagonal = 0;
        int maxSquare = 0;
        byte flagDiagonal = -1;
        byte flagSquare = -1;

        for (int i = 0; i <= 10; i++) {
            Squares.add(new Square((int)(Math.random() * 9 + 1)));
            Prisms.add(new SquarePrism((int)(Math.random() * 9 + 1), i));

            int currentSquare = Squares.get(i).calcSquare();
            if (currentSquare > maxSquare) {
                maxSquare = currentSquare;
                flagSquare = (byte)i;
            }

            double currentDiagonal = Prisms.get(i).calcDiagonal();
            if (currentDiagonal > maxDiagonal) {
                maxDiagonal = currentDiagonal;
                flagDiagonal = (byte)i;
            }
        }

        NativeSerialization.saveFile(Squares.get(flagSquare), Prisms.get(flagDiagonal));
        IFigure[] loadData = NativeSerialization.loadFile("FigureMon Nov 23 17:37:28 MSK 2020.txt");
        System.out.println("NATIVESERIALIZATION" + "\n" + "------------");
        System.out.println("Square:\n" + loadData[0].toString() + "\n\n" + "Prism:\n" + loadData[1].toString() + "\n");

        JSONSerialization.saveFile(Squares.get(flagSquare), Prisms.get(flagDiagonal));
        loadData = JSONSerialization.loadFile("SquareMon Nov 23 12:33:32 MSK 2020.json", "PrismMon Nov 23 12:33:32 MSK 2020.json");
        System.out.println("JACKSONSERIALIZATION" + "\n" + "------------");
        System.out.println("Square:\n" + loadData[0].toString() + "\n\n" + "Prism:\n" + loadData[1].toString());
    }
}