package area.calculator;

public class NoAreaException extends RuntimeException
{
    public NoAreaException() { System.out.println("This shape has no area!"); }
}
