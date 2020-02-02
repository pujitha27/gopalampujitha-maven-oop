import java.util.*;
import java.lang.*;

interface Details
{
  public void allDetails();
}
class RegPolygon
{
   int no_of_sides;
   RegPolygon(int n)
   {
     no_of_sides=n;
   }

   void shape()
   {
     if(no_of_sides>2)
        System.out.println("It's a regular polygon");
     else 
        System.out.println("It's not a regular polygon");
   }

   void area()
   {
     if(no_of_sides>2)
      System.out.println("Area can be found.");
     else
      System.out.println("Area cannot be found.");
  }
 
}


 
class Triangle extends RegPolygon 
{
  String shp="---";
  int base;
  int height,s1,s2,s3;
  boolean flag=true;
  double ar;
  Triangle(int b,int h)
  {
    super(3);
    base=b;
    height=h;
       if(b==0 || h==0)
     {      
        flag=false;
     }
  }
 Triangle(int a,int b,int c)
  {
  super(3);
  s1=a; s2=b;s3=c;
  if(s1==0 || s2==0 || s3==0)
     {      
        flag=false;
     }
  }
  
  void allDetails()
 {
   shape();
   area();
 }

  void shape()
  {
    if(flag==false)
     {      
        System.out.println("Triangle cannnot be formed.");
        return;
     }
    shp="Trinagle";
    System.out.println("It's a triangle ("+no_of_sides+" sides)");
  }

  void area()
  {
    if(height==0 && flag==true)
     {
      ar=area(s1,s2,s3);
     
        
     }
    else
     ar=area(base,height);
    System.out.println("Area::"+ar);
  }
  double area(int b,int h)
  {
    return 0.5*b*h;
  }
  double area(int a, int b,int c)
  {
    double p=(a+b+c)/2;
    double tmp=p*(p-a)*(p-b)*(p-c);
    if(tmp<0) shp="Impossible triangle";
    return Math.sqrt(tmp);
  }
 }

class Rectangle extends RegPolygon implements Details
{
  String shp="---";
  boolean flag=true;
  int length,breadth,s;
  double ar;
  Rectangle(int l,int b)
  {
    super(4);
    length=l;
    breadth=b;
    if(l==0 || b==0)
       flag=false;
  }

  public void allDetails()
 {
   shape();
   area();
 }  

  void shape()
  {
    if(flag==false)
    {
      System.out.println("Rectangle cannot be formed");
      return;
    }
    if(length==breadth)
       {
        shp="Square";
        System.out.println("It's a square ("+no_of_sides+" sides)"); 
       }
    else
      {
       shp="Rectangle";
       System.out.println("It's a rectangle ("+no_of_sides+" sides)");   
      }
  }
  void area()
  {
      ar=length*breadth;
      System.out.println("Area::"+ar);
  }
  
  
}

public class Polygon
{
  public static void main(String args[])
  {
    Scanner sc=new Scanner(System.in);
    int n,ch,dm;
    System.out.println("enter n:");  //// no of polygons u want to find areas of
    n=sc.nextInt();
    Map<Double,String> hm = new HashMap<>(); 
    while((n--)!=0)
    {
      System.out.println("1. 3-sided \n2. 4-sided");
      ch=sc.nextInt();
      if(ch==1)
      {
        System.out.println("1. 2-dimensions \n2. 3-dimensions");
        dm=sc.nextInt();
        System.out.println("Enter dimensions:");
        if(dm==1)
         {
           Triangle tr=new Triangle(sc.nextInt(),sc.nextInt());
           tr.allDetails();
           hm.put(tr.ar,tr.shp); 
         }
        else
           {
             Triangle tr=new Triangle(sc.nextInt(),sc.nextInt(),sc.nextInt());
             tr.allDetails();
             hm.put(tr.ar,tr.shp); 
           }
           
      }
     else
      {
        System.out.println("Enter dimensions:");
        Rectangle rt=new Rectangle(sc.nextInt(),sc.nextInt());
        rt.allDetails();
        hm.put(rt.ar,rt.shp);
      }
     }
    
   System.out.println("Sorting given polygons based on area::");
  
   TreeMap<Double,String> sort = new TreeMap<>(); 
   sort.putAll(hm); 
  
        for (Map.Entry<Double,String> ent : sort.entrySet())  
            System.out.println("Area = " + ent.getKey() +  
                         ", Shape = " + ent.getValue());         
     



  }
}









   

