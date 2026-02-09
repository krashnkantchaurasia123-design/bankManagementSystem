import java.util.Vector;
import java.io.*;
import java.io.Serializable;
public class sData implements Serializable{
     Vector<String> name=new Vector<>();
     Vector<String> accountNo=new Vector<>();
     Vector<String> mobileNo=new Vector<>();
     Vector<Integer>age=new Vector<>();
    Vector<Float>balance=new Vector<>();

    void setData(String n, String acc, String mob, int ag,float b) {
        name.add(n);
        accountNo.add(acc);
        mobileNo.add(mob);
        age.add(ag);
        balance.add(b);
    }

}
