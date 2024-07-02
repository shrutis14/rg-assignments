class A
{
    static A obj = new A();
    private A(){}
    public static A getA()
    {
        return obj;
    }
}
class Singleton
{
    public static void main(String[] args)
    {
        A a = A.getA();
    }
}
