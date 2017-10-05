package rjcorflo;

import com.beust.jcommander.JCommander;
import rjcorflo.commands.AbstractCommand;
import rjcorflo.commands.CommandCommit;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private Map<String, AbstractCommand> commands;

    private void init() {
        this.commands = new HashMap<>();
        commands.put("commit", new CommandCommit());
    }

    public static void main(String... argv) {
        Main main = new Main();
        main.init();

        JCommander.Builder builder = JCommander.newBuilder()
                .addObject(main);

        for (Map.Entry<String, AbstractCommand> entry : main.commands.entrySet()) {
            builder.addCommand(entry.getKey(), entry.getValue());
        }

        JCommander jc = builder.build();

        jc.parse(argv);

        System.out.printf("Parsed command: %s", jc.getParsedCommand());

        AbstractCommand command = main.commands.get(jc.getParsedCommand());
        command.execute();
    }

    private void run() {
        System.out.printf("AAAAAA");
    }
}