
public class AbstractFactoryPattern {
    public void run() {

        executeRemoteCommand(new TelnetShellFactory());
    }

    void executeRemoteCommand(AbstractShellFactory fact) {
        Shell shell = fact.createShell();
        shell.connect();
        ExecCommand cmd = fact.createCommand();
        cmd.execute();
    }
}


abstract class Shell {
    abstract void connect();
}

abstract class ExecCommand {
    abstract void execute();
}

class SSHShell extends Shell {
    @Override
    void connect() {
        System.out.println("SSHShell connect");
    }
}

class TelnetShell extends Shell {
    @Override
    void connect() {
        System.out.println("TelnetShell connect");
    }
}

class SSHCommand extends ExecCommand {
    @Override
    void execute() {
        System.out.println("SSHCommand execute");
    }
}

class TelnetCommand extends ExecCommand {
    @Override
    void execute() {
        System.out.println("TelnetCommand execute");
    }
}

abstract class AbstractShellFactory {
    abstract Shell createShell();
    abstract ExecCommand createCommand();
}

class SSHShellFactory extends AbstractShellFactory {
    @Override
    Shell createShell () {
        return new SSHShell();
    }

    @Override
    ExecCommand createCommand () {
        return new SSHCommand();
    }
}

class TelnetShellFactory extends AbstractShellFactory {
    @Override
    Shell createShell () {
        return new TelnetShell();
    }

    @Override
    ExecCommand createCommand () {
        return new TelnetCommand();
    }
}