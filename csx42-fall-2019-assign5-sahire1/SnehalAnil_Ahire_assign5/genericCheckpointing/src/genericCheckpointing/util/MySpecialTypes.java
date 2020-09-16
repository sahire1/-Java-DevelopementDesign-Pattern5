package genericCheckpointing.util;

public class MySpecialTypes extends SerializableObject
{


public int a3;
public int b3;
public String c3;
public String d3;
public double e3;
public double f3;

public MySpecialTypes(int aIn,int bIn,String cIn,String dIn,double eIn,double fIn)
	{
		a3=aIn;
		b3=bIn;
		c3=cIn;
		d3=dIn;
		e3=eIn;
		f3=fIn;
	}
	public MySpecialTypes()
	{
		
		
	}

	public void set_a(int aIn)
	{
		a3=aIn;
	}
	
	public void set_b(int bIn)
	{
	b3=bIn;
	}
	public void set_c(String cIn)
	{
		c3=cIn;
	}
	
	public void set_d(String dIn)
	{
		d3=dIn;
	}
	
	public void set_e(double eIn)
	{
			e3=eIn;
	}
	public void set_f(double fIn)
	{
			f3=fIn;
	}
	
	//getters
	public int get_a()
	{
		return a3;
	}
	
	public int get_b()
	{
		return b3;
	}
	
	public String get_c()
	{
		return c3;
	}
	
	public String get_d()
	{
		return d3;
	}
	
	public double get_e()
	{
		return e3;
	}
	
	public double get_f()
	{
		return f3;
	}
	
	
	@Override
    public boolean equals(Object o) {
		if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
		MySpecialTypes m= (MySpecialTypes) o;
		
		if((m.a3==a3)&&(m.b3==b3)&&(m.c3.equals(c3))&&(m.d3.equals(d3))&&(m.e3==e3)&&(m.f3==f3))
		{
			return true;
		}
		else
			return false;
	
	}
	
	 @Override
    public int hashCode() {
		
	
		int RetValue=0;
		RetValue=(a3*3)+(b3*3)+c3.hashCode()+d3.hashCode()+((int)e3*3)+((int)f3*3);
        return RetValue;
		
		
       // return 1;
    }
	
	@Override
    public String toString() { 
        return String.format("a3" +a3+"b3"+b3+"c3"+c3+"d3"+d3+"e3"+e3+"f3"+f3); 
    } 


}