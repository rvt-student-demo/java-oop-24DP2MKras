package rvt;
import java.util.*;
public class IOU {
    String ToWhom;
    double amount;
    HashMap<String, Double> debts;
    public IOU() {
        debts = new HashMap<>();
    }

    public void setSum(String ToWhom, double amount) {
        debts.put(ToWhom, amount);
    }
    public double howMuchDoIOweTo(String ToWhom) {
        return debts.getOrDefault(ToWhom, 0.0);
    }
    public static void main(String[] args) {
        

        IOU mattsIOU = new IOU();
        mattsIOU.setSum("Arthur", 51.5);
        mattsIOU.setSum("Michael", 30);

        System.out.println(mattsIOU.howMuchDoIOweTo("Arthur"));
        System.out.println(mattsIOU.howMuchDoIOweTo("Michael"));

    }


}
