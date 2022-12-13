package frc.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.subsystems.Indexer;
public class RunIndexer extends CommandBase{
    private Indexer indexer;

    public RunIndexer(Indexer indexer) {
        this.indexer = indexer;

        addRequirements(indexer);
    }

    @Override
    public void execute(){
        indexer.startIndexing(.75);
    }
    @Override
    public void end(boolean interrupted){
        indexer.stopIndexing();
    }
}
