package shared.commands;

import shared.model.User;

import java.io.Serializable;

public interface ICommand extends Serializable {
    static final long serialVersionUID = 1L;
    public Object execute() throws Exception;
    public Object execute(User originUser) throws Exception;
}
