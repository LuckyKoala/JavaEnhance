package tech.zuosi.javaenhance.generics;

/**
 * Created by iwar on 2017/6/8.
 */
public class WarningDemo {
    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        Box<Integer> bi;
        bi = createBox();
    }

    static Box createBox(){
        return new Box();
    }
}
