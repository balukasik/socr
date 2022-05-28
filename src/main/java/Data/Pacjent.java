package Data;

import javafx.scene.Node;

public class Pacjent {

    private int id;
    private int x;
    private int y;
    private int destination;
    private Node node;

    public Pacjent(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public Pacjent(String[] data, int lineNum) {
        try {
            this.id = Integer.parseInt(data[0]);
            this.x = Integer.parseInt(data[1]);
            this.y = Integer.parseInt(data[2]);
            this.destination = Integer.parseInt(data[3]);
        } catch (NumberFormatException e) {
            System.out.println("Zle dane w lini " + lineNum);
            System.exit(0);
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x=x;
    }
    public void setY(int y) {
        this.y=y;
    }

    public int getY() {
        return y;
    }

    public int getId() {
        return id;
    }

    public int getDestination() {
        return destination;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public Node getNode() {
        return node;
    }
}
