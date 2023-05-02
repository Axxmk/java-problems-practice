import java.io.FileNotFoundException;

class NoDummy  {
    public int noDummy() {
        Dummy d = new Dummy();
        try {
             return d.dummy();
        } catch (Exception e) {
            // handle exception ...
            return 0;
        }
    }
}

class Dummy {
    int value;

    public int dummy() throws DummyException {
        {
            value = 5;
            value--;
        }

        try {
            takeAction();
        } catch (Exception e) {
            value += 5;
        } finally {
            value += 10;
            return value;
        }
    }

    public void takeAction() throws Exception {
        throw new Exception();
    }
}

class DummyException extends FileNotFoundException {}

public class TestException {
    public static void main(String[] args) {
        Score row = new Score("Liverpool", 15);
    }
}

class Score {
    String name;
    int score;

    public Score(String name, int score) {
        this.name = name;
        this.score = score;
    }
}