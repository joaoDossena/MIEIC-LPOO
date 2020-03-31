package com.aor.refactoring.example5;

public class RotateRight implements Command
{
    @Override
    public void execute(Position position)
    {
        switch(position.getDirection())
        {
            case 'N':
                position.setDirection('E');
                break;
            case 'S':
                position.setDirection('W');
                break;
            case 'W':
                position.setDirection('N');
                break;
            case 'E':
                position.setDirection('S');
                break;
        }
    }
}