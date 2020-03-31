package com.aor.refactoring.example5;

public class MoveForward implements Command
{
    @Override
    public void execute(Position position)
    {
        switch(position.getDirection())
        {
            case 'N':
                position.setX(position.getX() - 1);
                break;
            case 'S':
                position.setX(position.getX() + 1);
                break;
            case 'W':
                position.setY(position.getY() - 1);
                break;
            case 'E':
                position.setY(position.getY() + 1);
                break;
        }
    }
}