package massim.javaagents.agents;

import eis.iilang.Identifier;
import eis.iilang.Parameter;
import eis.iilang.Percept;
import massim.javaagents.MailBox;
import massim.protocol.messagecontent.Action;

import java.util.List;

/**
 * A very basic agent.
 */
public class BasicAgent extends Agent {

    /**
     * Constructor.
     * @param name    the agent's name
     * @param mailbox the mail facility
     */
    public BasicAgent(String name, MailBox mailbox) {
        super(name, mailbox);
    }

    @Override
    public void handlePercept(Percept percept) {}

    @Override
    public Action step() {
        List<Percept> percepts = getPercepts();
        percepts.stream()
                .filter(p -> p.getName().equals("step"))
                .findAny()
                .ifPresent(p -> {
                    Parameter param = p.getParameters().getFirst();
                    if(param instanceof Identifier) say("Step " + ((Identifier) param).getValue());
        });
        return new Action("skip");
    }
}