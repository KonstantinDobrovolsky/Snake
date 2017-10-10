package Snake;
import java.util.Hashtable;


// couldn't find equivalent for internal in Java. default ???
class KeyInput
{
    private static Hashtable keyTable = new Hashtable();

    public static void ChangeState(Keys key, boolean state)
    {
        keyTable.replace(key, state);
    }

    public static boolean KeyPressed(Keys key)
    {
        if (keyTable.get(key) == null)
            return false;

        return (boolean)keyTable.get(key);
    }
}
