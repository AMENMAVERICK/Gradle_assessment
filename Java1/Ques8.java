import java.util.Scanner;

public class Ques8 {

    public static void main(String[] args) {
        Ques8 object = new Ques8();
        object.string();
    }

    private void string()
    {
        StringBuffer stringBuffer=new StringBuffer();
        Scanner input_string=new Scanner(System.in);
        System.out.println("enter the string");
        String string=input_string.next();
        for(int i=string.length()-1;i>=0;i--)
        {
            stringBuffer.append(string.charAt(i));
        }

        System.out.println("reverse string is:"+stringBuffer);

        System.out.println("reverse string after deleting from index 4 to 9 is:"+stringBuffer.delete(4,9));
    }
}

