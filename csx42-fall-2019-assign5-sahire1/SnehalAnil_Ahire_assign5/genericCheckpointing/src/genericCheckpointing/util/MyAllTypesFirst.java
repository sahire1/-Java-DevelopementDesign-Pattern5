package genericCheckpointing.util;

public class MyAllTypesFirst extends SerializableObject
{

public int a;
public long b;
public String c;
public boolean d;
public int e;

public MyAllTypesFirst(int aIn,long bIn,String cIn,boolean dIn,int eIn)
	{
		a=aIn;
		b=bIn;
		c=cIn;
		d=dIn;
		e=eIn;
		
	}
	
	public MyAllTypesFirst()
	{
		
		
	}
	

	public void set_a(int aIn)
	{
		a=aIn;
	}
	
	public void set_b(long bIn)
	{
	b=bIn;
	}
	public void set_c(String cIn)
	{
		c=cIn;
	}
	
	public void set_d(boolean dIn)
	{
		d=dIn;
	}
	
	public void set_e(int eIn)
	{
			e=eIn;
	}
	
	//getters
	public int get_a()
	{
		return a;
	}
	
	public long get_b()
	{
		return b;
	}
	
	public String get_c()
	{
		return c;
	}
	
	public boolean get_d()
	{
		return d;
	}
	
	public int get_e()
	{
		return e;
	}
	
	
	@Override
    public boolean equals(Object o) {
		if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
		MyAllTypesFirst m= (MyAllTypesFirst) o;
		
		if((m.a==a)&&(m.b==b)&&(m.c.equals(c))&&(m.d==d)&&(m.e==e))
		{
			return true;
		}
		else
			return false;
	
	}
	
	 @Override
    public int hashCode() {
		int temp=3;
		if(d=true)
		{
			
			temp=3;
			
		}else
			temp=0;
	
		int RetValue=0;
		RetValue=(a*3)+((int)b*3)+c.hashCode()+temp+(e*3);
        return RetValue;
    }
	
	@Override
    public String toString() { 
        return String.format("a" +a+"b"+b+"c"+c+"d"+d+"e"+e); 
    } 

}