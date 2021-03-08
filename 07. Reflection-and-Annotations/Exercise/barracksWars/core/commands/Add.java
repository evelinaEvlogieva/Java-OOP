
package barracksWars.core.commands;

import barracksWars.core.Inject;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public class Add extends Command {
    @Inject
    protected String[] data;
    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;

    protected Add(String[] data) {
        super(data);
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException {
        String unitType = super.getData()[1];
        Unit unitToAdd = unitFactory.createUnit(unitType);
        repository.addUnit(unitToAdd);
        return unitType + " added!";
    }
}