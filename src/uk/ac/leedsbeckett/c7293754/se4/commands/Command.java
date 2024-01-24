package uk.ac.leedsbeckett.c7293754.se4.commands;

public interface Command {

    public String getUsage();

    public void run(String[] args) throws Exception;

}
