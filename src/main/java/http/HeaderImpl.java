package http;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.ParseException;

/**
 * @author Ares
 * @date 2018/5/29 18:18
 */
public class HeaderImpl implements Header
{
    private String name;
    private String value;

    @Override
    public HeaderElement[] getElements() throws ParseException
    {
        return new HeaderElement[0];
    }

    public HeaderImpl(String name, String value)
    {
        this.name = name;
        this.value = value;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public String getValue()
    {
        return value;
    }

}
