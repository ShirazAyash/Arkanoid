public class Printer {
    public Printer(String s) throws Exception{
        if(s==null){
            throw new  MyException();
        }
        System.out.println(s);
    }
}
