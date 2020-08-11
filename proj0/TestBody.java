public class TestBody {
    public static void main(String[] args) {
        Body a = new Body(0,1,2,3,4,"Bodya");
        Body b = new Body(5,4,3,2,1,"Bodyb");
        Double force = a.calcForceExertedBy(b);

        System.out.println("Checking Body...");
        if (force == a.calcForceExertedBy(b)) {
            System.out.println("PASS: Expected " + force + " and you gave " + a.calcForceExertedBy(b));
        } else {
            System.out.println("Fail: Expected " + force +  " and you gave "+ a.calcForceExertedBy(b));
        }
    }
}