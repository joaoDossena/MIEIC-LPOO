package com.aor.refactoring.example5;

public class RotateLeft implements Command
{
    @Override
    public void execute(Position position)
    {
        switch(position.getDirection())
        {
            case 'N':
                position.setDirection('W');
                break;
            case 'S':
                position.setDirection('E');
                break;
            case 'W':
                position.setDirection('S');
                break;
            case 'E':
                position.setDirection('N');
                break;
        }
    }
}