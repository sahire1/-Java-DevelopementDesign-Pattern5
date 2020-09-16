package genericCheckpointing.util;

public class MyAllTypesSecond extends MyAllTypesFirst
{
public double a2;
public float b2;
public char c2;
public short d2;

public MyAllTypesSecond(int aIn,long bIn,String cIn,boolean dIn,int eIn,double a2In,float b2In,char c2In,short d2In)
	{
		
		super(aIn,bIn,cIn,dIn,eIn);
		
		a2=a2In;
		b2=b2In;
		c2=c2In;
		d2=d2In;
		
	}
public MyAllTypesSecond()
	{
		
		
	}


public void set_a2(double a2In)
	{
		a2=a2In;
	}
	
	public void set_b2(float b2In)
	{
	b2=b2In;
	}
	public void set_c2(char c2In)
	{
		c2=c2In;
	}
	
	public void set_d2(short d2In)
	{
		d2=d2In;
	}
	
	
	
	//getters
	public double get_a2()
	{
		return a2;
	}
	
	public float get_b2()
	{
		return b2;
	}
	
	public char get_c2()
	{
		return c2;
	}
	
	public short get_d2()
	{
		return d2;
	}
	
	
	
	
	@Override
    public boolean equals(Object o) {
		if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
		MyAllTypesSecond m= (MyAllTypesSecond) o;
		
		if((m.a2==a2)&&(m.b2==b2)&&(m.c2==c2)&&(m.d2==d2))
		{
			return true;
		}
		else
			return false;
	
	}
	
	 @Override
    public int hashCode() {
		Character c = Character.valueOf(c2); 
        int i = c.hashCode(); 
	
		int RetValue=0;
		RetValue=((int)a2*3)+((int)b2*3)+i+((int)d2*3);
        return RetValue;
		
           }

	@Override
    public String toString() { 
        return String.format("a2" +a2+"b2"+b2+"c2"+c2+"d2"+d2); 
    } 



}