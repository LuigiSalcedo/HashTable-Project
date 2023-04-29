package hashtablesproject.models;

/**
 *
 * @author Luigi Salcedo
 */
public class Identifier 
{
    private String idValue;
    
    public Identifier(String idValue)
    {
        this.idValue = idValue.trim();
    }
    
    public Identifier()
    {
        
    }
    
    public void setIdValue(String idValue)
    {
        this.idValue = idValue;
    }
    
    public String getIdValue()
    {
        return idValue;
    }
    
    @Override
    public int hashCode()
    {
        String id = idValue;
        char character;
        int hash = 0;
        while(!id.isEmpty())
        {
           character = id.charAt(0);
           hash += (int)character * Math.pow(2, id.length()-1);
           id = id.substring(1);
        }
        return hash;
    }
    
    @Override
    public boolean equals(Object o)
    {
        Identifier otherElement = (Identifier)o;
        return this.idValue.equals(otherElement.idValue);
    }
    
    @Override
    public String toString()
    {
        return idValue;
    }
}
