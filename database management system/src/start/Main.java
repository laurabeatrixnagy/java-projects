package start;

import presentation.Command;

import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws IOException, SQLException {
        Command commands = new Command();

        commands.parse(args);

    }
}
