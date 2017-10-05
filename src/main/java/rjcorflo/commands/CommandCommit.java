package rjcorflo.commands;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

import java.util.List;

@Parameters(separators = "=", commandDescription = "Record changes to the repository")
public class CommandCommit extends AbstractCommand {
    @Parameter(description = "The list of files to commit")
    public List<String> files;

    @Parameter(names = "--amend", description = "Amend")
    public Boolean amend = false;

    @Parameter(names = "--author")
    public String author;

    @Override
    public void execute() {
        System.out.print("\nExecute " + amend);
        System.out.print("\nExecute " + author);
    }
}