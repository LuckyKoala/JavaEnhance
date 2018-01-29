package tech.zuosi.javaenhance.sugar;

public class SwitchCaseWithString {
    void sugar(String str) {
        switch (str) {
            case "First":
                System.out.println("first");
                break;
            case "Second":
                System.out.println("second");
                break;
            case "Third":
                System.out.println("third");
                break;
        }
    }

    void actual(String str) {
        byte var3 = -1;
        switch(str.hashCode()) {
            case -1822412652:
                if (str.equals("Second")) {
                    var3 = 1;
                }
                break;
            case 67887760:
                if (str.equals("First")) {
                    var3 = 0;
                }
                break;
            case 80778567:
                if (str.equals("Third")) {
                    var3 = 2;
                }
        }

        switch(var3) {
            case 0:
                System.out.println("first");
                break;
            case 1:
                System.out.println("second");
                break;
            case 2:
                System.out.println("third");
        }

    }
}
